package edu.infsci2560.controllers;

import edu.infsci2560.models.University;
import edu.infsci2560.repositories.UniversityRepository;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UniversityController {
    @Autowired
    private UniversityRepository repository;    
    
    @RequestMapping(value = "universities", method = RequestMethod.GET)
    public ModelAndView index() {        
        return new ModelAndView("universities", "universities", repository.findAll());
    }
    
    @RequestMapping(value = "universities/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long id) {        
        return new ModelAndView("universities", "universities", repository.findOne(id));
    }
    
    @RequestMapping(value = "universities/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid University university, BindingResult result) {
        repository.save(university);
        return new ModelAndView("universities", "universities", repository.findAll());
    }
    
    @RequestMapping(value = "universities/{id}", method = RequestMethod.DELETE, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView delete( @Valid University university, BindingResult result) {
        repository.delete(university);
        return new ModelAndView("universities", "universities", repository.findAll());
    }  
}
