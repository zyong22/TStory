package site.metacoding.blogv3.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "user_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public User(Integer id, String username, String password, String email, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
    }

    @Builder
    public User(UserRequest.JoinDTO requestDTO) {
        this.username = requestDTO.getUsername();
        this.password = requestDTO.getPassword();
        this.email = requestDTO.getEmail();
        this.createdAt = LocalDateTime.now();
    }
}
