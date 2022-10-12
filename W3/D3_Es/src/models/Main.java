package models;



import it.epicode.be.gestioneventi.model.Genere;
import it.epicode.be.gestioneventi.model.dao.EventoDAO;
import models.es2.*;

public class Main {

	public static final String pu = "D3_Es";
	
	public static void main(String[] args) {
		
//		saveEventi();
		
		EventoDAO.getConcertiInStreaming(true);
		
		EventoDAO.getConcertiPerGenere(Genere.POP);

	}
	
	public static void saveEventi() {

		PartitaDiCalcio p1 = new PartitaDiCalcio("Inter", "Milan", "Inter", 2,
				1);
		
		PartitaDiCalcio p2 = new PartitaDiCalcio("Juventus", "Atalanta", null,  1,
				1);
		
		PartitaDiCalcioDAO.save(p1);
		PartitaDiCalcioDAO.save(p2);
		
		Concerto con1 = new Concerto(true, Genere.CLASSICO);
		
		Concerto con2 = new Concerto(false, Genere.POP);
		
		ConcertoDAO.save(con1);	
		
		ConcertoDAO.save(con2);	
		
	}

	
	
}
