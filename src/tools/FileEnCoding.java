package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileEnCoding {
	/**
	 * 递归的将文件file下的所有满足后缀为suffix的文件都读取进来
	 * @param file
	 * @param fileList
	 * @param suffix
	 */
	public static void allFile(File file, ArrayList<File> fileList, final String suffix) {
		if(file.isDirectory())
			for(File f : file.listFiles())
				allFile(f, fileList, suffix);
		else {
			if(file.getName().endsWith(suffix))
				fileList.add(file);
		}
	}
	public static void main(String[] args) throws IOException {
		String userDir = System.getProperty("user.dir");
		File file = new File(userDir);
		ArrayList<File> fileList = new ArrayList<>();
		allFile(file, fileList, ".java");
		for(File f : fileList) {
			try {
				// 读取莫名有很多错误（重复值
				Scanner s = new Scanner(f);
				while(s.hasNextLine()) {
					System.out.println(s.nextLine());
				}
				s.close();
//				// 转码写
//				BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "utf-8"));
//				bfw.write(sbuf.toString());
//				bfw.flush();
//				bfw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
