package edu.kpi.java.contentheap.message.out;

import edu.kpi.java.contentheap.model.User;
import lombok.Data;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Data
public class UserDTO {
    private String name;
    private ZonedDateTime creationTimestamp;

    public static UserDTO from(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.name = user.getName();
        userDTO.creationTimestamp = ZonedDateTime.of(user.getCreationTimestamp(), ZoneOffset.UTC);
        return userDTO;
    }
}
