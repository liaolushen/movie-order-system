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
    public FormatResponse getMovieList() {
        /**
         * 返回首页的电影列表
         */
        List<Movie> movieList = (List<Movie>) repository.findAll();
        List<ModelMap> data = new ArrayList<>();
        for (Movie movie: movieList) {
            ModelMap dataItem = new ModelMap();
            dataItem.addAttribute("id", movie.getId());
            dataItem.addAttribute("imageUrl", movie.getImgUrl());
            dataItem.addAttribute("name", movie.getName());
            dataItem.addAttribute("hot", movie.getHot());
            data.add(dataItem);
        }
        return new FormatResponse(200, "OK", data);
    }




}
