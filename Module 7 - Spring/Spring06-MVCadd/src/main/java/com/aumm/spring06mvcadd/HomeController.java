package com.aumm.spring06mvcadd;

import com.aumm.spring06mvcadd.model.Alien;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @RequestMapping("add")
    public String add(@RequestParam("num1") int i , @RequestParam("num2") int j, Model m){

        int num3 = i+j;


        m.addAttribute("num3",num3);

        return "add";
    }
    @RequestMapping("addAlien")
    public String addAlien(@ModelAttribute("a") Alien alien){
        return "add";
    }




}

