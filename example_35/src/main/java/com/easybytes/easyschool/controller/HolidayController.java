package com.easybytes.easyschool.controller;

import com.easybytes.easyschool.model.Holiday;
import com.easybytes.easyschool.repository.HolidaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.StreamSupport;

@Controller
public class HolidayController {

    @Autowired
    private HolidaysRepository holidaysRepository;

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model) {

        if (null != display && display.equals("all")) {
            model.addAttribute("festival", true);
            model.addAttribute("federal", true);
        } else if (null != display && display.equals("festival")) {
            model.addAttribute("festival", true);
        } else {
            model.addAttribute("federal", true);
        }

        Iterable<Holiday> holidays = holidaysRepository.findAll();

        List<Holiday> holidayList = StreamSupport.stream(holidays.spliterator(), false).toList();

        Holiday.Type[] values = Holiday.Type.values();
        for (Holiday.Type type : values) {
            model.addAttribute(type.toString(),
                    holidayList.stream()
                            .filter(holiday -> holiday.getType().equals(type))
                            .toList());
        }

        return "holidays.html";
    }
}
