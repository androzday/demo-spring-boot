package com.routebus.demo_spring_boot.model;

import com.routebus.demo_spring_boot.utils.DateUtils;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity  implements Serializable {
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;

    @PrePersist
    public void onPrePersist() {
        System.out.println("PRESIST");
        this.isDeleted = false;
        String timestamp = DateUtils.getNowDateStringFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        this.createAt = date;
        this.updateAt = date;
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updateAt = new Date();
    }
}
