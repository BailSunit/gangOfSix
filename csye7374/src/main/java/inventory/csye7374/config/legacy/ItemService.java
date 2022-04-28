package inventory.csye7374.config.legacy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ItemService extends FileReaderService {
	
	private String file = "gangOfSix/csye7374/data/inventory.csv";

	public String getFileName() {
		
		return super.getFilePath() + file;
	}
	
	@Override
	public List<List<String>> readFile() throws NumberFormatException, IOException {
		
		List<List<String>> itemList = new ArrayList<List<String>>();
		BufferedReader csvReader = new BufferedReader(new FileReader(getFileName()));
		String row;
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			itemList.add(Arrays.asList(data));
			
		}
		csvReader.close();
		return itemList;		
	}
	
	@Override
	public void writeFile(List<String> data) throws IOException {
		BufferedWriter csvWriter = new BufferedWriter(new FileWriter(new File(getFileName())));
		for(String line : data) {
		csvWriter.write(line);
		csvWriter.newLine();
		}
		csvWriter.close();
	}
}
