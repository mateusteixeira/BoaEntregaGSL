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
@Table(name = "ROUTE")
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

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
