package com.pjjstock.comment.domain.dto.response;

import com.pjjstock.comment.domain.entity.Comment;
import com.pjjstock.comment.domain.entity.SubComment;
import lombok.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {

    private Long id;
    private String content;
    private Integer likeCount;
    private Long memberId;
    private Long stockId;
    private List<SubCommentDto> subComments;

    public CommentResponse(Comment comment){
        this.id = comment.getId();
        this.content = comment.getContent();

        this.likeCount = comment.getLikeCount();
        this.memberId = comment.getMember().getId();
        this.stockId = comment.getStock().getId();
        this.subComments = comment.getSubComments().stream()
                .map(subComment -> new SubCommentDto(subComment))
                .collect(Collectors.toList());
    }

    @Getter
    @NoArgsConstructor
    public static class SubCommentDto{
        private Long id;
        private String content;
        private Integer likeCount;
        private Long memberId;
        private Long commentId;
        public SubCommentDto(SubComment subComment){
            this.id = subComment.getId();
            this.content = subComment.getContent();
            this.likeCount = subComment.getLikeCount();
            this.memberId = subComment.getMember().getId();
            this.commentId = subComment.getComment().getId();
        }

    }


}
