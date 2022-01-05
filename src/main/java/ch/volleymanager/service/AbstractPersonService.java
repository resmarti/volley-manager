package ch.volleymanager.service;

import ch.volleymanager.exception.ParentNotDeletable;
import ch.volleymanager.exception.UserNotFoundException;
import ch.volleymanager.repo.AbstractPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AbstractPersonService {
    private final AbstractPersonRepo abstractPersonRepo;

    @Autowired
    public AbstractPersonService(AbstractPersonRepo abstractPersonRepo) {
        this.abstractPersonRepo = abstractPersonRepo;
    }
/*
    public AbstractPerson addPerson(AbstractPerson person) {
        return abstractPersonRepo.save(person);
    }

    public List<Person> findAllPersons() {
        return abstractPersonRepo.findAll();
    }

    public Person updatePerson(Person person) {
        return abstractPersonRepo.save(person);
    }

    public Person findById(Long id) {
        return abstractPersonRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Die Person mit der ID " + id + " wurde nicht gefunden."));
    }

   public void deletePerson(Long id) throws ParentNotDeletable {
        Optional<Person> oPerson = abstractPersonRepo.findById(id);
        if (oPerson.isPresent()) {
            //Todo: check if can be deleted
            Person person = oPerson.get();
            if (person.getCh)
            abstractPersonRepo.delete(person.get());
        }

        // if id == parent && parent.hasPlaer
        // ndo not delete
        //else
        // delete
          Parent parent = parentRepo.findParent(id)
          abstractPersonRepo.deletePersonById(id)
                .orElseThrow(() -> new ParentNotDeletable("Die Person mit der ID " + id + "kann nicht gelöscht werden."));
    }
    */
}
