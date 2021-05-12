package entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Image {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imageId;
    private Integer width;
    private Integer height;
    private Long size;
    private String fileLink;
}
