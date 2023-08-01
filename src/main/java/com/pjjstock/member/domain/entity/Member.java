package com.pjjstock.member.domain.entity;

import com.pjjstock.comment.domain.entity.Comment;
import com.pjjstock.global.baseentity.BaseEntity;
import com.pjjstock.news.domain.entity.NewsBookmark;
import com.pjjstock.stock.domain.entity.InterestedStock;
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
@Table(name = "members")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    @Length(max = 50)
    private String email;

    @Column(name = "name", nullable = false)
    @Length(max = 50)
    private String name;

    @Column(name = "birth", nullable = false)
    @Length(max = 10)
    private String birth;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.REMOVE)
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.REMOVE)
    @Builder.Default
    private List<NewsBookmark> newsBookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.REMOVE)
    @Builder.Default
    private List<InterestedStock> interestedStocks = new ArrayList<>();
}
