package com.xiaomaweii;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiaoweii
 * @create 2025-03-01 22:23
 */
@Controller
@Slf4j
public class TestController {

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return "test";
    }
}
