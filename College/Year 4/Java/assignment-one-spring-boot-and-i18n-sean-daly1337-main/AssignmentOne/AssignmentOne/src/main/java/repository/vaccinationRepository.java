/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import model.Vaccinations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Sean
 */

@Repository
public interface vaccinationRepository extends CrudRepository<Vaccinations, Long> {
    
}

