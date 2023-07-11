package com.claboratorio2.dao.impl;

import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.claboratorio2.dao.EmpleadoDao;
import com.claboratorio2.model.Empleado;

public class EmpleadoDaoImpl implements EmpleadoDao{
	
	private static final String REGISTRO_OK = "Se registró correctamente el usuario";
	private static final String REGISTRO_ERROR = "No se registró el usuario";
	
	private static final String ACTUALIZA_OK = "Se actualizó correctamente el usuario";
	private static final String ACTUALIZA_ERROR = "No se actualizó el usuario";
	
	private static final String ELIMINA_OK = "Se eliminó correctamente el usuario";
	private static final String ELIMINA_ERROR = "No se eliminó el usuario";
			
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmpleadoPU");
	EntityManager manager = factory.createEntityManager();

	public String registrarEmpleado(Empleado empleado) {
		String mensaje = REGISTRO_ERROR;
		
		if(!Objects.isNull(empleado)) {
			manager.getTransaction().begin();
			manager.persist(empleado);//envia los datos a ejecucion nivel sql
			manager.getTransaction().commit(); //ejecuta
			mensaje = REGISTRO_OK;
			manager.close();//finaliza el registro
		}
		return mensaje;
	}

	public Empleado buscarEmpleado(int id) {
		return manager.find(Empleado.class, id);
	}
	
	private Empleado buscarEmpleadoId(int id) {
		return manager.find(Empleado.class, id);
	}

	public List<Empleado> listarEmpleados() {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();//especificar la query a realizar
		CriteriaQuery<Empleado> criteriaQuery = criteriaBuilder.createQuery(Empleado.class);
		Root<Empleado> registro = criteriaQuery.from(Empleado.class);
		CriteriaQuery<Empleado> todos = criteriaQuery.select(registro);
		TypedQuery<Empleado> lista = manager.createQuery(todos);

		return lista.getResultList();
	}

	public String actualizarEmpleado(Empleado empleado) {
		String mensaje = ACTUALIZA_ERROR;
		Empleado objeto = buscarEmpleadoId(empleado.getId());
		if(!Objects.isNull(objeto)) {
			manager.getTransaction().begin();
			objeto.setNombre(empleado.getNombre());
			objeto.setApellidos(empleado.getApellidos());
			objeto.setDni(empleado.getDni());	
			manager.getTransaction().commit(); //ejecuta			
			manager.close();//finaliza el actualizado
			mensaje = ACTUALIZA_OK;						
		}
		return mensaje;
	}

	public String eliminarEmpleado(int id) {
		String mensaje = ELIMINA_ERROR;
		Empleado objeto = buscarEmpleadoId(id);
		if(!Objects.isNull(objeto)) {
			manager.getTransaction().begin();
			manager.remove(objeto);
			manager.getTransaction().commit(); //ejecuta			
			manager.close();//finaliza la eliminacion
			mensaje = ELIMINA_OK;						
		}
		return mensaje;
	}

	@Override
	public Empleado listarEmpleadoPorId(int id) {
		return buscarEmpleadoId(id);
	}
}