package com.jjfly.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jjfly.common.FormatResponse;
import com.jjfly.service.RegisterService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Prac on 6/5/2016.
 */
@RestController
@RequestMapping(produces = "application/json; charset=utf-8")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    @ResponseBody
    public FormatResponse register(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.get("username").toString();
        String password = jsonObject.get("password").toString();
        String tel = jsonObject.get("tel").toString();
        return registerService.registerResponse(username, password, tel);
    }
}
