package com.demo.restservice.dao;

import com.demo.restservice.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccess implements PersonDao {
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName(),person.getAnnualSalary(),person.getSuperRate(), String.valueOf(person.getPayPeriod())));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople(){
        return DB;
    }

    @Override
    public Optional<Person> selectedPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectedPersonById(id);
        if (personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectedPersonById(id)
                .map(person -> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if ( indexOfPersonToUpdate>= 0){
                        DB.set(indexOfPersonToUpdate, new Person(id,update.getName(),update.getAnnualSalary(),update.getSuperRate(), String.valueOf(update.getPayPeriod())));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
