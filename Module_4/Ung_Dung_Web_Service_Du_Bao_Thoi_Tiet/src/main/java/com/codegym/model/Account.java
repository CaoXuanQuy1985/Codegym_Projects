package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="accounts")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String role;

    @OneToMany(mappedBy="account")
    private Set<User> users;

    public Account() {}

    public Account(String role, Set<User> users) {
        this.role = role;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
