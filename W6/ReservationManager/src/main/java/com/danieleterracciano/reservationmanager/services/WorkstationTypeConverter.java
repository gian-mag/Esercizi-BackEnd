package com.danieleterracciano.reservationmanager.services;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.danieleterracciano.reservationmanager.entities.WorkstationType;

@Service
public class WorkstationTypeConverter implements Converter<String, WorkstationType> {

	@Override
	public WorkstationType convert(String s) {
		if(s.equals(WorkstationType.PRIVATE.toString().toLowerCase())) {
			return WorkstationType.PRIVATE;
		}
		if(s.equals(WorkstationType.OPENSPACE.name())) {
			return WorkstationType.OPENSPACE;
		}
		if(s.equals(WorkstationType.MEETING_ROOM.name())) {
			return WorkstationType.MEETING_ROOM;
		}
		return null;
	}
	
}
