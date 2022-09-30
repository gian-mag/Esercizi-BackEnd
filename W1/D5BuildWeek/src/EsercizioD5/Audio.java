package EsercizioD5;

public class Audio extends Multimedia implements Volume {

	private int volume;

	public Audio(String _titolo, int _volume, int _durata) {
		super(_titolo, _durata);
		setVolume(_volume);
		play();
	}

	public void play() {
		String esclamativi = "";

		for (int i = 0; i < volume; i++) {
			esclamativi += "!";

		}
		for (int j = 0; j < getDurata(); j++) {
			System.out.println(getTitolo() + " " + esclamativi + "\n");
		}

	}
	
	public void setVolume(int vol) {
		if( vol > 0 && vol <= 10) {
			volume = vol;
		} else {
			System.out.println("Volume non consono. Portato al valore di default");
			volume = 1;
		}
	}

	public void alzaVolume(int più) {
		if (volume + più <= 20) {
			volume = volume + più;
			System.out.println("Volume al:" + volume);
		} else {
			volume = 20;
			System.out.println("Il volume è al massimo");
		}
	}


	public void abbassaVolume(int meno) {
		if (volume - meno > 0) {
			volume = volume - meno;
			System.out.println("Volume al:" + volume);
		} else {
			volume = 0;
			System.out.println("Il volume è mutato");
		}
	}
}
