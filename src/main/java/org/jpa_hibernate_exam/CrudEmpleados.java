package org.jpa_hibernate_exam;

import jakarta.persistence.EntityManager;
import org.jpa_hibernate_exam.entity.Empleado;
import org.jpa_hibernate_exam.service.EmpleadoService;
import org.jpa_hibernate_exam.service.EmpleadoServiceImpl;
import org.jpa_hibernate_exam.util.JpaUtil;

import java.util.List;
import java.util.Optional;

public class CrudEmpleados {
    public static void main(String[] args) {
        //Inicializacion del EntityManager
         EntityManager manager = JpaUtil.getEntityManger();

         //Inicializacion de empleado service para usar los metodos Crud
        EmpleadoService service = new EmpleadoServiceImpl(manager);

        //Listar Todos los empleados
        List<Empleado>empleados=service.listar();
        empleados.forEach(System.out::println);

        //Busca un empleado por id
        Optional<Empleado>empleadoOptional= service.porId(7369);
        empleadoOptional.ifPresent(System.out::println);

        //Creacion de un empleado
        Empleado empleado = new Empleado();
        empleado.setEmpNo(7523);
        empleado.setApellido("GOMEZ");
        empleado.setOficio("VENDEDOR");
        empleado.setDir(7698);
        empleado.setFechaAlt("1996-1-17");
        empleado.setSalario(1500.00F);
        empleado.setComision(300F);
        empleado.setDeptNo(30);
        //Guardar empleado en base de datos
        service.guardar(empleado);
        service.listar().forEach(System.out::println);

        //Editar apellido de empleado
        empleado.setApellido("RUBIALES");
        //Guardar el cambio en base de datos
        service.Editar(empleado);
        service.listar().forEach(System.out::println);

        //Eliminar un empleado
        Integer empNo= empleado.getEmpNo();
        //Verifica que exista el empleado
        Optional<Empleado> empleadoEliminar = service.porId(empNo);
        empleadoEliminar.ifPresent(empleadoEl ->{
            //Elimina al empleado
            service.eliminar(empleadoEl.getEmpNo());
            service.listar().forEach(System.out::println);
        });
        //Cierra la sesion a base de datos
        manager.close();
    }
}