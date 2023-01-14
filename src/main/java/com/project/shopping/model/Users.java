package com.project.shopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity

@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String name;
    private String phoneNumber;

    private String password;

    private String address;
    private String email;
    private String gender;

    @ManyToOne()
    private Role role;
}
