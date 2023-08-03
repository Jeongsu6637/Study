package com.pjjstock.comment.controller;

import com.pjjstock.comment.domain.dto.request.InsertRequest;
import com.pjjstock.comment.domain.dto.response.CommentResponse;
import com.pjjstock.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public void insert(@RequestBody InsertRequest request){
        commentService.insert(request);
    }
    @GetMapping
    public Page<CommentResponse> getAll(@PathVariable(value = "id", required = false) Long id,
                                        @RequestParam(required = false, defaultValue = "0", name = "page") int page,
                                        @RequestParam(required = false, defaultValue = "3", name = "size") int size
    ){
        if (id != null) {
            // id가 입력된 경우 해당 id에 해당하는 댓글 조회
            Page<CommentResponse> all = commentService.getAllById(id, PageRequest.of(page, size));
            return all;
        } else {
            // id가 입력되지 않은 경우
            Page<CommentResponse> all = commentService.getAll(PageRequest.of(page, size));
            return all;
        }
    }
    @PutMapping
    public void likeBtn(@RequestParam("commentId") Long commentId,
                        @RequestParam("memberId") Long memberId,
                        @RequestParam("num") int num){
        commentService.likeBtn(commentId, memberId, num);
    }


}
