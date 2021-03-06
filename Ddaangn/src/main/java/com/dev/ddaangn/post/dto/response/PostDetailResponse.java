package com.dev.ddaangn.post.dto.response;

import com.dev.ddaangn.common.dto.BaseResponse;
import com.dev.ddaangn.post.domain.Post;
import com.dev.ddaangn.post.domain.PostStatus;
import lombok.Getter;

import java.util.Objects;


@Getter
public class PostDetailResponse extends BaseResponse {
    private final Long id;
    private final String title;
    private final String contents;
    private final PostStatus status;
    private final Long views;
    // TODO: images
    private final String sellerName;
    private final String buyerName;
    private final Boolean isHidden;

    public PostDetailResponse(Post post) {
        super(post.getCreatedAt(), post.getUpdateAt(), post.getDeletedAt());
        id = post.getId();
        title = post.getTitle();
        contents = post.getContents();
        status = post.getStatus();
        views = post.getViews();
        sellerName = post.getSeller().getName();
        isHidden = post.isHidden();
        buyerName = post.getBuyer() != null ? post.getBuyer().getName() : "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDetailResponse that = (PostDetailResponse) o;
        return id.equals(that.id) && title.equals(that.title) && Objects.equals(contents, that.contents) && status == that.status && views.equals(that.views) && sellerName.equals(that.sellerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
