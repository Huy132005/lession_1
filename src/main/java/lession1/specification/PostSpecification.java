package lession1.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lession1.entity.Post;
import lession1.form.PostFilterForm;
import org.springframework.data.jpa.domain.Specification;

import java.sql.Array;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class PostSpecification {
    public static Specification<Post> buildSpec(PostFilterForm form){
        return form == null ? null : new Specification<Post>() {
            @Override
            public Predicate toPredicate
                    (Root<Post> root,
                     CriteriaQuery<?> query,
                     CriteriaBuilder builder) {
               var predicates = new ArrayList<Predicate>();

               String search = form.getSearch();
               if(search != null){
                   var predicate = builder.like(
                           root.get("title"),
                           "%" + search + "%"
                   );
                   predicates.add(predicate);
               }
//Where create >= ?
               var minCreatedDate = form.getMinCreatedDate();
               if(minCreatedDate != null){
                   var minCreateAt = LocalDateTime.of(minCreatedDate, LocalTime.MIN);
                   var predicate = builder.greaterThanOrEqualTo(
                           root.get("create_at"),
                           minCreateAt
                   );
                   predicates.add(predicate);
               }
//Where create <= ?
               var maxCreatedDate = form.getMaxCreatedDate();
               if(maxCreatedDate != null){
                   var maxCreateAt = LocalDateTime.of(maxCreatedDate, LocalTime.MAX);
                   var predicate = builder.lessThanOrEqualTo(
                           root.get("create_at"),
                           maxCreateAt

                   );
                   predicates.add(predicate);
               }

               return builder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
