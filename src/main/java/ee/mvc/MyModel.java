package ee.mvc;

import ee.bean.Person;

public class MyModel {
    public Person getPerson() {
        Person person = new Person();
        person.setName("Max");
        person.setAge(18);
        return person;
    }
}
