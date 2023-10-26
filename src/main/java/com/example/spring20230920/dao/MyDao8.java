package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto33Employee;
import com.example.spring20230920.domain.MyDto45;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface MyDao8 {
    @Select("""
            SELECT *
            FROM products
            WHERE productId = #{id}
            """)
    Map<String, Object> selectProductById(Integer id);

    @Select("""
                SELECT EmployeeID id,LastName,FirstName,Photo,Notes,BirthDate
                FROM employees
                WHERE EmployeeID = #{id}
            """)
    MyDto33Employee selectEmployeeId(Integer id);

    @Select("""
               SELECT p.ProductID id, p.Price, CategoryName category, p.Unit
               FROM products p JOIN categories c
                ON p.CategoryID = c.CategoryID
               WHERE p.ProductID = #{id}
                
            """)
    MyDto45 selectProductById2(Integer id);
}
