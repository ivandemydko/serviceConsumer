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

@Service
public class GetAddressFromService {

    private Address address;

    @Bean
    public ResponseErrorHandler responseErrorHandler() {
        return new RestTemplateResponseErrorHandler();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .errorHandler(responseErrorHandler())
                .build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            try {
                ResponseEntity<Address> result = restTemplate.getForEntity("http://localhost:8080/address/id/3", Address.class);
                Address add = result.getBody();
                System.out.println(add);
                address = add;

//                LOG.info("We are on course: {}", course.getTitle());
            } catch (IllegalArgumentException ex) {
//                LOG.error("Error while consuming: {}", ex.getMessage());
            }

        };
    }

    public Address getAddress() {
        return address;
    }
}
