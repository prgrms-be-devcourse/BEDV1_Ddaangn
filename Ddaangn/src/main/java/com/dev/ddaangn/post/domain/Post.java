package com.dev.ddaangn.post.domain;

import com.dev.ddaangn.common.BaseEntity;
import com.dev.ddaangn.post.converter.PostStatusAttributeConverter;
import com.dev.ddaangn.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "posts")
@DynamicUpdate
@Builder
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    private String contents;

    @Convert(converter = PostStatusAttributeConverter.class)
    @Column(name = "status", nullable = false)
    private PostStatus status;

    @Column(name = "views", nullable = false)
    private Long views;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private User seller;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private User buyer;

    public void addPost(User user) {
        this.seller = user;
        user.getSoldPosts().addPost(this);
    }
}