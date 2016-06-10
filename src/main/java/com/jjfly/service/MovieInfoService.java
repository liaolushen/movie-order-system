package com.jjfly.service;

import com.jjfly.common.FormatResponse;

/**
 * Created by luwin on 16-5-28.
 */

public interface MovieInfoService {
    FormatResponse getMovieInfo(long movieId);
}
