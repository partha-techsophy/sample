package com.techsophy.demo.restclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Annotate rest client with class as argument to test
 */
@RestClientTest
public class RestClientSampleTest {

    /**
     * Initialize mock rest server
     */
//    @Autowired
//    private MockRestServiceServer server;


    /**
     * Sample code
     */
//    @Test
//    void testAThirdPartyService() {
//        server
//            .expect(once(), requestTo(startsWith("/movie-quote")))
//            .andExpect(method(HttpMethod.GET))
//            .andExpect(queryParam("page", "0"))
//            .andExpect(queryParam("pageSize", "10"))
//            .andRespond(withSuccess(new ClassPathResource("movie-quotes.json"), MediaType.APPLICATION_JSON));
//    }
}
