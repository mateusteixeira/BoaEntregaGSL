package br.com.boaentrega.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ROUTE")
@SequenceGenerator(name = AbstractEntity.SEQ_NAME, sequenceName = "ROUTE_SEQ", initialValue = 0, allocationSize = 1)
public class Route extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

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
        return cityFrom;
    }

    @Override
    public String getSecondaryIdentifier() {
        return cityTo;
    }
}
