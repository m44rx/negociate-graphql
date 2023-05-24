package pe.tk.ne.negociategraphql.service;

import java.util.List;

public interface BaseService <T> {

    T findById(Long id);
    List<T> findAll();
    void createObjectClass(T t);
    void deleteById(Long id);
    
}
