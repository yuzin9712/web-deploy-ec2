package com.web.backend.service;

import com.web.backend.domain.posts.Posts;
import com.web.backend.domain.posts.PostsRepository;
import com.web.backend.dto.PostSaveRequestDto;
import com.web.backend.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostSaveRequestDto postSaveRequestDto) {
        Posts posts =  postsRepository.save(postSaveRequestDto.toEntity());
        return posts.getId();
    }

    @Transactional(readOnly = true)
    public List<PostsResponseDto> list() {
        return postsRepository.findAll().stream().map(PostsResponseDto::new).collect(Collectors.toList());
    }

    public PostsResponseDto getPost(Long id) {
        Optional<Posts> post =  postsRepository.findById(id);
        if(!post.isPresent()) {
            throw new IllegalArgumentException("존재하지 않는 게시글입니다.");
        }

        PostsResponseDto postsResponseDto = new PostsResponseDto(post.get());
        return postsResponseDto;
    }
}
