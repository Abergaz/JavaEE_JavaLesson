package ee.beanValidation;

import ee.servlet.Person;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckChronologicalDates implements ConstraintValidator<ChronDates, Person> {
    @Override
    public void initialize(ChronDates constraintAnnotation) {
    }

    @Override
    public boolean isValid(Person person, ConstraintValidatorContext context) {
        /** проверяем что дата рождения раньше даты смерти*/
        return person.getBithDate().isBefore(person.getDeathDate());
    }
}
