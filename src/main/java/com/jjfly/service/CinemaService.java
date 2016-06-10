package com.jjfly.service;

import com.jjfly.common.FormatResponse;

/**
 * Created by luwin on 16-5-29.
 */
public interface CinemaService {
    FormatResponse getCinemaList(long movieId, String viewingDate);
}
