package com.jjfly.service;

import com.jjfly.common.FormatResponse;
import com.jjfly.domain.Movie;
import com.jjfly.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luwin on 16-5-26.
 */

@Service
public class IndexServiceImpl implements  IndexService {
    private final MovieRepository repository;

    @Autowired
    public IndexServiceImpl(final MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public FormatResponse getMovieList(String name) {
        List<Movie> movieList = repository.findByName(name);
        List<ModelMap> data = new ArrayList<>();
        for (Movie movie: movieList) {
            ModelMap dataItem = new ModelMap();
            dataItem.addAttribute("name", movie.getName());
            dataItem.addAttribute("hot", movie.getHot());
            data.add(dataItem);
        }
        return new FormatResponse(200, "OK", data);
    }


}
