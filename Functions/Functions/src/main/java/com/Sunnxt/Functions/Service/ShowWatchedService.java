package com.Sunnxt.Functions.Service;

import com.Sunnxt.Functions.Entity.ShowWatched;
import com.Sunnxt.Functions.Repository.ShowWatchedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowWatchedService {

    @Autowired
    private ShowWatchedRepository showWatchedRepository;

    public ShowWatched saveShowWatched(ShowWatched showWatched) {
        return showWatchedRepository.save(showWatched);
    }

    public List<ShowWatched> getAllShowsWatched() {
        return showWatchedRepository.findAll();
    }

    public ShowWatched getShowWatchedById(int id) {
        Optional<ShowWatched> optionalShowWatched = showWatchedRepository.findById(id);
        return optionalShowWatched.orElse(null);
    }



    public void deleteShowWatchedById(int id) {
        showWatchedRepository.deleteById(id);
    }
}
