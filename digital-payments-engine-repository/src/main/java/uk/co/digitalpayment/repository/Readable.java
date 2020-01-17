package uk.co.digitalpayment.repository;

import java.util.Collection;
import java.util.Optional;

public interface Readable<ID, T> {

    Collection<T> findAll();

    Optional<T> findById(ID id);

    boolean exists(ID id);

}
