package com.philippew.phoneBookManagement.service;

import com.philippew.phoneBookManagement.Constants;
import com.philippew.phoneBookManagement.pojo.Person;
import com.philippew.phoneBookManagement.repository.PhoneBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneBookService {

    @Autowired
    PhoneBookRepository phoneBookRepository;

    public List<Person> getWholePhoneBook() {
        return phoneBookRepository.getWholePhoneBook();
    }

    public Person getOnePerson(int index) {
        return phoneBookRepository.getOnePerson(index);
    }

    public void updatePerson(Person person, int index) {
        phoneBookRepository.updatePerson(person, index);
    }

    public void addPerson(Person person) {
        phoneBookRepository.addPerson(person);
    }

    public int getPersonIndex(String id) {
        for (int index = 0; index < getWholePhoneBook().size(); index++) {
            if (getWholePhoneBook().get(index).getId().equals(id)) {
                return index;
            }
        }
        return Constants.NOT_FOUND;
    }

    public Person getPersonById(String id) {
        int index = getPersonIndex(id);
        return index == Constants.NOT_FOUND ? new Person() : getOnePerson(index);
    }

    public void submitPerson(Person person) {
        int index = getPersonIndex(person.getId());
        if (index == Constants.NOT_FOUND) {
            addPerson(person);
        } else {
            updatePerson(person, index);
        }
    }

}
