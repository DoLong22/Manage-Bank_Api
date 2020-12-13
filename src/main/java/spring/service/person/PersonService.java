package spring.service.person;

import org.springframework.data.domain.Pageable;
import spring.model.Person;

import java.util.List;

public interface PersonService {

    public Person addPerson(Person person);

    public Person updatePerson(Person person);

    public boolean deletePerson(int id);

    public List<Person> getAllPerson(int page);

    public Person getPersonById(int id);

    public Person findByCardNumber(String cardNumer);

    public Person findByPhoneNumber(String phoneNumber);

    public List<Person> getListPersonByName(String name);
}
