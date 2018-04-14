package com.ntt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {

    @RequestMapping("/planSetting")
    public String planSetting(){
        return "planSetting";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping("/main")
    public String main(){
        return "main";
    }


    @RequestMapping("/statusList")
    public String statusList(){
        return "statusList";
    }

    @RequestMapping("/uploadExcel")
    public String uploadExcel(){
        return "uploadExcel";
    }



//    @RequestMapping("/statusList")
//    public String indexList(Model model){
//        Person single=new Person("aa",1);
//        List<Person> people=new ArrayList<Person>();
//        Person p1=new Person("bb",2);
//        Person p2=new Person("cc",3);
//        Person p3=new Person("dd",4);
//        people.add(p1);
//        people.add(p2);
//        people.add(p3);
//        model.addAttribute("singlePerson",single);
//        model.addAttribute("people",people);
//        return "statusList";
//    }
}
