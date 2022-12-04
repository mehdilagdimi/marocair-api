package com.mehdilagdimi.marocair_api.base;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

@MappedSuperclass
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column (nullable = false, length = 200)
    protected String fullname;
    @Column (nullable = false, length = 150)
    protected String email;
    @Column (nullable = false)
    protected String passw;


    public Person () {

    }

    public Person(int id, String fullname, String email, String passw) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.passw = passw;
    }

    public Person(String fullname, String email, String passw) {
        this.fullname = fullname;
        this.email = email;
        this.passw = passw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return new EqualsBuilder().append(id, person.id).append(fullname, person.fullname).append(email, person.email).append(passw, person.passw).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(fullname).append(email).append(passw).toHashCode();
    }
}
