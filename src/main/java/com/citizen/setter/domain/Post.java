package com.citizen.setter.domain;

import com.citizen.setter.web.dto.PostResponseDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Post {

    @Id
    private Long id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private String author;

    @PrePersist
    public PostResponseDto update(String title, String content) {
        this.title = title;
        this.content = content;

        return new PostResponseDto(this);
    }

}
