package com.myexple.snapfood.common;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<E, ID extends Serializable> {

    void insert(E entity);

    E update(E entity);

    void delete(ID id);

    E findById(ID id);

    List<E> findAll();


}
