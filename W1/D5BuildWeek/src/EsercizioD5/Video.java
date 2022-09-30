package EsercizioD5;

public class Video extends Multimedia implements Volume, Luminosità {

	private int volume;


	private int luminosità;

	public Video(String _titolo, int _volume, int _durata, int _luminosità) {
		super(_titolo, _durata);
		setVolume(_volume);
		setLuminosità(_luminosità);
		play();
	}

	public void play() {
		String esclamativi = "";
		String asterischi = "";
		for (int i = 0; i < volume; i++) {
			esclamativi += "!";
		}

		for (int i = 0; i < luminosità; i++) {
			asterischi += "*";
		}

		for (int j = 0; j < getDurata(); j++) {
			System.out.println(getTitolo() + " " + esclamativi + asterischi + "\n");
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

	@Override
	public void alzaVolume(int più) {
		if (volume + più <= 20) {
			volume = volume + più;
			System.out.println("Volume al:" + volume);
		} else {
			volume = 20;
			System.out.println("Il volume è al massimo");
		}
	}

	@Override
	public void abbassaVolume(int meno) {
		if (volume - meno > 0) {
			volume = volume - meno;
			System.out.println("Volume al:" + volume);
		} else {
			volume = 0;
			System.out.println("Il volume è mutato");
		}
	}

	public void setLuminosità(int lum) {
		if( lum > 0 && lum <= 10) {
			luminosità = lum;
		} else {
			System.out.println("Volume non consono. Portato al valore di default");
			luminosità = 1;
		}
	}
	
	@Override
	public void aumentaLuminosità(int più) {
		if (luminosità + più < 10) {
			luminosità += più;
			System.out.println("Luminosità al:" + luminosità);
		} else {
			luminosità = 10;
			System.out.println("Ti servono gli occhiali da sole");
		}
	}

	@Override
	public void abbassaLuminosità(int meno) {
		if (luminosità - meno > 0) {
			luminosità -= meno;

			System.out.println("Luminosità al:" + luminosità);
		} else {
			luminosità = 0;
			System.out.println("Non vedi più nulla");
		}
	}


}
