package sg.edu.nus.iss.vttp5a_ssf_day13l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.vttp5a_ssf_day13l.model.Person;
import sg.edu.nus.iss.vttp5a_ssf_day13l.service.PersonService;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/personlist")
    public String personListing(Model model) {

        List<Person> persons = personService.findAll();
        model.addAttribute("persons", persons);
        return "personlist";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        Person p = new Person();
        model.addAttribute("person", p);
        return "personcreate";
    }

    @PostMapping("/create")
    public String submitForm(@Valid Person person, BindingResult binding, Model model) { // bindingresult has to be before model
        if (binding.hasErrors()) {
            System.out.println(binding.getAllErrors().toString());
            return "personcreate";
        }
        personService.create(person);

        // model.addAttribute("persons", personService.findAll());

        return "redirect:/personlist";
    }

    @GetMapping("/delete/{person-id}")
    public String deletePerson(@PathVariable("person-id") String personId) {
        Person p = personService.findById(personId);
        personService.delete(p);

        return "redirect:/personlist";
    }

    @GetMapping("/update/{person-id}")
    public String editPerson(@PathVariable("person-id") String personId, Model model) {
        Person p = personService.findById(personId);
        model.addAttribute("person", p);

        return "edit";
    }

    @PostMapping("/update")
    public String editPerson(@Valid Person person, BindingResult binding, Model model) {
        if (binding.hasErrors()) {
            return "edit";
        }
        personService.update(person);

        return "redirect:/personlist";
    }

}
