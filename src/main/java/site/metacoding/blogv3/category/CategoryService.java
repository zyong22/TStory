package site.metacoding.blogv3.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.metacoding.blogv3.user.User;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepositoty categoryRepositoty;


    public void addCategory(User sessionUser, CategoryRequest.addCategoryDTO addDTO) {
        Category category = new Category();
        category.setCategoryName(addDTO.getCategoryName());
        category.setUser(sessionUser);

        categoryRepositoty.save(category);
    }
}
