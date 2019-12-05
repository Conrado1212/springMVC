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


        @RequestMapping(value = "/addScooter",method = RequestMethod.GET)
        public ModelAndView addScooter(){
            return new ModelAndView("addScooter","addScooterKey",new Scooter());
        }

        @RequestMapping(value = "/addScooter",method = RequestMethod.POST)
        public String addScooterForm(@ModelAttribute("addScooterKey")Scooter scooter){
            System.out.println(scooter);
            return  "redirect:indexAddScooter";
        }

        @RequestMapping(value = "/removeScooterId",method = RequestMethod.GET)
        public ModelAndView removeScooterId(){
            return new ModelAndView("removeScooterId","removeScooterIdKey",new Scooter());
        }

        @RequestMapping(value = "/removeScooterId",method = RequestMethod.POST)
        public String removeScooterIdForm(@ModelAttribute("removeScooterIdKey")Scooter scooter){
            System.out.println(scooter);
            return "removeScooterId";
        }

        @RequestMapping(value = "/getScooter",method = RequestMethod.GET)
        public ModelAndView getScooter(){
            return new ModelAndView("getScooter","getScooterKey",new Scooter());
        }

        @RequestMapping(value = "/getScooter",method = RequestMethod.POST)
        public String getScooterForm(@ModelAttribute("getScooterKey")Scooter scooter){
            System.out.println(scooter);
            return "getScooter";
        }

        @RequestMapping(value = "/updateScooter",method = RequestMethod.GET)
        public ModelAndView updateScooter(){
            return new ModelAndView("updateScooter","updateScooterKey",new Scooter());
        }

        @RequestMapping(value = "/updateScooter",method = RequestMethod.POST)
        public String updateScooterForm(@ModelAttribute("updateScooterKey")Scooter scooter){
            System.out.println(scooter);
            return "updateScooter";
        }

   // @RequestMapping(value ="/addScooter",method = RequestMethod.GET)
   // public String allScooter(Model model){

     //  model.addAttribute("addScooter",new Scooter());
      //  model.addAttribute("addScooter",scooterRepository.addScooter());
      //  return "addScooter";
  //  }
     // @RequestMapping(value ="/getScooter",method = RequestMethod.GET)
   //  public String allScooter(Model model){
        // model.addAttribute("addScooter",new Scooter());
   // model.addAttribute("getScooter",scooterRepository.getScooter(1));
   //   return "getScooter";
   //  }

  //  @RequestMapping(value = "/removeScooterId",method = RequestMethod.POST)
    //public String removeScooterIdd(@ModelAttribute("removeScooterIdKey")int id){
      //      scooterRepository.removeScooterId(id);
      //      return "redirect:/AllScooter";
    //}
}
