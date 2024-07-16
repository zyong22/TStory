-- 유저 테이블
INSERT INTO user_tb (username, password, email, created_at) VALUES ('qwer', '123', '123@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at) VALUES ('ssar', '1234', 'ssar@nate.com', now());

-- 카테고리 테이블
INSERT INTO category_tb (user_id, category_name, created_at) VALUES ('1', '일상', now());
INSERT INTO category_tb (user_id, category_name, created_at) VALUES ('1', '고민', now());
INSERT INTO category_tb (user_id, category_name, created_at) VALUES ('1', '취미', now());

INSERT INTO category_tb (user_id, category_name, created_at) VALUES ('2', '취미', now());
INSERT INTO category_tb (user_id, category_name, created_at) VALUES ('2', '다이어트', now());
INSERT INTO category_tb (user_id, category_name, created_at) VALUES ('2', '운동', now());