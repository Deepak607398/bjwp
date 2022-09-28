package com.FilePoc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ContentCopy {
	public static void main(String args[]) throws IOException {
		// Creating a File object for directory
		File directoryPath = new File("E:\\Studies\\2 semester\\273 Hack Tricks");
		int count = 0;
		// List of all files and directories
		File filesList[] = directoryPath.listFiles();
		for (File file : filesList) {
			String ss = file.getName();
			char ch = '-';
			String sj = ss.replace(' ', ch).toLowerCase().replace(".txt", "");

			FileInputStream ins = null;
			FileOutputStream outs = null;
			File infile = new File("E:\\Studies\\2 semester\\273 Hack Tricks\\" + ss);
			File outfile = new File("E:\\Studies\\2 semester\\Destination\\" + sj + "\\index.md");
			ins = new FileInputStream(infile);
			outs = new FileOutputStream(outfile);
			byte[] buffer = new byte[1024];
			int length;

			while ((length = ins.read(buffer)) > 0) {
				outs.write(buffer, 0, length);
			}
			ins.close();
			outs.close();

			String s = "2017-01-01";
			String e = "2017-09-27";
			LocalDate startDate = LocalDate.parse(s);
			LocalDate endDate = LocalDate.parse(e);

			// List<LocalDate> ldate=
			// startDate.datesUntil(endDate).collect(Collectors.toList());
			List<Object> ldate = startDate.datesUntil(endDate).collect(Collectors.toList());
			// System.out.println(ldate.get(count++));
			String str = "---\r\n" + "title: " + sj.replace("-", " ") + "\r\n" + "date: \"" + ldate.get(count++)
					+ "\"\r\n" + "tags: ['misc']\r\n" + "template: post\r\n" + "---";

			BufferedWriter writer = new BufferedWriter(
					new FileWriter("E:\\Studies\\2 semester\\Destination\\" + sj + "\\index.md", true));
			writer.append(str);

			writer.close();

			System.out.println("File copied successfully!!");

		}
	}
}
