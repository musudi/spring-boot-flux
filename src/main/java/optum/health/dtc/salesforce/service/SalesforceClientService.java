package optum.health.dtc.salesforce.service;

import optum.health.dtc.salesforce.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class SalesforceClientService implements ISalesforceClientService
{
	@Autowired
	WebClient webClient;

	public Mono<User> findById(Integer id) {
		return webClient.get()
				.uri("/api/users/" + id)
				.retrieve()
				.bodyToMono(User.class);
	}

	@Override
	public Mono<ClientAccessTokenResponse> getClientAccessToken(ClientAccessTokenRequest accessTokenRequest) {
		return webClient.post()
				.uri("/oauth2/token")
				.body(Mono.just(accessTokenRequest), ClientAccessTokenRequest.class)
				.retrieve()
				.bodyToMono(ClientAccessTokenResponse.class)
				.timeout(Duration.ofMillis(10_000));
	}

	@Override
	public Mono<User> createUser(UserCreate user) {
		return webClient.post()
				.uri("/api/users/")
				.body(Mono.just(user), UserCreate.class)
				.retrieve()
				.bodyToMono(User.class)
				.timeout(Duration.ofMillis(10_000));
	}

	@Override
	public Mono<SObjectResponse> createSOObject(SObjectRequest request) {
		return webClient.post()
				.uri("/sobjects/Attachment")
				.body(Mono.just(request), SObjectRequest.class)
				.retrieve()
				.bodyToMono(SObjectResponse.class)
				.timeout(Duration.ofMillis(10_000));
	}

	@Override
	public Mono<String> getSObject(String id) {
		return webClient.get()
				.uri("/sobjects/Attachment/" + id +"/body")
				.retrieve()
				.bodyToMono(String.class);
	}
}