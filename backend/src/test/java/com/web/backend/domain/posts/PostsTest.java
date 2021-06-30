package com.web.backend.domain.posts;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsTest {

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void 게시물생성후조회() {
        String title = "첫 번째로 올린 글";
        String content = "첫 번째 글 내용입니다! 안녕하세요~ 반가워요!";
        String writer = "김유진";

        postsRepository.save(Posts.builder().title(title).content(content).writer(writer).build());

        List<Posts> posts = postsRepository.findAll();

        Posts post = posts.get(0);

        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
        assertThat(post.getWriter()).isEqualTo(writer);
    }

}
