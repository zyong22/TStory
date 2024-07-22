package site.metacoding.blogv3.post;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    // 삭제
    @DeleteMapping("/post/delete/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer postId) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        postService.deletePost(postId, sessionUser.getId());

        return ResponseEntity.ok().body("{\"message\": \"게시글 삭제 완료\"}");
    }

    // 수정하기
    @PutMapping("/post/update")
    public ResponseEntity<?> update(@RequestBody PostRequest.UpdatePostDTO updatePostDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        postService.updatePost(sessionUser.getId(), updatePostDTO);

        return ResponseEntity.ok().body("{\"message\": \"게시글 수정 완료\"}");
    }

    // 상세보기
    @GetMapping("/post/open/{postId}")
    public String openPost(@PathVariable Integer postId, Model model) {
        PostResponse.PostDetailDTO detail = postService.findPostDetail(postId);
        model.addAttribute("detail", detail);

        return "/post/detail";
    }

    // list폼 열기
    @GetMapping("/list-form")
    public String postList() {
        return "/post/list";
    }

    // 열어버리면서 바로 그려버리기, 난 이렇게 하고 싶었어..
    @GetMapping("/list-form/ajax")
    public @ResponseBody Page<PostResponse.UserPostDTO> postListAjax(Model model, @PageableDefault(size = 5) Pageable pageable) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        Page<PostResponse.UserPostDTO> postPage = postService.findPost(sessionUser.getId(), pageable);

        return postPage; // json 컨버팅(lazy loading) -> buffer에 담아서 응답!!
    }

    // 글쓰기
    @PostMapping("/post/write")
    public String writeTest(PostRequest.AddPostDTO postDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        postService.savePost(sessionUser.getId(), postDTO);

        return "redirect:/list-form";
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
