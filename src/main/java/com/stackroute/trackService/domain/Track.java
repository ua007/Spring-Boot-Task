package com.stackroute.trackService.domain;

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
    private int id;
    private String name;
    private String artist;

}
