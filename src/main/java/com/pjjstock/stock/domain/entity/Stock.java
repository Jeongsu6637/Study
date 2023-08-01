package com.pjjstock.stock.domain.entity;

import com.pjjstock.comment.domain.entity.Comment;
import com.pjjstock.news.domain.entity.News;
import jakarta.persistence.*;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock_name", nullable = false)
    @Length(max = 50)
    private String stockName;

    @Column(name = "stock_code", nullable = false)
    @Length(max = 7)
    private String stockCode;

    @Column(name = "isin_cd", nullable = false)
    @Length(max = 20)
    private String isinCd;

    @Column(name = "market_type", nullable = false)
    @Length(max = 10)
    @Enumerated(EnumType.STRING)
    private MarketType marketType;

    @Column(name = "strong_buy", nullable = false)
    @Builder.Default
    private Integer strongBuy = 0;

    @Column(name = "buy", nullable = false)
    @Builder.Default
    private Integer buy = 0;

    @Column(name = "sell", nullable = false)
    @Builder.Default
    private Integer sell = 0;

    @Column(name = "strong_sell", nullable = false)
    @Builder.Default
    private Integer strongSell = 0;

    @OneToMany(mappedBy = "stock", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.REMOVE)
    @Builder.Default
    private List<News> newsList = new ArrayList<>();

    @OneToMany(mappedBy = "stock", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.REMOVE)
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();
}
