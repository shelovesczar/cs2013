package homework_one;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		getMenu();
	}

	public static void getMenu() {

		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to the PPM Editor");
		System.out.print("Please select an image to edit\n" + "Enter image name: ");

		PPMImage image = new PPMImage(input.nextLine());
		System.out.println("Image has been read!");

		int exit = 5;
		int selection = 0;

		do {

			System.out.print("What would you like to do the image?\n" + "1. grayscale\n" + "2. sepia\n"
					+ "3. negative\n" + "4. save altered image\n" + "5. quit\n"
							+ "Selection: ");
			
			selection = input.nextInt();

			
			if (!(input.hasNextInt())) {
				System.out.println("try again");
				selection = input.nextInt();
			}


			switch (selection) {

			case 1:
				image.grayscale();
				System.out.println("Grayscale has been applied");

				break;

			case 2:
				image.sepia();
				System.out.println("Sepia has been applied");

				break;

			case 3:
				image.negative();
				System.out.println("Negative has been applied");

				break;

			case 4:
				System.out.println("Enter new image name:");
				String imageName = input.next();
				image.checkFile(imageName);
				image.writeImage(imageName);
				System.out.println("New image succesfully made");
				break;

			case 5:
				System.exit(1);		
				System.out.println("Program has ended");
				break;
			}
		} while (selection != exit);


	}

}
