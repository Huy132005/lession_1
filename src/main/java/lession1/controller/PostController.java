package lession1.controller;

import jakarta.validation.Valid;
import lession1.dto.PostDto;
import lession1.form.PostCreateForm;
import lession1.form.PostFilterForm;
import lession1.form.PostUpdateForm;
import lession1.service.PostService;
import lession1.validation.PostIdExists;
import lession1.wrapper.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class PostController {
    private PostService postService;

    @GetMapping("/api/v1/posts")
    public Page<PostDto> findAll(PostFilterForm filter, Pageable pageable) {
        return postService.findAll(filter, pageable);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostDto findById(@PathVariable("id") @PostIdExists Long id){

        return postService.findById(id);
    }
    @PostMapping("/api/v1/posts")
    public PostDto create(@RequestBody @Valid PostCreateForm form){
        return postService.create(form);
    }
    @PutMapping("/api/v1/posts/{id}")
    public PostDto update(@RequestBody @Valid PostUpdateForm form,@PathVariable("id") @PostIdExists Long id){
        return postService.update(form, id);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public void deleteById(@PathVariable("id") @PostIdExists Long id){

        postService.deleteById(id);
    }
}
