package com.example.demo.ejercicio1.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.ejercicio1.modelo.Matricula;
import com.example.demo.ejercicio1.modelo.Propietario;
import com.example.demo.ejercicio1.modelo.Vehiculo;
import com.example.demo.ejercicio1.repository.IMatriculaRepository;
import com.example.demo.ejercicio1.repository.IPropietarioRepository;
import com.example.demo.ejercicio1.repository.IVehiculoRepository;

@Service
public class GestorMatriculaServiceImpl implements IGestorMatriculaService{
	@Autowired
	@Qualifier("Pesado")
	//private IMatriculaService matriculaService;
	private IMatriculaNuevaService matriculaService;
	
	@Autowired
	@Qualifier("Liviano")
	private IMatriculaNuevaService matriculaServiceLiviano;
	
	@Autowired
	private IVehiculoRepository ivehiculoRepo;
	
	@Autowired
	private IPropietarioRepository iproRepo;
	
	@Autowired
	private IMatriculaRepository matriculaRepository;
	
	
	@Override
	public void matricular(String cedula, String placa) {
		//Esto es común para las clases. Es decir, se encarga la clase gestora
		Vehiculo vehi = this.ivehiculoRepo.buscar(placa);
		Propietario pro = this.iproRepo.buscar(cedula);
		
		
		Matricula matri = new Matricula();
		matri.setFecha(LocalDateTime.now());
		matri.setPropietario(pro);
		matri.setVehiculo(vehi);
		
		// TODO Auto-generated method stub
		//Estos métodos dependen según la clase
		BigDecimal valor = null;
		if(vehi.getTipo()=="P") {
			valor =this.matriculaService.matricular(vehi.getPrecio());
			System.out.println("Su vehículo es Pesado");
		}else {
		    valor =this.matriculaServiceLiviano.matricular(vehi.getPrecio());
		System.out.println("Su vehículo es Liviano");
		}
		//Descuento
		
		if (valor.compareTo(new BigDecimal(2000)) > 1) {
			BigDecimal descuento = valor.multiply(new BigDecimal(0.07));
			descuento = descuento.divide(new BigDecimal(100));
			valor = valor.subtract(descuento);
		}
		
		matri.setValor(valor);
		this.matriculaRepository.insertar(matri);
		System.out.println("Se matriculó el vehículo: "+matri);
		System.out.println("El valor fue: "+valor);
	}

}
