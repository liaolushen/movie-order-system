package com.jjfly.controller;

import com.jjfly.common.FormatResponse;
import com.jjfly.service.CinemaService;
import com.jjfly.service.CinemaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by luwin on 16-5-29.
 */

@RestController
@RequestMapping(produces = "application/json; charset=utf-8", value = "/api/cinema")
public class CinemaController {
    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(final CinemaServiceImpl cinemaService) {
        this.cinemaService = cinemaService;
    }

    @RequestMapping(value = "/get-cinema-list", method = RequestMethod.GET)
    public @ResponseBody
    FormatResponse index(@RequestParam("movie_id") long movieId, @RequestParam("viewing_date") String viewingDate) {
        return cinemaService.getCinemaList(movieId, viewingDate);
    }
}
