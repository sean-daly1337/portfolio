
package entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class Properties implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private String city;
    private Integer listing_Num;
    private Integer style_Id;
    private Integer type_Id;
    private Integer bedrooms;
    private Float bathrooms;
    private Integer squarefeet;
    private String ber_Rating;
    @Lob
    private String description;
    private String lotsize;
    private Short garagesize;
    private Integer garage_Id;
    private Integer agent_Id;
    private String photo;
    private Double price;
    @Temporal(TemporalType.DATE)
    private Date date_Added;
}
