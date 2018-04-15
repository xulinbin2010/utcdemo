package com.ntt.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ntt.model.Option;
import com.ntt.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping({"/option"})
public class OptionController {


    @Autowired
    OptionService optionService;


    @ResponseBody
    @RequestMapping("/add")
    public String addOption(Option option) {
        int i = optionService.addOption(option);
        JSONObject result = new JSONObject();
        if(i>0){
            System.out.println("add success");
            result.put("state", "success");
        }else{
            System.out.println("add fail");
            result.put("state", "fail");
        }
        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/update")
    public String updateOption(Option option) {
        int i = optionService.editOption(option);
        JSONObject result = new JSONObject();
        result.put("state", "success");
        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String deleteOption(HttpServletRequest request) {
        String[] list=request.getParameterValues("ids");

        System.out.println(list);
        int i = optionService.deleteOptions(list);
        JSONObject result = new JSONObject();
        if(i>0) {
            result.put("state", "success");
        }else{
            result.put("state", "fail");
        }
        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public String  findOptionList( HttpServletResponse response){
        response.setContentType("text/json");
        response.setCharacterEncoding("utf-8");
        List<Option> allOption = optionService.findAllOption();
        JSONObject result = new JSONObject();
        result.put("lists",allOption);
        System.out.println(result.toJSONString());
        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/all", produces = {"html/text;charset=UTF-8"})
    public String  findAllOption(@RequestParam int pageNumber, @RequestParam int pageSize, HttpServletResponse response){
        response.setContentType("text/json");
        response.setCharacterEncoding("utf-8");
        List<Option> allOption = optionService.findAllOption();
        int total = allOption.size();
        PageHelper.startPage(pageNumber,pageSize);
        List<Option> pageInfo=optionService.findAllOption();
        JSONObject result = new JSONObject();
        result.put("rows",pageInfo);
        result.put("total",total);
        System.out.println(result.toJSONString());
        return result.toJSONString();
    }

}
