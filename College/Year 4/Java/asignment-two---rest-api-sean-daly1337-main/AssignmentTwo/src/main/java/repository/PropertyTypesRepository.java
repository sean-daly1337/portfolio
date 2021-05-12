package repository;

import entities.Propertytypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyTypesRepository extends JpaRepository<Propertytypes, Long> {


    @Query("SELECT a FROM Propertytypes a WHERE a.type_Id = :type_Id")
    Propertytypes getPropertyType(Long type_Id);
}
