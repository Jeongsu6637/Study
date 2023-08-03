package com.pjjstock.comment.repository;

import com.pjjstock.comment.domain.entity.LikeCheck;
import com.pjjstock.comment.domain.entity.SubLikeCheck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubLikeRepository extends JpaRepository<SubLikeCheck, Long> {

    Optional<SubLikeCheck> findByMemberIdAndSubCommentId(Long memberId, Long subCommentId);
}
