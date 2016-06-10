package com.jjfly.service;

import com.jjfly.common.FormatResponse;
import com.jjfly.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Prac on 6/5/2016.
 */
@Service
public class RegisterService {

    @Autowired
    RegisterRepository registerRepository;

    public FormatResponse registerResponse(String name, String password, String tel) {
        return registerRepository.register(name, password, tel);
    }
}
