package lession1.service;
import lession1.dto.PostDto;
import lession1.form.PostCreateForm;
import lession1.form.PostFilterForm;
import lession1.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    Page<PostDto> findAll(PostFilterForm filter, Pageable pageable);

    PostDto findById(Long id);

    PostDto create(PostCreateForm form);

    PostDto update(PostUpdateForm form, Long id);

    void deleteById(Long id);


}

