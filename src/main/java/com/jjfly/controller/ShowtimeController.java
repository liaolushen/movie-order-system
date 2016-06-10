package com.jjfly.controller;

import com.jjfly.common.FormatResponse;
import com.jjfly.service.ShowtimeService;
import com.jjfly.service.ShowtimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by luwin on 16-5-29.
 */

@RestController
@RequestMapping(produces = "application/json; charset=utf-8", value = "/api/showtime")
public class ShowtimeController {
    private final ShowtimeService showtimeService;

    @Autowired
    public ShowtimeController(final ShowtimeServiceImpl showtimeService) {
        this.showtimeService = showtimeService;
    }

    @RequestMapping(value = "/get-showtime-list", method = RequestMethod.GET)
    public @ResponseBody
    FormatResponse index(@RequestParam("movie_to_cinema_id") long movieToCinemaId) {
        return showtimeService.getShowtimeList(movieToCinemaId);
    }

    @RequestMapping(value = "/get-showtime-info", method = RequestMethod.GET)
    public @ResponseBody
    FormatResponse getShowtime(@RequestParam("showtime_id") long showtimeId) {
        return showtimeService.getShowtimeInfo(showtimeId);
    }

    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    public @ResponseBody
    FormatResponse reserve(@RequestParam("showtime_id") long showtimeId, @RequestParam("seat_status") String seatStatus) {
        return showtimeService.reserveSeat(showtimeId, seatStatus);
    }
}
