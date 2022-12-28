package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner; //ejecuta en consola
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.ejercicio1.modelo.Propietario;
import com.example.demo.ejercicio1.modelo.Vehiculo;
import com.example.demo.ejercicio1.service.IGestorMatriculaService;
import com.example.demo.ejercicio1.service.IMatriculaNuevaService;
import com.example.demo.ejercicio1.service.IMatriculaService;
import com.example.demo.ejercicio1.service.IVehiculoService;
import com.example.demo.ejercicio1.service.IpropietarioService;

@SpringBootApplication
public class ProyectoU1ScApplication implements CommandLineRunner {

	@Autowired
	private IVehiculoService vehiculoService;
	@Autowired
	private IpropietarioService ipropietarioService;
	@Autowired
	private IGestorMatriculaService gestorMatriculaService; //ctrl +space
	
	
	
//	@Autowired
//	@Qualifier("Pesado")
//	//private IMatriculaService matriculaService;
//	private IMatriculaNuevaService matriculaService;
//	
//	@Autowired
//	@Qualifier("Liviano")
//	private IMatriculaService matriculaServiceLiviano;
	  
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU1ScApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		// Matricula

		// Opcion1
		Vehiculo vehi = new Vehiculo();
		vehi.setMarca("Tocyota");
		vehi.setPlaca("PSD2312");
		vehi.setPrecio(new BigDecimal(20000));
		vehi.setTipo("L");
		this.vehiculoService.crear(vehi);
		vehi.setMarca("Toyota");
		vehi.setPrecio(new BigDecimal(15000));
		this.vehiculoService.modificar(vehi);

		// Opcion2
		Propietario propietario = new Propietario();
		propietario.setApellido("Hidalgo");
		propietario.setNombre("Reymon");
		propietario.setCedula("1241587458");
		propietario.setFechaNaciemiento(LocalDateTime.of(1999, 12, 12, 12, 12));
		this.ipropietarioService.guardar(propietario);
		
		
		//////////////////////////////////////
		//Aunque esto está "correcto" para diferenciar el tipo de vehículo,  
		//no se debe poner aquí la lógica de negocio
//		if(vehi.getTipo()=="P") {
//			this.matriculaService.matricular("1241587458", "PSGD2312");
//		}else {
//			this.matriculaServiceLiviano.matricular("1241587458", "PSGD2312");
//		}
		// Opcion 3
		this.gestorMatriculaService.matricular("1241587458", "PSD2312");
	
		//System.out.println(vehi);
	}

}
