package com.yuan.gotonecore.http.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by cold
 * @date 2020/12/15
 */
@RestController
public class IndexController {

    @RequestMapping(value = {"/"})
    public String index() {
        return "Hello,这里是 yuan gotonecore.";
    }
}
