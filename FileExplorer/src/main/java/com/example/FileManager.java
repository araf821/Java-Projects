package com.example;

import java.io.File;

public class FileManager {

	public File[] listFiles(String path) {
		File directory = new File(path);

		if (!directory.exists() || !directory.isDirectory()) {
			throw new IllegalArgumentException("Invalid directory: " + path);
		}

		return directory.listFiles();
	}
}
