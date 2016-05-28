package com.jjfly.controller;

import com.jjfly.common.FormatResponse;
import com.jjfly.service.MovieInfoService;
import com.jjfly.service.MovieInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by luwin on 16-5-28.
 */

@RestController
@RequestMapping(produces = "application/json; charset=utf-8", value = "/api/movie-info")
public class MovieInfoController {
    private final MovieInfoService movieInfoService;

    @Autowired
    public MovieInfoController(final MovieInfoServiceImpl movieInfoService) {
        this.movieInfoService = movieInfoService;
    }

    @RequestMapping(value = "/get-movie-info", method = RequestMethod.GET)
    public @ResponseBody
    FormatResponse index(@RequestParam("movie_id") long movieId) {
        return movieInfoService.getMovieInfo(movieId);
    }
}
