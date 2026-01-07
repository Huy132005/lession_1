package lession1.service;

import lession1.dto.CommentDto;
import lession1.dto.PostDto;
import lession1.entity.Comment;
import lession1.form.PostFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
   // Thêm Long postId vào đây
   Page<CommentDto> findAll(PostFilterForm filter, Pageable pageable);
}