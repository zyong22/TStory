package site.metacoding.blogv3.post;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import site.metacoding.blogv3.category.Category;
import site.metacoding.blogv3.category.CategoryService;
import site.metacoding.blogv3.user.User;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;
    private final CategoryService categoryService;
    private final HttpSession session;

    // 상세보기
    @GetMapping("/post/open/{postId}")
    public String openPost(@PathVariable int postId, Model model) {
        PostResponse.PostDetailDTO detail = postService.findPostDetail(postId);
        model.addAttribute("detail", detail);

        return "/post/detail";
    }

    // 글쓰기
    @PostMapping("/post/write")
    public String writeTest(PostRequest.AddPostDTO postDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        postService.savePost(sessionUser.getId(), postDTO);

        return "redirect:/list-form";
    }

    // list폼 열기
    @GetMapping("/list-form")
    public String commList(Model model) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        List<Post> posts = postService.findPost(sessionUser.getId());
        model.addAttribute("posts", posts);

        return "/post/list";
    }

    // write폼 열기
    @GetMapping("/write-form")
    public String writeForm(Model model) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        List<Category> categoryList = categoryService.categoryList(sessionUser.getId());
        model.addAttribute("categoryList", categoryList);

        return "/post/writeForm";
    }
}
