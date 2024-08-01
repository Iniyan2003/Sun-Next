package com.Sunnxt.Functions.Service;

import com.Sunnxt.Functions.Entity.Channel;
import com.Sunnxt.Functions.Entity.Show;
import com.Sunnxt.Functions.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserService userService;

    public Show createShow(int userId, Show show) {
        if (userService.isChannelAdminLoggedIn(userId)) {

            return showRepository.save(show);
        } else {
            throw new IllegalArgumentException("Only logged-in Channel Admin can create a show for a channel.");
        }
    }

    public void deleteShow(int userId, int id) {
        if (userService.isChannelAdminLoggedIn(userId)) {
            showRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Only logged-in Channel Admin can delete a show.");
        }
    }

    public Show updateShow(int userId, int id, Show show) {
        if (userService.isChannelAdminLoggedIn(userId)) {
            Show show1 = showRepository.findById(id).orElseThrow(() -> new RuntimeException("Show not found with Show ID : " + id));

            show1.setName(show.getName());
            show1.setDescription(show.getDescription());
            show1.setSchedule((show.getSchedule()));
            show1.setGenre(show.getGenre());

            return showRepository.save(show);
        } else {
            throw new IllegalArgumentException("Only logged-in Channel Admins can update shows.");
        }
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Show getByName(String name) {
        return showRepository.findByName(name);
    }


    public Show findById(int id) {
        Optional<Show> dispShow = showRepository.findById(id);
        return dispShow.orElse(null);
    }

}
