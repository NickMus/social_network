package com.example.social_network.services;

import com.example.social_network.entities.Client;
import com.example.social_network.entities.Role;
import com.example.social_network.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 12.01.2023
 */
@Service
@RequiredArgsConstructor
public class ClientService {
    private final OAuth2AuthorizedClientService loadAuthorizedClient;
    private final ClientRepository repository;

    public void createNewOAuthClient(OAuth2AuthenticationToken authenticationToken) {
        OAuth2AuthorizedClient client = loadAuthorizedClient
                .loadAuthorizedClient(authenticationToken.getAuthorizedClientRegistrationId(), authenticationToken.getName());
        String userInfoEndpointUri = client.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUri();

        if (StringUtils.hasLength(userInfoEndpointUri)) {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken()
                    .getTokenValue());
            HttpEntity entity = new HttpEntity("", headers);
            ResponseEntity<Map> response = restTemplate
                    .exchange(userInfoEndpointUri, HttpMethod.GET, entity, Map.class);
            Map userAttributes = response.getBody();
            System.out.println(userAttributes.size());

            Client newClient = createClient(userAttributes);
            repository.save(newClient);
        }
    }

    private Client createClient(Map userAttributes) {
        Client newClient = new Client();
        //sub, name, given_name, family_name, picture, email, email_verified, locale
        newClient.setName((String) userAttributes.get("given_name"));
        newClient.setSecondName((String) userAttributes.get("family_name"));
        newClient.setAvatar((String) userAttributes.get("picture"));
        newClient.setEmail((String) userAttributes.get("email"));
        newClient.setRole(Role.USER);
        return newClient;
    }

}

