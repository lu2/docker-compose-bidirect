package com.cerlite.playground.bidirectb;

import com.cerlite.playground.bidirect.common.dto.CurrentDateDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BidirectARestClientService {

    @Value("${bidirectA.getCurrentDateUrl}")
    private String currentDateUrl;

    public CurrentDateDto getCurrentDate() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrentDateDto> response = restTemplate.getForEntity(currentDateUrl, CurrentDateDto.class);
        return response.getBody();
    }

}
