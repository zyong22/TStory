package site.metacoding.blogv3.category;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import site.metacoding.blogv3.user.User;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "category_tb")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public Category(Integer categoryId, String categoryName, User user, LocalDateTime createdAt) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.user = user;
        this.createdAt = createdAt;
    }
}