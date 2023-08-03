package com.pjjstock.comment.domain.dto.request;

import com.pjjstock.comment.domain.entity.Comment;
import com.pjjstock.comment.domain.entity.SubComment;
import com.pjjstock.member.domain.entity.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public class SubInsertRequest {
    private final String content;
    private final Long memberId;
    private final Long commentId;

    public SubComment toEntity(){
        Member member = Member.builder().id(memberId).build();
        Comment comment = Comment.builder().id(commentId).build();

        return SubComment
                .builder()
                .content(content)
                .likeCount(0)
                .member(member)
                .comment(comment)
                .build();
    }
}
