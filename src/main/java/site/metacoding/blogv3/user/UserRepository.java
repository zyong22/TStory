package site.metacoding.blogv3.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    // 로그인
    Optional<User> findByUsernameAndPassword (String username, String password);
}
