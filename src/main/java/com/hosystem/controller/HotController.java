package com.hosystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hyh
 * @Createdate 2022/12/7 10:43
 */
@RestController
@RequestMapping("/hot")
public class HotController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        boolean flag = true;
        if (flag) {
            System.out.println("开始处理逻辑");
            throw new RuntimeException("出异常了");
        }
        System.out.println("结束流程");
        return "hot test";
    }
}
