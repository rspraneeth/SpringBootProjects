package com.reddi.WebApplication;

//import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller //making it a controller
public class HomeController {
    @RequestMapping("home") //path
    //@ResponseBody // to display returning string, if uncommented home.jsp will be displayed in browser
    public ModelAndView home(@RequestParam("name") String myName){
        ModelAndView mv = new ModelAndView();
        System.out.println("Home..hi "+myName);
        mv.addObject("name", myName);
        mv.setViewName("home");

        return mv; // returning a view, to display the view add dependency "tomcat-jasper", to support JSP.
    }
}
