USE mydb1;


-- 테이블 만들기

CREATE TABLE 테이블명 (
    컬러명 컬럼타입,
    컬럼명 컬럼타입
);

-- 테이블명, 컬러명 작성 관습
-- rower_snake_case
-- UPPER_SNAKE_CASE
-- UpperCamelCase
-- lowrCamelCase

CREATE  TABLE  my_table1(
    col_name1 varchar(100),
    col_name2 varchar(100),
    col_name3 varchar(100)
);


SELECT * FROM my_table1;

INSERT INTO my_table1(col_name1, col_name2, col_name3)
    VALUE('흥민','민재','강인');


-- 예) my_table2 만들기, 컬럼은4개, 모든컬럼타입 varchar(10)
CREATE TABLE my_table2(
    no varchar(10),
    name varchar(10),
    address varchar(10),
    phone varchar(10)
);

SELECT *
FROM my_table2;

INSERT INTO my_table2(no, name, address, phone)
VALUE (1,'흥민','런던','010');

