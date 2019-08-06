package com.cerlite.playground.bidirecta;

import com.cerlite.playground.bidirect.common.dto.CurrentDateDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class HelloController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CurrentDateDto getIndex() {
        LOG.info("GetCurrentDate requested");
        CurrentDateDto currentDateDto = new CurrentDateDto();
        currentDateDto.setMessage("Current Date");
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        currentDateDto.setCurrentDate(date.format(formatter));
        return currentDateDto;
    }

}
