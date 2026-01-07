package lession1.controller;

import lession1.dto.CommentDto;
import lession1.dto.PostDto;
import lession1.form.PostFilterForm;
import lession1.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class CommentController {
    private final CommentService commentService;
    @GetMapping("/api/v1/comments")
    public Page<CommentDto> findAll(PostFilterForm filter, Pageable pageable) {
        return commentService.findAll(filter, pageable);
    }

}
