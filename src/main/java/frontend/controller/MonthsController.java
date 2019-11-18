package frontend.controller;

import frontend.model.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class MonthsController {

    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping("/months")
    public String getMonths(Model model) {
        List<Month> months = Arrays.asList(restTemplate.getForObject("http://localhost:8081/api/months", Month[].class));
        model.addAttribute("months", months);
        return "months";
    }

}
