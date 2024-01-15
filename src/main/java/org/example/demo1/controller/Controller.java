package org.example.demo1.controller;



import org.example.demo1.model.City;
import org.example.demo1.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@org.springframework.stereotype.Controller
@RequestMapping("/city")
public class Controller {

    @Autowired
    ICityService iCityService;

    @GetMapping
    public ModelAndView listCity(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("listCity",iCityService.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/info")
    public ModelAndView info(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/info");
        modelAndView.addObject("info",iCityService.findById(id));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("cityNew", new City());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView create(@Valid City city, BindingResult bindingResult){
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()){
            modelAndView = new ModelAndView("/create");
            modelAndView.addObject("cityNew", new City());
            modelAndView.addObject("listERR", bindingResult.getAllErrors());
            return modelAndView;
        }
       modelAndView = new ModelAndView("redirect:/city");
        iCityService.save(city);
        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        City city = iCityService.findById(id).get();
        modelAndView.addObject("city",city);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView update( City city) {
        ModelAndView modelAndView = new ModelAndView("redirect:/city");
        iCityService.save(city);
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView deleteForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/city");
        City city = iCityService.findById(id).get();
        iCityService.remove(city.getId());
        return modelAndView;
    }


}

