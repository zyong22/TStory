-- 유저 테이블
INSERT INTO user_tb (id, username, password, email, created_at) VALUES (1, 'qwer', '123', '123@nate.com', now());
INSERT INTO user_tb (id, username, password, email, created_at) VALUES (2, 'ssar', '1234', 'ssar@nate.com', now());
INSERT INTO user_tb (id, username, password, email, created_at) VALUES (3, 'dragon', '1234', 'dragon@nate.com', now());

-- 카테고리 테이블
INSERT INTO category_tb (category_id, user_id, category_name, created_at) VALUES ('1', '1', '일상', now());
INSERT INTO category_tb (category_id, user_id, category_name, created_at) VALUES ('2', '1', '고민', now());
INSERT INTO category_tb (category_id, user_id, category_name, created_at) VALUES ('3', '1', '취미', now());

INSERT INTO category_tb (category_id, user_id, category_name, created_at) VALUES ('4', '2', '취미', now());
INSERT INTO category_tb (category_id, user_id, category_name, created_at) VALUES ('5', '2', '다이어트', now());
INSERT INTO category_tb (category_id, user_id, category_name, created_at) VALUES ('6', '2', '운동', now());

-- 게시글 테이블
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (1, '2', '4', '오운완', '제곧내입니다.',now());

-- 댓글 테이블
INSERT INTO reply_tb (id, reply, user_id, post_id, created_at) VALUES (1, '첫번째 댓글 입니다.', 1, 1, now());
INSERT INTO reply_tb (id, reply, user_id, post_id, created_at) VALUES (2, '두번째 댓글 입니다.', 3, 1, now());