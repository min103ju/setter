package com.citizen.setter.web.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostRequestDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
