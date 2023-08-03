package com.pjjstock.comment.controller;

import com.pjjstock.comment.domain.dto.request.SubInsertRequest;
import com.pjjstock.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/subComment")
public class SubCommentController {

    private final CommentService commentService;

    @PostMapping
    public void insert(@RequestBody SubInsertRequest request){
        commentService.sub_insert(request);
    }

    @PutMapping
    public void SubLikeBtn(@RequestParam("subCommentId") Long subCommentId,
                           @RequestParam("memberId") Long memberId,
                           @RequestParam("num") int num){
        commentService.subLikeBtn(subCommentId, memberId, num);
    }


}
