package edu.kpi.java.contentheap.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Getter
@Setter
public class User {
    @Id
    private String name;
    private LocalDateTime creationTimestamp;

    public User(String name) {
        this.name = name;
        creationTimestamp = LocalDateTime.now();
    }
}
