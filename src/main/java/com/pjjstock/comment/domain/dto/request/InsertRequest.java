package com.pjjstock.comment.domain.dto.request;

import com.pjjstock.comment.domain.entity.Comment;
import com.pjjstock.comment.domain.entity.SubComment;
import com.pjjstock.member.domain.entity.Member;
import com.pjjstock.stock.domain.entity.Stock;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
@Getter
public class InsertRequest {
    private final String content;
    private final Long memberId;
    private final Long stockId;

    public Comment toEntity(){
        Member member = Member.builder().id(memberId).build();
        Stock stock = Stock.builder().id(stockId).build();

        return Comment
                .builder()
                .content(content)
                .likeCount(0)
                .member(member)
                .stock(stock)
                .subComments(null)
                .build();
    }
}
