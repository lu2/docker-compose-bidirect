package com.cerlite.playground.bidirectb;

import com.cerlite.playground.bidirect.common.dto.CurrentDateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HelloController {

    @Autowired
    private BidirectARestClientService bidirectARestClientService;

    @ModelAttribute
    public void addAttributes(Model model) {
        CurrentDateDto currentDateDto = bidirectARestClientService.getCurrentDate();
        model.addAttribute("aCurrentDate", currentDateDto.getCurrentDate());
    }

    @GetMapping
    public String get() {
        return "hello";
    }

}
