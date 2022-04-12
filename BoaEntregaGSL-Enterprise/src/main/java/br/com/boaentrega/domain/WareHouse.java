package br.com.boaentrega.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WARE_HOUSE")
public class WareHouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="WARE_HOUSE_SEQ_GEN",sequenceName="WARE_HOUSE_SEQ", initialValue=0, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="WARE_HOUSE_SEQ_GEN")
    private Long id;

    @Column(name = "CODE")
    private Long code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CAPACITY")
    private Long capacity;

    @Column(name = "LOCATION")
    private String location;
}
