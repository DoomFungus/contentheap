package edu.kpi.java.contentheap.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Tag {
    @Id
    private String name;

    public Tag(String name) {
        this.name = name;
    }
}
