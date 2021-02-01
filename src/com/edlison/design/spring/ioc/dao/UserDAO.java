package com.edlison.design.spring.ioc.dao;

import com.edlison.design.spring.ioc.pojo.Address;

import java.util.*;

/**
 * UserDAO
 *
 * @Author Edlison
 * @Date 2/1/21 09:20
 */
public class UserDAO {
    private String username;
    private Address address;
    private String[] books;
    private Set<String> games;
    private List<String> hobbies;
    private Map<String, String> cards;
    private Properties info;
    private String wife;

    public UserDAO(String username) {
        this.username = username;
        System.out.println("This is UserDAO Constructor");
    }

    @Override
    public String toString() {
        return "UserDAO{" +
                "username='" + username + '\'' +
                ", address=" + address +
                ", books=" + Arrays.toString(books) +
                ", games=" + games +
                ", hobbies=" + hobbies +
                ", cards=" + cards +
                ", info=" + info +
                ", wife='" + wife + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String[] getBooks() {
        return books;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public Set<String> getGames() {
        return games;
    }

    public void setGames(Set<String> games) {
        this.games = games;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, String> getCards() {
        return cards;
    }

    public void setCards(Map<String, String> cards) {
        this.cards = cards;
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }
}
