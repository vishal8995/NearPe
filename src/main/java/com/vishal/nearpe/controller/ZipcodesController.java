package com.vishal.nearpe.controller;

import com.vishal.nearpe.service.ZipcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ZipcodesController {

    @Autowired
    ZipcodeService zipcodeService;

    @GetMapping("api/state/options")
    List<String> getStates(){
        return zipcodeService.getState();
    }

    @GetMapping("api/city/options")
    List<String> getCity(@RequestParam String states){
        return zipcodeService.getCity(states);
    }

    @GetMapping("api/zipcode/options")
    List<Integer> getZip(@RequestParam String city){
        return zipcodeService.getZip(city);
    }

}
