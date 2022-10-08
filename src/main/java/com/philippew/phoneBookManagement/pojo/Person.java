package com.philippew.phoneBookManagement.pojo;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {
    @NotBlank(message = "Lastname cannot be blank")
    private String lastName;
    @NotBlank(message = "Firstname cannot be blank")
    private String firstName;
    private String phoneNumber;
    private String id;

    public Person() {
        this.id = UUID.randomUUID().toString();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
