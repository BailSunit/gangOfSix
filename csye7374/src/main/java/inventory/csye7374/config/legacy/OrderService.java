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
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class OrderService extends FileReaderService {

	private String orderFile = "gangOfSix/csye7374/data/order.csv";

	public String getFileName() {
		return super.getFilePath() + orderFile;
	}

	@Override
	public void writeFile(List<String> data) throws IOException {
		String record = data.stream().collect(Collectors.joining(","));
		try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(new File(getFileName()), true))) {
			csvWriter.write(record);
			csvWriter.newLine();
		}
	}

	public void replaceFile(List<String> data) throws IOException {
		try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(new File(getFileName())))) {
			for (String line : data) {
				csvWriter.write(line);
				csvWriter.newLine();
			}
		}
	}

	public List<List<String>> readFile() throws IOException {
		List<List<String>> list = new ArrayList<List<String>>();
		try (BufferedReader csvReader = new BufferedReader(new FileReader(getFileName()))) {
			String row;
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(",");
				list.add(Arrays.asList(data));
			}
		}
		return list;
	}

}
