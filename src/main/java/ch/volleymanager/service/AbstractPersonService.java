package ch.volleymanager.service;

import ch.volleymanager.repo.AbstractPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AbstractPersonService {
    private final AbstractPersonRepo abstractPersonRepo;

    @Autowired
    public AbstractPersonService(AbstractPersonRepo abstractPersonRepo) {
        this.abstractPersonRepo = abstractPersonRepo;
    }

}
