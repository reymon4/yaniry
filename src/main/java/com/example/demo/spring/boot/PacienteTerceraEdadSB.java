package com.example.demo.spring.boot;

import org.springframework.stereotype.Component;

@Component
public class PacienteTerceraEdadSB extends PacienteSB{

	private String codigoIESS;
	
	public Integer calcularDescuento() {
		System.out.println("Paciente con descuento del 20% de descuento");
		return 20;
	}

	public String getCodigoIESS() {
		return codigoIESS;
	}

	public void setCodigoIESS(String codigoIESS) {
		this.codigoIESS = codigoIESS;
	}
	
}
