package TSS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TournamentScoringSystem {

	private static final int NO_OF_NORMAL_TEAM = 5;
	private static final int NO_OF_NORMAL_INDIVIDUAL = 20;
	private static final int NO_OF_TEAM_MEMBER = 5;
	private static final int NO_OF_NORMAL_EVENT = 4;

	private static int noOfRanks;
	private static int[] rankPoints;

	private static Scanner input;
	private static List<Integer> highestPointIndexes;

	public static void main(String[] args) {
		// Initialize a list to store the indices of teams with the highest points

		// Options for the type of tournament
		final String[] OPTIONNAMES = { "Normal Team", "Normal Individual", "Special Team", "Special Individual" };

		// Welcome message and instructions
		printWelcomeMessage();

		// Prompt the user to enter the number of ranks

		noOfRanks = promptForNumber(input,
				"Please enter the total number of ranks you want to assign, \nwith a minimum value of 1: ", 1, 10);

		printFormattedHeader("Number of Ranks SET SUCCESSFULLY");
		System.out.println("Total Ranks: " + noOfRanks);
		printFormattedFooter();

		rankPoints = new int[noOfRanks];

		// Prompt the user to enter points for each rank
		for (int i = 0; i < noOfRanks; i++) {

			rankPoints[i] = promptForNumber(input, "Enter points for rank " + (i + 1) + ": ", 1, 50);

		}

		printFormattedHeader("Points for each Rank SET SUCCESSFULLY");

		for (int i = 0; i < noOfRanks; i++) {
			System.out.println("Rank " + (i + 1) + ": " + rankPoints[i] + " points");
		}

		printFormattedFooter();

		System.out.println("!!!!! Other ranks will be set as 1 point !!!!!");

		printFormattedFooter();

		printFormattedHeader("Select an option");

		for (int i = 0; i < 4; i++) {
			System.out.println((i + 1) + ": for " + OPTIONNAMES[i]);
		}

		printFormattedFooter();

		System.out.println("The Normal Team and Normal Individual will play 5 events,"
				+ "\nwhile the Special Team and Special Individual can choose \nthe events to play.");

		printFormattedFooter();

		int choose = 0;

		// Prompt the user to select an option

		choose = promptForNumber(input, "Enter a number between 1 to 4: ", 1, 4);

		System.out.print("\n------------------------------------------------------------------");
		printFormattedHeader("You selected option " + choose + " -> " + OPTIONNAMES[choose - 1] + " <-");
		printFormattedFooter();

		switch (choose) {
		case 1: {
			// Initialize variables for team and event details

			String teamNames[];
			String teamMembers[];
			String eventNames[];
			int[][] teamPoints;

			System.out.println();
			printFormattedHeader("Number of Events SET SUCCESSFULLY");

			System.out.println("Total Number of Events: " + NO_OF_NORMAL_EVENT);

			printFormattedFooter();

			eventNames = new String[NO_OF_NORMAL_EVENT];

			System.out.println();

			printFormattedHeader("Number of Teams SET SUCCESSFULLY");

			System.out.println("Total Number of Teams: " + NO_OF_NORMAL_TEAM);

			printFormattedFooter();

			teamNames = new String[NO_OF_NORMAL_TEAM];

			int totalMember = 5 * NO_OF_NORMAL_TEAM;
			teamMembers = new String[totalMember];
			teamPoints = new int[NO_OF_NORMAL_TEAM][NO_OF_NORMAL_EVENT + 1];

			calculateTeam(NO_OF_NORMAL_EVENT, eventNames, NO_OF_NORMAL_TEAM, teamNames, teamMembers, teamPoints);
		}
			break;
		case 2:
		// Code for Normal Individual
		{

			String eventNames[] = new String[NO_OF_NORMAL_EVENT];
			String memberNames[] = new String[NO_OF_NORMAL_INDIVIDUAL];

			int pointsOfMembers[][] = new int[NO_OF_NORMAL_INDIVIDUAL][1 + NO_OF_NORMAL_EVENT];

			System.out.println();
			printFormattedHeader("Number of Events SET SUCCESSFULLY");

			System.out.println("Total Number of Events: " + NO_OF_NORMAL_EVENT);

			printFormattedFooter();

			printFormattedHeader("Number of Members SET SUCCESSFULLY");

			System.out.println("Total Number of Members: " + NO_OF_NORMAL_INDIVIDUAL);

			printFormattedFooter();

			calculateIndividual(NO_OF_NORMAL_EVENT, eventNames, NO_OF_NORMAL_INDIVIDUAL, memberNames, pointsOfMembers);

		}
			break;
		case 3:
		// Code for Special Team
		{
			int minEvent = 1, minTeam = 1;
			int maxEvent = 5, maxTeam = 5;
			int noOfTeams = 0;
			int noOfEvents = 0;

			String teamNames[];
			String teamMembers[];
			String eventNames[];
			int[][] teamPoints;

			// Prompt the user to enter the number of events
			noOfEvents = promptForNumber(input, "Enter the total number of events (min 1 and max 5): ", minEvent,
					maxEvent);

			System.out.println();
			printFormattedHeader("Number of Events SET SUCCESSFULLY");

			System.out.println("Total Number of Events: " + noOfEvents);

			printFormattedFooter();
			eventNames = new String[noOfEvents];

			printFormattedFooter();

			// Prompt the user to enter the number of teams
			noOfTeams = promptForNumber(input, "Enter the total number of teams (min 1 and max 5): ", minTeam, maxTeam);

			printFormattedHeader("Number of Teams SET SUCCESSFULLY");

			System.out.println("Total Number of Teams: " + noOfTeams);

			printFormattedFooter();

			teamNames = new String[noOfTeams];
			int totalMember = 5 * noOfTeams;
			teamMembers = new String[totalMember];
			teamPoints = new int[noOfTeams][noOfEvents + 1];

			calculateTeam(noOfEvents, eventNames, noOfTeams, teamNames, teamMembers, teamPoints);

		}
			break;
		case 4:
		// Code for Special Individual
		{
			int minEvent = 1;
			int maxEvent = 5;
			int minMember = 5;
			int maxMember = 20;
			int noOfEvents = 0;
			int noOfMembers = 0;

			String[] eventNames;
			String[] memberNames;
			int pointsOfMembers[][];

			// Prompt the user to enter the number of events
			noOfEvents = promptForNumber(input, "Enter the total number of events (min 1 and max 5): ", minEvent,
					maxEvent);

			System.out.println();
			printFormattedFooter();

			printFormattedHeader("Number of Events SET SUCCESSFULLY");

			System.out.println("Total Number of Events: " + noOfEvents);

			printFormattedFooter();
			// Prompt the user to enter the number of teams
			noOfMembers = promptForNumber(input, "Enter the total number of member (min 5 and max 20): ", minMember,
					maxMember);
			printFormattedFooter();

			pointsOfMembers = new int[noOfMembers][1 + noOfEvents];
			memberNames = new String[noOfMembers];

			printFormattedHeader("Member Number SET SUCCESSFULLY");

			System.out.println("Total members : " + noOfMembers);

			printFormattedFooter();

			eventNames = new String[noOfEvents];

			calculateIndividual(noOfEvents, eventNames, noOfMembers, memberNames, pointsOfMembers);

		}
			break;
		}

		System.out.println("\n!!!!! Program FINISHED. See you soon !!!!!");
	}

	private static void calculateTeam(int noOfEvents, String[] eventNames, int noOfTeams, String[] teamNames,
			String[] teamMembers, int[][] teamPoints) {
		highestPointIndexes = new ArrayList<Integer>();

		// Prompt the user to enter the name of each event
		for (int i = 0; i < noOfEvents; i++) {

			System.out.print("Enter the name of event " + (i + 1) + ": ");
			eventNames[i] = input.nextLine();
		}

		printFormattedHeader("Events Name SET SUCCESSFULLY");

		for (int i = 0; i < noOfEvents; i++) {

			System.out.println("Event " + (i + 1) + " name: " + eventNames[i]);
		}

		int index = 0;

		// Prompt the user to enter the names of teams and their members
		for (int i = 0; i < noOfTeams; i++) {

			System.out.print("Enter the name of Team " + (i + 1) + ": ");
			teamNames[i] = input.nextLine();

			System.out.println();

			for (int ii = 0; ii < NO_OF_TEAM_MEMBER; ii++) {

				System.out.print("Enter " + teamNames[i] + " member (" + (ii + 1) + ") name: ");
				teamMembers[index++] = input.nextLine();
			}

			printFormattedHashFooter();
		}

		printFormattedHeader("Teams and Members Name SET SUCCESSFULLY");

		for (int i = 0; i < noOfTeams; i++) {

			System.out.println("\nTeam " + (i + 1) + " name: " + teamNames[i]);

			for (int ii = 0; ii < 5; ii++) {

				System.out.println("Member " + (ii + 1) + " name: " + teamMembers[index++]);
			}

			printFormattedHashFooter();
		}

		printFormattedFooter();

		// Prompt the user to enter the rank for each team in each event
		for (int i = 0; i < noOfTeams; i++) {

			System.out.println("Enter rank for Team -> " + teamNames[i] + " <-");

			int inputRank = 0;
			int totalRankPoints = 0;

			for (int ii = 0; ii < noOfEvents; ii++) {

				inputRank = promptForNumber(null, "Rank for " + eventNames[ii] + " event: ", 0, 50);

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

			printFormattedHashFooter();
		}

		printFormattedHeader("Rank of Teams SET SUCCESSFULLY");

		index = 0;
		for (int i = 0; i < noOfTeams; i++) {

			System.out.println("Team (" + (i + 1) + ") name: " + teamNames[i] + "\n");

			for (int ii = 0; ii < noOfEvents; ii++) {

				System.out.println(eventNames[ii] + " event: " + teamPoints[i][ii] + " points");

				if (ii == noOfEvents - 1) {

					System.out.println("Total Points: " + teamPoints[i][ii + 1]);
				}
			}

			printFormattedHashFooter();
		}

		printFormattedFooter();

		printFormattedHeader("FINAL RESULT");

		// Determine the highest points for each event and the total points
		for (int i = 0; i < noOfEvents + 1; i++) {

			if (i < noOfEvents)

				System.out.println("\nFinding the max points of " + eventNames[i] + " event.");
			else

				System.out.println("\nFinding the total max points.");

			int max = teamPoints[0][i];

			for (int ii = 1; ii < noOfTeams; ii++) {

				if (max < teamPoints[ii][i]) {

					max = teamPoints[ii][i];

				}
			}

			if (i < noOfEvents)

				System.out.println("Max point of " + eventNames[i] + " event = " + max);
			else

				System.out.println("The total max points: " + max);

			printFormattedFooter();

			// save the indexs of team name with the same points
			for (int ii = 0; ii < noOfTeams; ii++) {

				if (max == teamPoints[ii][i])
					highestPointIndexes.add(ii);
			}

			if (i < noOfEvents) {

				printFormattedHeader("Winner of " + eventNames[i] + " event");

				for (int highest : highestPointIndexes) {

					System.out.println("Team: " + teamNames[highest]);

				}

				printFormattedFooter();
			} else {

				printFormattedHeader("Highest Total Points Team(s)");

				for (int highest : highestPointIndexes) {

					System.out.println("Team: " + teamNames[highest]);
				}
			}

			highestPointIndexes.clear();
		}
		printFormattedFooter();
	}

	private static void calculateIndividual(int noOfEvents, String[] eventNames, int noOfMembers, String[] memberNames,
			int[][] pointsOfMembers) {

		highestPointIndexes = new ArrayList<Integer>();
		// Prompt the user to enter the name of each event
		for (int i = 0; i < noOfEvents; i++) {

			System.out.print("Enter the name of event " + (i + 1) + ": ");
			eventNames[i] = input.nextLine();
		}
		printFormattedFooter();

		printFormattedHeader("Events Name SET SUCCESSFULLY");

		for (int i = 0; i < noOfEvents; i++) {

			System.out.println("Event " + (i + 1) + " name: " + eventNames[i]);
		}
		printFormattedFooter();

		for (int i = 0; i < noOfMembers; i++) {

			System.out.print("Enter name of member(" + (i + 1) + ") :");
			memberNames[i] = input.nextLine();
		}
		printFormattedFooter();

		printFormattedHeader("Member names SET SUCCESSFULLY");

		for (int i = 0; i < noOfMembers; i++) {
			System.out.println("Member (" + (i + 1) + ") name : " + memberNames[i]);
		}

		printFormattedFooter();

		// rank for each member

		for (int i = 0; i < noOfMembers; i++) {
			System.out.println("Enter rank for member : " + memberNames[i]);

			int inputRank = 0, totalRankPoints = 0;

			for (int ii = 0; ii < noOfEvents; ii++) {

				inputRank = promptForNumber(input,
						"Rank for " + eventNames[ii] + " event (min 0 and max " + noOfMembers + "): ", 0, noOfMembers);

				if (inputRank <= noOfRanks) {

					totalRankPoints += rankPoints[inputRank - 1];
					pointsOfMembers[i][ii] = rankPoints[inputRank - 1];

				} else {

					totalRankPoints += 1;
					pointsOfMembers[i][ii] = 1;

				}

				if (ii == noOfEvents - 1) {

					pointsOfMembers[i][ii + 1] = totalRankPoints;
				}

			}

			printFormattedHashFooter();
		}

		for (int i = 0; i < noOfMembers; i++) {

			System.out.println("Member (" + (i + 1) + ") name: " + memberNames[i] + "\n");

			for (int ii = 0; ii < noOfEvents; ii++) {

				System.out.println(eventNames[ii] + " event: " + pointsOfMembers[i][ii] + " points");

				if (ii == noOfEvents - 1) {

					System.out.println("Total Points: " + pointsOfMembers[i][ii + 1]);
				}
			}

			printFormattedHashFooter();
		}

		printFormattedFooter();

		System.out.println();
		printFormattedFooter();
		printFormattedHeader("FINAL RESULT");

		// Determine the highest points for each event and the total points
		for (int i = 0; i < noOfEvents + 1; i++) {

			if (i < noOfEvents)

				System.out.println("\nFinding the max points of " + eventNames[i] + " event.");
			else

				System.out.println("Finding the total max points.");

			int max = pointsOfMembers[0][i];

			for (int ii = 1; ii < noOfMembers; ii++) {

				if (max < pointsOfMembers[ii][i]) {

					max = pointsOfMembers[ii][i];

				}
			}

			if (i < noOfEvents)

				System.out.println("Max point of " + eventNames[i] + " event = " + max);
			else

				System.out.println("The total max points: " + max);

			printFormattedFooter();

			// save the indexs of team name with the same points
			for (int ii = 0; ii < noOfMembers; ii++) {

				if (max == pointsOfMembers[ii][i])
					highestPointIndexes.add(ii);
			}

			if (i < noOfEvents) {

				System.out.println("Winner of " + eventNames[i] + " event.");

				for (int highest : highestPointIndexes) {

					System.out.println("Member: " + memberNames[highest]);

				}

				printFormattedFooter();
			} else {

				System.out.println("Highest Total Points Member(s) ...");

				for (int highest : highestPointIndexes) {

					System.out.println("Member: " + memberNames[highest]);
				}
			}

			highestPointIndexes.clear();
		}
		printFormattedFooter();

	}

	public static void printWelcomeMessage() {

		printFormattedHeader("Welcome to the Torunament Scoring System");

		System.out.println("This version of the system will only display the HIGHEST POINTS");
		System.out.println("of the winner for Team or Individual player.");

		printFormattedFooter();

		printFormattedHeader("Every input for numbers must be in INTEGER FORMAT");
		System.out.println();
	}

	private static void printFormattedHeader(String text) {

		System.out.println();
		int totalLength = 66;
		int dashCount = 4;

		int textLength = text.length();
		int remainingLength = totalLength - 2 * dashCount - textLength;
		int padding = remainingLength / 2;

		int paddingRight = padding + (remainingLength % 2);

		System.out.printf("%s%s%s%s%s\n", "-".repeat(dashCount), " ".repeat(padding), text, " ".repeat(paddingRight),
				"-".repeat(dashCount));

		System.out.println("-".repeat(totalLength));
	}

	private static void printFormattedFooter() {
		int totalLength = 66;
		System.out.println("-".repeat(totalLength));
	}

	private static void printFormattedHashFooter() {
		String str = "##";
		int totalLength = 66;
		int tabLength = 8; // Typically, a tab is 8 spaces
		int strLength = str.length();

		int numPairs = totalLength / (strLength + tabLength);

		for (int i = 0; i < numPairs; i++) {
			System.out.print(str + "\t");
		}

		// Print remaining ## to reach total length if needed
		int remainingLength = totalLength - (numPairs * (strLength + tabLength));
		if (remainingLength >= strLength) {
			System.out.print(str);
		}

		System.out.println();
	}

	public static int promptForNumber(Scanner input, String message, int minValue, int maxValue) {
		int num;
		do {
			System.out.print(message);

			String temp = input.nextLine();

			if (isValidNumber(temp)) {

				num = Integer.parseInt(temp);

				if (num >= minValue && num <= maxValue) {
					return num;
				} else {
					System.out.println("\n!!! Number must be between " + minValue + " and " + maxValue + " !!!");
				}
			} else {
				System.out.println("\n!!! Invalid input. Please enter an integer !!!");
			}
		} while (true);
	}

	// Method to check if a string is a valid integer
	private static boolean isValidNumber(String st) {
		try {
			Integer.parseInt(st);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
