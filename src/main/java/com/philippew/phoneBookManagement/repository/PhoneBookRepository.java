package com.philippew.phoneBookManagement.repository;

import com.philippew.phoneBookManagement.pojo.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PhoneBookRepository {

    private final List<Person> phoneBook = new ArrayList<>();

    public List<Person> getWholePhoneBook() {
        return phoneBook;
    }

    public Person getOnePerson(int index) {
        return phoneBook.get(index);
    }

    public void updatePerson(Person person, int index) {
        phoneBook.set(index, person);
    }

    public void addPerson(Person person) {
        phoneBook.add(person);
    }

}
