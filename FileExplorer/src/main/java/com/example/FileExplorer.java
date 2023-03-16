package com.example;

import java.io.File;

public class FileExplorer {

	private FileManager fileManager;

	public FileExplorer(FileManager fileManager) {
		this.fileManager = fileManager;
	}

	public void explore(String path) {
		File[] files = fileManager.listFiles(path);

		for (File file : files) {

			if (file.isDirectory()) {
				System.out.println(file.getName() + "/");
			} else {
				System.out.println(file.getName());
			}
		}
	}
}
