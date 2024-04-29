package com.Sunnxt.Functions.Service;

import com.Sunnxt.Functions.Entity.Show;
import com.Sunnxt.Functions.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public Show saveShow(Show show) {
        return showRepository.save(show);
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Show getShowById(int id) {
        Optional<Show> optionalShow = showRepository.findById(id);
        return optionalShow.orElse(null);
    }

    public void deleteShowById(int id) {
        showRepository.deleteById(id);
    }

}
