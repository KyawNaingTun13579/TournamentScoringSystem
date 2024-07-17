package TSS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TournamentScoringSystem {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		// Initialize a list to store the indices of teams with the highest points
		List<Integer> highestPointIndexes = new ArrayList<Integer>();

		Scanner input = new Scanner(System.in);
		boolean flag = false;

		// Options for the type of tournament
		final String[] OPTIONNAMES = { "Normal Team", "Normal Individual", "Special Team", "Special Individual" };

		int noOfRanks = 0;
		int[] rankPoints;

		// Welcome message and instructions
		System.out.println("\n\t   Welcome to the Tournament Scoring System\n");
		System.out.println("--------------------------------------------------------------");
		System.out.println("This version of the system will only display the HIGHEST POINTS");
		System.out.println("of the winner for Team or Individual player.");
		System.out.println("--------------------------------------------------------------");
		System.out.println("Every input for numbers must be in INTEGER FORMAT.");
		System.out.println("--------------------------------------------------------------");

		// Prompt the user to enter the number of ranks
		do {
			System.out.print(
					"\nPlease enter the total number of ranks you want to assign, \n" + "with a minimum value of 1: ");
			String temp = input.nextLine();

			flag = isValidNumber(temp);

			if (flag)
				noOfRanks = Integer.parseInt(temp);

		} while (!flag || noOfRanks < 1);

		System.out.println("\n----- Number of Ranks SET SUCCESSFULLY -----");
		System.out.println("--------------------------------------------------------------");
		System.out.println("Total Ranks: " + noOfRanks);
		System.out.println("--------------------------------------------------------------\n");

		rankPoints = new int[noOfRanks];

		// Prompt the user to enter points for each rank
		for (int i = 0; i < noOfRanks; i++) {

			flag = false;

			do {

				System.out.print("Enter points for rank " + (i + 1) + ": ");
				String temp = input.nextLine();

				flag = isValidNumber(temp);

				if (flag)
					rankPoints[i] = Integer.parseInt(temp);

			} while (!flag);
		}

		System.out.println("\n----- Points for each Rank SET SUCCESSFULLY -----");
		System.out.println("--------------------------------------------------------------");

		for (int i = 0; i < noOfRanks; i++) {
			System.out.println("Rank " + (i + 1) + ": " + rankPoints[i] + " points");
		}

		System.out.println("--------------------------------------------------------------\n");

		System.out.println("!!!!! Other ranks will be set as 1 point !!!!!\n");

		System.out.println("--------------------------------------------------------------");
		System.out.println("Select an option:");
		System.out.println("--------------------------------------------------------------");

		for (int i = 0; i < 4; i++) {
			System.out.println((i + 1) + ": for " + OPTIONNAMES[i]);
		}

		System.out.println("--------------------------------------------------------------\n");

		int choose = 0;
		flag = false;

		// Prompt the user to select an option
		do {
			System.out.print("Enter a number between 1 to 4: ");
			String tempInput = input.nextLine();

			flag = isValidNumber(tempInput);

			if (flag) {

				choose = Integer.parseInt(tempInput);

				if (choose < 1 || choose > 4)
					flag = false;
			}

		} while (!flag);

		System.out.println("--------------------------------------------------------------");
		System.out.println("You selected option " + choose + " -> " + OPTIONNAMES[choose - 1] + " <-");
		System.out.println("--------------------------------------------------------------\n");

		switch (choose) {
		case 1:
			// Initialize variables for team and event details
			int teamMember = 5;
			int minEvent = 1, minTeam = 1;
			int maxEvent = 5, maxTeam = 5;
			int noOfTeams = 0;
			int noOfEvents = 0;

			String teamNames[];
			String teamMembers[];
			String eventNames[];
			int[][] teamPoints;

			flag = false;

			// Prompt the user to enter the number of events
			do {

				System.out.print("Enter the total number of events (min 1 and max 5): ");
				String temp = input.nextLine();

				flag = isValidNumber(temp);

				if (flag) {
					noOfEvents = Integer.parseInt(temp);
				}

			} while (!flag || noOfEvents < minEvent || noOfEvents > maxEvent);

			System.out.println("\n----- Number of Events SET SUCCESSFULLY -----");
			System.out.println("--------------------------------------------------------------");
			System.out.println("Total Number of Events: " + noOfEvents);
			System.out.println("--------------------------------------------------------------\n");

			eventNames = new String[noOfEvents];

			// Prompt the user to enter the name of each event
			for (int i = 0; i < noOfEvents; i++) {

				System.out.print("Enter the name of event " + (i + 1) + ": ");
				eventNames[i] = input.nextLine();
			}

			System.out.println("\n----- Events Name SET SUCCESSFULLY -----");
			System.out.println("--------------------------------------------------------------");

			for (int i = 0; i < noOfEvents; i++) {

				System.out.println("Event " + (i + 1) + " name: " + eventNames[i]);
			}
			System.out.println("--------------------------------------------------------------\n");

			flag = false;

			// Prompt the user to enter the number of teams
			do {

				System.out.print("Enter the total number of teams (min 1 and max 5): ");
				String temp = input.nextLine();

				flag = isValidNumber(temp);

				if (flag) {
					noOfTeams = Integer.parseInt(temp);

				}
			} while (!flag || noOfTeams < minTeam || noOfTeams > maxTeam);

			System.out.println("\n----- Number of Teams SET SUCCESSFULLY -----");
			System.out.println("--------------------------------------------------------------");
			System.out.println("Total Number of Teams: " + noOfTeams);
			System.out.println("--------------------------------------------------------------\n");

			teamNames = new String[noOfTeams];

			int totalMember = 5 * noOfTeams;
			teamMembers = new String[totalMember];
			teamPoints = new int[noOfTeams][noOfEvents + 1];

			int index = 0;

			// Prompt the user to enter the names of teams and their members
			for (int i = 0; i < noOfTeams; i++) {

				System.out.print("Enter the name of Team " + (i + 1) + ": ");
				teamNames[i] = input.nextLine();

				System.out.println();

				for (int ii = 0; ii < teamMember; ii++) {

					System.out.print("Enter " + teamNames[i] + " member (" + (ii + 1) + ") name: ");
					teamMembers[index++] = input.nextLine();
				}

				System.out.println("##\t##\t##\t##\t##\t##\t##\t##");
			}

			index = 0;

			System.out.println("\n----- Teams and Members Name SET SUCCESSFULLY -----");
			System.out.println("--------------------------------------------------------------");

			for (int i = 0; i < noOfTeams; i++) {

				System.out.println("\nTeam " + (i + 1) + " name: " + teamNames[i]);

				for (int ii = 0; ii < 5; ii++) {

					System.out.println("Member " + (ii + 1) + " name: " + teamMembers[index++]);
				}

				System.out.println("##\t##\t##\t##\t##\t##\t##\t##");
			}

			System.out.println("--------------------------------------------------------------\n");

			flag = false;

			// Prompt the user to enter the rank for each team in each event
			for (int i = 0; i < noOfTeams; i++) {

				System.out.println("Enter rank for Team -> " + teamNames[i] + " <-");

				int inputRank = 0;
				int totalRankPoints = 0;

				for (int ii = 0; ii < noOfEvents; ii++) {
					do {

						System.out.print("Rank for " + eventNames[ii] + " event: ");
						String temp = input.nextLine();

						flag = isValidNumber(temp);

						if (flag) {
							inputRank = Integer.parseInt(temp);

						}
					} while (!flag || inputRank <= 0);

					if (inputRank <= noOfRanks) {

						totalRankPoints += rankPoints[inputRank - 1];
						teamPoints[i][ii] = rankPoints[inputRank - 1];

					} else {

						totalRankPoints += 1;
						teamPoints[i][ii] = 1;

					}

					if (ii == noOfEvents - 1) {

						teamPoints[i][ii + 1] = totalRankPoints;
					}
				}

				System.out.println("##\t##\t##\t##\t##\t##\t##\t##");
			}

			System.out.println("\n----- Rank of Teams SET SUCCESSFULLY -----");
			System.out.println("--------------------------------------------------------------");

			index = 0;
			for (int i = 0; i < noOfTeams; i++) {

				System.out.println("Team (" + (i + 1) + ") name: " + teamNames[i] + "\n");

				for (int ii = 0; ii < noOfEvents; ii++) {

					System.out.println(eventNames[ii] + " event: " + teamPoints[i][ii] + " points");

					if (ii == noOfEvents - 1) {

						System.out.println("Total Points: " + teamPoints[i][ii + 1]);
					}
				}

				System.out.println("##\t##\t##\t##\t##\t##\t##\t##");
			}

			System.out.println("--------------------------------------------------------------\n");

			System.out.println("\n----- FINAL RESULT -----");
			System.out.println("--------------------------------------------------------------");

			// Determine the highest points for each event and the total points
			for (int i = 0; i < noOfEvents + 1; i++) {

				if (i < noOfEvents)

					System.out.println("\nFinding the max point of " + eventNames[i] + " event.");
				else

					System.out.println("Finding the max point of total points.");

				int max = teamPoints[0][i];

				for (int ii = 1; ii < noOfTeams; ii++) {

					if (max < teamPoints[ii][i]) {

						max = teamPoints[ii][i];

					}
				}

				if (i < noOfEvents)

					System.out.println("Max point of " + eventNames[i] + " event = " + max);
				else

					System.out.println("Max point of total points: " + max);

				System.out.println("--------------------------------------------------------------\n");

				for (int ii = 0; ii < noOfTeams; ii++) {

					if (max == teamPoints[ii][i])
						highestPointIndexes.add(ii);
				}

				if (i < noOfEvents) {

					System.out.println("Winner of " + eventNames[i] + " event.");

					for (int highest : highestPointIndexes) {

						System.out.println("Team: " + teamNames[highest]);

					}

					System.out.println("--------------------------------------------------------------");
				} else {

					System.out.println("Highest Total Points Team(s) ...");

					for (int highest : highestPointIndexes) {

						System.out.println("Team: " + teamNames[highest]);
					}
				}

				highestPointIndexes.clear();
			}
			System.out.println("--------------------------------------------------------------\n");

			break;
		case 2:
			// Code for Normal Individual
			break;
		case 3:
			// Code for Special Team
			break;
		case 4:
			// Code for Special Individual
			break;
		}

		System.out.println("\n!!!!! Program FINISHED. See you soon !!!!!");
	}

	// Method to check if a string is a valid integer
	public static boolean isValidNumber(String st) {
		try {
			Integer.parseInt(st);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
