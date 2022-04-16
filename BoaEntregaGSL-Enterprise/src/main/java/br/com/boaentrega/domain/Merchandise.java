package br.com.boaentrega.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MERCHANDISE")
@SequenceGenerator(name = AbstractEntity.SEQ_NAME, sequenceName = "MERCHANDISE_SEQ", initialValue = 0, allocationSize = 1)
public class Merchandise extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Column(name = "CODE")
    private Long code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EAN")
    private String ean;

    @Override
    public String getMainIdentifier() {
        return String.valueOf(this.getCode());
    }

    @Override
    public String getSecondaryIdentifier() {
        return this.getName();
    }

}
