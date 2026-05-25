package com.javadoterr.api.service;

import com.javadoterr.api.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private RestClient restClient;

    public User testRestClient(){
        User response = restClient.get()
                .uri("https://jsonplaceholder.typicode.com/users/1")
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (req, resp) ->{
                    throw new RuntimeException("Client error : "+ resp.getStatusCode());
                })
                .onStatus(HttpStatusCode::is5xxServerError, (req, resp) -> {
                    throw new RuntimeException("Server error : "+ resp.getStatusCode());
                })
                .body(User.class);

        return response;
    }

    public List<User> getListUsers(){
        List<User> userList = restClient.get()
                .uri("https://jsonplaceholder.typicode.com/users")
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (req, resp) -> {
                    throw new RuntimeException("Client error : " + resp.getStatusCode());
                })
                .onStatus(HttpStatusCode::is5xxServerError, (req, resp) -> {
                    throw new RuntimeException("Servcer error : " + resp.getStatusCode());
                })
                .body(new ParameterizedTypeReference<List<User>>() {
                });
        return userList;
    }


}
