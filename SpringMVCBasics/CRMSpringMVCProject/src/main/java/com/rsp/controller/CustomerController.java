package com.rsp.controller;

import com.rsp.model.CustomerInfo;
import com.rsp.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @GetMapping("/customers")
    public String fetchCustomerData(Model model) {
        List<CustomerInfo> cList = service.getCustomers();
        cList.forEach(System.out::println);
        model.addAttribute("customers", cList);
        return "customerlist";
    }

    @PostMapping("/addNewCustomer")
    public String addCustomer(@ModelAttribute CustomerInfo cust, Map<String, Object> model){
        service.newCustomer(cust);
        return "redirect:/customers";
    }

    @GetMapping("/newCustomer")
    public String showFormPage(Map<String, Object> model){
        CustomerInfo info = new CustomerInfo();
        model.put("customer", info);
        return "showForm";
    }

    @GetMapping("/updatecustomer")
    public String updateCustomer(@RequestParam("customerId") Integer id, Map<String, Object> model){
        CustomerInfo cu = service.findCustomerById(id).orElseThrow();
        model.put("customer", cu);

        return "showForm";
    }

    @GetMapping("deletecustomer")
    public String deleteCustomer(@RequestParam("customerId") Integer id){
        service.deleteCustomer(id);
        return "redirect:/customers";
    }
}
