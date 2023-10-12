-- mariadb INT - java int
--         DEC -      double
--     VARCHAR -      String
--        DATE -      Timestamp(LocalDate)
--    DATETIME -      Timestamp(LocalDateTime)

USE mydb1;

CREATE TABLE my_table12(
    int_col1 INT,
    dec_col1 DEC(10,2),
    str_col1 VARCHAR(10),
    date_col1 DATE,
    date_time_col DATETIME
);

SELECT *
FROM my_table12;

CREATE TABLE my_board(
    board_no int

    board_title VARCHAR(100),
    board_content VARCHAR(3000),
    board_Writer VARCHAR(100),
    date DATE,
    primary key (board_no)
);

SELECT *
FROM my_board;

INSERT INTO my_board(board_no,board_title, board_content, board_Writer, date)
value (2,'저녘메뉴','맛집 리스트','삼길동',now());