package com.pjjstock.news.domain.entity;

import com.pjjstock.stock.domain.entity.Stock;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    @Length(max = 255)
    private String title;

    @Column(name = "url", nullable = false)
    @Length(max = 255)
    private String url;

    @Column(name = "image", nullable = false)
    @Length(max = 255)
    private String image;

    @Column(name = "description", nullable = false)
    @Length(max = 255)
    private String description;

    @Column(name = "pub_date", nullable = false)
    @Length(max = 255)
    private String pubDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

}
