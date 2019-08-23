package xom.example.compdemo;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import xom.component.cloudFileAccessApi.CloudFileLoader;
import xom.component.cloudFileAccessApi.CloudReadonlyFile;

@Component
public class FileLoaderDemo {
	@Resource
	CloudFileLoader fileLoader;

	private CloudReadonlyFile asyncText;
	private CloudReadonlyFile asyncConfig;
	private String textTemplate;
	private String editorConfig;
	/**
	 * Initialize loader configuration
	 * @param conf
	 */
	public FileLoaderDemo(CloudFileLoader loader) {
		fileLoader = loader;  
	}
	public void startLoader() throws IOException {
		if (textTemplate != null) {
			return;
		}
		textTemplate = null;
		editorConfig = null; 
		// Start loading files
		String currfile = null;
		currfile = "cover2.cfg";
		asyncConfig = fileLoader.loadFileAsync(currfile);
		currfile = "cover2.1.txt";
		asyncText = fileLoader.loadFileAsync(currfile);
	}
	/**
	 * Get config file content. Eventualy wait for I/O operation to complete.
	 * @return the config file content.
	 * @throws IOException 
	 */
	public String getEditorConfig() throws IOException {
		if (editorConfig == null) {
			editorConfig = asyncConfig.getTextFile();
		}
		return editorConfig;
	}
	/**
	 * Get cover text template file content. Eventualy wait for I/O operation to complete.
	 * @return the cover text template file content.
	 * @throws IOException 
	 */
	public String getCoverTextTemplate() throws IOException {
		if (textTemplate == null) {
			textTemplate = asyncText.getTextFile();
		}
		return textTemplate;
	}
}
