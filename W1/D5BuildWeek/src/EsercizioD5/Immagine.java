package EsercizioD5;

public class Immagine extends Multimedia implements Luminosità {

	private int luminosità;

	public Immagine(String _titolo, int _luminosità) {
		super(_titolo);
		setLuminosità(_luminosità);
		show();
	}

	public void show() {
		String asterischi = "";
		for (int i = 0; i < luminosità; i++) {
			asterischi += "*";
		}
		System.out.println(getTitolo() + " " + asterischi + "\n");
	}

	public void setLuminosità(int lum) {
		if( lum > 0 && lum <= 10) {
			luminosità = lum;
		} else {
			System.out.println("Luminosità non consono. Portato al valore di default");
			luminosità = 1;
		}
	}

	public void aumentaLuminosità(int più) {
		if (luminosità + più < 10) {
			luminosità += più;
			System.out.println("Luminosità al:" + luminosità);
		} else {
			luminosità = 10;
			System.out.println("Ti servono gli occhiali da sole");
		}
	}


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
