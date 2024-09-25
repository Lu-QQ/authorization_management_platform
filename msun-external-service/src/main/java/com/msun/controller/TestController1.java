package com.msun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luqianqi
 * @title: TestController
 * @projectName authorization_management_platform
 * @description: TODO
 * @date 2024/9/2511:31
 */
@RestController
@RequestMapping("/external1/test")
public class TestController1 {

        @GetMapping("/test")
        public String test() {
            return "external test";
        }
}
