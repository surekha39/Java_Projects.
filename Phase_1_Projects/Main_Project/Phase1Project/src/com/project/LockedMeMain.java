package com.project;

import com.project.menuOptions;

public class LockedMeMain {
		
		public static void main(String[] args) {
				
				// Create "main" folder if not present in current folder structure
				FileOperations.createMainFolderIfNotPresent1("MainMenu");
				
				menuOptions.printWelcomeScreen("Locker","Surekha");
				HandleOption.handleWelcomeScreenInput();
			}
		


}
