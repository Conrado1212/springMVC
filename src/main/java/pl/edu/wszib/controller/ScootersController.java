package pl.edu.wszib.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.model.Scooter;
import pl.edu.wszib.repository.ScooterRepository;

@Controller
public class ScootersController {

    @Autowired
    ScooterRepository scooterRepository ;


    @RequestMapping(value ="/allScooter",method = RequestMethod.GET)
    public String allScooter(Model model){
        model.addAttribute("allScooter",this.scooterRepository.getAllScooters());
        return "allScooter";
    }

    @RequestMapping(value = "/allScooterXiomi",method = RequestMethod.GET)
    public String scooterXiaomiPage(Model model){
        model.addAttribute("allScooterXiomi",this.scooterRepository.getAllScooterXiaomi());
    return"allScooterXiomi";
    }

    @RequestMapping(value = "/allScooterFiat",method = RequestMethod.GET)
    public String scooterFiatPage(Model model){
        model.addAttribute("allScooterFiat",this.scooterRepository.getAllScooterFiat());
        return "allScooterFiat";
    }


}
