package com.play.dao;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Table(name = "pd_transaction_id_mapping")
@Entity
public class PdTransactionIdMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agent_id", referencedColumnName = "id")
    private PdAgent agent;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enterprise_id", referencedColumnName = "id")
    private Enterprise enterprise;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ent_user_log_id", referencedColumnName = "id")
    private EntUserLog entUserLogId;
    private String partnerUniqueId;
    private String url;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "is_scheduled")
    @Enumerated(EnumType.STRING)
    private IsScheduled isScheduled;
    @Column(name = "notification_sent")
    @Enumerated(EnumType.STRING)
    private NotificationSent notificationSent;
    @Column(name = "scheduled_from")
    private Timestamp scheduledFrom;
    @Column(name = "scheduled_to")
    private Timestamp scheduledTo;
    @Column(name = "created_on")
    private Timestamp createdOn;
    @Column(name = "updated_on")
    private Timestamp updatedOn;

    public enum Status {
        ACTIVE,
        INACTIVE
    }

    public enum IsScheduled {
        TRUE,
        FALSE
    }

    public enum NotificationSent {
        TRUE,
        FALSE
    }
}
