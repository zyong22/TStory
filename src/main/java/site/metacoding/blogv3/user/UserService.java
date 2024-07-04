package site.metacoding.blogv3.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3._core.errors.exception.LoginFailException;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJPARepository userRepo;

    @Transactional
    public void join(UserRequest.JoinDTO requestDTO) {
        userRepo.save(requestDTO.toEntity());
    }

    public User login(UserRequest.LoginDTO requestDTO) {
        System.out.println("requestDTO 2= " + requestDTO);
        User user = userRepo.findByUsernameAndPassword(requestDTO.getUsername(), requestDTO.getPassword())
                .orElseThrow(() -> new LoginFailException());

        System.out.println("user3 = " + user);
        return user;
    }
}
