package com.stackroute.userService.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "track")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Track {

    @Id
    int id;
    String name;
    String artist;

}
