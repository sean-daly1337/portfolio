package repository;

import entities.Garagetypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageTypesRepository extends JpaRepository<Garagetypes, Long> {


    @Query("SELECT a FROM Garagetypes a WHERE a.garage_Id = :garageId")
    Garagetypes getGarageType(Long garageId);
}
