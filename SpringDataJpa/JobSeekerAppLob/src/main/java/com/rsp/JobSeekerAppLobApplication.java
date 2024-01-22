package com.rsp;

import com.rsp.bo.JobSeeker;
import com.rsp.service.JobSeekerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.*;
import java.util.Optional;

@SpringBootApplication
public class JobSeekerAppLobApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JobSeekerAppLobApplication.class, args);
        JobSeekerServiceImpl service = context.getBean(JobSeekerServiceImpl.class);

//        InputStream is = null;
//        FileReader reader = null;
//        byte[] image = null;
//        char[] textFile = null;
//
//        try {
//            is = new FileInputStream("C:\\Users\\Praneeth\\Downloads\\1111.jpg");
//            image = new byte[is.available()];
//            is.read(image);
//
//            File file = new File("C:\\Users\\Praneeth\\Desktop\\resume\\lll.txt");
//            reader = new FileReader(file);
//            textFile = new char[(int) file.length()];
//            reader.read(textFile);
//
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        JobSeeker seeker = new JobSeeker("Satya", "MMD", image, textFile);
//
//        try {
//            is.close();
//            reader.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println(service.registerJobSeeker(seeker));

        Optional<JobSeeker> optional = service.getDetailsById(2);
        if (optional.isPresent()){
            JobSeeker seeker = optional.get();
            System.out.println(seeker.getId()+" "+seeker.getName()+" "+seeker.getCity());
            try {
                OutputStream output = new FileOutputStream("image.jpg");
                output.write(seeker.getImage());
                output.flush();

                FileWriter writer = new FileWriter("qqq.txt");
                writer.write(seeker.getTextFile());
                writer.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }else System.out.println("No Data Present with given Id");
    }

}
