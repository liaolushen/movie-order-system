package com.jjfly.service;

import com.jjfly.common.FormatResponse;

/**
 * Created by luwin on 16-5-29.
 */
public interface ShowtimeService {
    FormatResponse getShowtimeList(long movieToCinemaId);
    FormatResponse getShowtimeInfo(long showtimeId);
    FormatResponse reserveSeat(long showtimeId, String seatStatus);
}
