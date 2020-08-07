package com.example.HotelBookingSystem.View;

public class UserDetails {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String cardType;
    private String cardNumber;
    private String expiryDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getNumber()
    {
        return phone;
    }

    public void setNumber(String phone)
    {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress()
    {
        this.address = address;
    }

    public String getCardType()
    {
        return cardType;
    }
    public void setCardType(String cardType)
    {
        this.cardType = cardType;
    }
    public String getCardNumber()
    {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }
    public String getExpiryDate()
    {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate)
    {
        this.expiryDate = expiryDate;
    }

}