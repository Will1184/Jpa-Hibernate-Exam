package org.jpa_hibernate_exam.repository;

import java.util.List;

public interface CrudRepository <T>{
    List<T> listar();
    T porId(Integer empNo);
    void guardar(T t);
    void editar(T t);
    void eliminar(Integer empNo);

}
