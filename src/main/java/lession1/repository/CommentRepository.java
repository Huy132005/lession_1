package lession1.repository;

import lession1.dto.CommentDto;
import lession1.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
//    Page<Comment> findAll(Pageable pageable);
}
