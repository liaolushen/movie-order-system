package com.jjfly.repository;

import com.jjfly.domain.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by luwin on 16-5-26.
 */
@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findByName(String name);
}