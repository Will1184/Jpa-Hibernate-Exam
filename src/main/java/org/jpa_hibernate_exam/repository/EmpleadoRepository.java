package org.jpa_hibernate_exam.repository;

import jakarta.persistence.EntityManager;
import org.jpa_hibernate_exam.entity.Empleado;

import java.util.List;
import java.util.Optional;

public class EmpleadoRepository implements CrudRepository<Empleado>{
    private final  EntityManager manager;

    public EmpleadoRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Empleado> listar() {
        return manager.createQuery("SELECT e FROM Empleado e",Empleado.class).getResultList();
    }

    @Override
    public Empleado porId(Integer empNo) {
        return manager.find(Empleado.class,empNo);
    }

    @Override
    public void guardar(Empleado empleado) {
        if (empleado.getEmpNo()!=null && empleado.getEmpNo()>-0){
            manager.merge(empleado);
        }else {
            manager.persist(empleado);
        }
    }

    @Override
    public void editar(Empleado empleado) {
        Empleado empleadoEditar= this.porId(empleado.getEmpNo());
        if(empleadoEditar!= null){
          manager.merge(empleado);
        }
    }

    @Override
    public void eliminar(Integer empNo) {
        Empleado empleado = porId(empNo);
        manager.remove(empleado);
    }
}
