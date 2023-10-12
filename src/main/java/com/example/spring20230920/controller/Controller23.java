package com.example.spring20230920.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main23")
public class Controller23 {
    @Autowired
    private DataSource dataSource;
    @GetMapping("Sub1")
    public void method1(String keyword) throws SQLException {
        String sql = """
                SELECT *
                FROM  products 
                WHERE productName LIKE ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,"%"+keyword+"%");
       ResultSet resultSet = statement.executeQuery();
       try(connection; statement; resultSet;) {
           System.out.println();
           System.out.println(keyword+"가 포함된 상품명들");
           while (resultSet.next()){
               String name = resultSet.getString("productName");
               System.out.println("name = " + name);
           }
       }

    }
    // /main23/sub2?k=erd
    // erd라는 텍스타가 중간에 있는 고객명 조회하는
    // 2번쨰 메소드 작성

    @GetMapping("sub2")
    public void method2(
            @RequestParam(value = "k",defaultValue = "") String keyword,
            Model model
    ) throws  SQLException{
        String sql = """
                    SELECT *
                    FROM customers
                    WHERE CustomerName LIKE ?
        """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,"%"+keyword+"%");
        ResultSet resultSet = statement.executeQuery();
        List<Map<String,Object>> list = new ArrayList<>();
        try(connection; statement; resultSet;) {

            while (resultSet.next()){
              Map<String,Object> map = new HashMap<>();
              map.put("name",resultSet.getString("CustomerName"));

              list.add(map);
            }
        }

        model.addAttribute("keyWord",keyword);
        model.addAttribute("customerNameList",list);
    }

    @GetMapping("sub3")
    public void method3(
            @RequestParam(value = "st",defaultValue ="name1") String searchType,
            @RequestParam(value = "k",defaultValue = "") String keyword,
            Model model
    ) throws SQLException{
        String sql = """
                    SELECT *
                    FROM customers
                    WHERE                            
                     """;

        if(searchType.equals("name1")){
            sql += "customerName LIKE ?";
        }else if(searchType.equals("name2")){
            sql += "contactName LIKE ?";
        }

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,"%"+keyword+"%");
        ResultSet resultSet =statement.executeQuery();

        List<Map<String,Object>> list = new ArrayList<>();
        try(connection; statement; resultSet;) {
            while (resultSet.next()){
                Map<String,Object> map = new HashMap<>();
                map.put("customerName",resultSet.getString("customerName"));
                map.put("contactName",resultSet.getString("contactName"));
                list.add(map);
            }
        }
        model.addAttribute("searchType",searchType);
        model.addAttribute("keyword",keyword);
        model.addAttribute("customers",list);
    }

    @GetMapping("sub4")
    public void metho4(
            @RequestParam(value = "t", defaultValue = "lname") String searchType,
            @RequestParam(value = "k", defaultValue = "") String keyword,
            Model model
    )throws SQLException{
        String sql = """
                        SELECT *
                        FROM  employees
                        WHERE
                        """;
//        if(searchType.equals("lname")){
//            sql += "LastName LIKE ?" ;
//        }else if(searchType.equals("fname")){
//           sql += "FirstName LIKE ?";
//        }else if(searchType.equals("note")){
//           sql +=  "Notes LIKE ? ";
//        }

        switch (searchType){
            case "lname" :
                sql += "LastName LIKE ?" ;
                break;
            case "fname" :
                sql += "FirstName LIKE ?";
                break;
            case "note":
                sql +=  "Notes LIKE ? ";
                break;
        }


        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,"%"+keyword+"%");
        ResultSet resultSet = statement.executeQuery();

        List<Map<String,Object>> list = new ArrayList<>();
        try(connection; statement; resultSet;) {
            while (resultSet.next()){
                Map<String,Object> map = new HashMap<>();
                map.put("lastName",resultSet.getString("LastName"));
                map.put("firstName",resultSet.getString("FirstName"));
                map.put("note",resultSet.getString("Notes"));
                list.add(map);
            }
        }
        model.addAttribute("searchType",searchType);
        model.addAttribute("keyword",keyword);
        model.addAttribute("employeesList",list);
    }
}
