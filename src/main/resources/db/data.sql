-- 유저 테이블
INSERT INTO user_tb (id, username, password, email, created_at)
VALUES (1, 'ssar', '1234', 'ssar@nate.com', now());
INSERT INTO user_tb (id, username, password, email, created_at)
VALUES (2, 'qwer', '123', '123@nate.com', now());
INSERT INTO user_tb (id, username, password, email, created_at)
VALUES (3, 'dragon', '1234', 'dragon@nate.com', now());

-- 카테고리 테이블
INSERT INTO category_tb (category_id, user_id, category_name, created_at)
VALUES ('1', '1', '일상', now());
INSERT INTO category_tb (category_id, user_id, category_name, created_at)
VALUES ('2', '1', '고민', now());
INSERT INTO category_tb (category_id, user_id, category_name, created_at)
VALUES ('3', '1', '취미', now());
INSERT INTO category_tb (category_id, user_id, category_name, created_at)
VALUES ('7', '1', '운동', now());

INSERT INTO category_tb (category_id, user_id, category_name, created_at)
VALUES ('4', '2', '취미', now());
INSERT INTO category_tb (category_id, user_id, category_name, created_at)
VALUES ('5', '2', '다이어트', now());
INSERT INTO category_tb (category_id, user_id, category_name, created_at)
VALUES ('6', '2', '운동', now());

-- 게시글 테이블
-- 1번 유저 게시글
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (1, '1', '7', '0701 오운완', '제곧내입니다.', now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (2, '1', '7', '0702 오운완', '제곧내입니다.', now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (3, '1', '7', '0703 오운완', '제곧내입니다.', now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (4, '1', '7', '0704 오운완', '제곧내입니다.', now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (5, '1', '7', '0705 오운완', '제곧내입니다.', now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (6, '1', '1', '운동 쉬고 데일리룩 한 컷~ ', '오늘의 착장은요...', now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (7, '1', '7', '0706 오운완', '제곧내입니다.', now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (8, '1', '7', '0707 오운완', '제곧내입니다.', now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (9, '1', '7', '0708 오운완', '제곧내입니다.', now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (10, '1', '1', '일상입니다', '핫한 카페 갔어용~', now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (11, '1', '7', '0709 오운완', '제곧내입니다.', now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (12, '1', '7', '0710 오운완', '제곧내입니다.', now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (13, '1', '7', '0711 오운완', '제곧내입니다.', now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (14, '1', '7', '0712 오운완', '제곧내입니다.', now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (15, '1', '7', '0713 오운완', '제곧내입니다.', now());
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (16, '1', '3', '새로운 취미에 빠졌어요', '코딩이 너무 재밌는걸요?', now());

-- 2번 유저
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (17, 2, 4, '여름 휴가 계획', '올해 여름 휴가 계획을 세우고 있습니다. 추천할 만한 곳이 있을까요?', '2024-06-15 10:00:00'),
       (18, 2, 4, '최신 영화 리뷰', '최근 개봉한 영화를 보고 왔습니다. 리뷰를 공유합니다.', '2024-06-20 14:30:00'),
       (19, 2, 4, '새로운 요리 도전', '이번 주말에 새로운 요리에 도전해 보았습니다. 레시피와 결과를 공유합니다.', '2024-06-25 18:45:00'),
       (20, 2, 4, '독서 추천', '최근 읽은 책 중에서 추천할 만한 책들을 소개합니다.', '2024-07-01 09:15:00'),
       (21, 2, 4, '주말 산책 코스', '주말에 다녀온 산책 코스를 소개합니다. 자연경관이 정말 아름다웠어요.', '2024-07-05 16:00:00'),
       (22, 2, 4, '스포츠 경기 관람 후기', '어제 다녀온 스포츠 경기 관람 후기를 남깁니다. 정말 흥미진진했어요.', '2024-07-10 20:20:00');

-- 댓글 테이블
-- 16번 게시글 댓글
INSERT INTO reply_tb (id, content, user_id, post_id, created_at)
VALUES (1, '첫번째 댓글 입니다.', 2, 16, now());
INSERT INTO reply_tb (id, content, user_id, post_id, created_at)
VALUES (2, '두번째 댓글 입니다.', 3, 16, now());
INSERT INTO reply_tb (id, content, user_id, post_id, created_at)
VALUES (3, '세번째 댓글 입니다.', 1, 16, now());
INSERT INTO reply_tb (id, content, user_id, post_id, created_at)
VALUES (9, '네번째 댓글 입니다.', 1, 16, now());
INSERT INTO reply_tb (id, content, user_id, post_id, created_at)
VALUES (10, '다섯번째 댓글 입니다.', 1, 16, now());
INSERT INTO reply_tb (id, content, user_id, post_id, created_at)
VALUES (11, '여섯번째 댓글 입니다.', 1, 16, now());
INSERT INTO reply_tb (id, content, user_id, post_id, created_at)
VALUES (12, '일곱번째 댓글 입니다.', 1, 16, now());
INSERT INTO reply_tb (id, content, user_id, post_id, created_at)
VALUES (13, '여덟번째 댓글 입니다.', 1, 16, now());

-- 15번 게시글 댓글
INSERT INTO reply_tb (id, content, user_id, post_id, created_at)
VALUES (4, '첫번째 댓글 입니다.', 2, 15, now());
INSERT INTO reply_tb (id, content, user_id, post_id, created_at)
VALUES (5, '두번째 댓글 입니다.', 3, 15, now());
INSERT INTO reply_tb (id, content, user_id, post_id, created_at)
VALUES (6, '세번째 댓글 입니다.', 1, 15, now());

-- 14번 게시글 댓글
INSERT INTO reply_tb (id, content, user_id, post_id, created_at)
VALUES (7, '첫번째 댓글 입니다.', 2, 14, now());
INSERT INTO reply_tb (id, content, user_id, post_id, created_at)
VALUES (8, '두번째 댓글 입니다.', 3, 14, now());