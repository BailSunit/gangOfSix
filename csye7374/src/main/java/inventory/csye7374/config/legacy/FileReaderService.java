package inventory.csye7374.config.legacy;

import java.io.IOException;
import java.util.List;

public abstract class FileReaderService {

	private String filePath = "/Users/surbhiparihar/";

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	List<List<String>> readFile() throws NumberFormatException, IOException{
		return null;
	}

	void writeFile(List<String> data) throws IOException {
		// No IMP
	}
}
