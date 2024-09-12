package com.eci.arep4;

import com.eci.arep4.Model.LogEntry;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RoundRobinLoadBalancer {

    private final String[] logServiceUrls = {
            "http://logservice1/log",
            "http://logservice2/log",
            "http://logservice3/log"
    };
    private int currentIndex = 0;

    public List<LogEntry> delegateMessage(String message) {
        String url = logServiceUrls[currentIndex];
        currentIndex = (currentIndex + 1) % logServiceUrls.length;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, message, List.class);
    }
}