package site.metacoding.blogv3.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJPARepository userRepo;

    @Transactional
    public User join(UserRequest.JoinDTO requestDTO) {
        User user = userRepo.save(requestDTO.toEntity());
        return user;
    }
}
