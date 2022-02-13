package com.ugerodarr.iobuilders.domain.model.user;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "USERS")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDUSER")
    private BigInteger idUser;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="LASTNAME", nullable = false)
    private String lastName;

    @Column(name="PASSWORD", nullable = false)
    private String password;

    @Column(name="EMAIL", nullable = false)
    private String email;

    @Column(name="CREATION_DATE")
    private Date creationDate;

    public User() {
    }

    public User(String name, String lastName, String password, String email, Date creationDate) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.creationDate = creationDate;
    }

    public BigInteger getIdUser() {
        return idUser;
    }

    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
