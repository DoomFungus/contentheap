package edu.kpi.java.contentheap.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Tag {
    @Id
    private String id;
    private String name;
}
