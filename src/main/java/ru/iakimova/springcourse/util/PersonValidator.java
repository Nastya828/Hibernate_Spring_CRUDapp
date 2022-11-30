package ru.iakimova.springcourse.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.iakimova.springcourse.dao.PersonDAO;
import ru.iakimova.springcourse.models.Person;


@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if (!Character.isUpperCase(person.getName().codePointAt(0))) {
            errors.rejectValue("name", "", "Name should start" +
                    "with a capital letter");
        }

    }
}
