package com.claboratorio2.dao;

import java.util.List;

import com.claboratorio2.model.Empleado;

public interface EmpleadoDao {
	public String registrarEmpleado(Empleado empleado);
	public Empleado buscarEmpleado(int id);
	public List<Empleado> listarEmpleados();
	public String actualizarEmpleado(Empleado empleado);
	public String eliminarEmpleado(int id);
	public Empleado listarEmpleadoPorId(int id);
}
