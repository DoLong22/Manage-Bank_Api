package spring.validate;

import org.springframework.stereotype.Component;
import spring.model.Employee;
import spring.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidationObject {
    private static final String validStringPhoneNumber = "^(\\d{3}[- .]?){2}\\d{4}$";

    public List<String> getAllErrors(Person person){
        List<String> errors = new ArrayList<>();

        if(person.getCardNumber() == null){
            errors.add("Card number is require");
        }
//        if (person.getPhoneNumber() == null){
//            errors.add("Phone number is require");
//        }
//        else if (!person.getPhoneNumber().matches(validStringPhoneNumber)){
//            errors.add(
//                    "Phone number: " + person.getPhoneNumber() + " is wrong. Phone number consists of 10 characters as a number"
//            );
//        }
        if(person.getAddress() == null){
            errors.add("Address is require");
        }
        if(person.getEmail() == null){
            errors.add("Email is require");
        }
        if(person.getFullName() == null){
            errors.add("Full name is require");
        }
        if(person.getNgaySinh() == null){
            errors.add("Date of birth is require");
        }
        return errors;
    }

    public List<String> getAllErrors(Employee employee) {
        List<String> errors = new ArrayList<>();

        if (employee.getIdEmployee() == null) {
            errors.add("Id employee is require");
        }
        if (employee.getLevel() == null) {
            errors.add("Card number is require");
        }
        if (employee.getPosition() == null) {
            errors.add("Position is require");
        }
        if (employee.getThamNien() < 0) {
            errors.add("Seniority have to greater 0");
        }
        errors.addAll(getAllErrors(employee.getPerson()));
        return errors;
    }
}
