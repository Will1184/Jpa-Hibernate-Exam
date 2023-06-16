package org.jpa_hibernate_exam.service;

import org.jpa_hibernate_exam.entity.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<Empleado> listar();
    Optional<Empleado> porId(Integer empNo);
    void guardar(Empleado empleado);
    void Editar(Empleado empleado);
    void eliminar(Integer empNo);
}
