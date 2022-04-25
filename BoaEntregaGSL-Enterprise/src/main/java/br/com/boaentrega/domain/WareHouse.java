package br.com.boaentrega.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WARE_HOUSE")
@SequenceGenerator(name = AbstractEntity.SEQ_NAME, sequenceName = "WARE_HOUSE_SEQ", initialValue = 0, allocationSize = 1)
public class WareHouse extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Column(name = "CODE")
    private Long code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CAPACITY")
    private Long capacity;

    @Column(name = "LOCATION")
    private String location;

    @Override
    public String getMainIdentifier() {
        return String.valueOf(code);
    }

    @Override
    public String getSecondaryIdentifier() {
        return name;
    }
}
