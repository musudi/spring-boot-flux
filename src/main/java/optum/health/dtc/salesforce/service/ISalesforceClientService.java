package optum.health.dtc.salesforce.service;

import optum.health.dtc.salesforce.model.*;
import reactor.core.publisher.Mono;
 
public interface ISalesforceClientService {
	Mono<User> findById(Integer id);

    Mono<ClientAccessTokenResponse> getClientAccessToken(ClientAccessTokenRequest accessTokenRequest);

    Mono<User> createUser(UserCreate user);
}