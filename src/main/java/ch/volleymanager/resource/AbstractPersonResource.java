package ch.volleymanager.resource;

import ch.volleymanager.service.AbstractPersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class AbstractPersonResource {
    private final AbstractPersonService personService;

    public AbstractPersonResource(AbstractPersonService personService) {
        this.personService = personService;
    }

    /*
    @GetMapping("/all")
    public ResponseEntity<List<AbstractPerson>> getAllPerson () {
        List<AbstractPerson> personen = personService.findAllPersons();
        return new ResponseEntity<>(personen, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Person> getById (@PathVariable("id") Long id) {
        Person person = personService.findById(id);
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
    */

}
