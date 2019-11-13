package edu.kpi.java.contentheap.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Like {
    @Id
    private Key key;

    public Like(String postId, String userId){
        key = new Key(postId, userId);
    }

    @Value
    public static class Key{
        String postId;
        String userId;
    }
}
