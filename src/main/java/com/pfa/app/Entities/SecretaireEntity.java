package com.pfa.app.Entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "secretaires")
public class SecretaireEntity {

    private String id;
    private String salaire;
    private Date create_at;

    private UserEntity user;

}
