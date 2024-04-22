package com.Sunnxt.Functions.Controller;

import com.Sunnxt.Functions.Entity.Show;
import com.Sunnxt.Functions.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/addShow")
    public String addShow(@RequestBody Show show) {
        showService.saveShow(show);
        return "Show added successfully";
    }
}
