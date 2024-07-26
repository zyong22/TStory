package site.metacoding.blogv3.subscribe;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blogv3.user.User;

@Entity
@NoArgsConstructor
@Data
@Table(name = "subscribe_tb")
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriber_id", nullable = false)
    private User subscriber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscribed_to_id", nullable = false)
    private User subscribedTo;

    public Subscribe(Integer id, User subscriber, User subscribedTo) {
        this.id = id;
        this.subscriber = subscriber;
        this.subscribedTo = subscribedTo;
    }
}
