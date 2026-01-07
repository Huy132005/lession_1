package lession1.service.impl;

import lession1.dto.CommentDto;
import lession1.dto.PostDto;
import lession1.form.PostFilterForm;
import lession1.repository.CommentRepository;
import lession1.service.CommentService;
import lession1.specification.PostSpecification;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.modelmapper.Converters.Collection.map;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<CommentDto> findAll(PostFilterForm form, Pageable pageable) {
        var spec = PostSpecification.buildSpec(form);
        return commentRepository.findAll(pageable)
                .map(comment -> modelMapper.map(comment, CommentDto.class));
    }

}
