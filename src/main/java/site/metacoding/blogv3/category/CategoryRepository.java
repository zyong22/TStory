package site.metacoding.blogv3.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
    // 아이디, 카테고리로 중복체크
    Optional<Category> findByCategoryNameAndUserId (String categoryName, Integer sessionUserId);

    // 아이디로 카테고리 목록 찾음
    List<Category> findByUserId(Integer userId);
}
