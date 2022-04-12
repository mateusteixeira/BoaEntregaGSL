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
@Table(name = "MERCHANDISE")
public class Merchandise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="MERCHANDISE_SEQ_GEN",sequenceName="MERCHANDISE_SEQ", initialValue=0, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="MERCHANDISE_SEQ_GEN")
    private Long id;

    @Column(name = "CODE")
    private Long code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EAN")
    private String ean;

}
