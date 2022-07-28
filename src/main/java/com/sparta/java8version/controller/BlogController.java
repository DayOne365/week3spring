package com.sparta.java8version.controller;

import com.sparta.java8version.domain.Blog;
import com.sparta.java8version.domain.BlogRepository;
import com.sparta.java8version.domain.BlogRequestDto;
import com.sparta.java8version.domain.BlogResponseDto;
import com.sparta.java8version.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BlogController {

    private final BlogRepository repository;
    private final BlogService blogService;

    // 게시글 작성
    @PostMapping("/api/post") // 게시글 생성
    public Blog createBlog(@RequestBody BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);
        return repository.save(blog);
    }
    // 게시글 수정
    @PutMapping("/api/post/{id}")
    public String updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto){
        return blogService.update(id,requestDto);
    }

    // 게시글 전체 조회 테스트
    @GetMapping("/api/post")
    public List<BlogResponseDto> getBlog(){
        return blogService.ResponseList();
    }

    // 게시글 세부 조회 아이디값으로 들어가기
    @GetMapping("/api/post/{id}")
    public Optional<Blog> idBlog(@PathVariable Long id){
        return repository.findById(id);
    }

    //게시글 비밀번호 확인
    @PostMapping("/api/post/pw/{id}")
    public String checkPassword(@PathVariable Long id,@RequestBody BlogRequestDto requestDto ){
        return blogService.checkPw(id,requestDto);
    }

    // 게시글 삭제
    @DeleteMapping("/api/post/{id}")
    public Long deleteBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto){
        return blogService.delete(id, requestDto);
    }

}
