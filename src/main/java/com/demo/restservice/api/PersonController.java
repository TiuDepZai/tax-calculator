package com.demo.restservice.api;

import com.demo.restservice.model.Payslip;
import com.demo.restservice.model.Person;
import com.demo.restservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")

@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){

          this.personService = personService;
    }


    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping("payslip/{id}")
    public Optional<Payslip> getPaySlipById(@PathVariable("id") UUID id){
        return personService.getPaySlipById(id);
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }
    @DeleteMapping(path="{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path="{id}")
    public void updatePerson(@PathVariable("id") UUID id,@RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }


}
