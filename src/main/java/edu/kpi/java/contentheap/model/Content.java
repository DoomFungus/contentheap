package edu.kpi.java.contentheap.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Content {
    @Id
    private String id;
    private String content;
}
