package com.ntt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/planSetting")
    public String planSetting(){
        return "planSetting";
    }

    @RequestMapping("/optionSetting")
    public String optionSetting(){
        return "optionSetting";
    }



    @RequestMapping("/uploadExcel")
    public String uploadExcel(){
        return "uploadExcel";
    }


    @RequestMapping("/test")
    public String test(){
        return "test";
    }

}
