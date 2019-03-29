package com.app.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
/**
 * Created by MichalPC on 2018-03-07, 00:45.
 */



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="Activity")
public class Activity{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    Long points;
    String type;
    String name;
    String description;
    String photo;
    LocalDate startingDate;
    LocalDate finishDate;
    Long maxUsers;
    Long actualUsers;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "projectId")
    Project project;

}
