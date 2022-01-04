package ch.volleymanager.service;

import ch.volleymanager.domain.Person;
import ch.volleymanager.exception.ParentNotDeletable;
import ch.volleymanager.exception.UserNotFoundException;
import ch.volleymanager.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonService {
    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person addPerson(Person person) {
        return personRepo.save(person);
    }

    public List<Person> findAllPersons() {
        return personRepo.findAll();
    }

    public Person updatePerson(Person person) {
        return personRepo.save(person);
    }

    public Person findPersonById(Long id) {
        return personRepo.findPersonById(id)
                .orElseThrow(() -> new UserNotFoundException("Die Person mit der ID " + id + " wurde nicht gefunden."));
    }

    public void deletePerson(Long id) throws ParentNotDeletable {

        // if id == parent && parent.hasPlaer
        // ndo not delete
        //else
        // delete
        /*
        Parent parent = parentRepo.findParent(id)
         */
        personRepo.deletePersonById(id)
                .orElseThrow(() -> new ParentNotDeletable("Die Person mit der ID " + id + "kann nicht gelöscht werden."));
    }
}
