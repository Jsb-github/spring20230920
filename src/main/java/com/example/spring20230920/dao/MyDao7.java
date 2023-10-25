package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto40;
import com.example.spring20230920.domain.MyDto41;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.Map;

@Mapper
public interface MyDao7 {


    @Select("""
                SELECT * FROM customers
                WHERE CustomerID = #{id}
            """)
    Map<String, Object> selectByCustomerId(Integer id);

    @Select("""
                SELECT * FROM employees
                WHERE EmployeeID = #{id}
            """)
    Map<String, Object> selectByEmployeedId(Integer id);


    @Insert("""
                INSERT INTO employees(lastName,firstName,birthDate)
                VALUES (#{lastName}, #{firstName}, #{birthDate})
                
            """)
    int insertEmployee(String lastName, String firstName, LocalDate birthDate);


    @Insert("""
             INSERT INTO products(productName, price, categoryId)
             VALUE (#{name},#{price},#{category})
            """)
    int insertProduct(String name, Double price, Integer category);

    @Delete("""
                DELETE FROM products
                WHERE productId = #{pid}
            """)
    int deleteByProductId(Integer pid);

    @Delete("""
              DELETE FROM employees
              WHERE EmployeeID = #{pid}
            """)
    int deleteByEmployeeId(Integer pid);


    @Update("""
            UPDATE products
            SET ProductName =#{name},
                CategoryID = #{category},
                Price = #{price}
            WHERE
                ProductID = #{id}
            """)
    int updateProduct(MyDto40 dto);


    @Update("""
            UPDATE employees
            SET lastName =  #{lastName},
                firstName = #{firstName},
                birthDate = #{birthDate}
             WHERE
                employeeID = #{id}   
            
            """)
    int updateEmployee(MyDto41 dto);
}
