package com.sparta.java8version.service;

import com.sparta.java8version.domain.Blog;
import com.sparta.java8version.domain.BlogRepository;
import com.sparta.java8version.domain.BlogRequestDto;
import com.sparta.java8version.domain.BlogResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository repository;


    @Transactional
    public String update(Long id, BlogRequestDto requestDto) {
        Blog blog = repository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디을 찾을 수 없습니다."));
        if (blog.getPassword() == requestDto.getPassword()) {
            blog.update(requestDto);
            return "수정 완료";
        } else {
            return "비밀번호가 틀립니다.";
        }
    }

    public String checkPw(Long id, BlogRequestDto requestDto) {
        Blog blog = repository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디를 찾을 수 없습니다."));
        if (blog.getPassword() == requestDto.getPassword()) {
            return "비밀번호가 일치합니다.";
        }
        return "비밀번호가 불일치합니다.";
    }

    public Long delete(Long id, BlogRequestDto requestDto) {
        Blog blog = repository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디를 찾을 수 없습니다."));
        if (blog.getPassword() == requestDto.getPassword()) {
            repository.deleteById(id);
        }
        return id;
    }
    public List<BlogResponseDto> ResponseList(){
        List<Blog> blogList = repository.findAllByOrderByModifiedAtDesc();
        List<BlogResponseDto> responseDtoList = new ArrayList<>();
        for(Blog blog : blogList){
            responseDtoList.add(new BlogResponseDto(blog));
        }
        return responseDtoList;
    }

}
