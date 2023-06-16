package org.jpa_hibernate_exam.service;

import jakarta.persistence.EntityManager;
import org.jpa_hibernate_exam.entity.Empleado;
import org.jpa_hibernate_exam.repository.CrudRepository;
import org.jpa_hibernate_exam.repository.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

public class EmpleadoServiceImpl implements EmpleadoService{
    private final EntityManager manager;
    private CrudRepository<Empleado> repository;

    public EmpleadoServiceImpl(EntityManager manager) {
        this.manager = manager;
        this.repository= new EmpleadoRepository(manager);
    }

    @Override
    public List<Empleado> listar() {
        System.out.println("=====lISTAR EMPLEADO====");
        return repository.listar();
    }

    @Override
    public Optional<Empleado> porId(Integer empNo) {
        System.out.println("=====BUSQUEDA DE EMPLEADO POR ID====");
        return Optional.ofNullable(repository.porId(empNo));
    }

    @Override
    public void guardar(Empleado empleado) {
        try {
            System.out.println("=====GUARDAR====");
            manager.getTransaction().begin();
            repository.guardar(empleado);
            manager.getTransaction().commit();
            System.out.println("=====EMPLEADO GUARDADO====");
        }catch (Exception e){
            System.out.println("=====EMPLEADO NO GUARDADO====");
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void Editar(Empleado empleado) {
        try {
            System.out.println("=====EDITAR EMPLEADO====");
            manager.getTransaction().begin();
            repository.editar(empleado);
            manager.getTransaction().commit();
            System.out.println("=====EMPLEADO EDITADO====");
        }catch (Exception e){
            System.out.println("=====EMPLEADO NO EDITADO====");
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Integer empNo) {
        try {
            System.out.println("=====ELIMINAR EMPLEADO====");
            manager.getTransaction().begin();
            repository.eliminar(empNo);
            manager.getTransaction().commit();
            System.out.println("=====EMPLEADO ELIMINADO====");
        }catch (Exception e){
            System.out.println("=====EMPLEADO NO ELIMINADO====");
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
