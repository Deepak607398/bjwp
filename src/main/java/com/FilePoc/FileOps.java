package com.FilePoc;

import java.io.File;
import java.io.IOException;

public class FileOps {

	// Source folder contains 273 text files (E:\Studies\2 semester\273 Hack Tricks)
	// Extract each file name and create a folder with the it - for example: 10
	// reasons why PCs crash U must Know -> 10-reasons-why-PCs-crash-U-must-Know
	// Inside each folder create an file called index.md and copy the contents of
	// each txt file to the index.md
	public static void main(String[] args) throws IOException {

		// Creating a File object for directory
		File directoryPath = new File("E:\\Studies\\2 semester\\273 Hack Tricks");
		// List of all files and directories
		File filesList[] = directoryPath.listFiles();
		System.out.println("List of files and directories in the specified directory:");
		System.out.println(" ");
		for (File file : filesList) {
			String ss = file.getName();
			char ch = '-';
			ss = ss.replace(' ', ch).toLowerCase().replace(".txt", "");

			System.out.println("String after replacing spaces with given character: " + ss);

			String path = "E:\\Studies\\2 semester\\Destination\\" + ss;

			File f1 = new File(path);

			// Creating a folder using mkdirs() method
			boolean bool2 = f1.mkdirs();

			File file1 = new File("E:\\Studies\\2 semester\\Destination\\" + ss + "\\index.md");

			boolean result = file1.createNewFile(); // creates a new file

			if (bool2 || result) {
				System.out.println("Folder is created successfully");
				System.out.println("file created " + file1.getCanonicalPath()); // returns the path string
			} else {
				System.out.println("Error Found!");
				System.out.println("File already exist at location: " + file1.getCanonicalPath());
			}

			System.out.println(" " + path);
		}
	}
}
