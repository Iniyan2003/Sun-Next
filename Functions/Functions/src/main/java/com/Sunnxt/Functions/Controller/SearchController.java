package com.Sunnxt.Functions.Controller;

import com.Sunnxt.Functions.Entity.Search;
import com.Sunnxt.Functions.Service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("/createSearch")
    public String createSearch(@RequestBody Search search) {
        searchService.saveSearch(search);
        return "Search created successfully!";
    }

    @GetMapping("/searches")
    public List<Search> getAllSearches() {
        return searchService.getAllSearches();
    }

    @PutMapping("/updateSearch/{id}")
    public String updateSearch(@PathVariable("id") int id, @RequestBody Search updatedSearch) {
        Search search = searchService.getSearchById(id);
        if (search != null) {
            // Update the fields of the existing search with the new data
            search.setPopularSearches(updatedSearch.getPopularSearches());
            search.setSearchBehavior(updatedSearch.getSearchBehavior());
            search.setUserId(updatedSearch.getUserId());

            searchService.saveSearch(search);
            return "Search with ID " + id + " updated successfully!";
        } else {
            return "Search with ID " + id + " not found.";
        }
    }

    @DeleteMapping("/deleteSearch/{id}")
    public String deleteSearch(@PathVariable("id") int id) {
        Search search = searchService.getSearchById(id);
        if (search != null) {
            searchService.deleteSearchById(id);
            return "Search with ID " + id + " deleted successfully!";
        } else {
            return "Search with ID " + id + " not found.";
        }
    }

    // Add more controller methods as needed
}
