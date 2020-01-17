package uk.co.digitalpayment.repository;

public interface Updateable<ID, T> {

    ID save(T entity);

    void delete(ID id);

}
