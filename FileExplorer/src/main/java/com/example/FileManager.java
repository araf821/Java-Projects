package com.example;

import java.io.File;

public class FileManager {

	public File[] listFiles(String path) {
		File directory = new File(path);

		if (!directory.exists() || !directory.isDirectory()) {
			System.out.println("Invalid Directory! :((");
		}

		return directory.listFiles();
	}
}
