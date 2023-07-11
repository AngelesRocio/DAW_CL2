package com.claboratorio2.test;

import com.claboratorio2.dao.EmpleadoDao;
import com.claboratorio2.dao.impl.EmpleadoDaoImpl;

public class EliminarEmpleado {

	public static void main(String[] args) {
		EmpleadoDao dao = new EmpleadoDaoImpl();
		String mensaje = dao.eliminarEmpleado(3);
		System.out.println(mensaje);
	}
}
