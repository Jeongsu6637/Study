package com.pjjstock.stock.repository;

import com.pjjstock.stock.domain.entity.Clicked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClickedRepository extends JpaRepository<Clicked, Long> {

    @Query("select c from Clicked c where c.stock.id = :stockId and c.member.id = :memberId")
    Optional<Clicked> findByStockIdAndMemberId(Long stockId, Long memberId);

    Optional<Clicked> findByNum(Integer num);

}
