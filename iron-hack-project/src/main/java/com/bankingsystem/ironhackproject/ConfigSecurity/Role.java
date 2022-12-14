package com.bankingsystem.ironhackproject.ConfigSecurity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Role {
    @Id
    @GeneratedValue
    private Integer roleId;

    private String name;

    @ManyToOne
    private User user;

    public Role() {}
    public Role(Integer roleId, String name, User user) {
        this.roleId = roleId;
        this.name = name;
        this.user = user;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
