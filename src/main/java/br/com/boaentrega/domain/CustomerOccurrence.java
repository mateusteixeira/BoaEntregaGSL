package br.com.boaentrega.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "CUSTOMER_OCCURRENCE")
public class CustomerOccurrence implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE")
    private Long code;

    @Column(name = "COMMENT")
    private String comment;

}



