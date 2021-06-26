package com.pfa.app.dto;

import com.pfa.app.Entities.UserEntity;
import com.pfa.app.enums.CouvertureSociale;

import java.util.Date;

public class PatientDto {
    private String cin;
    private String ville;
    private String profession;
    private String motif;
    private CouvertureSociale couvertureSociale;
    private UserDto userDto;

    public PatientDto() {
    }

    public PatientDto(String cin, String ville, String profession, String motif, CouvertureSociale couvertureSociale, UserDto userDto) {
        this.cin = cin;
        this.ville = ville;
        this.profession = profession;
        this.motif = motif;
        this.couvertureSociale = couvertureSociale;
        this.userDto = userDto;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public CouvertureSociale getCouvertureSociale() {
        return couvertureSociale;
    }

    public void setCouvertureSociale(CouvertureSociale couvertureSociale) {
        this.couvertureSociale = couvertureSociale;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
