package optum.health.dtc.salesforce.controller;

import optum.health.dtc.salesforce.model.*;
import optum.health.dtc.salesforce.service.SalesforceClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
@RestController
@RequestMapping("/client")
public class SalesforceClientController
{
    @Autowired
    private SalesforceClientService salesforceClientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ClientAccessTokenResponse> getClientAccessToken(@RequestBody ClientAccessTokenRequest accessTokenRequest) {
        return salesforceClientService.getClientAccessToken(accessTokenRequest);
    }

    @GetMapping(value = "/{id}")
    public Mono<User> findById(@PathVariable("id") Integer id) {
        return salesforceClientService.findById(id);
    }

    @PostMapping("/createuser")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> create(@RequestBody UserCreate user) {
        return salesforceClientService.createUser(user);
    }
}
