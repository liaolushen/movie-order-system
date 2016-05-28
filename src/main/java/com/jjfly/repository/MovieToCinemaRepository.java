package com.jjfly.repository;

import com.jjfly.domain.MovieToCinema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by luwin on 16-5-28.
 */
@Repository
public interface MovieToCinemaRepository extends CrudRepository<MovieToCinema, Long> {
    List<MovieToCinema> findByMovieIdAndViewingDate(long movieId, String viewingDate);
}
