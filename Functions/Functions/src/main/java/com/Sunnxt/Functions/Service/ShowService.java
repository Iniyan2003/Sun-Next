package com.Sunnxt.Functions.Service;

import com.Sunnxt.Functions.Entity.Show;
import com.Sunnxt.Functions.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public Show saveShow(Show show) {
        return showRepository.save(show);
    }
}
