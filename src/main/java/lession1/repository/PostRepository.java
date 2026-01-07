package lession1.repository;

import lession1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostRepository extends
        JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {


}
