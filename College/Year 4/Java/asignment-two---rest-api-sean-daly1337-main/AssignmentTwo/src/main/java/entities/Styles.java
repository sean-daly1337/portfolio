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
public class Styles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long style_Id;
    private String p_Style;
}
