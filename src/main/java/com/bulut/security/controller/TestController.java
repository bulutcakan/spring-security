package com.bulut.security.controller;

import com.bulut.security.service.DataGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    DataGeneratorService dataGeneratorService;


    @RequestMapping("/sample")
    public ModelAndView getOwners() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("samples", dataGeneratorService.getSampleData());
        mav.setViewName("sample");
        return mav;
    }

    @GetMapping("/sampledata")
    public ResponseEntity getData() {

        return new ResponseEntity(dataGeneratorService.getSampleData(), HttpStatus.ACCEPTED);
    }


    @RequestMapping("/pcs")
    @ResponseBody
    public String welcome() {
        return "Welcome to PetClinic World!";
    }

}
