package rest.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import rest.entity.Address;
import rest.errorHandler.RestTemplateResponseErrorHandler;
import rest.errors.AddressNotExistException;

import java.util.Objects;

@Service
public class GetAddressFromService {

    private RestTemplate restTemplate;

    @Bean
    public ResponseErrorHandler responseErrorHandler() {
        return new RestTemplateResponseErrorHandler();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        restTemplate = builder
                .errorHandler(responseErrorHandler())
                .build();
        return restTemplate;
    }

    public Address getAddress(long id) {
        ResponseEntity<Address> result = restTemplate.getForEntity("http://localhost:8080/address/id/" + id, Address.class);
        if(Objects.isNull(result.getBody())){
            throw new AddressNotExistException("This address does not exist!");
        }
        return result.getBody();
    }
}
