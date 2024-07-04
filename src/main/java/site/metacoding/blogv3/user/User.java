package site.metacoding.blogv3.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "user_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private String email;

    // 오어스 로그인
//    private String provider;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
