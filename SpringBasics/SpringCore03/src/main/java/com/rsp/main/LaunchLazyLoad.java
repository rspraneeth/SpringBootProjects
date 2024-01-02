package com.rsp.main;

import com.rsp.bean.Employee;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;


public class LaunchLazyLoad {
    public static void main(String[] args) {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("applicationContext.xml"); // can load multiple context files, by calling the method many times

        Employee e = factory.getBean("emp", Employee.class);
        System.out.println(e);
        System.out.println(e.empActivity());

    }
}
