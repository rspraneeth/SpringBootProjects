package com.rsp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("empDao")
public class EmployeeDaoImpl implements IEmployeeDao{

    @Autowired
    private DataSource dataSource;
    private String sql = "SELECT * FROM schema2.employee";
    private List<Employee> empList;

    public EmployeeDaoImpl(){
        System.out.println("EmployeeDaoImpl bean created");
    }

    @Override
    public List<Employee> getTheEmployee() {
        System.out.println("DataSource "+dataSource.getClass().getName());
        try {
            Connection connect = dataSource.getConnection();
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            empList = new ArrayList<Employee>();
            while (rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getInt(1));
                employee.setCity(rs.getString(2));
                employee.setName(rs.getString("name"));
                employee.setSalary(rs.getDouble("salary"));
                empList.add(employee);
                System.out.println("Added to list, "+employee);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return empList;
    }
}
