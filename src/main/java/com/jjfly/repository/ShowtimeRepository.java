package com.jjfly.repository;

import com.jjfly.domain.Showtime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by luwin on 16-5-29.
 */
@Repository
public interface ShowtimeRepository extends CrudRepository<Showtime, Long> {
    List<Showtime> findByMovieToCinemaId(long movieToCinemaId);
}
