package com.stackroute.userService.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Track {

    @Id
    int id;
    String name;
    String comment;

}
