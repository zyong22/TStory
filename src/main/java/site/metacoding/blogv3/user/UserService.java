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

    @Transactional
    public User login(UserRequest.LoginDTO requestDTO) {
        User user = userRepository.findByUsernameAndPassword(requestDTO.getUsername(), requestDTO.getPassword())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user;
    }

    @Transactional
    public UserResponse.ShowUpdateDTO showUpdate(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponse.ShowUpdateDTO(user);
    }

    @Transactional
    public void update(Integer userId, UserRequest.UpdatePasswordDTO updateDTO) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(updateDTO.getOldPassword())){
           throw new RuntimeException("기존 비밀번호 틀렸음");
        }

        if(user.getPassword().equals(updateDTO.getNewPassword())) {
            throw new RuntimeException("동일한 비밀번호로 변경할 수 없음");
        }

        user.setPassword(updateDTO.getNewPassword());
        userRepository.save(user);
    }
}
