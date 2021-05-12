package service;

import model.Vaccinations;
import repository.vaccinationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class vaccinationService {
    
    
    @Autowired
    private vaccinationRepository vaccineRepo;

    public Vaccinations findOne(Long id) {
        return vaccineRepo.findById(id).get();
    }

    public List<Vaccinations> findAll() {
        return (List<Vaccinations>) vaccineRepo.findAll();
    }

    public long count() {
        return vaccineRepo.count();
    }

    public void deleteByID(long vaccineID) {
        vaccineRepo.deleteById(vaccineID);
    }

    public void saveBook(Vaccinations v) {
        vaccineRepo.save(v);
    }  
    
}//end class

