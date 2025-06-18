package userdata;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class fileoperations {
	
	
		static final String path ="C:\\Users\\MAHALAKSHMI\\Pictures\\Saved Pictures";
		public static void main(String[] args) {

			Scanner scr = new Scanner(System.in);
			int ch;

			do {

				displaymenu();
				ch = Integer.parseInt(scr.next());
				switch (ch) {
				case 1:
					addfiles();
					break;
				case 2:
					deletefiles();
					break;
				case 3:
					searchfiles();
					break;
				case 4:
					displaysfiles();
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("invaild opeartion");
					break;
				}

			} while (ch > 0);
		}

		private static void displaysfiles() {
			
			File[] files = new File(path).listFiles();
			
			if(files.length==0) {
				System.out.println("no files exit in the directory");
			}
			else {
				
				for(File f :files) {
					System.out.println(f.getName());
				}
			}
			
		}

		private static void searchfiles() {
			try {
				Scanner scr = new Scanner(System.in);
				String Filename;
				System.out.println("enter the file name to be searched :");
				Filename=scr.nextLine();
				
				File f = new File(Filename);
				
				if(f.exists()) {
					System.out.println("file is aviable"+Filename);
				}
				else {
					System.out.println("file does not exits...");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		private static void deletefiles() {
		
			try {
			Scanner scr = new Scanner(System.in);
			String filename;
			System.out.println("enter the file which u want to delete : ");
			filename = scr.nextLine();
			
			File f = new File(path+"\\"+filename);
			
			if(f.exists()) {
				f.delete();
				System.out.println("deleted successfully");
			}
			else {
				System.out.println("file does not exist..");
			}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		private static void addfiles() {
			
			try {
				
				Scanner scr = new Scanner(System.in);
				String filename;
				int linecount;
				System.out.println("enter the file name : ");
				filename= scr.nextLine();
				System.out.println("enter the how many line u want to write :");
				linecount = Integer.parseInt(scr.nextLine());
				
				FileWriter fw = new FileWriter(path +"\\"+filename);
				for(int i=1;i<=linecount;i++) {
					System.out.println("enter file data line :");
					fw.write(scr.nextLine()+"\n");
				}
				
				System.out.println("file created succesfully");
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		private static void displaymenu() {
			System.out.println("");
			System.out.println("\t1. add file");
			System.out.println("\t2. delete file");
			System.out.println("\t3. Search the file");
			System.out.println("\t4. Display all files");
			System.out.println("\t5.exit");
			System.out.println("");

		}
	}


