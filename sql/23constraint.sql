-- NULL 허용 여부
-- 유일한 값 여부
-- 기본값 지정
-- 값 체크
use mydb1;

create table my_table13(
    col1 INT NULL ,  -- null 허용
    col2 INT NOT NULL  -- null 허용 안함
);
