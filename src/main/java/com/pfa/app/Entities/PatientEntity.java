package com.pfa.app.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "patients")
public class PatientEntity {
    @Id
    private String id;
    private String cin;
    private String ville;
    private String profession;
    private String motif;
    private Date create_at;

    private UserEntity user;

}
