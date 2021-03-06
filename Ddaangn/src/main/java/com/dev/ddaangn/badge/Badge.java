package com.dev.ddaangn.badge;


import com.dev.ddaangn.common.BaseEntity;
import com.dev.ddaangn.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@DynamicUpdate
@Entity(name = "badges")
public class Badge extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "achievement", nullable = false)
    private boolean achievement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "badge_images_id", referencedColumnName = "id")
    private BadgeImage badgeImage;

    public void setUser(User user) {
        if (Objects.nonNull(this.user)) {
            this.user.getBadges().remove(this);
        }
        this.user = user;
        user.getBadges().add(this);
    }

    public void removeUser() {
        this.user = null;
    }

}
