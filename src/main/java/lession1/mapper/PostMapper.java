package lession1.mapper;

import lession1.dto.PostDto;
import lession1.entity.Post;
import lession1.form.PostCreateForm;
import lession1.form.PostUpdateForm;

public class PostMapper {

    public static PostDto map(Post post){
          var dto = new PostDto();
          dto.setId(post.getId());
          dto.setTitle(post.getTitle());
          dto.setContent(post.getContent());
          dto.setCreatedAt(post.getCreatedAt());
          dto.setUpdatedAt(post.getUpdatedAt());
          return dto;
    }
    public static Post map(PostCreateForm form) {
        var post = new Post();

        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        return post;
    }

    // Update: Form -> Existing Entity
    public static void map(PostUpdateForm form, Post post) {

        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
    }
}
