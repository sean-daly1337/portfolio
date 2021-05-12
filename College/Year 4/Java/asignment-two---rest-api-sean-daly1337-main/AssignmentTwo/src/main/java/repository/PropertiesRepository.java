package repository;

import entities.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties, Long> {

    @Query("SELECT a FROM Properties a WHERE a.id = :pId")
    Properties getPropertiesById(Long pId);
}
