package ch.volleymanager.config;

        import ch.volleymanager.domain.*;
        import ch.volleymanager.repo.*;
        import ch.volleymanager.utils.HasLogger;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.Profile;
        import org.springframework.data.domain.Sort;
        import org.springframework.transaction.annotation.Transactional;

        import javax.annotation.PostConstruct;
        import java.time.LocalDate;
        import java.util.List;

/**
 * Defines a Bean for the dev-Profile
 * Last push: 21.01.22
 */
@Configuration
@Profile("dev")
@Transactional
public class DevConfiguration implements HasLogger {

    //Variables class AbstractPerson
    private Long MaleOneId;
    private Long MaleTwoId;
    private Long MaleThreeId;
    private Long MaleFourId;
    private Long MaleFiveId;

    private Long FemaleOneId;
    private Long FemaleTwoId;
    private Long FemaleThreeId;
    private Long FemaleFourId;
    private Long FemaleFiveId;

    private Long DiverseOneId;
    private Long DiverseTwoId;
    private Long DiverseThreeId;

    //Variables class Team; single limitation by maximum age
    private Long teamMax14AgedId;
    private Long teamMax18AgedId;
    private Long teamMax35AgedId;
    private Long teamMax50AgedId;
    private Long teamMax80AgedId;

    //Variables class TeamMember --> 14YearsId
    private Long teamMemberMaleOne14YearsId;
    private Long teamMemberMaleTwo14YearsId;
    private Long teamMemberMaleThree14YearsId;
    private Long teamMemberMaleFour14YearsId;
    private Long teamMemberMaleFive14YearsId;
    private Long teamMemberFemaleOne14YearsId;
    private Long teamMemberFemaleTwo14YearsId;
    private Long teamMemberFemaleThree14YearsId;
    private Long teamMemberFemaleFour14YearsId;
    private Long teamMemberFemaleFive14YearsId;
    private Long teamMemberDiverseOne14yearsId;
    private Long teamMemberDiverseTwo14yearsId;
    private Long teamMemberDiverseThree14yearsId;

    //Variables class TeamMember --> 18YearsId
    private Long teamMemberMaleOne18YearsId;
    private Long teamMemberMaleTwo18YearsId;
    private Long teamMemberMaleThree18YearsId;
    private Long teamMemberMaleFour18YearsId;
    private Long teamMemberMaleFive18YearsId;
    private Long teamMemberFemaleOne18YearsId;
    private Long teamMemberFemaleTwo18YearsId;
    private Long teamMemberFemaleThree18YearsId;
    private Long teamMemberFemaleFour18YearsId;
    private Long teamMemberFemaleFive18YearsId;
    private Long teamMemberDiverseOne18yearsId;
    private Long teamMemberDiverseTwo18yearsId;
    private Long teamMemberDiverseThree18yearsId;

    //Variables class TeamMember --> 35YearsId
    private Long teamMemberMaleOne35YearsId;
    private Long teamMemberMaleTwo35YearsId;
    private Long teamMemberMaleThree35YearsId;
    private Long teamMemberMaleFour35YearsId;
    private Long teamMemberMaleFive35YearsId;
    private Long teamMemberFemaleOne35YearsId;
    private Long teamMemberFemaleTwo35YearsId;
    private Long teamMemberFemaleThree35YearsId;
    private Long teamMemberFemaleFour35YearsId;
    private Long teamMemberFemaleFive35YearsId;
    private Long teamMemberDiverseOne35yearsId;
    private Long teamMemberDiverseTwo35yearsId;
    private Long teamMemberDiverseThree35yearsId;

    //Variables class TeamMember --> 50YearsId
    private Long teamMemberMaleOne50YearsId;
    private Long teamMemberMaleTwo50YearsId;
    private Long teamMemberMaleThree50YearsId;
    private Long teamMemberMaleFour50YearsId;
    private Long teamMemberMaleFive50YearsId;
    private Long teamMemberFemaleOne50YearsId;
    private Long teamMemberFemaleTwo50YearsId;
    private Long teamMemberFemaleThree50YearsId;
    private Long teamMemberFemaleFour50YearsId;
    private Long teamMemberFemaleFive50YearsId;
    private Long teamMemberDiverseOne50yearsId;
    private Long teamMemberDiverseTwo50yearsId;
    private Long teamMemberDiverseThree50yearsId;

    //Variables TeamMember ---> 80YearsId
    private Long teamMemberMaleOne80YearsId;
    private Long teamMemberMaleTwo80YearsId;
    private Long teamMemberMaleThree80YearsId;
    private Long teamMemberMaleFour80YearsId;
    private Long teamMemberMaleFive80YearsId;
    private Long teamMemberFemaleOne80YearsId;
    private Long teamMemberFemaleTwo80YearsId;
    private Long teamMemberFemaleThree80YearsId;
    private Long teamMemberFemaleFour80YearsId;
    private Long teamMemberFemaleFive80YearsId;

