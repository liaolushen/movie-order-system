package com.jjfly.controller;

import com.jjfly.common.FormatResponse;
import com.jjfly.service.IndexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by luwin on 16-5-26.
 */

@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class IndexController {
    private final IndexServiceImpl indexService;

    @Autowired
    public IndexController(final IndexServiceImpl indexService) {
        this.indexService = indexService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    FormatResponse index(@RequestParam("name") String name) {
        return indexService.getMovieList(name);
    }
}
