package com.play.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "pd_agent")
public class PdAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "fname")
    private String firstName;
    private String emailId;
    private String authId;
    private String webToken;
    @Column(name = "lname")
    private String lastName;
    private String transactionId;
    private String password;
    private String status;
    private String salt;
    private String palgo;
    private String mobile;
    private String role;
    private String muteStatus;
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date createdOn;
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date updatedOn;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enterprise_id",referencedColumnName = "id")
    private Enterprise enterprise;
}
