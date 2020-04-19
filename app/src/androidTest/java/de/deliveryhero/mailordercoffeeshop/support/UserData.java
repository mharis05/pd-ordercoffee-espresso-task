package de.deliveryhero.mailordercoffeeshop.support;

import com.github.javafaker.Faker;

public class UserData {

    private Faker faker = new Faker();

    public UserData() {
        this.userName = faker.name().fullName();
        this.userEmail = faker.name().firstName() + "@gmail.com";
        this.userAlias = faker.funnyName().name();
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserAlias() {
        return userAlias;
    }

    private String userName;
    private String userEmail;
    private String userAlias;


}
