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

}
