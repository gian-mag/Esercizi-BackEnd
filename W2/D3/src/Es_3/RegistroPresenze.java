package Es_3;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class RegistroPresenze {
	String presenze = "";

	public String getPresenze() {
		setPresenze();
		return presenze;
	}

	public void setPresenze() {
		String fileName = "docs/BastardiSenzaGloria.txt";
		File maledettoFile = new File(fileName);
		String encoding = "UTF-8";

		if (maledettoFile.exists()) {

			try {
				String fileContent = FileUtils.readFileToString(maledettoFile, encoding);

				this.presenze = fileContent;

			} catch (IOException e) {
				System.out.println("Error");
			}

		} else {
			try { // Nel caso in cui non esiste il file, viene creato automaticamente
				FileUtils.writeStringToFile(maledettoFile, " ", encoding);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void addPresenze(String name, int numero) {
		String fileName = "docs/BastardiSenzaGloria.txt";
		File maledettoFile = new File(fileName);
		String encoding = "UTF-8";

		try {
			FileUtils.writeStringToFile(maledettoFile, name + "@" + numero + "#\n", encoding, true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		setPresenze();
	}
}