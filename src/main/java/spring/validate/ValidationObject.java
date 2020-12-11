package spring.validate;

import spring.model.Person;

import java.util.ArrayList;
import java.util.List;

public class ValidationObject {
    private static final String validStringPhoneNumber = "^(\\d{3}[- .]?){2}\\d{4}$";

    public List<String> getAllErrors(Person person){
        List<String> errors = new ArrayList<>();

        if(person.getCardNumber() == null){
            errors.add("Card number is require");
        }
        if(person.getCardNumber() == null){
            errors.add("Card number is require");
        }
        if(person.getCardNumber() == null){
            errors.add("Card number is require");
        }
        if(person.getCardNumber() == null){
            errors.add("Card number is require");
        }
        if(person.getCardNumber() == null){
            errors.add("Card number is require");
        }
        return errors;
    }
}
