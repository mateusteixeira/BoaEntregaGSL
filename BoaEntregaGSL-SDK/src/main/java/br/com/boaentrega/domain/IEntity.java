package br.com.boaentrega.domain;

import java.io.Serializable;

@FunctionalInterface
public interface IEntity<T extends Serializable> {
    T getId();
}
