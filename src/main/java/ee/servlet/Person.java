package ee.servlet;

import ee.beanValidation.ChronDates;

import java.time.LocalDate;

@ChronDates
public class Person {
   LocalDate bithDate;
    LocalDate deathDate;

    public LocalDate getBithDate() {
        return bithDate;
    }

    public void setBithDate(LocalDate bithDate) {
        this.bithDate = bithDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
}
