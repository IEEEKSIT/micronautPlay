package com.play.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="ent")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column(name="shortname")
    private String shortName;
    private String address;
    private transient String phone;
    private transient String email;
    private transient String gst;
    private transient String pan;
    private transient String cin;
    private transient String tin;
    private String pname;
    private String pemail;
    private String pphone;
    private String sname;
    private String semail;
    private String sphone;
    private String s3link;
    private String logo;
    @Column(name="createdon")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name="updatedon")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date updatedOn;

}
