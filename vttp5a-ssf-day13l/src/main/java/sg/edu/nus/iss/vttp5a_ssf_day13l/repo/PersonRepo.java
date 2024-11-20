package sg.edu.nus.iss.vttp5a_ssf_day13l.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day13l.model.Person;

@Repository
public class PersonRepo {

    private List<Person> persons = new ArrayList<>();

    public List<Person> findAll() {
        return persons;
    }

    public Boolean create(Person person) {
        return persons.add(person);
    }

    public Boolean delete(Person person) {
        return persons.remove(person);
    }

    public Boolean update(Person person) {
        List<Person> filteredPerson = persons.stream().filter(p -> p.getId().equals(person.getId())).collect(Collectors.toList());

        if (filteredPerson.size() > 0) {
            persons.remove(filteredPerson.getFirst());
            persons.add(person);
            return true;
        }
        return false;
    }

    public Person findById(String id) {
        List<Person> personList = this.persons.stream().filter(p -> p.getId().equals(id)).collect(Collectors.toList());
        return personList.getFirst();
    }


}
