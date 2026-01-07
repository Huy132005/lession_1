package lession1.service.impl;

import lession1.dto.PostDto;
import lession1.entity.Post;
import lession1.form.PostCreateForm;
import lession1.form.PostFilterForm;
import lession1.form.PostUpdateForm;
import lession1.repository.PostRepository;
import lession1.service.PostService;
import lession1.specification.PostSpecification;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private ModelMapper modelMapper;

    @Override
    public Page<PostDto> findAll(PostFilterForm form, Pageable pageable) {
        var spec = PostSpecification.buildSpec(form);
        return postRepository.findAll(pageable)
                .map(post -> modelMapper.map(post, PostDto.class));
    }
    @Override
    public PostDto findById(Long id){
        return postRepository.findById(id)
                .map(post -> modelMapper.map(post, PostDto.class))
                .orElse(null);

    }
    @Override
    public PostDto create(PostCreateForm form){
        var post = modelMapper.map(form, Post.class);
        var savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }
    @Override
    public PostDto update(PostUpdateForm form, Long id){
        var optional = postRepository.findById(id);
        if (optional.isEmpty()){
            return  null;
        }
          var post = optional.get();
          modelMapper.map(form, post);
        var savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
        }
    @Override
    public void deleteById(Long id){
        postRepository.deleteById(id);
    }
}

