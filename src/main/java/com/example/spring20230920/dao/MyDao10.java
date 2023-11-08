package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto18Employee;
import com.example.spring20230920.domain.MyDto34Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyDao10 {
    @Select("""
        SELECT CustomerName FROM customers
        WHERE CustomerID = 50
        """)
    String getCustomerName();

    @Select("""
            SELECT CustomerID as id,CustomerName as name, ContactName,Address,City
                    ,PostalCode,Country
             FROM customers
            WHERE CustomerID =50
            """)
    MyDto34Customer getCustomer();


    @Select("""
            SELECT CustomerID,CustomerName as name, ContactName,Address,City
                    ,PostalCode,Country
             FROM customers
            WHERE CustomerID = #{id}
            """)
    MyDto34Customer getCustomerById(Integer id);


    @Select("""
                SELECT EmployeeID id ,
                 LastName ,
                 FirstName,
                 BirthDate,
                 Photo,
                 Notes
                 FROM employees
                 WHERE EmployeeID = #{id}
            """)
    MyDto18Employee getEmployeeById(Integer id);


    @Select("""
                SELECT CustomerID 
                FROM customers
                ORDER BY CustomerID
            """)
    List<Integer> getCustomerIdList();

    @Select("""
                SELECT EmployeeID
                FROM employees
                ORDER BY EmployeeID
            """)
    List<Integer> getEmployeeIdList();

    @Select("""
                SELECT *
                FROM employees
                ORDER BY EmployeeID
            """)
    MyDto18Employee getEployee();
}
