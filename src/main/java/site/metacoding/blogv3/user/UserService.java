package site.metacoding.blogv3.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void join(UserRequest.JoinDTO requestDTO) {
        User user = new User(requestDTO);
        userRepository.save(user);
    }

    public User login(UserRequest.LoginDTO requestDTO) {
        User user = userRepository.findByUsernameAndPassword(requestDTO.getUsername(), requestDTO.getPassword())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user;
    }
}
