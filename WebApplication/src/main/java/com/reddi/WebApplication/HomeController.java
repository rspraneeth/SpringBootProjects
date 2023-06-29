package com.reddi.WebApplication;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller //making it a controller
public class HomeController {
    @RequestMapping("home") //path
    //@ResponseBody // to display returning string, if uncommented home.jsp will be displayed in browser
    public String home(HttpServletRequest req){
        HttpSession session = req.getSession();
        String val = req.getParameter("name");
        System.out.println("Home..hi "+val);
        session.setAttribute("name", val);
        return "home"; // returning a view, to display the view add dependency "tomcat-jasper", to support JSP.
    }
}
