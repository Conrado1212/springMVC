package pl.edu.wszib.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.model.Scooter;

import java.util.Scanner;

@Controller
public class ScooterController {

        @RequestMapping(value = "/scooter_page",method = RequestMethod.GET)
        public ModelAndView scooterPage(){
            return new ModelAndView("scooterPage","scooterKey",new Scooter());
        }

        @RequestMapping(value = "/scooter_page",method = RequestMethod.POST)
        public String scooterForm(@ModelAttribute("scooterKey")Scooter scooter){
            System.out.println(scooter);
            return "scooterPage";
        }

        @RequestMapping(value = "/index",method = RequestMethod.GET)
        public String index(){
            return "index";
        }
}
