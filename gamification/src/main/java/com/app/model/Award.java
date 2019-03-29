package com.app.model;
import lombok.*;
import org.hibernate.annotations.JoinColumnOrFormula;
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
@Table(name="Award")
public class Award{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    String type;
    String name;
    String photo;
    LocalDate date;
    Long cost;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    User user;
}