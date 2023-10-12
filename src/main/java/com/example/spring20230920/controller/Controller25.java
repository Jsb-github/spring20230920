package com.example.spring20230920.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

@Controller
@RequestMapping("main25")
public class Controller25 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(
            @RequestParam(value = "id", required = false) Integer customerId
    ) throws SQLException {
        if (customerId == null) {
            System.out.println("삭제할 id를 넣어주세여");
            return;
        }
        String sql = """
                  DELETE FROM customers
                  WHERE CustomerID = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement;) {
            statement.setInt(1, customerId);
            int row = statement.executeUpdate();
            if (row == 1) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
            }
        }
    }

    @GetMapping("sub2")
    public void method2() {

    }

    @PostMapping("sub2")
    public void method3(
            @RequestParam(value = "pid", required = false) Integer productsId
    ) throws SQLException {
        if (productsId == null) {
            System.out.println("번호를 입력하세요");
            return;
        }

        String sql = """                
                DELETE FROM products 
                WHERE ProductID = ?
                     """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement;) {
            statement.setInt(1, productsId);
            int row = statement.executeUpdate();
            if (row == 1) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
            }
        }
    }

    @GetMapping("sub4")
    public void method4() throws SQLException {
        String sql = """
                UPDATE shippers
                SET ShipperName = ?,
                    Phone = ?
                WHERE ShipperID = ?                  UPDATE shippers
                                    SET
                                        ShipperName = ?,
                                        Phone = ?
                                   WHERE ShipperID = ?
                                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement) {
            statement.setString(1, "이강인");
            statement.setString(2, "01077778888");
            statement.setInt(3, 1);

            int row = statement.executeUpdate();
            if (row == 1) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        }
    }

    @GetMapping("sub5")
    public void method5(
         @RequestParam(value = "id",defaultValue = "1")  Integer shipperId,
         Model model
    )throws  SQLException {
        String sql = """   
                        SELECT *
                        FROM shippers
                        WHERE ShipperID = ?       
                    """;


        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        try (connection; statement) {
            statement.setInt(1, shipperId);

            ResultSet resultSet = statement.executeQuery();

            try (resultSet) {
                if (resultSet.next()) {
                    model.addAttribute("shipper", Map.of("shipperId", resultSet.getInt("shipperId"),
                            "shipperName", resultSet.getString("shipperName"),
                            "phone", resultSet.getString("phone")));
                }

            }
        }
    }

    @PostMapping("sub5")
    public void mthod6(
            @RequestParam("id") Integer shipperId,
            @RequestParam("name") String shipperName,
            @RequestParam("phone") String phone
    ) throws SQLException {
        String sql = """
                UPDATE shippers
                SET ShipperName = ?,
                    Phone = ?
                WHERE ShipperID = ?
                      """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement) {
            statement.setString(1, shipperName);
            statement.setString(2, phone);
            statement.setInt(3, shipperId);

            int row = statement.executeUpdate();
            if (row == 1) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        }

    }


    @GetMapping("sub7")
    public void method7(
            @RequestParam(value = "id",required = false) Integer employeeId
            , Model model
            )throws  SQLException {

        if (employeeId != null) {
            String sql = """
                          
                    SELECT *
                          FROM employees
                          WHERE EmployeeID = ?
                          """;

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            List<Map<String, Object>> list = new ArrayList<>();
            try (connection; statement) {
                statement.setInt(1, employeeId);
                ResultSet resultSet = statement.executeQuery();

                try (resultSet;) {
                    if (resultSet.next()) {
                        String lastName = resultSet.getString("lastName");
                        String firstName = resultSet.getString("firstName");
                        LocalDate birthDate = resultSet.getTimestamp("birthDate").toLocalDateTime().toLocalDate();
                        String photo = resultSet.getString("photo");
                        String notes = resultSet.getString("notes");

                        model.addAttribute("employee", Map.of("lastName", lastName,
                                "firstName", firstName,
                                "birthDate", birthDate,
                                "photo", photo,
                                "notes", notes,
                                "employeeId", employeeId));

                    }
                }
            }
        }
    }

    @PostMapping("sub7")
    public String method8(
            @RequestParam("id") Integer employeeId,
            @RequestParam("lastName") String lastName,
            @RequestParam("firstName") String firstName,
            @RequestParam("birthDate") LocalDate bitrhDate,
            @RequestParam("photo") String photo,
            @RequestParam("notes") String notes,
            RedirectAttributes rttr
    )throws  SQLException{
        String sql = """                    
                      UPDATE employees
                      SET FirstName = ?,
                          LastName = ?,
                          BirthDate = ?,
                          Photo = ?,
                          Notes = ?
                           WHERE EmployeeID =?
                      """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try(connection; statement) {
            statement.setString(1,firstName);
            statement.setString(2,lastName);
            statement.setTimestamp(3, Timestamp.valueOf(bitrhDate.atStartOfDay()));

            statement.setString(4,photo);
            statement.setString(5,notes);
            statement.setInt(6,employeeId);
           int row = statement.executeUpdate();
           if(row==1){
               rttr.addFlashAttribute("message", "직원 정보가 변경되었습니다.");
           } else {
               rttr.addFlashAttribute("message", "직원 정보가 변경되지 않았습니다.");
           }
        }
        rttr.addAttribute("id",employeeId);
        return "redirect:/main25/sub7";
    }

    @GetMapping("sub9")
    public String method9(RedirectAttributes rttr){
        // COntroller의 request handler  메소드의 리턴이
        // void(또는 null 리턴) 이면 view의 이름으로 해석

        // String 이면 view의 이름으로 해석
        // "redirect :"  접두어가 붙으면
        // 응답코드가 302이고 location 응답헤더의 값이 접두어 이후의 값으로 셋팅

        // 쿼리스트링에 request parameter로 붙음
        rttr.addAttribute("abc","dfe");
        rttr.addAttribute("address","seoul");

        // 모델에 붙임(session을 잠깐 거침)
        rttr.addFlashAttribute("email","abc@gmail.com");
        return "redirect:/main25/sub10";
    }

    @GetMapping("sub10")
    public void method10(Model model){
       Object email=  model.getAttribute("email");

       System.out.println(email);
        System.out.println("Controller25.method10");
    }
}
