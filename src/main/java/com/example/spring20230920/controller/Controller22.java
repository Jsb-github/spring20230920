package com.example.spring20230920.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main22")
public class Controller22 {

    @Autowired
   private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(Integer page) throws SQLException {
        String sql = """
                SELECT customerId id,
                        customerName name
                FROM customers
                ORDER BY id   
                LIMIT ?,?    
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

//        statement.setInt(1,0); // 1페이지
//        statement.setInt(1,10); // 2페이지
//        statement.setInt(1,20); // 3페이지
//        statement.setInt(2,10);
          statement.setInt(1,(page-1)*10);
          statement.setInt(2,10);

        ResultSet resultSet = statement.executeQuery();

        try(connection; statement; resultSet;) {
            System.out.println("고객 목록");
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name= resultSet.getString("name");

                System.out.println(id +":" + name
                );
            }
        }
    }

    // 페이지당 7개 씩 공급자 목록 조회
    // /main22/sub2?p=2

    @GetMapping("sub2")
    public void method2(
            @RequestParam(value = "p",defaultValue = "1") Integer page
            , Model model)throws SQLException{
        String sql = """
                SELECT SupplierID id,
                        SupplierName name,
                        City city,
                        Country country
                FROM suppliers
                ORDER BY SupplierID
                LIMIT ?,?
            """;


        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,(page-1)*7);
        statement.setInt(2,7);
        ResultSet resultSet = statement.executeQuery();
        List<Map<String,Object>> list = new ArrayList<>();

        try(connection; statement; resultSet;) {
            while (resultSet.next()){
                Map<String,Object> map = new HashMap<>();
                map.put("id",resultSet.getString("id"));
                map.put("name",resultSet.getString("name"));
                map.put("city",resultSet.getString("city"));
                map.put("country",resultSet.getString("country"));

                list.add(map);
            }
        }

        String sql1 = """
                    SELECT COUNT(*)
                    FROM suppliers
                """;

        Connection connection1 = dataSource.getConnection();
        Statement statement1 = connection1.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(sql1);

        try(connection1; statement1; resultSet1;) {
            if(resultSet1.next()) {
                int countAll = resultSet1.getInt(1);
                // 마지막 페이지 번호
                int lastPageNumber = ((countAll - 1) / 7) + 1;
                model.addAttribute("lastPageNumber", lastPageNumber);
            }
        }
        model.addAttribute("suppliersList",list);
    }

    // /main22/sub3?p=2
    // 고객목록 jsp에 테이블 형식 (id,name) 출력
    // page 번호로 링크
    // 1페이지 5개씩

    @GetMapping("sub3")
    public void method3(
            @RequestParam(value = "p",defaultValue = "1") Integer page
            ,Model model) throws  SQLException {
        //페이지 나누기
        String sql = """
                SELECT CustomerID id,
                       CustomerName name
                FROM customers
                ORDER BY CustomerID
                LIMIT ?,5
        """;

        // 테이블 컬럼수 찾기
        String sql1 = """
                    SELECT COUNT(*)
                    FROM customers                
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (page - 1) * 5);
        // (page -1 ) * 페이지 출력수(n)
        Statement statement1 = connection.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(sql1);
        ResultSet resultSet = statement.executeQuery();
        List<Map<String, Object>> list = new ArrayList<>();
        int lastPageNumber = 1;

        try (connection; statement; resultSet; statement1; resultSet1;) {
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", resultSet.getString("id"));
                map.put("name", resultSet.getString("name"));

                list.add(map);
            }

            // 마지막 페이지 번호 구하기
            if (resultSet1.next()) {
                int countALl = resultSet1.getInt(1);
                lastPageNumber = ((countALl - 1) / 5) + 1;
            }


        }

        //왼쪽 출력 페이지 넘버
        int leftPageNumber = (page-1)/5 *5+1;
        System.out.println(leftPageNumber);

        //오른족 출력 페이지 넘버
        int rightPageNumber = leftPageNumber+4;


        // 이전 클릭시 출력 페이지 넘버
        int prevPageNumber = leftPageNumber-5;
        System.out.println(prevPageNumber);

        // 다음 클릭시 출력 페이지 넘버
        int nextPageNumber = rightPageNumber+1;

        rightPageNumber = Math.min(rightPageNumber,lastPageNumber);
        //
        System.out.println(rightPageNumber);

        //model
        model.addAttribute("customersList", list);
        model.addAttribute("lastPageNumber", lastPageNumber);
        model.addAttribute("leftPageNumber",leftPageNumber);
        model.addAttribute("rightPageNumber",rightPageNumber);
        model.addAttribute("prevPageNumber",prevPageNumber);
        model.addAttribute("nextPageNumber",nextPageNumber);
        model.addAttribute("currentPage",page);

    }
}
