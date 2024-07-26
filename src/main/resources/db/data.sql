-- 유저 테이블
INSERT INTO user_tb (id, username, password, email, created_at)
VALUES (1, 'ssar', '1234', 'ssar@nate.com', now());
INSERT INTO user_tb (id, username, password, email, created_at)
VALUES (2, 'qwer', '1234', '123@nate.com', now());
INSERT INTO user_tb (id, username, password, email, created_at)
VALUES (3, 'dragon', '1234', 'dragon@nate.com', DATEADD('DAY', -88, CURRENT_TIMESTAMP));




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

INSERT INTO category_tb (category_id, user_id, category_name, created_at)
VALUES ('8', '3', '여행', now());
INSERT INTO category_tb (category_id, user_id, category_name, created_at)
VALUES ('9', '3', '일상', now());

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

-- 3번 유저 게시글
INSERT INTO post_tb (id, user_id, category_id, title, content, created_at)
VALUES (23, 3, 8, '겨울 여행지 추천', '겨울에 가기 좋은 여행지를 추천합니다. 따뜻한 휴양지를 찾아보세요.', '2024-07-12 11:00:00'),
       (24, 3, 9, '취미 생활 공유', '요즘 새로 시작한 취미에 대해 이야기해볼게요. 정말 재미있어요!', '2024-07-14 13:30:00'),
       (25, 3, 9, '최고의 커피 맛집', '최근에 방문한 커피 맛집 중에서 최고였던 곳을 소개합니다.', '2024-07-16 15:45:00'),
       (26, 3, 9, '기술 서적 리뷰', '최근에 읽은 기술 서적에 대한 리뷰를 공유합니다. 많은 도움이 되었어요.', '2024-07-18 17:20:00'),
       (27, 3, 8, '주말 등산 후기', '주말에 다녀온 등산 후기입니다. 상쾌한 공기와 멋진 풍경이 인상적이었어요.', '2024-07-20 09:00:00'),
       (28, 3, 9, '새로운 게임 리뷰', '새로 출시된 게임을 플레이해봤습니다. 리뷰를 남겨봅니다.', '2024-07-22 19:40:00');

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