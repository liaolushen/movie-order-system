package com.jjfly.service;

import com.jjfly.common.FormatResponse;
import com.jjfly.domain.Movie;
import com.jjfly.domain.MovieActor;
import com.jjfly.repository.MovieActorRepository;
import com.jjfly.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by luwin on 16-5-28.
 */

@Service
public class MovieInfoServiceImpl implements MovieInfoService {

    private final MovieRepository movieRepository;
    private final MovieActorRepository movieActorRepository;

    @Autowired
    public MovieInfoServiceImpl(
            final MovieRepository movieRepository,
            final MovieActorRepository movieActorRepository) {
        this.movieRepository = movieRepository;
        this.movieActorRepository = movieActorRepository;
    }

    @Override
    public FormatResponse getMovieInfo(long movieId) {
        Movie movie = movieRepository.findOne(movieId);
        List<MovieActor> actors = movieActorRepository.findByMovieId(movieId);
        ModelMap data = new ModelMap(movie);
        data.addAttribute("actors", actors);
        return new FormatResponse(200, "OK", data);
    }
}
