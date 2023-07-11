package com.claboratorio2.test;

import com.claboratorio2.dao.EmpleadoDao;
import com.claboratorio2.dao.impl.EmpleadoDaoImpl;
import com.claboratorio2.model.Empleado;

public class ActualizarEmpleado {

	public static void main(String[] args) {
		EmpleadoDao dao = new EmpleadoDaoImpl();
		Empleado empleado = dao.listarEmpleadoPorId(1);
		System.out.println(empleado);
		
		empleado.setNombre("Analia");
		String mensaje = dao.actualizarEmpleado(empleado);
		System.out.println(mensaje);
		System.out.println(empleado);

	}

}
