package com.psp3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.ParameterizedTest;
import dziugas306.Exceptions.EmailException;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void UserFields_Test(){
        User user = new User( "Luka","Lukaite","866123456","luka@email.com","Vilniaus g. 7","Manopass@");
        assertAll(
                () -> assertEquals("Luka", user.getName()),
                () -> assertEquals("Lukaite", user.getSurname()),
                () -> assertEquals("866123456", user.getPhoneNumber()),
                () -> assertEquals("luka@email.com", user.getEmail()),
                () -> assertEquals("Vilniaus g. 7", user.getAddress()),
                () -> assertEquals("Mano@", user.getPassword())
        );
    }

    @Test
    void compateTo_Test(){
        User user1 = new User( "Luka","Lukaite","866123456","luka@email.com","Vilniaus g. 7","Manopass@");
        User user2 = new User( "Vardenis","Pavardenis","866666666","vardenis@email.com","Kauno g. 7","Manopass#");
        assertEquals(0, user1.compareTo(user2));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Pasword@12", "$QwertyuioP#"})
    void isPasswordValid_Test(String string){
        User user = new User();
        user.isPasswordValid(string);
    }
    @ParameterizedTest
    @ValueSource(strings = {"mail@email.com", "l@mail.com"})
    void isEmailValid_Test(String string) throws EmailException {
        User user = new User();
        user.isEmailValid(string);
    }
}
