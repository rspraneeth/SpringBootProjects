package com.reddi.WebApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller //making it a controller
public class HomeController {
    @RequestMapping("home") //path
    //@ResponseBody // to display returning string, if uncommented home.jsp will be displayed in browser
    public String home(){
        System.out.println("Home..hi");
        return "home.jsp"; // returning a view, to display the view add dependency "tomcat-jasper", to support JSP.
    }
}
