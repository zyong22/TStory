package site.metacoding.blogv3.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3.user.User;
import site.metacoding.blogv3.user.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Transactional
    public void saveCategory(Integer id, String categoryName) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));

        Optional<Category> category = categoryRepository.findByCategoryNameAndUserId(categoryName, id);

        if(category.isPresent()) {
            throw  new RuntimeException("이미 존재하는 카테고리");
        } else {
            categoryRepository.save(Category.builder()
                    .categoryName(categoryName)
                    .user(user)
                    .build());
        }
    }

    @Transactional
    public List<Category> categoryList(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));

        List<Category> categories = categoryRepository.findByUserId(user.getId());

        return categories;
    }
}
