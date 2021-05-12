/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sean
 */

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Vaccinations implements Serializable {

  @Id
  @GeneratedValue(strategy =GenerationType.AUTO)  
  Long id;
 
  String country;
  @NotNull
  String iso_code;
  
  @Temporal(javax.persistence.TemporalType.DATE)
  @NotNull
  Date v_date; 
 
  int total_vaccinations;
  int people_vaccinated;
  int people_fully_vaccinated; 
  int daily_vaccinations;
  double total_vaccinations_per_hundred;
  double people_vaccinated_per_hundred;
  double people_fully_vaccinated_per_hundred;
  double daily_vaccinations_per_million;
  String vaccines;
  String source_name;
  String source_website;
}