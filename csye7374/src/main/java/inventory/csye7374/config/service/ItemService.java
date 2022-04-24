package inventory.csye7374.config.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemService {
	private String file = "data/inventory.csv";

	public String getFileName() {
		return file;
	}

	public void checkFileExists(File file) throws IOException {
		if (!file.exists()) {
			file.createNewFile();
		}
	}

	public List<List<String>> readFile() throws NumberFormatException, IOException {
		
		List<List<String>> itemList = new ArrayList<List<String>>();
		BufferedReader csvReader = new BufferedReader(new FileReader(this.file));
		String row;
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			itemList.add(Arrays.asList(data));
			
		}
		csvReader.close();
		return itemList;		
	}
	public void writeFile(String data) throws IOException {
		BufferedWriter csvWriter = new BufferedWriter(new FileWriter(new File(file), true));
		csvWriter.write(data);
		csvWriter.newLine();
		csvWriter.close();
	}
}
