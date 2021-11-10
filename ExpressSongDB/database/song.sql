# 권한 설정
# 필요 없으면 Skip!
grant all privileges on  *.* to 'root'@'%' identified by 'mysql1234';
delete from mysql.user where host="localhost" and user="root";
flush privileges;
select host,user,plugin,authentication_string from mysql.user;

###############################################
DROP DATABASE IF EXISTS songdb;

CREATE DATABASE IF NOT EXISTS songdb 
  DEFAULT CHARACTER SET utf8 
  DEFAULT COLLATE utf8_general_ci;

USE songdb;

CREATE TABLE song (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  singer VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8 
  DEFAULT COLLATE utf8_general_ci;

###############################################

INSERT INTO song (title, singer) VALUES
  ('총 맞은 것처럼', '백지영'),
  ('소주 한 잔', '임창정'),
  ('테스형', '나훈아'),
  ('한 장의 추억', '쿨'),
  ('화장을 고치고', '왁스'),
  ('사고쳤어요', '다비치'),
  ('사랑에 연습이 있었다면', '임재현'),
  ('멀어져간 사람아', '박상민'),
  ('사랑했지만', '김광석'),
  ('세월이 가면', '최호섭'),
  ('인연', '이선희'),
  ('그대와 영원히', '이문세'),
  ('해야', '마그마'),
  ('밤에 피는 장미', '어우러기'),
  ('희야', '부활'),
  ('애인있어요', '이은미'),
  ('내가 저지른 사랑', '임창정'),
  ('요즘 너 말야', '제이레빗'),
  ('무조건', '박상철'),
  ('내 마음에 비친 내 모습', '유재하'); # 맨 마지막엔 세미콜론 (;)