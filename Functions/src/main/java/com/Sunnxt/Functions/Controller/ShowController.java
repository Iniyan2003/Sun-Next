package com.Sunnxt.Functions.Controller;

import com.Sunnxt.Functions.Entity.Show;
import com.Sunnxt.Functions.Repository.ShowRepository;
import com.Sunnxt.Functions.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowController {

    @Autowired
    private ShowService showService;

    @Autowired
    private ShowRepository showRepository;

    @PostMapping("/addShow/{userId}")
    public String addShow(@PathVariable("userId") int userId, @RequestBody Show show) {
        showService.createShow(userId, show);
        return "Show added successfully";
    }

    @PutMapping("/updateshows/{userId}/{id}")
    public String updateShow(@PathVariable("userId") int userId, @PathVariable("id") int id, @RequestBody Show show) {
        showService.updateShow(userId, id, show);
        return "Show updated successfully!";
    }

    @DeleteMapping("/deleteShow/{userId}/{id}")
    public String deleteShow(@PathVariable("userId") int userId, @PathVariable("id") int id) {
       Show show = showService.findById(id);
       if(show!=null)
       {
           showService.deleteShow(userId, id);
           return "Show with ID " + id + " Deleted successfully!";
        } else {
            return "Show with ID " + id + " not found.";
        }
    }

    @GetMapping("/getAllShows")
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @GetMapping("/searchByName/{name}")
    public Show getByName(@PathVariable("name") String name) {
        Show show = showService.getByName(name);
        if(show!=null) {
            return showService.getByName(name);
        }
        else {
            return null;
        }
    }

}
