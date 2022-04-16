package br.com.boaentregasupport.domain;

import br.com.boaentrega.domain.AbstractEntity;
import br.com.boaentregasupport.domain.enumeration.OccurrenceStatus;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOMER_OCCURRENCE")
@SequenceGenerator(name = AbstractEntity.SEQ_NAME, sequenceName = "CUSTOMER_OCCURRENCE_SEQ", initialValue = 0, allocationSize = 1)
public class CustomerOccurrence extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Column(name = "CODE")
    private Long code;

    @Column(name = "USER_COMMENT")
    private String userComment;

    @Column(name = "SUPPORT_COMMENT")
    private String supportComment;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private OccurrenceStatus occurrenceStatus;

    @Override
    public String getMainIdentifier() {
        return String.valueOf(super.getId());
    }

    @Override
    public String getSecondaryIdentifier() {
        return String.valueOf(this.code);
    }
}



