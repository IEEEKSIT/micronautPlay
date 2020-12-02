package com.play.dao;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mobile;
    private String email;
    private String password;
    @Column(name="fname")
    private String firstName;
    @Column(name="lname")
    private String lastName;
    private String palgo;
    private String salt;
    private String type;
    private String partnerUserId;
    private String clientPartnerUserId;
    @Column(name="createdon")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name="updatedon")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date updatedOn;
}
