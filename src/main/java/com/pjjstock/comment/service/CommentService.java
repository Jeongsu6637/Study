package com.pjjstock.comment.service;

import com.pjjstock.comment.domain.dto.request.InsertRequest;
import com.pjjstock.comment.domain.dto.request.SubInsertRequest;
import com.pjjstock.comment.domain.dto.response.CommentResponse;
import com.pjjstock.comment.domain.entity.Comment;
import com.pjjstock.comment.domain.entity.LikeCheck;
import com.pjjstock.comment.domain.entity.SubLikeCheck;
import com.pjjstock.comment.repository.CommentRepository;
import com.pjjstock.comment.repository.LikeRepository;
import com.pjjstock.comment.repository.SubCommentRepository;
import com.pjjstock.comment.repository.SubLikeRepository;
import com.pjjstock.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final SubCommentRepository subCommentRepository;
    private final MemberRepository memberRepository;
    private final LikeRepository likeRepository;
    private final SubLikeRepository subLikeRepository;

    public void insert(InsertRequest request){
            commentRepository.save(request.toEntity());
    }

    public void sub_insert(SubInsertRequest request){
        subCommentRepository.save(request.toEntity());
    }

    public Page<CommentResponse> getAllById(Long id, Pageable pageable){
        Page<Comment> byId = commentRepository.findById(id, pageable);
        return byId.map(CommentResponse::new);
    }

    public Page<CommentResponse> getAll(Pageable pageable){
        Page<Comment> byId = commentRepository.findAll(pageable);
        return byId.map(CommentResponse::new);
    }

    public void likeBtn(Long commentId, Long memberId, int num){
        Optional<LikeCheck> likeCheck = likeRepository.findByMemberIdAndCommentId(memberId, commentId);

        if (num == 1) {
            if (likeCheck.isPresent()) {
                // 이미 좋아요를 눌렀을 때 처리
                System.out.println("이미 좋아요를 누른 상태");
            } else {
                // 좋아요 추가 처리
                commentRepository.updateByLikeCountPlus(commentId);
                LikeCheck newLike = LikeCheck.builder().memberId(memberId).commentId(commentId).build();
                likeRepository.save(newLike);
            }
        } else {
            if (likeCheck.isPresent()) {
                // 좋아요 취소 처리
                commentRepository.updateByLikeCountMinus(commentId);
                likeRepository.delete(likeCheck.get());
            } else {
                // 이미 좋아요를 취소한 상태 처리
                System.out.println("이미 좋아요를 취소한 상태");
            }
        }
    }

    public void subLikeBtn(Long subCommentId, Long memberId, int num){
        Optional<SubLikeCheck> subLikeCheck = subLikeRepository.findByMemberIdAndSubCommentId(memberId, subCommentId);
        if (num == 1) {
            if (subLikeCheck.isPresent()) {
                // 이미 좋아요를 눌렀을 때 처리
                System.out.println("이미 좋아요를 누른 상태");
            } else {
                // 좋아요 추가 처리
                subCommentRepository.updateByLikeCountPlus(subCommentId);
                SubLikeCheck newLike = SubLikeCheck.builder().memberId(memberId).subCommentId(subCommentId).build();
                subLikeRepository.save(newLike);
            }
        } else {
            if (subLikeCheck.isPresent()) {
                // 좋아요 취소 처리
                subCommentRepository.updateByLikeCountMinus(subCommentId);
                subLikeRepository.delete(subLikeCheck.get());
            } else {
                // 이미 좋아요를 취소한 상태 처리
                System.out.println("이미 좋아요를 취소한 상태");
            }
        }
    }


}
