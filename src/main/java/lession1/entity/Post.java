package lession1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.descriptor.jdbc.CharJdbcType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "post", uniqueConstraints = {
        @UniqueConstraint(name = "id", columnNames = "id")
})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Luu id 1 bang khac
//    @SequenceGenerator(
//            name = "post_id",
//            sequenceName = "post_id",
//            initialValue = 10,
//            allocationSize = 1
//    )
//    @GeneratedValue(generator = "post_id")

//in ra doan ma dinh danh id
//    @GeneratedValue(strategy = GenerationType.UUID)
//  @JdbcType(value = CharJdbcType.class)
//    private UUID id;

// Custom
    @Column(name = "title", length = 50, nullable = false)
    private String title;
    @Column(name = "content", length = 150, nullable = false)
    private String content;
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comment> comments = new ArrayList<>();

}
