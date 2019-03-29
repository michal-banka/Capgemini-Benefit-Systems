package com.app.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by MichalPC on 2018-03-07, 00:45.
 */



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="Account")
public class Account{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    String login;
    String password;
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "account")
    User user;



}

