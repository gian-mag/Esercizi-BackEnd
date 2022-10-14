package Es_D5;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Pubblicazione {

	static String archivio = "";

	static String percorsoFile = "docs/Archivio.txt";
	static File file = new File(percorsoFile);
	static String encoding = "UTF-8";

	public static void getArchivio() {

		if (file.exists()) {

			try {
				String fileContent = FileUtils.readFileToString(file, encoding);

				archivio = fileContent;

			} catch (IOException e) {
				System.out.println("Errore di lettura");
			}
		} else {
			try { // Nel caso in cui non esiste il file, viene creato automaticamente
				FileUtils.writeStringToFile(file, "Non ci sono pubblicazioni nell'archivio\n", encoding);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}

	public static void setArchivio(List<Oggetto> obj) {

		try {
			FileUtils.writeStringToFile(file, obj.toString() + "\n", encoding, true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		getArchivio();
	}

	public static String getArchivioTxt() {
		getArchivio();
		return archivio;
	}

}
