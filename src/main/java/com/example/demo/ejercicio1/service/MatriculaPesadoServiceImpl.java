package com.example.demo.ejercicio1.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ejercicio1.modelo.Vehiculo;
import com.example.demo.ejercicio1.repository.IVehiculoRepository;

//Esta clase es la implmentación de la interfaz de la funcionalidad común

//Es identificador del service
@Service("Pesado")
public class MatriculaPesadoServiceImpl implements IMatriculaNuevaService {

	@Override
	public BigDecimal matricular(BigDecimal precio) {
	
		// TODO Auto-generated method stub
		System.out.println("Matriculado vehículo pesado");
		System.out.println("Cálculo del descuento de 2000");
		BigDecimal valor = precio.multiply(new BigDecimal(0.15));
		return valor;
	}

}
