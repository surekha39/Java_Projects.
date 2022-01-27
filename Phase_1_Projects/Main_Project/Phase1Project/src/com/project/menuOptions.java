package com.project;



	public class menuOptions {
		public static void printWelcomeScreen(String appName, String developerName) {
			String companyDetails = String.format("****************************************************\n"
					+ "** Welcome to %s.com. \n" + "** This application was developed by %s.\n"
					+ "*****************************************************\n", appName, developerName);
			String appFunction = "You can use this application to :-\n"
					+ "• Retrieve all file names in the \"MainMenu\" folder\n"
					+ "• Search, add, or delete files in \"MainMenu\" folder.\n"
					+ "\n**Please be careful to ensure the correct filename is provided for searching or deleting files.**\n";
			System.out.println(companyDetails);

			System.out.println(appFunction);
		}

		public static void displayMenu() {
			String menu = "\n\n****** Select any option number from below and press Enter ******\n\n"
					+ "1) Retrieve all files inside \"MainMenu\" folder\n" + "2) Display menu for File operations\n"
					+ "3) Exit program\n";
			System.out.println(menu);

		}

		public static void displayFileMenuOptions() {
			String fileMenu = "\n\n****** Select any option number from below and press Enter ******\n\n"
					+ "1) Add a file to \"MainMenu\" folder\n" + "2) Delete a file from \"main\" folder\n"
					+ "3) Search for a file from \"MainMenu\" folder\n" + "4) Show Previous Menu\n" + "5) Exit program\n";

			System.out.println(fileMenu);
		}

		public static void printWelcomeScreen1(String appName, String developerName) {
			// TODO Auto-generated method stub
			
		}

	




}
