package com.rsp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greet(){
        return "Welcome to my page";
    }

    @GetMapping("/info")
    public String aboutMachine(){

        String os = System.getProperty("os.name");
        String version = System.getProperty("os.version");
        String arch = System.getProperty("os.arch");
        String jv = System.getProperty("java.version");
        String user = System.getProperty("user.name");

        return "System details - "+"OS: "+os+", Ver: "+version+",Arch: "+arch+", Java: "+jv+", UserName: "+user;

    }
}
