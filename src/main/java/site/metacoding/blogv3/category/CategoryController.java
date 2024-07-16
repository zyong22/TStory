package site.metacoding.blogv3.category;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import site.metacoding.blogv3.user.User;

@RequiredArgsConstructor
@Controller
public class CategoryController {

    private final CategoryService categoryService;
    private final HttpSession session;

    @GetMapping("/category/write-form")
    public String writeForm() {
        return "category/writeForm";
    }

    @PostMapping("/category/add")
    public ResponseEntity<?> add(@RequestBody CategoryRequest.addCategoryDTO addDTO) {
        User sessionUser  = (User) session.getAttribute("sessionUser");
        System.out.println("===========" + addDTO.toString());
        categoryService.addCategory(sessionUser, addDTO);

        return ResponseEntity.ok().build();
    }
}
