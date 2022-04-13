package br.com.boaentregasupport.domain;

import br.com.boaentregasupport.domain.enumeration.OccurrenceStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOMER_OCCURRENCE")
public class CustomerOccurrence implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "CUSTOMER_OCCURRENCE_SEQ_GEN", sequenceName = "CUSTOMER_OCCURRENCE_SEQ", initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_OCCURRENCE_SEQ_GEN")
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE")
    private Long code;

    @Column(name = "USER_COMMENT")
    private String userComment;

    @Column(name = "SUPPORT_COMMENT")
    private String supportComment;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private OccurrenceStatus occurrenceStatus;

}



