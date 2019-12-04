package pl.edu.wszib.controller;


import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.model.Scooter;
import pl.edu.wszib.repository.ScooterRepository;

import java.util.Scanner;

@Controller
public class ScooterController {

    ScooterRepository scooterRepository;

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

        @RequestMapping(value = "/add",method = RequestMethod.POST)
        public String addScooter(@ModelAttribute("addScooter")Scooter scooter){
                scooterRepository.addScooter(scooter);
            return "addScooter";
        }

        @RequestMapping(value = "/removeScooterId",method = RequestMethod.DELETE)
        public String removeScooterId(@PathVariable("Id")int id, Model model){
            model.addAttribute("allScooter",scooterRepository.getAllScooters());
            scooterRepository.removeScooterId(id);
            return "removeScooterId";
        }

   //     @RequestMapping(value = "updateScooter",method = RequestMethod.POST)
   //     public String updateScooter(@PathVariable("Id")int id, Model model){
    //        model.addAttribute("updateScooter",this.scooterRepository.getUpdate(id,scooter));
    //        model.addAttribute("allScooter",this.scooterRepository.getAllScooters());
    //                return "updateScooter";
     //   }
}
