package br.com.boaentrega.domain;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable> implements IEntity<ID>, Serializable {

    public static final String SEQ_NAME = "SEQ";

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    private ID id;

    public abstract String getMainIdentifier();

    public abstract String getSecondaryIdentifier();

    public ID getId() {
        return this.id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
