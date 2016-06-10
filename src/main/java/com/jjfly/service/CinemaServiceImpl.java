package com.jjfly.service;

import com.jjfly.common.FormatResponse;
import com.jjfly.domain.MovieToCinema;
import com.jjfly.repository.CinemaRepository;
import com.jjfly.repository.MovieToCinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luwin on 16-5-29.
 */

@Service
public class CinemaServiceImpl implements CinemaService {
    private final MovieToCinemaRepository movieToCinemaRepository;
    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaServiceImpl(MovieToCinemaRepository movieToCinemaRepository,
                             CinemaRepository cinemaRepository) {
        this.movieToCinemaRepository = movieToCinemaRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public FormatResponse getCinemaList(long movieId, String viewingDate) {
        List<ModelMap> data = new ArrayList<>();
        List<MovieToCinema> movieToCinemaList = movieToCinemaRepository.findByMovieIdAndViewingDate(movieId, viewingDate);
        for (MovieToCinema movieToCinemaItem : movieToCinemaList) {
            ModelMap dateItem = new ModelMap();
            dateItem.addAttribute("movieToCinemaId", movieToCinemaItem.getId());
            dateItem.addAttribute("hasDiscount", movieToCinemaItem.isHasDiscount());
            dateItem.addAttribute("cinemaInfo", cinemaRepository.findOne(movieToCinemaItem.getCinemaId()));
            data.add(dateItem);
        }
        return new FormatResponse(200, "OK", data);
    }
}
