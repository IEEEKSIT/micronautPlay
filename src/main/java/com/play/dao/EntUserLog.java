package com.play.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="ent_user_log")
public class EntUserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="uid",referencedColumnName = "id")
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="eid",referencedColumnName = "id")
    private Enterprise enterprise;
    private String type;
    @Column(name="txnid")
    private String transactionId;
    @Column(name="urlpath")
    private String urlPath;
    @Column(name="serviceid")
    private String serviceid;
    private String status;
    private String activityStatus;
    private String shortUrl;
    @Column(name="msg")
    private String message;
    @Column(name="createdon")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name="updatedon")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date updatedOn;
}
