package com.example;


public class Main {

	public static void main(String[] args) {
		String path = "/home";
        FileManager fileManager = new FileManager();
        FileExplorer fileExplorer = new FileExplorer(fileManager);
        fileExplorer.explore(path);
	}

}
