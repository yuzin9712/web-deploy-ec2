package com.web.backend.controller;

import com.web.backend.dto.PostSaveRequestDto;
import com.web.backend.dto.PostsResponseDto;
import com.web.backend.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
@RestController
public class PostsController {

    private final PostsService postsService;

    @PostMapping("")
    private Long savePost(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        return postsService.save(postSaveRequestDto);
    }

    @GetMapping("")
    private List<PostsResponseDto> listPost() {
        return postsService.list();
    }

    @GetMapping("/{id}")
    private PostsResponseDto getPost(@PathVariable Long id) {
        return postsService.getPost(id);
    }
}
