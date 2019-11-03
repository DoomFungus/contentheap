package edu.kpi.java.contentheap.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class TextContent {
    private String text;
}
