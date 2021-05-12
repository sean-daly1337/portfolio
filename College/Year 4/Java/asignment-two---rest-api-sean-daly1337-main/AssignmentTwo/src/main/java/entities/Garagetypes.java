package entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Garagetypes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long garage_Id;
    private String g_Type;

}
