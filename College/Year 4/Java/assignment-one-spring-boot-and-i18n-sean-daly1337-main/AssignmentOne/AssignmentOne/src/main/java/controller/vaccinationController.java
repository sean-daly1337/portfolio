/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Vaccinations;
import service.vaccinationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class vaccinationController {
    
   @Autowired
    private vaccinationService vaccinationService;

    @GetMapping("/vaccinations")
    public List<Vaccinations> getAll() {
        return vaccinationService.findAll();
    }
    
    @GetMapping("/home")
        public ModelAndView getArticle(ModelAndView modelAndView) 
        {

        return new ModelAndView("/home","listVaccines", vaccinationService.findAll());
        }

    }
