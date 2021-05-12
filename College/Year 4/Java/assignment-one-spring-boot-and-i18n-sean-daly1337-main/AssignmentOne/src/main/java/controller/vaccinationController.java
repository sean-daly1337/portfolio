/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import model.Vaccinations;
import service.vaccinationService;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("/index")
        public ModelAndView IndexPage(ModelAndView modelAndView) 
        {

        return new ModelAndView("/index","listVaccines", vaccinationService.findAll());
        }
        
        
        
    @GetMapping("search")
    public ModelAndView DisplaySearch() {
        return new ModelAndView("/search", "searchVac", new Vaccinations());

    }
    

    // Search button functionality for from-to date range.
    @PostMapping("/SearchFunctionality")
    public ModelAndView searchVaccination(@RequestParam String search, String searchDateFrom, String searchDateTo, @ModelAttribute Vaccinations v, Model model, BindingResult result) throws ParseException {
        
        if (result.hasErrors()) {
            return new ModelAndView("/errorPage");
        }
        
        Date dateFrom=new SimpleDateFormat("yyyy-MM-dd").parse(searchDateFrom); 
        Date dateTo=new SimpleDateFormat("yyyy-MM-dd").parse(searchDateTo); 
        
            return new ModelAndView("/SearchPage","VacList", vaccinationService.searchVaccine(search, dateFrom, dateTo));

        }
    
    // Drill down functionality for when you click "View Record" button.
    @RequestMapping("/DrillDown/{id}")
    public ModelAndView drillDown(@PathVariable (name = "id") String id) {
      
        Long vid = Long.parseLong(id);

        Vaccinations v = vaccinationService.findOne(vid);

        String s = v.getVaccines();

        Scanner scanner = new Scanner(s).useDelimiter(", "); 
        long n1 = scanner.nextLong(); 
        long n2 = scanner.hasNextLong() ? scanner.nextLong() : n1;
        long n3 = scanner.hasNextLong() ? scanner.nextLong() : n1;
              
        Map<String, Object> model = new HashMap<String, Object>();
        
        model.put("sVaccine", vaccinationService.VacById(n1, n2, n3));
        model.put("sVaccination", vaccinationService.findOne(vid));
        
        
        return new ModelAndView("/DrilldownPage", "model", model);
        }
    
    }
