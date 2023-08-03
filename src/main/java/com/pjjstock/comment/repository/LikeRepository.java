package com.pjjstock.comment.repository;

import com.pjjstock.comment.domain.entity.LikeCheck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<LikeCheck, Long> {

    Optional<LikeCheck> findByMemberIdAndCommentId(Long memberId, Long commentId);
}
