package com.example.spring20230920.examController;

import com.example.spring20230920.domain.Myboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("board")
public class boardController {

    @Autowired
    private DataSource dataSource;
    @GetMapping("list")
    public void view(Model model) throws SQLException {
        String sql = """
                      SELECT *
                      FROM mydb1.my_board
                      """;


        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<Myboard> list = new ArrayList<>();
        try(connection; statement; resultSet;) {
            while (resultSet.next()){
                Myboard dto = new Myboard();
                dto.setNo(resultSet.getInt(1));
                dto.setTitle(resultSet.getString(2));
                dto.setContent(resultSet.getString(3));
                dto.setWriter(resultSet.getString(4));
                dto.setDate(resultSet.getTimestamp(5).toLocalDateTime());
                list.add(dto);
            }
            model.addAttribute("myBoard",list);
        }
    }

    @GetMapping("write")
    public void writeView(){

    }

    @PostMapping("write")
    public String write(
            Myboard myboard
            ,Model model
    ) throws  SQLException{
        String sql =
                """
                INSERT INTO mydb1.my_board(board_title, board_content, board_Writer,date)
                VALUE(?,?,?,NOW())
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try(connection; statement;) {
            statement.setString(1, myboard.getTitle());
            statement.setString(2, myboard.getContent());
            statement.setString(3, myboard.getWriter());
           int row = statement.executeUpdate();
           if(row==1){
               System.out.println("성공");
           }else {
               System.out.println("실패");
           }
        }
        return   "redirect:/board/list";
    }
}
