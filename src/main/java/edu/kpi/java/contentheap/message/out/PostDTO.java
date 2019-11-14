package edu.kpi.java.contentheap.message.out;

import edu.kpi.java.contentheap.model.Content;
import edu.kpi.java.contentheap.model.Post;
import edu.kpi.java.contentheap.model.Tag;
import lombok.Data;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class PostDTO {
    private String id;
    private Content content;
    private UserDTO author;
    private List<Tag> tags;
    private Long rating;
    private ZonedDateTime creationTimestamp;

    public static PostDTO from(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.id = post.getId();
        postDTO.content = post.getContent();
        postDTO.author = UserDTO.from(post.getAuthor());
        postDTO.tags = post.getTags();
        postDTO.creationTimestamp = ZonedDateTime.of(post.getCreationTimestamp(), ZoneOffset.UTC);
        postDTO.rating = post.getRating();
        return postDTO;
    }
}
