package com.project.shopping.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "payments")
@Data

public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
    private Date date;
    private String paymentMode;
    private int userId;

    @OneToOne
    private Orders orders;

    

    

    
}