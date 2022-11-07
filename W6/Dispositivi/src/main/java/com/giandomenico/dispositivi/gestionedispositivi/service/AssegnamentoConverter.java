//package com.giandomenico.dispositivi.gestionedispositivi.service;
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Service;
//
//import com.giandomenico.dispositivi.gestionedispositivi.entities.Assegnamento;
//
//
//@Service
//public class AssegnamentoConverter implements Converter<String, Assegnamento> {
//
//	@Override
//	public Assegnamento convert(String s) {
//		if(s.equals(Assegnamento.DISPONIBILE.name().toLowerCase())) {
//			return Assegnamento.DISPONIBILE;
//		}
//		if(s.equals(Assegnamento.ASSEGNATO.name().toLowerCase())) {
//			return Assegnamento.ASSEGNATO;
//		}
//		if(s.equals(Assegnamento.IN_MANUTENZIONE.name().toLowerCase())) {
//			return Assegnamento.IN_MANUTENZIONE;
//		}
//		if(s.equals(Assegnamento.DISMESSO.name().toLowerCase())) {
//			return Assegnamento.DISMESSO;
//		}
//		return null;
//	}
//	
//}
