package com.ntt.controller;

import com.ntt.model.Engine;
import com.ntt.model.EngineDto;
import com.ntt.service.EngineService;
import com.ntt.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    private static int UNIT=35;
    private static int ALLDAYS=32;

    @Autowired
    private EngineService engineService;

    @RequestMapping("/main")
    public String mainPage(Model model){
        Date date= new Date();
        List<String> dateBarList = dateBarList(date, ALLDAYS);  //取得日期条
        List<EngineDto> engineList = null;  //取得日期条
        try {
            engineList = getEngineMain(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        model.addAttribute("dateBarList",dateBarList);
        model.addAttribute("engineList",engineList);
        return "main";
    }


    private  List<EngineDto> getEngineMain(Date beginDate) throws ParseException {
        List<Engine> allEngineAndOption = engineService.findAllEngineAndOption();
        List<EngineDto> returnList= new ArrayList<>();
        for (Engine engine : allEngineAndOption) {
            EngineDto dto= new EngineDto();
            int cursor;
            int marginWidth= 0;
            int g0Width= 0;
            int g1Width= 0;
            int g2Width= 0;
            int g3Width= 0;
            String soNo = engine.getSoNo();
            String myStartDate = engine.getStartDate();
            int g0days = engine.getOption().getgZero();
            int g1days = engine.getOption().getgOne();
            int g2days = engine.getOption().getgTwo();
            int g3days = engine.getOption().getgThree();


            dto.setSoNo(soNo);

            int marginDays = DateUtils.daysBetween(beginDate, DateUtils.format(myStartDate));  //取得日期差值
            cursor = marginDays;
            if (cursor >= 0 && cursor < ALLDAYS) {
                marginWidth = cursor;
            }
//            cursor += g0days ;
            int all = g0days + cursor;
            if(all>0){
                if(all<=ALLDAYS){
                    g0Width=all;
                }else{
                    g0Width=ALLDAYS-cursor;
                }
            }
            cursor+=g0days;

            int all_1 = g1days + cursor;
            if(all_1>0){
                if(all<=ALLDAYS){
                    g1Width=all_1;
                }else{
                    g1Width=ALLDAYS-cursor;
                }
            }
            cursor+=g1days;

            int all_2 = g2days + cursor;
            if(all_2>0){
                if(all<=ALLDAYS){
                    g2Width=all_2;
                }else{
                    g2Width=ALLDAYS-cursor;
                }
            }
            cursor+=g2days;

            int all_3 = g3days + cursor;
            if(all_3>0){
                if(all<=ALLDAYS){
                    g3Width=all_3;
                }else{
                    g3Width=ALLDAYS-cursor;
                }
            }
            cursor+=g2days;

            dto.setMarginLeft("margin-left: " + (marginWidth+4) * 35 + "px;");

            if(g0Width>0) {
                dto.setG0width("width:" + g0Width * 35 + "px;");
            }else{
                dto.setG0width("display:none");
            }

            if(g1Width>0) {
                dto.setG1width("width:" + g1Width * 35 + "px;");
            }else{
                dto.setG1width("display:none");
            }

            if(g2Width>0) {
                dto.setG2width("width:" + g2Width * 35 + "px;");
            }else{
                dto.setG2width("display:none");
            }

            if(g3Width>0) {
                dto.setG3width("width:" + g3Width * 35 + "px;");
            }else{
                dto.setG3width("display:none");
            }


            returnList.add(dto);
        }
        return returnList;

    }



    /**
     *  日期条列表
     * @param date
     * @param dayNum
     * @return
     */
    private  List<String> dateBarList(Date date, int dayNum) {
        List<String> lists= new ArrayList<>();
        for (int i = 0; i < dayNum; i++) {
            Date dateAfter = DateUtils.getDateAfter(date, i );
            String s = DateUtils.convertDay(dateAfter);
            lists.add(s);
        }
        return lists;
    }


//    public static void main(String[] args) {
//        Date date= new Date();
//        List<String> strings = dateBarList(date, 32);
//        for (String string : strings) {
//            System.out.println("string = " + string);
//        }
//
//
//
//    }
}
