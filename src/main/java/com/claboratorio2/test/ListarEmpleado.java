package com.claboratorio2.test;

import com.claboratorio2.dao.EmpleadoDao;
import com.claboratorio2.dao.impl.EmpleadoDaoImpl;

public class ListarEmpleado {

	public static void main(String[] args) {
		EmpleadoDao dao = new EmpleadoDaoImpl();
		dao.listarEmpleados().stream().forEach(System.out::println);
	}
}
