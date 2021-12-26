package com.citizen.setter.service;

import com.citizen.setter.domain.Post;
import com.citizen.setter.domain.repository.PostRepository;
import com.citizen.setter.web.dto.PostRequestDto;
import com.citizen.setter.web.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostResponseDto findPostById(Long id) {
        Post post = postRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto updateWithSetter(PostRequestDto requestDto) {
        Post post = postRepository.findById(requestDto.getId())
            .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + requestDto.getId()));

        post.setTitle(requestDto.getTitle());
        post.setContent(requestDto.getContent());

        return post.toDto();
    }

    @Transactional
    public PostResponseDto updateNoSetter(PostRequestDto requestDto) {
        Post post = postRepository.findById(requestDto.getId())
            .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + requestDto.getId()));

        return post.update(requestDto.getTitle(), requestDto.getContent());
    }

}
