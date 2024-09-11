/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.model;

import edu.ijse.db.DBConnection;
import edu.ijse.dto.CustomerDto;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author thenuri
 */
public class CustomerModel {
    public String saveCustomer(CustomerDto customerDto)throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO CUSTOMER VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,customerDto.getCustId());
        statement.setString(2,customerDto.getCustTitle());
        statement.setString(3,customerDto.getCustName());
        statement.setString(4,customerDto.getDob());
        statement.setDouble(5,customerDto.getSalary());
        statement.setString(6,customerDto.getCustAddress());
        statement.setString(7,customerDto.getCity());
        statement.setString(8,customerDto.getProvince());
        statement.setString(9,customerDto.getPostalCode());
       
        int result = statement.executeUpdate();
        return result > 0 ? "Successfully Saved" : "Fail";
    }

    public String updateCustomer(CustomerDto customerDto)throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE CUSTOMER SET VALUES CustTitle=?,CustName=?,Dob=?,Salary=?,CustAddress=?,City=?,Province=?,PostalCode=? WHERE CustId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
      
        statement.setString(1,customerDto.getCustTitle());
        statement.setString(2,customerDto.getCustName());
        statement.setString(3,customerDto.getDob());
        statement.setDouble(4,customerDto.getSalary());
        statement.setString(5,customerDto.getCustAddress());
        statement.setString(6,customerDto.getCity());
        statement.setString(7,customerDto.getProvince());
        statement.setString(8,customerDto.getPostalCode());
        statement.setString(9,customerDto.getCustId());
       
        int result = statement.executeUpdate();
        return result > 0 ? "Successfully Updated" : "Fail";
    }
 public String deleteCustomer(String custId) throws Exception{        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM CUSTOMER WHERE CustId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
      
        statement.setString(1, custId);
        
        int result = statement.executeUpdate();
        return result > 0 ? "Successfully Deleted" : "Fail";}
}