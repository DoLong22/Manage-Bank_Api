package spring.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.model.FullName;
import spring.model.Person;
import spring.repository.FullNameRepository;
import spring.repository.PersonRepository;
import spring.service.person.PersonService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceIml implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private FullNameRepository fullNameRepository;

    @Override
    public Person addPerson(Person person) {
        return this.personRepository.save((person));
    }

    @Override
    public Person updatePerson(Person person) {
        Person exitsPerson = this.personRepository.findById(person.getId()).orElse(null);
        if(exitsPerson != null){
            exitsPerson = personRepository.saveAndFlush(person);
        }
        System.out.println(exitsPerson);
        return  exitsPerson;
    }

    @Override
    public boolean deletePerson(int id) {
        boolean isDeleted = false;
        Person person = this.personRepository.findById(id).orElse(null);
        if(person != null ){
            this.personRepository.deleteById(id);
            isDeleted = true;
        }
        return isDeleted;
    }

    @Override
    public List<Person> getAllPerson(int page) {
        List<Person> listPerson = this.personRepository.findAll(PageRequest.of(page, 20)).getContent();
        return listPerson;
    }

    @Override
    public Person getPersonById(int id) {
        Person person = this.personRepository.findById(id).orElse(null);
        return person;
    }

    @Override
    public Person findByCardNumber(String cardNumer) {
        Person person = this.personRepository.findByCardNumber(cardNumer);
        return person;
    }

    @Override
    public Person findByPhoneNumber(String phoneNumber) {
        Person person = this.personRepository.findByPhoneNumber(phoneNumber);
        return person;
    }

    @Override
    public List<Person> getListPersonByName(String name) {
        List<Person> personList = new ArrayList<>();
        List<FullName> fullNames = fullNameRepository.findByTen(name);
        if (!fullNames.isEmpty()){
            for (FullName fullName : fullNames){
                Person person = personRepository.findByFullName(fullName);
                if (person != null){
                    personList.add(person);
                }
            }
            return personList;
        }
        else {
            return null;
        }
    }

}
