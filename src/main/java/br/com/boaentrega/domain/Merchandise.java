package br.com.boaentrega.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "MERCHANDISE")
public class Merchandise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "CODE")
    private Long code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EAN")
    private String ean;

}
