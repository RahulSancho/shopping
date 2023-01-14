package com.project.shopping.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id

    private int roleId;
    private String Role;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<Users> users;

}
