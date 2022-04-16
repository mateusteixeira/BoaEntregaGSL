package br.com.boaentrega.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ROUTE")
public class Route extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "ROUTE_SEQ_GEN", sequenceName = "ROUTE_SEQ", initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROUTE_SEQ_GEN")
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

    @Override
    public String getMainIdentifier() {
        return null;
    }

    @Override
    public String getSecondaryIdentifier() {
        return null;
    }
}
