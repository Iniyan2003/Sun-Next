package com.Sunnxt.Functions.Controller;

import com.Sunnxt.Functions.Entity.Show;
import com.Sunnxt.Functions.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/addShow")
    public String addShow(@RequestBody Show show) {
        showService.saveShow(show);
        return "Show added successfully";
    }

    @GetMapping("/shows")
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @GetMapping("/showsbyid/{id}")
    public Show getShowById(@PathVariable("id") int id) {
        Show show = showService.getShowById(id);
        if (show != null) {
            return show;
        } else {
            return null; // Or handle the null scenario as appropriate
        }
    }

    @PutMapping("/updateshows/{id}")
    public String updateShow(@PathVariable("id") int id, @RequestBody Show updatedShow) {
        Show show = showService.getShowById(id);
        if (show != null) {
//            show.setShowSchedule(updatedShow.getShowSchedule());
//            show.setShowGenre(updatedShow.getShowGenre());
//            show.setChannelId(updatedShow.getChannelId());
            show.setSchedule(updatedShow.getSchedule());
            show.setGenre(updatedShow.getGenre());
            show.setChannelId(updatedShow.getChannelId());

            showService.saveShow(show);
            return "Show updated successfully!";
        } else {
            return "Show with ID " + id + " not found.";
        }
    }

    @DeleteMapping("/deleteShow/{id}")
    public String deleteShow(@PathVariable("id") int id) {
        Show show = showService.getShowById(id);
        if (show != null) {
            showService.deleteShowById(id);
            return "Show with ID " + id + " deleted successfully!";
        } else {
            return "Show with ID " + id + " not found.";
        }
    }

}
