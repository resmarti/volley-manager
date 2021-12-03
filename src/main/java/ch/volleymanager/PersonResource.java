package ch.volleymanager;

import ch.volleymanager.domain.Person;
import ch.volleymanager.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonResource {
    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPerson () {
        List<Person> personen = personService.findAllPersons();
        return new ResponseEntity<>(personen, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Person> getPersonById (@PathVariable("id") Long id) {
        Person person = personService.findPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person newPerson = personService.addPerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        Person newPerson = personService.updatePerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
