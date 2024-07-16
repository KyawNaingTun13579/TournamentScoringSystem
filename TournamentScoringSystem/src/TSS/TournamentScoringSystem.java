package TSS;

import java.util.List;
import java.util.Scanner;

public class TournamentScoringSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> highestPoints;
		Scanner input = new Scanner(System.in);

		int noOfRanks = 0;
		int[] rankPoints;

		System.out.println("\n\t   Welcome to Tournament Scoring System\n");
		System.out.println("--------------------------------------------------------------");
		System.out.println("This version of system will only display the HIGHEST POINTS of");
		System.out.println("winner for Team or Individual player name.");
		System.out.println("--------------------------------------------------------------");
		System.out.println("Every input for Number must be in INTEGER FORMAT");
		System.out.println("--------------------------------------------------------------");

		do {
			boolean flag = false;
			do {
				input = new Scanner(System.in);

				System.out.print("\nPlease enter the total number of ranks you want to assign, "
						+ "with a minimum value of 1 : ");
				String temp = input.nextLine();

				flag = isValidNumber(temp);

				if (flag)
					noOfRanks = Integer.parseInt(temp);

			} while (!flag);

		} while (noOfRanks < 1);

		System.out.println("\n----- Number of Ranks SET SUCCESSFULLY -----");
		rankPoints = new int[noOfRanks];

		for (int i = 0; i < noOfRanks; i++) {

			boolean flag = false;

			do {
				input = new Scanner(System.in);

				System.out.print("Enter points of rank " + (i + 1) + " : ");
				String temp = input.nextLine();

				flag = isValidNumber(temp);

				if (flag)
					rankPoints[i] = Integer.parseInt(temp);

			} while (!flag);

		}

		System.out.println("\n----- Points of each Rank SET SUCCESSFULLY -----");
		for (int i = 0; i < noOfRanks; i++) {
			System.out.println("Rank " + (i + 1) + " : " + rankPoints[i] + " points");
		}
		System.out.println("!!!!! Other rank will set as 1 point !!!!!\n");

		System.out.println("\n!!!!! Program FINISHED. See you soon. !!!!!");
	}

	public static boolean isValidNumber(String st) {
		try {
			Integer.parseInt(st);
			return true;
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return false;
		}
	}
}