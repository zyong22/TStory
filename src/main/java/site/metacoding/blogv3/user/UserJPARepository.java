package site.metacoding.blogv3.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<User, Integer> {


    Optional<User> findByUsernameAndPassword(UserRequest.LoginDTO requestDTO);
}
