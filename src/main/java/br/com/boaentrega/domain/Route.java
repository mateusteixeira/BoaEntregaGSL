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
@Table(name = "ROUTE")
@RequiredArgsConstructor
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

    @Column(name = "CODE")
    private Long code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CITY_FROM")
    private String cityFrom;

    @Column(name = "CITY_TO")
    private String cityTo;

    @Column(name = "DURATION_IN_DAYS")
    private Long durationInDays;

}
