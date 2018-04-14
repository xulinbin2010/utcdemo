package com.ntt.controller;

import com.github.pagehelper.PageHelper;
import com.ntt.model.Engine;
import com.ntt.service.EngineService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping({"/engine"})
public class EngineController {


    @Autowired
    EngineService engineService;



    @ResponseBody
    @RequestMapping("/add")
    public String addEngine(Engine engine) {
        int i = engineService.addEngine(engine);
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
    public String updateEngine(Engine engine) {
        int i = engineService.editEngine(engine);
        JSONObject result = new JSONObject();
        result.put("state", "success");
        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String deleteEngine(HttpServletRequest request) {
        String[] list=request.getParameterValues("ids");

        System.out.println(list);
        int i = engineService.deleteEngines(list);
        JSONObject result = new JSONObject();
        if(i>0) {
            result.put("state", "success");
        }else{
            result.put("state", "fail");
        }
        return result.toJSONString();
    }

//    @RequestMapping(value = "/find")
//    @ResponseBody
//    public String engineInfo(){
//        Engine engine = engineService.getEngineBySono("E6789-01");
//        return engine.getCustomer()+"-----"+engine.getCustomer();
//    }


    @ResponseBody
    @RequestMapping(value = "/all", produces = {"html/text;charset=UTF-8"})
    public String  findAllEngine(@RequestParam int pageNumber,@RequestParam int pageSize,HttpServletResponse response){
//
//        List<Engine> allEngine = engineService.findAllEngine(pageNumber, pageSize);
//        JSONObject result = new JSONObject();
//        result.put("rows",allEngine);
//        System.out.println("result = " + result.toJSONString());
//        return result.toJSONString();



        response.setContentType("text/json");
        response.setCharacterEncoding("utf-8");
        List<Engine> allEngine = engineService.findAllEngine();
        int total = allEngine.size();
        PageHelper.startPage(pageNumber,pageSize);
        List<Engine> pageInfo=engineService.findAllEngine();
        JSONObject result = new JSONObject();
        result.put("rows",pageInfo);
        result.put("total",total);
        System.out.println(result.toJSONString());
        return result.toJSONString();
    }


//    @ResponseBody
//    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
//    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
//
//        return engineService.findAllEngine(pageNum,pageSize);
//    }
}
