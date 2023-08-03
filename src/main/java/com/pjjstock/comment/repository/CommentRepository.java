package com.pjjstock.comment.repository;

import com.pjjstock.comment.domain.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findById(Long id, Pageable pageable);
    @Modifying
    @Query("UPDATE Comment c SET c.likeCount = c.likeCount+1 WHERE c.id = :id")
    void updateByLikeCountPlus(Long id);
    @Modifying
    @Query("UPDATE Comment c SET c.likeCount = c.likeCount-1 WHERE c.id = :id")
    void updateByLikeCountMinus(Long id);




}
