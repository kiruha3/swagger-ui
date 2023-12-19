package ru.hogwarts.hogwarts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class InfoService {
    @Value("${server.port}")
    private String port;
    public String getPort(){
        return port;
    };

}
