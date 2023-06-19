package org.jpa_hibernate_exam.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;



@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @Column(name = "emp_no")
    private Integer empNo;
    private String apellido;
    private String oficio;
    private Integer dir;
    @Column(name = "fecha_alt")
    private LocalDate fechaAlt;
    private Float salario;
    private Float comision;
    @Column(name = "dept_no")
    private  Integer deptNo;


    public Empleado() {
    }

    public Empleado(Integer empNo, String apellido, String oficio, Integer dir, LocalDate fechaAlt, Float salario, Float comision, Integer deptNo) {
       try {
           this.fechaAlt = fechaAlt;

       }catch (DateTimeParseException e){
           System.err.println("Error al analizar la fecha: "+e.getMessage());
       }
        this.empNo = empNo;
        this.apellido = apellido;
        this.oficio = oficio;
        this.dir = dir;
        this.salario = salario;
        this.comision = comision;
        this.deptNo = deptNo;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public Integer getDir() {
        return dir;
    }

    public void setDir(Integer dir) {
        this.dir = dir;
    }

    public LocalDate getFechaAlt() {
        return fechaAlt;
    }

    public void setFechaAlt(LocalDate fechaAlt) {
        try {
            this.fechaAlt = fechaAlt;
        }catch (DateTimeParseException e){
            System.err.println("Error al analizar la fecha: "+e.getMessage());
        }
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Float getComision() {
        return comision;
    }

    public void setComision(Float comision) {
        this.comision = comision;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return
                "empNo: " + empNo +
                ", apellido: " + apellido +
                ", oficio: " + oficio  +
                ", dir: " + dir +
                ", fechaAlt: " + fechaAlt.format(dtformat) +
                ", salario: " + salario +
                ", comision: " + comision +
                ", deptNo: " + deptNo;
    }
}
