package edu.kpi.java.contentheap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    private String id;
    @DBRef
    private Content content;
    @DBRef
    private User author;
    @DBRef
    private List<Tag> tags;
    private LocalDateTime creationTimestamp;
    private Long rating;
}
