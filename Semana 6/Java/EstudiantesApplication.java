package utn.estudiantes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utn.estudiantes.modelo.Estudiantes2022;
import utn.estudiantes.servicio.EstudianteServicio;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	//Usamos la capa de servicio desde la de presentación

	private EstudianteServicio estudianteServicio;
	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	//Regresa el salto de linea cualquiera sea el sistema operativo
	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicación");
		// Levantar fábrica de Spring
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicación finalizada");
	}
	@Override
	public void run(String... args) throws Exception {
		logger.info(nl+"Ejecutando método run de Spring"+nl);
		var salir = false;
		var consola = new Scanner(System.in);
		while(!salir){
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);
		} // Fin ciclo while
	}

	private void mostrarMenu(){
		logger.info(nl);
		logger.info("""
						*** Sistema de Estudiantes ***
						1. Listar estudiantes
						2. Buscar estudiantes
						3. Agregar estudiante
						4. Modificar estudiante
						5. Eliminar estudiante
						6. Salir
						Elige una opción:""");
	}

	private boolean ejecutarOpciones(Scanner consola){
		var opcion = Integer.parseInt((consola.nextLine()));
		var salir = false;
		switch (opcion){
			case 1 -> { //Listar estudiantes
				logger.info(nl+"Listado de estudiantes: "+nl);
				List<Estudiantes2022> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach(( estudiante -> logger.info(estudiante.toString()+nl)));
			} // Fin caso1

			case 2 -> {//Buscar estudiante por ID
				logger.info("Ingrese el ID del estudiante: ");
				var IdEstudiante = Integer.parseInt(consola.nextLine());
				Estudiantes2022 estudiante = estudianteServicio.buscarEstudiantePorId(IdEstudiante);
				if(estudiante != null)
					logger.info("Estudiante encontrado: "+ estudiante +nl);
				else
					logger.info("Estudiante no encontrado: "+ estudiante +nl);
			}
			case 3 -> { //Agregar estudiante
				logger.info("Agregar estudiante: "+nl);
				logger.info("Nombre: ");
				var nombre = consola.nextLine();
				logger.info("Apellido: ");
				var apellido = consola.nextLine();
				logger.info("Email: ");
				var email =  consola.nextLine();
				logger.info("Teléfono: ");
				var telefono = consola.nextLine();
				//Creamos el objeto estudiantes sin el ID
				var estudiante = new Estudiantes2022();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setEmail(email);
				estudiante.setTelefono(telefono);
				estudianteServicio.guardarEstudiante(estudiante);
				logger.info("Estudiante agregado: "+estudiante+nl);
			}
			case 4 -> { //Modificar estudiante
				logger.info("Modificar estudiante: " + nl);
				logger.info("Ingrese el ID estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				// Buscamos el estudiante a modificar
				Estudiantes2022 estudiante =
						estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if (estudiante != null) {
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Email: ");
					var email = consola.nextLine();
					logger.info("Teléfono: ");
					var telefono = consola.nextLine();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setEmail(email);
					estudiante.setTelefono(telefono);
					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Estudiante modificado: " + estudiante + nl);
				} else
					logger.info("Estudiante no encontrado con el ID" + idEstudiante + nl);
			}
			case 5 ->  { //Eliminar estudiante
				logger.info("Eliminar estudiante: "+nl);
				logger.info("Ingrese el ID del estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				// Buscamos el id estudiante a eliminar
				var estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					estudianteServicio.eliminarEstudiante(estudiante);
					logger.info("Estudiante eliminado: "+estudiante+nl);
				}
				else
					logger.info("Estudiante no encontrado por ID: "+estudiante+nl);
			}
			case 6 -> { //Salir
				logger.info("Hasta pronto"+nl+nl);
				salir = true;
			}
			default -> logger.info("Opción no reconocida: "+opcion+nl);
		}//Fin switch
		return salir;
	} //Fin método
}
