-- 유저 테이블
INSERT INTO user_tb (id, username, password, email, created_at) VALUES (1, 'ssar', '1234', 'ssar@nate.com', now());
INSERT INTO user_tb (id, username, password, email, created_at) VALUES (2, 'qwer', '123', '123@nate.com', now());
INSERT INTO user_tb (id, username, password, email, created_at) VALUES (3, 'dragon', '1234', 'dragon@nate.com', now());

-- 카테고리 테이블
INSERT INTO category_tb (category_id, user_id, category_name, created_at) VALUES ('1', '1', '일상', now());
INSERT INTO category_tb (category_id, user_id, category_name, created_at) VALUES ('2', '1', '고민', now());
INSERT INTO category_tb (category_id, user_id, category_name, created_at) VALUES ('3', '1', '취미', now());
INSERT INTO category_tb (category_id, user_id, category_name, created_at) VALUES ('7', '1', '운동', now());

INSERT INTO category_tb (category_id, user_id, category_name, created_at) VALUES ('4', '2', '취미', now());
INSERT INTO category_tb (category_id, user_id, category_name, created_at) VALUES ('5', '2', '다이어트', now());
INSERT INTO category_tb (category_id, user_id, category_name, created_at) VALUES ('6', '2', '운동', now());

-- 게시글 테이블
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (1, '1', '7', '0701 오운완', '제곧내입니다.',now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (2, '1', '7', '0702 오운완', '제곧내입니다.',now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (3, '1', '7', '0703 오운완', '제곧내입니다.',now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (4, '1', '7', '0704 오운완', '제곧내입니다.',now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (5, '1', '7', '0705 오운완', '제곧내입니다.',now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (6, '1', '1', '운동 쉬고 데일리룩 한 컷~ ', '오늘의 착장은요...',now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (7, '1', '7', '0706 오운완', '제곧내입니다.',now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (8, '1', '7', '0707 오운완', '제곧내입니다.',now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (9, '1', '7', '0708 오운완', '제곧내입니다.',now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (10, '1', '1', '일상입니다', '핫한 카페 갔어용~',now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (11, '1', '7', '0709 오운완', '제곧내입니다.',now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (12, '1', '7', '0710 오운완', '제곧내입니다.',now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (13, '1', '7', '0711 오운완', '제곧내입니다.',now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (14, '1', '7', '0712 오운완', '제곧내입니다.',now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (15, '1', '7', '0713 오운완', '제곧내입니다.',now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at) VALUES (16, '1', '3', '새로운 취미에 빠졌어요', '코딩이 너무 재밌는걸요?',now());

-- 댓글 테이블
INSERT INTO reply_tb (id, content, user_id, post_id, created_at) VALUES (1, '첫번째 댓글 입니다.', 2, 16, now());
INSERT INTO reply_tb (id, content, user_id, post_id, created_at) VALUES (2, '두번째 댓글 입니다.', 3, 16, now());
INSERT INTO reply_tb (id, content, user_id, post_id, created_at) VALUES (3, '세번째 댓글 입니다.', 1, 16, now());