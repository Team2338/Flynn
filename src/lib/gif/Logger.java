package lib.gif;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
	
	// TODO: Create one logger object so that you don't have to flush and close every time
	private static FileWriter writer;
	
	/**
	 * Appends a String to the given log file and terminates the line.
	 * This method handles any IOException that may be thrown.
	 * 
	 * @param message The String to append to the file
	 * @param file The File to append to
	 * @return True if the method successfully appends the message,
	 * 			false if an IOException is thrown.
	 */
	public static final boolean println(String message, File file) {
		return print(message + "\n", file);
	}
	
	/**
	 * Appends a String to the given log file.
	 * This method handles any IOException that may be thrown.
	 * 
	 * @param message The String to append to the file
	 * @param file The File to append to
	 * @return True if the method successfully appends the message,
	 * 			false if an IOException is thrown.
	 */
	public static final boolean print(String message, File file) {
		System.out.print(message);
		try {
			writer = new FileWriter(file, true);
			writer.write(message);
			writer.flush();
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
