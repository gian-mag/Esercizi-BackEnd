package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;

	private String cognome;

	private String email;

	private String data_di_nascita;

	@Enumerated(EnumType.STRING)
	private Sesso sesso;

	@OneToMany(mappedBy = "persona")
	private List<Partecipazione> listapartecipazioni;

	
	
	public Persona() {

	}

	public Persona(String _nome, String _cognome, String _email, String _data_di_nascita, Sesso _sesso,
			Partecipazione _listapartecipazioni) {
		nome = _nome;
		cognome = _cognome;
		email = _email;
		data_di_nascita = _data_di_nascita;
		sesso = _sesso;
		setListapartecipazioni(_listapartecipazioni);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getData_di_nascita() {
		return data_di_nascita;
	}

	public void setData_di_nascita(String data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
	}

	public Sesso getSesso() {
		return sesso;
	}

	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}

	public List<Partecipazione> getListapartecipazioni() {
		return listapartecipazioni;
	}

	public List<Partecipazione> setListapartecipazioni(Partecipazione Object) {
		List<Partecipazione> fittizia = new ArrayList<Partecipazione>();
		fittizia.add(Object);
		this.listapartecipazioni = fittizia;
		return this.listapartecipazioni;
	}

}
