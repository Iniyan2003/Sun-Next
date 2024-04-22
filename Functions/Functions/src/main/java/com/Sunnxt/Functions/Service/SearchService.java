package com.Sunnxt.Functions.Service;

import com.Sunnxt.Functions.Entity.Search;
import com.Sunnxt.Functions.Repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    public Search saveSearch(Search search) {
        return searchRepository.save(search);
    }

    public List<Search> getAllSearches() {
        return searchRepository.findAll();
    }

    public Search getSearchById(int id) {
        Optional<Search> optionalSearch = searchRepository.findById(id);
        return optionalSearch.orElse(null);
    }

    public void deleteSearchById(int id) {
        searchRepository.deleteById(id);
    }
}
