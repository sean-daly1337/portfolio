package repository;

import entities.Styles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StylesRepository extends JpaRepository<Styles, Long> {


    @Query("SELECT a FROM Styles a WHERE a.style_Id = :style_Id")
    Styles getStylesById(Long style_Id);
}
