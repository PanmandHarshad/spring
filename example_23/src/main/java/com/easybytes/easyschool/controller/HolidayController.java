package com.easybytes.easyschool.controller;

import com.easybytes.easyschool.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class HolidayController {

    @GetMapping("/holidays")
    public String displayHolidays(@RequestParam(required = false) boolean festival,
                                  // default value of required true
                                  @RequestParam(required = true) boolean federal,
                                  Model model) {

        model.addAttribute("festival", festival);
        model.addAttribute("federal", federal);

        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1 ", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ", "Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ", "Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ", "Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17 ", "Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                new Holiday(" July 4 ", "Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ", "Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Nov 11 ", "Veterans Day", Holiday.Type.FEDERAL)
        );

        Holiday.Type[] values = Holiday.Type.values();
        for (Holiday.Type type : values) {
            model.addAttribute(type.toString(),
                    holidays.stream()
                            .filter(holiday -> holiday.type().equals(type))
                            .toList());
        }

        return "holidays.html";
    }
}
