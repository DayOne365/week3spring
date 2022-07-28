package com.sparta.java8version.domain;

import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class BlogResponseDto {

    private String title;
    private Long id;
    private String author;
    private LocalDateTime modifiedAt;
    private LocalDateTime createAt;

    public BlogResponseDto(Blog blog) {
        this.title = blog.getTitle();
        this.id = blog.getId();
        this.author = blog.getAuthor();
        this.modifiedAt = blog.getModifiedAt();
        this.createAt = blog.getCreateAt();
    }
}
