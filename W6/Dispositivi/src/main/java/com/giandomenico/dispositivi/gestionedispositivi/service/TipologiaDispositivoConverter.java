//package com.giandomenico.dispositivi.gestionedispositivi.service;
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Service;
//import com.giandomenico.dispositivi.gestionedispositivi.entities.TipologiaDispositivo;
//
//@Service
//public class TipologiaDispositivoConverter implements Converter<String, TipologiaDispositivo> {
//
//	@Override
//	public TipologiaDispositivo convert(String s) {
//		if (s.equals(TipologiaDispositivo.TABLET.name().toLowerCase())) {
//			System.out.println(s);
//			return TipologiaDispositivo.valueOf(s.toUpperCase());
//		}
//		if (s.equals(TipologiaDispositivo.SMARTPHONE.name().toLowerCase())) {
//			System.out.println(s);
//			return TipologiaDispositivo.valueOf(s.toUpperCase());
//		}
//		if (s.equals(TipologiaDispositivo.LAPTOP.name().toLowerCase())) {
//			System.out.println(s);
//			return TipologiaDispositivo.valueOf(s.toUpperCase());
//		}
//
//		return null;
//	}
//
//}