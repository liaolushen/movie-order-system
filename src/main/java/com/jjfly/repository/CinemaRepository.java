package com.jjfly.repository;

import com.jjfly.domain.Cinema;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by luwin on 16-5-28.
 */
public interface CinemaRepository  extends CrudRepository<Cinema, Long> {
}
