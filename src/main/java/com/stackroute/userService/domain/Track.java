package com.stackroute.userService.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Track {

    @Id
    private int id;
    private String name;
    private String comment;

}
