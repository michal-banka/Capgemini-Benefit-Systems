package com.app.model;
import com.app.model.enums.Role;
import lombok.*;
import org.hibernate.annotations.JoinColumnOrFormula;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by MichalPC on 2018-03-07, 00:45.
 */



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="User")
public class User{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    String email;
    String name;
    String surname;
    @Enumerated(EnumType.STRING)
    Role role;
    Long pointsSum;
    Long currentPoints;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "accountId", unique = true)
    Account account;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    List<Award> awards = new ArrayList<>();


}