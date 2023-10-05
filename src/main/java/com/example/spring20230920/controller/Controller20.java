package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto15;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main20")
public class Controller20 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(){

    }

    @GetMapping("sub2")
    public String method2(String id, Model model) throws SQLException {

        // 쿼리 작성
        String sql = """
            SELECT CustomerID,CustomerName,Address,Country 
            FROM customers
            WHERE CustomerID = ?
        """;

        // 쿼리 실행
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<MyDto15> list = new ArrayList<>();
        // 실행 결과 처리
        try(connection; preparedStatement; resultSet;) {
            while (resultSet.next()){
                MyDto15 dto = new MyDto15();
                dto.setId(resultSet.getInt(1));
                dto.setName(resultSet.getString(2));
                dto.setAddress(resultSet.getString(3));
                dto.setCountry(resultSet.getString(4));

                list.add(dto);
            }
        }
        // 처리한 결과 모델에 넣기
        model.addAttribute("customerList",list);
        // 적절한 view로 포워드
        return "/main19/sub6";
    }

    @GetMapping("sub3")
    public void method3(String id) throws SQLException{
        String sql = """
                SELECT customerId,customerName,country
                FROM customers
                WHERE customerId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,id);
        ResultSet resultSet = statement.executeQuery();

        try(connection; statement; resultSet;) {
            while (resultSet.next()){
                System.out.println("고객정보");
                System.out.println("id = " + resultSet.getString(1));
                System.out.println("name = " + resultSet.getString(2));
            }
        }

    }
    
    //main20/sub4?pid=5
    @GetMapping("sub4")
    public void method4(String pid) throws  SQLException{
        String sql = """
            SELECT ProductID, ProductName
            FROM products
            WHERE ProductID = ?
        """;
        
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,pid);
        ResultSet resultSet = statement.executeQuery();
        
        try(connection; statement; resultSet;) {
            while (resultSet.next()){
                System.out.println("상품 정보 ");
                System.out.println("상품번호 = " + resultSet.getInt(1));
                System.out.println("상품명 = " + resultSet.getString(2));
            }
        }
    }

    // /main20/sub5?country=spain
    // 콘솔에 spain에 사는 고객 이름 출력
    @GetMapping("sub5")
    public void method5(String country) throws  SQLException{
        String sql = """
            SELECT  CustomerName,Country
            FROM  customers
            where Country =?
        """;


        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,country);
        ResultSet resultSet = statement.executeQuery();

        try(connection; statement; resultSet;) {
            while (resultSet.next()){
                System.out.println(country + "에 거주 고객 명단");
                System.out.println("이름 : "+resultSet.getString(1));
                System.out.println("나라 : " + resultSet.getString(2));
                System.out.println();
            }
        }
    }


    @GetMapping("sub6")
    public void method6(String c1, String c2) throws SQLException{
        String sql = """
                    SELECT  CustomerName,Country
                    FROM customers
                    WHERE  Country = ? OR  Country =?
                    """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,c1);
        statement.setString(2,c2);
        ResultSet resultSet = statement.executeQuery();

        try(connection; statement; resultSet;) {
            System.out.println("고객 목록 : " );
            while (resultSet.next()){
                String name = resultSet.getString(1);
                String country = resultSet.getString(2);
                System.out.println(country + ":" + name);
            }
        }
    }

    @GetMapping("sub7")
    public void method7(){

    }

    @GetMapping("sub8")
    public void method8(Double min,Double max, Model model) throws SQLException{

        String sql = """
                    SELECT ProductName,Price
                    FROM  products
                    WHERE Price <=? AND Price >= ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1,min);
        statement.setDouble(2,max);
        ResultSet resultSet = statement.executeQuery();

        List<Map<String ,String>> list = new ArrayList<>();
        try(connection; statement; resultSet;) {
            while (resultSet.next()){
                Map<String,String> map = new HashMap<>();
                map.put("name",resultSet.getString(1));
                map.put("price",resultSet.getString(2));

                list.add(map);
            }
        }
        model.addAttribute("productsList",list);
    }

    // /main20/sub9?countryList=spain&countryList=mexico&countryList=uk
    @GetMapping("sub9")
    public void method9(
            @RequestParam("country")  List<String> countryList
            ) throws SQLException{
       String questionMArks ="";
       for (int i=0; i<countryList.size(); i++){
           questionMArks += "?";

           if(i<countryList.size()-1){
               questionMArks +=",";
           }
        }
        // 특정 국가에 속한 고객들 조회
        String sql= """
            SELECT *
            FROM customers
            WHERE Country IN("""
                +

                questionMArks

                +
            """
              )
            """;

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for(int i=0; i<countryList.size(); i++){
            preparedStatement.setString(i+1,countryList.get(i));
        }

        ResultSet resultSet = preparedStatement.executeQuery();

        try(connection; preparedStatement; resultSet;) {
            System.out.println("고객목록");
            while (resultSet.next()){
                String name = resultSet.getString(2);
                String country = resultSet.getString(7);

                System.out.println(name +":" +country);
            }
        }
    }

    @GetMapping("sub10")
    public void method10(Model model) throws  SQLException{

        //공급자의 국가 목록 조회
        String sql = """
            SELECT DISTINCT Country
            FROM suppliers
            """;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<String> list = new ArrayList<>();
        try (connection; statement; resultSet;) {
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        }
        model.addAttribute("countryList",list);
    }

    @GetMapping("sub11")
    public void method11(
            @RequestParam("country") List<String> countryList
            ,Model model
    ) throws SQLException{
        String questionMArks ="";

        for(int i=0; i<countryList.size(); i++){
            questionMArks += "?";

            if(i<countryList.size()-1){
                questionMArks += ",";
            }
        }
        String sql =
                """
                SELECT *
                FROM suppliers
                WHERE Country in("""

                +
                questionMArks
                +
                """
                    )
                """;

                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                for (int i=0; i<countryList.size(); i++){
                    statement.setString(i+1,countryList.get(i));
                }

                ResultSet resultSet = statement.executeQuery();
                List<Map<String,String>> list = new ArrayList<>();
                try(connection; statement; resultSet;) {
                    while (resultSet.next()){
                        Map<String, String> map = new HashMap<>();
                        map.put("id",resultSet.getString(1));
                        map.put("name",resultSet.getString(2));
                        map.put("address",resultSet.getString(4));
                        map.put("city",resultSet.getString(5));
                        map.put("country",resultSet.getString(7));
                        map.put("phone",resultSet.getString(8));

                        list.add(map);
                    }

                }
            model.addAttribute("suppliersList",list);
    }

}



