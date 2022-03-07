import java.io.File;

public class FileTraversal {

	public static void main(String args[]) {
		File file = new File("/Users/harshgandhi/Documents/CSC110/LabAssignments/");
		System.out.println(count(file));
	}

	public static File display(File directory) {
		if (directory.isDirectory()) {
			// get File object array
			// for all Files/Folders in folder
			File[] contentsInFolder = directory.listFiles();
			// remember, this is an array of File objects!
			for (int i = 0; i < contentsInFolder.length; i++) {
				// print out absolute path of each File object in folder
				System.out.println(contentsInFolder[i].getAbsolutePath());
			}
		} else {
			System.out.println("File not found");
		}
		return directory;
	}

	public static void traverse(File directory) {
		if (directory.isDirectory()) {
			// get File object array
			// for all Files/Folders in folder
			File[] contentsInFolder = directory.listFiles();
			// remember, this is an array of File objects!
			for (int i = 0; i < contentsInFolder.length; i++) {
				// print out absolute path of each File object in folder
				System.out.println(contentsInFolder[i].getAbsolutePath());
				if (contentsInFolder[i].isDirectory()) {
					traverse(contentsInFolder[i]);
				}
			}
		} else {
			System.out.println("File not found");
		}
	}

	public static int count(File directory) {
		int count = 0;
		if (directory.isDirectory()) {
			// get File object array
			// for all Files/Folders in folder
			File[] contentsInFolder = directory.listFiles();
			// remember, this is an array of File objects!
			for (int i = 0; i < contentsInFolder.length; i++) {
				// print out absolute path of each File object in folder
//				System.out.println(contentsInFolder[i].getAbsolutePath());
				if (directory.isDirectory()) {
					count++;
					count += count(contentsInFolder[i]);
				} else {
					System.out.println("File not found");
					return 0;
				}
			}
		}
		return count;

	}
}
