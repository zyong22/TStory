package site.metacoding.blogv3.category;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import site.metacoding.blogv3.user.User;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CategoryController {

    private final CategoryService categoryService;
    private final HttpSession session;

    @GetMapping("/category/write-form")
    public String writeForm() {
        return "category/writeForm";
    }

    // 카테고리 등록
    @PostMapping("/category/save")
    public String save(String categoryName, Model model) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        categoryService.saveCategory(sessionUser.getId(), categoryName);

        return "redirect:/write-form";
    }
}
