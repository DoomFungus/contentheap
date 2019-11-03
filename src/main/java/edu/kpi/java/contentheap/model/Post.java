package edu.kpi.java.contentheap.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Post {
    @Id
    private Integer id;
    @DBRef
    private Content content;
    @DBRef
    private User author;
    @DBRef
    private List<Tag> tags;
}
