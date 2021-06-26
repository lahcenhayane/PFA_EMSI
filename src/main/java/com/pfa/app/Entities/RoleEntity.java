//package com.pfa.app.Entities;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity(name = "roles")
//public class RoleEntity {
//    @Id @GeneratedValue
//    private long id;
//    private String name;
//
//    @ManyToMany
//    private List<UserEntity> users;
//
//    public RoleEntity() {
//    }
//
//    public RoleEntity(String name) {
//        this.name = name;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
