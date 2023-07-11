package com.claboratorio2.test;

import com.claboratorio2.dao.EmpleadoDao;
import com.claboratorio2.dao.impl.EmpleadoDaoImpl;
import com.claboratorio2.model.Empleado;

public class RegistroEmpleadoTest {

	public static void main(String[] args) {
		EmpleadoDao  dao = new EmpleadoDaoImpl();
		Empleado empleado = new Empleado("Alexandra", "Meza","15468239");
		String mensaje = dao.registrarEmpleado(empleado);
		System.out.println(mensaje);
	}
}
