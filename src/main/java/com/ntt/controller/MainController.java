package com.ntt.controller;

import com.ntt.model.Engine;
import com.ntt.model.EngineDto;
import com.ntt.model.Option;
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

import static com.ntt.util.DateUtils.getDateAfter;

@Controller
public class MainController {

    private static int UNIT = 35;
    private static int ALLDAYS = 32; // 时间条长度，后期可以修改

    @Autowired
    private EngineService engineService;

    @RequestMapping("/main")
    public String mainPage(Model model) {
        Date date = new Date();
        String sDate = DateUtils.convertCommon(date);
        List<String> dateBarList = dateBarList(date, ALLDAYS);  //取得日期条
        List<EngineDto> engineList = null;  //取得plan engine list
        try {
            engineList = getEngineMain(DateUtils.format(sDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        model.addAttribute("dateBarList", dateBarList);
        model.addAttribute("engineList", engineList);
        return "main";
    }


    /**
     * 日期条列表
     *
     * @param date
     * @param dayNum
     * @return
     */
    private List<String> dateBarList(Date date, int dayNum) {
        List<String> lists = new ArrayList<>();
        for (int i = 0; i < dayNum; i++) {
            Date dateAfter = getDateAfter(date, i);
            String s = DateUtils.convertDay(dateAfter);
            lists.add(s);
        }
        return lists;
    }


    /**
     * 每个engine 的 plan 列表参数
     * @param beginDate
     * @return
     * @throws ParseException
     */
    private List<EngineDto> getEngineMain(Date beginDate) throws ParseException {
        List<Engine> allEngineAndOption = engineService.findAllEngineAndOption();
        List<EngineDto> returnList = new ArrayList<>();
        for (Engine engine : allEngineAndOption) {

            EngineDto dto = getDtoBy(engine, beginDate);

            returnList.add(dto);
        }
        return returnList;

    }

    private static EngineDto getDtoBy(Engine engine, Date beginDate) throws ParseException {
        EngineDto dto = new EngineDto();

        int cursor;
        int marginWidth = 0;
        int g0Width = 0;
        int g1Width = 0;
        int g2Width = 0;
        int g3Width = 0;
        String soNo = engine.getSoNo();
        String myStartDate = engine.getOption().getoStartDate();  //根据相应的

        int g0days = engine.getOption().getgZero();
        int g1days = engine.getOption().getgOne();
        int g2days = engine.getOption().getgTwo();
        int g3days = engine.getOption().getgThree();


        int marginDays = DateUtils.daysBetween(beginDate, DateUtils.format(myStartDate));  //取得日期差值
        if (marginDays >= 0 && marginDays <= ALLDAYS) { //只有在日期范围内才会显示，即有margin值
            marginWidth = marginDays;
        }
        cursor = marginDays;

        if(cursor<=ALLDAYS) {  //如果游标超出长度，不进行处理了
            int all = g0days + cursor;
            if (all > 0) {
                if (all < g0days && all < ALLDAYS) {
                    g0Width = all;
                } else if (all >= g0days && all <= ALLDAYS) {
                    g0Width = g0days;
                } else if (all > ALLDAYS) {
                    g0Width = ALLDAYS - marginWidth;
                }
            }
        }
        cursor += g0days;

        if(cursor<=ALLDAYS) {  //如果游标超出长度，不进行处理了
            int all_1 = g1days + cursor;
            if (all_1 > 0) {
                if (all_1 < g1days && all_1 < ALLDAYS) {
                    g1Width = all_1;
                } else if (all_1 >= g1days && all_1 <= ALLDAYS) {
                    g1Width = g1days;
                } else if (all_1 > ALLDAYS) {
                    g1Width = ALLDAYS - marginWidth - g0Width;
                }
            }
        }
        cursor += g1days;

        if(cursor<=ALLDAYS) {  //如果游标超出长度，不进行处理了
            int all_2 = g2days + cursor;
            if (all_2 > 0) {
                if (all_2 < g2days && all_2 < ALLDAYS) {
                    g2Width = all_2;
                } else if (all_2 >= g2days && all_2 <= ALLDAYS) {
                    g2Width = g2days;
                } else if (all_2 > ALLDAYS) {
                    g2Width = ALLDAYS - marginWidth - g0Width - g1Width;
                }
            }
        }
        cursor += g2days;

        if(cursor<=ALLDAYS) {  //如果游标超出长度，不进行处理了
            int all_3 = g3days + cursor;
            if (all_3 > 0) {
                if (all_3 < g3days && all_3 < ALLDAYS) {
                    g3Width = all_3;
                } else if (all_3 >= g3days && all_3 <= ALLDAYS) {
                    g3Width = g3days;
                } else if (all_3 > ALLDAYS) {
                    g3Width = ALLDAYS - marginWidth - g0Width - g1Width - g2Width;
                }
            }
        }
        cursor += g3days;

        dto.setOption(engine.getOption());
        dto.setSoNo(soNo);
        dto.setMarginLeft(marginWidth*UNIT);
        dto.setG0(g0Width*UNIT);
        dto.setG1(g1Width*UNIT);
        dto.setG2(g2Width*UNIT);
        dto.setG3(g3Width*UNIT);

        // 开始设置actual 的engine 的
        int cursorAC;
        int marginWidthAC = 0;
        int g0WidthAC = 0;
        int g1WidthAC = 0;
        int g2WidthAC = 0;
        int g3WidthAC = 0;
        String myStartDateAC = engine.getStartDate();  //根据相应的

        int g0daysAC = engine.getG0days();
        int g1daysAC = engine.getG1days();
        int g2daysAC = engine.getG2days();
        int g3daysAC = engine.getG3days();

        int marginDaysAC = DateUtils.daysBetween(beginDate, DateUtils.format(myStartDateAC));  //取得日期差值
        if (marginDaysAC >= 0 && marginDaysAC <= ALLDAYS) { //只有在日期范围内才会显示，即有margin值
            marginWidthAC = marginDaysAC;
        }
        cursorAC = marginDaysAC;

        if(cursorAC<=ALLDAYS) {  //如果游标超出长度，不进行处理了
            int allAC = g0daysAC + cursorAC;
            if (allAC > 0) {
                if (allAC < g0daysAC && allAC < ALLDAYS) {
                    g0WidthAC = allAC;
                } else if (allAC >= g0daysAC && allAC <= ALLDAYS) {
                    g0WidthAC = g0daysAC;
                } else if (allAC > ALLDAYS) {
                    g0WidthAC = ALLDAYS - marginWidthAC;
                }
            }
        }
        cursorAC += g0daysAC;

        if(cursorAC<=ALLDAYS) {  //如果游标超出长度，不进行处理了
            int all_1AC = g1daysAC + cursorAC;
            if (all_1AC > 0) {
                if (all_1AC < g1daysAC && all_1AC < ALLDAYS) {
                    g1WidthAC = all_1AC;
                } else if (all_1AC >= g1daysAC && all_1AC <= ALLDAYS) {
                    g1WidthAC = g1daysAC;
                } else if (all_1AC > ALLDAYS) {
                    g1WidthAC = ALLDAYS - marginWidthAC - g0WidthAC;
                }
            }
        }
        cursorAC += g1daysAC;

        if(cursorAC<=ALLDAYS) {  //如果游标超出长度，不进行处理了
            int all_2AC = g2daysAC + cursorAC;
            if (all_2AC > 0) {
                if (all_2AC < g2daysAC && all_2AC < ALLDAYS) {
                    g2WidthAC = all_2AC;
                } else if (all_2AC >= g2daysAC && all_2AC <= ALLDAYS) {
                    g2WidthAC = g2daysAC;
                } else if (all_2AC > ALLDAYS) {
                    g2WidthAC = ALLDAYS - marginWidthAC - g0WidthAC - g1WidthAC;
                }
            }
        }
        cursorAC += g2daysAC;

        if(cursorAC<=ALLDAYS) {  //如果游标超出长度，不进行处理了
            int all_3AC = g3daysAC + cursorAC;
            if (all_3AC > 0) {
                if (all_3AC < g3daysAC && all_3AC < ALLDAYS) {
                    g3WidthAC = all_3AC;
                } else if (all_3AC >= g3daysAC && all_3AC <= ALLDAYS) {
                    g3WidthAC = g3daysAC;
                } else if (all_3AC > ALLDAYS) {
                    g3WidthAC = ALLDAYS - marginWidthAC - g0WidthAC - g1WidthAC - g2WidthAC;
                }
            }
        }
        cursorAC += g3daysAC;


        dto.setMarginLeftAC(marginWidthAC*UNIT);
        dto.setG0normal(g0WidthAC*UNIT);
        dto.setG1normal(g1WidthAC*UNIT);
        dto.setG2normal(g2WidthAC*UNIT);
        dto.setG3normal(g3WidthAC*UNIT);

        return dto;
    }

    /**
     * 获取两个时间段的超前，延期天数
     * @param barStartDate
     * @param barDays
     * @param planStartDate
     * @param planDays
     * @param actualStartDate
     * @param actualDays
     * @return
     */
    private List<Integer> getDiffDays(Date barStartDate,int barDays,Date planStartDate,int planDays,Date actualStartDate,int actualDays){
        List<Integer> returnDays = new ArrayList<>();
        int diffStartCount = DateUtils.daysBetween(actualStartDate,planStartDate);
        if(diffStartCount>0){ //存在提前
            returnDays.add(diffStartCount);
        }else{
            returnDays.add(0);
        }
        Date planEndDate   = DateUtils.getDateAfter(planStartDate,planDays);
        Date actualEndDate   = DateUtils.getDateAfter(actualStartDate,actualDays);
        int diffEndCount = DateUtils.daysBetween(planEndDate,actualEndDate);
        if(diffEndCount>0){  //存在延期
            returnDays.add(diffEndCount);
        }else{
            returnDays.add(0);
        }
        returnDays.add(actualDays-diffStartCount-diffEndCount);  //正常时间
        return returnDays;
    }


    public static void main(String[] args) {

//        Date date = new Date();
//        Engine e = new Engine();
//        Option option = new Option();
//        e.setStartDate("2018-04-19");
//        option.setgZero(5);
//        option.setgOne(3);
//        option.setgTwo(7);
//        option.setgThree(6);
//        e.setSoNo("7171717");
//        e.setOption(option);
//        try {
//            EngineDto dtoBy = getDtoBy(e, date);
//        } catch (ParseException e1) {
//            e1.printStackTrace();
//        }
//        System.out.println("dto = ");


    }
}
