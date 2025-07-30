# db DDL
```
CREATE DATABASE cinema_db CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE USER 'cinema_user'@'%' IDENTIFIED BY 'cinema!@#$1234';
GRANT ALL PRIVILEGES ON cinema_db.* TO 'cinema_user'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;




CREATE TABLE genre_tbl (
id BIGINT UNSIGNED auto_increment NOT NULL COMMENT 'PK, 자동증가',
name varchar(50) NOT NULL COMMENT '영화 장르 이름',
CONSTRAINT genre_tbl_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='영화장르 마스터 테이블';

CREATE TABLE cinema_tbl (
id BIGINT UNSIGNED auto_increment NOT NULL COMMENT 'PK, 자동증가',
name varchar(50) NOT NULL COMMENT '이름',
genre_id BIGINT UNSIGNED NOT NULL COMMENT '장르 FK',
play_time varchar(10) NOT NULL COMMENT '플레이타임 02:05',
casts varchar(100) NOT NULL COMMENT '영화출연진정보',
description text null COMMENT '영화줄거리',
restrict_age INT UNSIGNED NOT NULL COMMENT '관람제한나이',
CONSTRAINT cinema_tbl_pk PRIMARY KEY (id),
CONSTRAINT cinema_tbl_fk_genre FOREIGN KEY (genre_id) REFERENCES genre_tbl(id) ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='연락처';
```