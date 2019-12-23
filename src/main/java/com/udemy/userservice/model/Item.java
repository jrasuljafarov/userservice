package com.udemy.userservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
public class Item extends BaseEntity {

    private String name;
    private String status;

    @Column(columnDefinition = "text")
    private String description;

    private String itemCondition;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date addDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
