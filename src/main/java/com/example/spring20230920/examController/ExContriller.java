package com.example.spring20230920.examController;

import com.example.spring20230920.domain.MyDto18Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("api")
public class ExContriller {
        @Autowired
        private DataSource dataSource;
    @GetMapping("ad")
    public void method1(
            @RequestParam(value = "p",defaultValue = "1") Integer page,
            Model model
    ) throws SQLException {
        String sql = """
                SELECT LastName lName, 
                       FirstName fName,
                       BirthDate birth,
                       Photo photo,
                       Notes note
                FROM employees
                ORDER BY EmployeeID
                LIMIT ?,3
        """;




        //테이블 컬럼수 찾기
        String sql1 =
                """
                    SELECT COUNT(*)
                    FROM employees
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,(page-1)*3);
        Statement statement1 = connection.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(sql1);
        ResultSet resultSet = statement.executeQuery();
        List<Map<String,Object>> list = new ArrayList<>();
        int lastPageNumber =1;

        try(connection; statement; resultSet; statement1; resultSet1;) {
            while (resultSet.next()){
                Map<String, Object> map = new HashMap<>();
                map.put("name",resultSet.getString("lName"));
                map.put("birth",resultSet.getString("birth"));
                map.put("photo",resultSet.getString("photo"));
                list.add(map);
            }
            if(resultSet1.next()){
                int countAll = resultSet1.getInt(1);
                lastPageNumber = ((countAll-1)/3)+1;
            }
            int leftPageNumber = (page-1)/3*3+1;

            int rightPageNumber = leftPageNumber+2;

            int prevPageNumber = leftPageNumber-3;

            int nextPageNumber = rightPageNumber+1;

            rightPageNumber = Math.min(rightPageNumber,lastPageNumber);
            model.addAttribute("employees",list);
            model.addAttribute("lastPageNumber", lastPageNumber);
            model.addAttribute("leftPageNumber",leftPageNumber);
            model.addAttribute("rightPageNumber",rightPageNumber);
            model.addAttribute("prevPageNumber",prevPageNumber);
            model.addAttribute("nextPageNumber",nextPageNumber);
            model.addAttribute("currentPage",page);
        }
    }

    @GetMapping("add1")
    public void  add1(){

    }

    @PostMapping("add1")
    public String add2(
            MyDto18Employee employee
    )throws SQLException{
        String sql = """
                INSERT INTO employees(LastName, FirstName, birthdate, photo, notes)
                value (?,?,?,?,?)
                    """;
        Connection connection =dataSource.getConnection();
        PreparedStatement statement =connection.prepareStatement(sql);
        try(connection; statement;) {
            statement.setString(1,employee.getLastName());
            statement.setString(2,employee.getFirstName());
            statement.setTimestamp(3,Timestamp.valueOf(employee.getBirthDate().atStartOfDay()));
            statement.setString(4,employee.getPhoto());
            statement.setString(5,employee.getNotes());
           int cnt = statement.executeUpdate();
           if(cnt==1){
               System.out.println("성공");
           }else{
               System.out.println("실패");
           }
        }
        return "redirect:/api/ad";
    }


    @GetMapping("list")
    public void list(
            @RequestParam(value = "p") String name,
            Model model
    ) throws SQLException{
        System.out.println(name);
       String sql = """
                    SELECT *
                    FROM employees
                    WHERE LastName = ?
                    """;
        Connection connection =dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        ResultSet resultSet = statement.executeQuery();
        List<Map<String ,Object>> list = new ArrayList<>();
        try(connection; statement;resultSet;) {
            while (resultSet.next()){
                Map<String, Object> map = new HashMap<>();
                map.put("lName",resultSet.getString(2));
                map.put("fName",resultSet.getString(3));
                map.put("birth",resultSet.getString(4));
                map.put("photo",resultSet.getString(5));
                map.put("note",resultSet.getString(6));
                list.add(map);
            }
        }
        model.addAttribute("employees",list);
    }
    @GetMapping("del")
    public void del(
            @RequestParam("name") String name
    ) throws  SQLException{
        String sql = """
                    DELETE FROM employees WHERE LastName =?
                    """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        try(connection; statement;) {
            int cnt = statement.executeUpdate();

            if(cnt==1){
                System.out.println("삭제 성공");
            }else {
                System.out.println("삭제 실패");
            }
        }


    }
}