    //Variables Event
    private Long eventTurnierFebruarId;
    private Long eventTurnierMarchId;

    @Autowired
    AbstractPersonRepo abstractPersonRepo;

    @Autowired
    ContactPersonRepo contactPersonRepo;

    @Autowired
    EventRepo eventRepo;

    @Autowired
    TeamMemberRepo teamMemberRepo;

    @Autowired
    TeamRepo teamRepo;

    public DevConfiguration() {
        getLogger().info("Dev Configuration Class");
    }

    @PostConstruct
    public void createData() {
        createPersonData();
        createTeamData();
        createTeamMemberData();
        createEventData();
        assignContactPersonToTeamMember();
        assignTeamMemberToTeam();
        assignTeamToEvent();
        assignTeamMemberToEvent();
    }

    private void createPersonData() {
        //Paremeters ContactPerson --> A true pleaseure for every woke person
        ContactPerson cpMaleOne = new ContactPerson(null, "Karim", "Berrada", "Chillerweg", "1", 8703, "Erlenbach", "mobile079", "email@test.ch");
        ContactPerson cpMaleTwo = new ContactPerson(null, "Chen Lu", "Wang", "Alpenblick", "2", 3000, "Bern", "mobile079", "email@test.ch");
        ContactPerson cpMaleThree = new ContactPerson(null, "Jari", "Mäkelä", "Gimmermehweg", "3", 5014, "Gretzenbach", "mobile079", "email@test.ch");
        ContactPerson cpMaleFour = new ContactPerson(null, "Sekou", "Kanumba", "Stasigässlein", "4", 4104, "Oberwil", "mobile079", "email@test.ch");
        ContactPerson cpMaleFive = new ContactPerson(null, "Hansruedi", "Hugetobler", "Selfiweg", "5", 7307, "Jenins", "mobile079", "email@test.ch");
        ContactPerson cpFemaleOne = new ContactPerson(null, "Maleika", "Kimathi", "Lagerstrasse", "6", 8004, "Zürich", "mobile079", "email@test.ch");
        ContactPerson cpFemaleTwo = new ContactPerson(null, "Lily Grace Victoria", "Moore", "Lagerstrasse", "7", 8004, "Zürich", "mobile079", "email@test.ch");
        ContactPerson cpFemaleThree = new ContactPerson(null, "Hildur", "Thorisdottir", "Inselweg", "8", 8630, "Rüti", "mobile079", "email@test.ch");
        ContactPerson cpFemaleFour = new ContactPerson(null, "Svenja", "Djokovic", "Melbourne Park", "9", 3001, "Melbourne", "mobile079", "email@test.ch");
        ContactPerson cpFemaleFive = new ContactPerson(null, "Annegret", "Schneider", "Lagerstrasse", "10", 8004, "Zürich", "mobile079", "email@test.ch");
        ContactPerson cpDiverseOne = new ContactPerson(null, "Elisa", "Barrymore", "Rue de Lausanne", "11", 1700, "Fribourg", "mobile079", "email@test.ch");
        ContactPerson cpDiverseTwo = new ContactPerson(null, "Carole", "Bernard", "Rue du Lac", "12", 1200, "Genf", "mobile079", "email@test.ch");
        ContactPerson cpDiverseThree = new ContactPerson(null, "Ye", "East", "Irringersteig", "13", 8004, "Zürich", "mobile079", "email@test.ch");

        cpMaleOne = contactPersonRepo.save(cpMaleOne);
        cpMaleTwo = contactPersonRepo.save(cpMaleTwo);
        cpMaleThree = contactPersonRepo.save(cpMaleThree);
        cpMaleFour = contactPersonRepo.save(cpMaleFour);
        cpMaleFive = contactPersonRepo.save(cpMaleFive);
        cpFemaleOne = contactPersonRepo.save(cpFemaleThree);
        cpFemaleTwo = contactPersonRepo.save(cpFemaleThree);
        cpFemaleFour = contactPersonRepo.save(cpFemaleFour);
        cpFemaleFive = contactPersonRepo.save(cpFemaleFive);
        cpDiverseOne = contactPersonRepo.save(cpDiverseOne);
        cpDiverseTwo = contactPersonRepo.save(cpDiverseTwo);
        cpDiverseThree = contactPersonRepo.save(cpDiverseThree);

        MaleOneId = cpMaleOne.getId();
        MaleTwoId = cpMaleTwo.getId();
        MaleThreeId = cpMaleThree.getId();
        MaleFourId = cpMaleFour.getId();
        MaleFiveId = cpMaleFive.getId();
        FemaleOneId = cpFemaleOne.getId();
        FemaleTwoId = cpFemaleTwo.getId();
        FemaleThreeId = cpFemaleThree.getId();
        FemaleFourId = cpFemaleFour.getId();
        FemaleFiveId = cpFemaleFive.getId();
        DiverseOneId = cpDiverseOne.getId();
        DiverseTwoId = cpDiverseTwo.getId();
        DiverseThreeId = cpDiverseThree.getId();

        getLogger().debug("Person MaleOne to MaleFive, FemaleOne to FemaleFive and DiverseOne to DiverseThree are saved to DB");

        //Bedeutung dieser Zeilen unklar
        List<ContactPerson> persons = contactPersonRepo.findQueryByLastName("Hugentobler");
        persons.forEach(person -> getLogger().debug("findQueryByLastName Hugentobler = " + person.toString()));

        abstractPersonRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName")).forEach(person -> {
            abstractPersonRepo.findById(person.getId())
                    .ifPresent(p -> getLogger().debug("findAll, Sort by lastName ASC = " + p.toString()));
        });
    }

    private void createTeamData() {

        Team teamMax14Aged = new Team (null, 14, "U14", null, null);
        teamRepo.save(teamMax14Aged);
        teamMax14AgedId = teamMax14Aged.getTeamId();

        Team teamMax18Aged = new Team (null, 18, "U18", null, null);
        teamRepo.save(teamMax18Aged);
        teamMax18AgedId = teamMax18Aged.getTeamId();

        Team teamMax35Aged = new Team (null, 35, "U35", null, null);
        teamRepo.save(teamMax35Aged);
        teamMax35AgedId = teamMax35Aged.getTeamId();

        Team teamMax50Aged = new Team (null, 50, "U50", null, null);
        teamRepo.save(teamMax50Aged);
        teamMax50AgedId = teamMax50Aged.getTeamId();

        Team teamMax80Aged = new Team (null, 80, "U80", null, null);
        teamRepo.save(teamMax80Aged);
        teamMax80AgedId = teamMax80Aged.getTeamId();
    }

    private void createTeamMemberData() {

        //Creates some TeamMembers currently not assigned to team, freely adaptable
        TeamMember teamMemberMaleOne14Years = new TeamMember(null, "Karim", "Berrada", "Chillerweg", "1", 8703, "Erlenbach", "mobile079", "email@test.ch",  LocalDate.of(2008, 3, 3), "m", null, null, false, true);
        teamMemberMaleOne14Years = teamMemberRepo.save(teamMemberMaleOne14Years);
        teamMemberMaleOne14YearsId = teamMemberMaleOne14Years.getId();

        TeamMember teamMemberFemaleThree18Years = new TeamMember(null, "Hildur", "Thorisdottir", "Inselweg", "8", 8630, "Rüti","mobile079", "email@test.ch",  LocalDate.of(2008, 4, 3), "f", null, null, false, true);
        teamMemberFemaleThree18Years = teamMemberRepo.save(teamMemberFemaleThree18Years);
        teamMemberFemaleThree18YearsId = teamMemberFemaleThree18Years.getId();

        TeamMember teamMemberMaleFive80Years = new TeamMember(null, "Hansruedi", "Hugetobler", "Selfiweg", "5", 7307, "Jenins", "mobile079", "email@test.ch", LocalDate.of(1945, 5, 3), "f", null, null, false, true);
        teamMemberMaleFive80Years = teamMemberRepo.save(teamMemberMaleFive80Years);
        teamMemberMaleFive80YearsId = teamMemberMaleFive80Years.getId();
    }

    ContactPerson cpMaleOne = new ContactPerson(null, "Karim", "Berrada", "Chillerweg", "1", 8703, "Erlenbach", "mobile079", "email@test.ch");
    ContactPerson cpMaleTwo = new ContactPerson(null, "Chen Lu", "Wang", "Alpenblick", "2", 3000, "Bern", "mobile079", "email@test.ch");
    ContactPerson cpMaleThree = new ContactPerson(null, "Jari", "Mäkelä", "Gimmermehweg", "3", 5014, "Gretzenbach", "mobile079", "email@test.ch");
    ContactPerson cpMaleFour = new ContactPerson(null, "Sekou", "Kanumba", "Stasigässlein", "4", 4104, "Oberwil", "mobile079", "email@test.ch");
    ContactPerson cpMaleFive = new ContactPerson(null, "Hansruedi", "Hugetobler", "Selfiweg", "5", 7307, "Jenins", "mobile079", "email@test.ch");
    ContactPerson cpFemaleOne = new ContactPerson(null, "¨Maleika", "Kimathi", "Lagerstrasse", "6", 8004, "Zürich", "mobile079", "email@test.ch");
    ContactPerson cpFemaleTwo = new ContactPerson(null, "¨Lily Grace Victoria", "Moore", "Lagerstrasse", "7", 8004, "Zürich", "mobile079", "email@test.ch");
    ContactPerson cpFemaleThree = new ContactPerson(null, "Hildur", "Thorisdottir", "Inselweg", "8", 8630, "Rüti", "mobile079", "email@test.ch");
    ContactPerson cpFemaleFour = new ContactPerson(null, "Svenja", "Djokovic", "Melbourne Park", "9", 3001, "Melbourne", "mobile079", "email@test.ch");
    ContactPerson cpFemaleFive = new ContactPerson(null, "Annegret", "Schneider", "Lagerstrasse", "10", 8004, "Zürich", "mobile079", "email@test.ch");
    ContactPerson cpDiverseOne = new ContactPerson(null, "Elisa", "Barrymore", "Rue de Lausanne", "11", 1700, "Fribourg", "mobile079", "email@test.ch");
    ContactPerson cpDiverseTwo = new ContactPerson(null, "Carole", "Bernard", "Rue du Lac", "12", 1200, "Genf", "mobile079", "email@test.ch");
    ContactPerson cpDiverseThree = new ContactPerson(null, "Ye", "East", "Irringersteig", "13", 8004, "Zürich", "mobile079", "email@test.ch");


    private void createEventData() {
        Event eventTournamentFebruary = new Event(null, "Februar Turnier", LocalDate.of(2022, 2, 12),"Volley Ball Halle", 5, false, null, null);
        eventTournamentFebruary = eventRepo.save(eventTournamentFebruary);
        eventTurnierFebruarId = eventTournamentFebruary.getEventId();

        Event eventTournamentMarch = new Event(null, "März Turnier", LocalDate.of(2022, 3, 15), "Volley Ball Halle", 5, false, null, null);
        eventTournamentMarch = eventRepo.save(eventTournamentMarch);
        eventTurnierMarchId = eventTournamentMarch.getEventId();
    }

    private void assignContactPersonToTeamMember() {

        assignContactPersonToTeamMember(MaleTwoId, teamMemberMaleOne14YearsId);
        assignContactPersonToTeamMember(FemaleFiveId, teamMemberFemaleThree18YearsId);
        assignContactPersonToTeamMember(FemaleFiveId, teamMemberMaleFive80YearsId);

    }

    private void assignContactPersonToTeamMember(Long contactId, Long teamMemberId) {

        contactPersonRepo.findByIdWithEagerRelationships(contactId).ifPresent(contactPerson -> {
            teamMemberRepo.findByIdWithEagerRelationships(teamMemberId).ifPresent(teamMember -> {
                teamMember.setContactPerson(contactPerson);
                contactPerson.addTeamMember(teamMember);
                teamMemberRepo.save(teamMember);
                contactPersonRepo.save(contactPerson);
            });
        });
    }

    private void assignTeamMemberToTeam() {
        assignTeamMemberToTeam(teamMemberMaleOne14YearsId, teamMax14AgedId);
        assignTeamMemberToTeam(teamMemberFemaleThree18YearsId, teamMax18AgedId);
        assignTeamMemberToTeam(teamMemberMaleFive80YearsId, teamMax80AgedId);
    }

    private void assignTeamMemberToTeam(Long teamMemberId, Long teamId) {
        teamRepo.findByIdWithEagerRelationships(teamId).ifPresent(team -> {
            teamMemberRepo.findByIdWithEagerRelationships(teamMemberId).ifPresent(teamMember -> {
                teamMember.addTeam(team);
                team.addTeamMember(teamMember);
                teamMemberRepo.save(teamMember);
                teamRepo.save(team);
            });
        });
    }

    private void assignTeamToEvent() {
        assignTeamToEvent(teamMax14AgedId, eventTurnierFebruarId);
    }

    private void assignTeamToEvent(Long teamId, Long eventId) {
        teamRepo.findByIdWithEagerRelationships(teamId).ifPresent(team -> {
            eventRepo.findByIdWithEagerRelationships(eventId).ifPresent(event -> {
                event.addTeam(team);
                team.addEvent(event);
                eventRepo.save(event);
                teamRepo.save(team);
            });
        });
    }

    private void assignTeamMemberToEvent() {
        //Assigns TeamMember to Event, freely adaptable
        assignTeamMemberToEvent(teamMemberMaleOne14YearsId, eventTurnierMarchId);
    }

    private void assignTeamMemberToEvent(Long teamMemberId, Long eventId) {
        teamMemberRepo.findByIdWithEagerRelationships(teamMemberId).ifPresent(teamMember -> {
            eventRepo.findByIdWithEagerRelationships(eventId).ifPresent(event -> {
                event.addTeamMember(teamMember);
                teamMember.addEvent(event);
                eventRepo.save(event);
                teamMemberRepo.save(teamMember);
            });
        });
    }

}