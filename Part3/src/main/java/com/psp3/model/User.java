package com.psp3.model;

import dziugas306.Exceptions.EmailException;
import dziugas306.Validators.EmailValidator;
import dziugas306.Validators.PhoneValidator;
import dziugas306.Validators.PasswordChecker;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User implements Comparable<User>{

    @Id
    private Long userId;

    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String address;
    private String password;

    public User(){}

    public User(String name, String surname, String phoneNumber, String email, String address, String password){
        super();
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public User(Long userId, String name, String surname, String phoneNumber, String email, String address, String password){
        super();
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User: " + "User ID= " + userId + "; Name= " + name + '\'' + "; Surname= " + surname + '\'' + "; Phone number = " + phoneNumber + '\'' + "; Email= " + email + '\'' + "; Address= " + address + '\'' + "; Password= " + password + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(email, user.email) && Objects.equals(address, user.address) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, password);
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }

    public boolean isPhoneNumberValid(String phoneNumber){
        PhoneValidator phoneValidator = new PhoneValidator();
        boolean success = true;
        try{
            phoneValidator.validate(phoneNumber);
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    public boolean isEmailValid(String email) {
        EmailValidator emailValidator = new EmailValidator();
        boolean success = true;
        try{
            emailValidator.validate(email);
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    public boolean isPasswordValid(String password){
        PasswordChecker passwordChecker = new PasswordChecker();
        boolean success = true;
        try{
            passwordChecker.validate(password);
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isPhoneNumberValid(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailException {
        if (isEmailValid(email)) this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (isPasswordValid(password)) this.password = password;
    }
}