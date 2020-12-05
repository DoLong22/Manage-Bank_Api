package spring.service.person;

import org.springframework.data.domain.Pageable;
import spring.model.Person;

import java.util.List;

public interface PersonService {

    public Person addPerson(Person person);

    public Person updatePerson(Person person);

    public boolean deletePerson(int id);

    public List<Person> getAllPerson(Pageable pageable);

    public Person getPersonById(int id);

}
