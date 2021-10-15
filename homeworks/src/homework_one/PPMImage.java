package homework_one;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PPMImage {

	/**
	 * This is a class that represents a PPMImage class. The class needs a '.ppm' to
	 * read and to write
	 * 
	 * @author Cesar Hernandez, 303578319
	 * https://calstatela.instructuremedia.com/embed/7c667b30-d642-42ad-b838-0ff6f367fc64"
	 */

	private String magicNumber;
	private int width;
	private int height;
	private int maxColorValue;
	private char[] raster = new char[getWidth() * getHeight() * 3];

	/**
	 * 
	 * The constructor takes a imageFile
	 * 
	 * @param imageFileName
	 */

	public PPMImage(String imageFileName) {
		
		checkFile(imageFileName);
		readImage(imageFileName);

	}
	
	

	private void readImage(String fileName) {

		File inFile = new File(fileName);

		try {
			BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(inFile));
			Scanner scan = new Scanner(inStream);

			this.magicNumber = scan.nextLine();

			this.width = scan.nextInt();

			this.height = scan.nextInt();

			scan.nextLine();
			this.maxColorValue = scan.nextInt();
			scan.nextLine();

			this.raster = new char[getWidth() * getHeight() * 3];

			StringBuilder strBuilder = new StringBuilder();

			while (scan.hasNext()) {

				strBuilder.append(scan.next());
			}

			// Adding values to raster @ specific index
			for (int i = 0; i < strBuilder.length(); i++) {
				raster[i] = strBuilder.charAt(i);
			}

			inStream.close();
			scan.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void writeImage(String outputFileName) {

		String suffix = ".ppm";

		if (!(outputFileName.endsWith(suffix))) {

			System.out.println("File is not a .ppm");

			Scanner input = new Scanner(System.in);

			System.out.print("Enter a new file name: ");

			outputFileName = input.next();

			writeImage(outputFileName);

			input.close();

		}

		try {
			DataOutputStream outStream = new DataOutputStream(new FileOutputStream(outputFileName));

			outStream.write(new String(getMagicNumber().concat("\n")).getBytes());
			outStream.write(new String(getWidth() + " " + getHeight() + "\n").getBytes());
			outStream.write(new String(getMaxColorValue() + "\n").getBytes());
			
			for (char values: raster) {
				outStream.write(values);
			}

			outStream.flush();
			outStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public char[] grayscale() {

		int R = 0; // R is position 1
		for (int i = R; i < getRaster().length; i++) {
			raster[i] = raster[(int) ((raster[i] * 0.299) + (raster[i] * .587) + (raster[i] * .114))];
			if (raster[i] > 255) {
				raster[i] = 255;
			}
			R = i + 2; // R will be every third iteration
		}

		int G = 1; // G is position 2
		for (int i = G; i < getRaster().length; i++) {
			raster[i] = raster[(int) ((raster[i] * 0.299) + (raster[i] * .587) + (raster[i] * .114))];
			if (raster[i] > 255) {
				raster[i] = 255;
			}
			G = i + 2; // G will be every third iteration
		}

		int B = 2; // B is position 3
		for (int i = B; i < getRaster().length; i++) {
			raster[i] = raster[(int) ((raster[i] * 0.299) + (raster[i] * .587) + (raster[i] * .114))];
			if (raster[i] > 255) {
				raster[i] = 255;
			}
			B = i + 2; // B will be every third iteration
		}
		return raster;

	}

	public char[] sepia() {

		int R = 0; // R is position 1
		for (int i = R; i < getRaster().length; i++) {
			raster[i] = raster[(int) ((raster[i] * 0.393) + (raster[i] * .769) + (raster[i] * .189))];
			if (raster[i] > 255) {
				raster[i] = 255;
			}
			R = i + 2; // R will be every third iteration
		}

		int G = 1; // G is position 2
		for (int i = G; i < getRaster().length; i++) {
			raster[i] = raster[(int) ((raster[i] * 0.349) + (raster[i] * .686) + (raster[i] * .168))];
			if (raster[i] > 255) {
				raster[i] = 255;
			}
			G = i + 2; // G will be every third iteration
		}

		int B = 2; // B is position 3
		for (int i = B; i < getRaster().length; i++) {
			raster[i] = raster[(int) ((raster[i] * 0.272) + (raster[i] * .534) + (raster[i] * .131))];
			if (raster[i] > 255) {
				raster[i] = 255;
			}
			B = i + 2; // B will be every third iteration
		}
		return raster;

	}

	public char[] negative() {

		int R = 0; // R is position 1
		for (int i = R; i < getRaster().length; i++) {
			raster[i] = raster[(int) (255 - (raster[i]))];
			if (raster[i] > 255) {
				raster[i] = 255;
			}
			R = i + 2; // R will be every triplet 
		}

		int G = 1; // G is position 2
		for (int i = G; i < getRaster().length; i++) {
			raster[i] = raster[(int) (255 - (raster[i]))];
			if (raster[i] > 255) {
				raster[i] = 255;
			}
			G = i + 2; // G will be every triplet 
		}

		int B = 2; // B is position 3
		for (int i = B; i < getRaster().length; i++) {
			raster[i] = raster[(int) (255 - (raster[i]))];
			if (raster[i] > 255) {
				raster[i] = 255;
			}
			B = i + 2; // B will be every triplet 
		}
		return raster;

	}

	public void setMagicNumber(String magicNumber) {
		this.magicNumber = magicNumber;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setMaxColorValue(int maxColorValue) {
		this.maxColorValue = maxColorValue;
	}

	public String getMagicNumber() {
		return magicNumber;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getMaxColorValue() {
		return maxColorValue;
	}

	public char[] getRaster() {
		return raster;
	}

	public void setRaster(char[] raster) {
		this.raster = raster;
	}
	
	public String checkFile(String fileName) {
		String suffix = ".ppm";

		if (!(fileName.endsWith(suffix))) {

			System.out.println("File is not a .ppm");

			Scanner input = new Scanner(System.in);

			System.out.print("Enter a new file name: ");

			fileName = input.next();

			checkFile(fileName);

			input.close();

		}
		
		return fileName;
	}

}
