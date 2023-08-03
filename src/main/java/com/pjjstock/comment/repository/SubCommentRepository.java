package com.pjjstock.comment.repository;

import com.pjjstock.comment.domain.entity.Comment;
import com.pjjstock.comment.domain.entity.SubComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SubCommentRepository extends JpaRepository<SubComment, Long> {
    Page<SubComment> findById(Long id, Pageable pageable);
    @Modifying
    @Query("UPDATE SubComment c SET c.likeCount = c.likeCount+1 WHERE c.id = :id")
    void updateByLikeCountPlus(Long id);
    @Modifying
    @Query("UPDATE SubComment c SET c.likeCount = c.likeCount-1 WHERE c.id = :id")
    void updateByLikeCountMinus(Long id);
}
