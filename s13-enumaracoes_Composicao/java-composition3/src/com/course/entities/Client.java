package com.course.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

    private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

    private String name;
    private String email;
    private Date birthDate;

    public Client(String name, String email, Date birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name + " (" + sdf1.format(birthDate) + ") - " + email;
    }
}
