/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import java.util.Date;
import model.Vaccinations;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sean
 */

@Repository
public interface vaccinationRepository extends CrudRepository<Vaccinations, Long> {
    
    @Query("SELECT b FROM Vaccinations b WHERE b.iso_code LIKE ?1 AND b.v_date BETWEEN ?2 AND ?3")
    
    public List<Vaccinations> getVacThatContainTerm(String term,Date dateFrom, Date dateTo);
    
}

