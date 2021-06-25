package com.pfa.app.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "medecins")
public class MedcinEntity {
    @Id
    private String id;
    private Date create_at;
    private UserEntity user;


}
