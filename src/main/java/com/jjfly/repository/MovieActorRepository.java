package com.jjfly.repository;

import com.jjfly.domain.MovieActor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by luwin on 16-5-28.
 */
@Repository
public interface MovieActorRepository extends CrudRepository<MovieActor, Long> {
    List<MovieActor> findByMovieId(long movieId);
}
