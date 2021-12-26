
import java.io.*;
import java.util.Scanner;

public class lockedMe {

	public static void main(String[] args) {
		boolean flag;
		boolean innerflag;
		String name;

		File ob1 = new File("C:\\Users\\Danish\\eclipse-workspace\\LockedME.com\\main");

		if (!ob1.exists()) {
			File folder = new File("C:\\Users\\Danish\\eclipse-workspace\\LockedME.com\\main");
			folder.mkdir();//CREATING MAIN FOLDER
			System.out.println("main folder created successfully!!");
		}
		else
		{
			System.out.println("main folder already exists");
		}

		//File ob = new File("C:\\Users\\Danish\\eclipse-workspace\\LockedME.com\\main\\");
		File array[] = ob1.listFiles();

		//ob.mkdir();
		Scanner scan = new Scanner(System.in);

		System.out.println("WELCOME TO ****Lockers Pvt. Ltd.*****");
		System.out.println("Developed By:Danish Ismail Khan");
		do {

			flag = false;

			System.out.println("\n1.RETRIEVE ALL FILES IN MAIN FOLDER AND DISPLAY IN ASCENDING ORDER ");// Initial Menu
			System.out.println("2.DISPLAY SECONDARY MENU & TAKE USER INPUT");//
			System.out.println("3.TERMINATE THE PROGRAM\n");//

			int choice = scan.nextInt();// user input

			switch (choice) {

			case 1:
				for (int i = 1; i < array.length; i++)
				{
					if (array[i].isFile()) {
						System.out.println("File is:" + array[i]);
					} else if (array[i].isDirectory()) {
						System.out.println("Directory is:" + array[i]);

					}
				}

				flag = true;
				break;

			case 2:

				do {
					System.out.println("\n1.Allow user to add file to main folder taking input of folder/file name ");
					System.out.println("2.Allow user to specify file/folder name to delete");
					System.out.println(
							"3.Allow user to specify file name and show respective files starting with the given name");
					System.out.println("4.Return to previous menu");
					System.out.println("5.TO TERMINATE PROGRAM");

					int choice2 = scan.nextInt();
					innerflag = false;
					switch (choice2) {

					case 1: // System.out.println("we are in case1 innerloop");
						System.out.println("Please Enter File/Folder Name To be Created:-");
						name = scan.next();

						File folder = new File("C:\\Users\\Danish\\eclipse-workspace\\LockedME.com\\main\\" + name);
						File file = new File(
								"C:\\Users\\Danish\\eclipse-workspace\\LockedME.com\\main\\" + name + ".txt");
						if ((!folder.exists()) && (!file.exists())) {

							try {
								folder.mkdir();
								file.createNewFile();
								System.out.println("File created successfully");
							} catch (IOException e) {

								e.printStackTrace();
							}

						} else {
							System.out.println("File/folder with this name already exists");
						}
						innerflag = true;
						break;

					case 2: // System.out.println("we are in case2 innerloop");
						name = scan.next();

						File file2 = new File("C:\\Users\\Danish\\eclipse-workspace\\LockedME.com\\main\\" + name);
						if (file2.exists()) {
							file2.delete();
							System.out.println("File with the following  name deleted successfully:  " + name);
						} else
							System.out.println("file not found with the name: " + name);

						innerflag = true;
						break;

					case 3:// System.out.println("we are in case3 innerloop");

						name = scan.next();
						File folder3 = new File("C:\\Users\\Danish\\eclipse-workspace\\LockedME.com\\main\\" + name);
						for (int i = 0; i < array.length; i++) {
							if (array[i].getName().startsWith(name))
								System.out.println(array[i]);
						}

						innerflag = true;
						break;

					case 4:
						System.out.println("INITIAL MENU");
						flag = true;
						break;

					case 5:
						System.out.println("PROGRAM TERMINATED SUCCESSFULLY");
						break;

					default:
						System.out.println("INPUT CORRECT VALUE\n\n");
						innerflag = true;
						break;

					}

				} while (innerflag);

				break;

			case 3:
				System.out.println("PROGRAM TERMINATED SUCCESSFULLY");
				break;

			default:

				System.out.println("INPUT CORRECT VALUE/RETRY\n\n");
				flag = true;
				break;

			}
		} while (flag);

	}

}

