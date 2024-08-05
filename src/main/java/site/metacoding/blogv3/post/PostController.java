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
import site.metacoding.blogv3.reply.ReplyResponse;
import site.metacoding.blogv3.user.User;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;
    private final CategoryService categoryService;
    private final HttpSession session;

    // 메인
    @GetMapping("/")
    public String index(Model model) {
        List<PostResponse.MainPageDTO> mainPageList = postService.findAllPost();
        model.addAttribute("mainPageList", mainPageList);

        return "main";
    }

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

        User sessionUser = (User) session.getAttribute("sessionUser");
        model.addAttribute("user", sessionUser);

        return "/post/detail";
    }

    // 게시글 리스트 열기
    @GetMapping("/user/post/{userId}")
    public String anotherUserPost(@PathVariable Integer userId, Model model) {

        // 유저 아이디랑 세션 유저 아이디 일치 하는지 확인용
        User sessionUser = (User) session.getAttribute("sessionUser");
        boolean isCurrentUser = sessionUser != null && sessionUser.getId().equals(userId);

        model.addAttribute("userId", userId);
        model.addAttribute("isCurrentUser", isCurrentUser);

        return "/post/list";
    }

    // 내 게시글 리스트 열기
//    @GetMapping("/list/form/{userId}")
//    public String postList(@PathVariable Integer userId, Model model) {
//        model.addAttribute("userId", userId);
//
//        return "/post/list";
//    }

    // 리스트 불러오기
    @GetMapping("/list/load/{userId}")
    public @ResponseBody Page<PostResponse.UserPostDTO> postListAjax(@PathVariable Integer userId, Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<PostResponse.UserPostDTO> postPage = postService.findPost(userId, pageable);

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
