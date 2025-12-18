import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * --- Day 5: Cafeteria ---
 * <p>
 * As the forklifts break through the wall, the Elves are delighted to
 * discover that there was a cafeteria on the other side after all.
 * <p>
 * You can hear a commotion coming from the kitchen. "At this rate, we won't
 * have any time left to put the wreaths up in the dining hall!" Resolute in
 * your quest, you investigate.
 * <p>
 * "If only we hadn't switched to the new inventory management system right
 * before Christmas!" another Elf exclaims. You ask what's going on.
 * <p>
 * The Elves in the kitchen explain the situation: because of their
 * complicated new inventory management system, they can't figure out which of
 * their ingredients are fresh and which are spoiled. When you ask how it
 * works, they give you a copy of their database (your puzzle input).
 * <p>
 * The database operates on ingredient IDs. It consists of a list of fresh
 * ingredient ID ranges, a blank line, and a list of available ingredient IDs.
 * For example:
 * <p>
 * 3-5
 * 10-14
 * 16-20
 * 12-18
 * <p>
 * 1
 * 5
 * 8
 * 11
 * 17
 * 32
 * <p>
 * The fresh ID ranges are inclusive: the range 3-5 means that ingredient IDs
 * 3, 4, and 5 are all fresh. The ranges can also overlap; an ingredient ID is
 * fresh if it is in any range.
 * <p>
 * The Elves are trying to determine which of the available ingredient IDs are
 * fresh. In this example, this is done as follows:
 * <p>
 *    - Ingredient ID 1 is spoiled because it does not fall into any range.
 *    - Ingredient ID 5 is fresh because it falls into range 3-5.
 *    - Ingredient ID 8 is spoiled.
 *    - Ingredient ID 11 is fresh because it falls into range 10-14.
 *    - Ingredient ID 17 is fresh because it falls into range 16-20 as well as
 *      range 12-18.
 *    - Ingredient ID 32 is spoiled.
 * <p>
 * So, in this example, 3 of the available ingredient IDs are fresh.
 * <p>
 * Process the database file from the new inventory management system. How
 * many of the available ingredient IDs are fresh?
 * <p>
 *
 * Your puzzle answer was 773.
 * <p>
 * The first half of this puzzle is complete! It provides one gold star: *
 * <p>
 * --- Part Two ---
 * <p>
 * The Elves start bringing their spoiled inventory to the trash chute at the
 * back of the kitchen.
 * <p>
 * So that they can stop bugging you when they get new inventory, the Elves
 * would like to know all of the IDs that the fresh ingredient ID ranges
 * consider to be fresh. An ingredient ID is still considered fresh if it is
 * in any range.
 * <p>
 * Now, the second section of the database (the available ingredient IDs) is
 * irrelevant. Here are the fresh ingredient ID ranges from the above example:
 * <p>
 * 3-5
 * 10-14
 * 16-20
 * 12-18
 * <p>
 * The ingredient IDs that these ranges consider to be fresh are 3, 4, 5, 10,
 * 11, 12, 13, 14, 15, 16, 17, 18, 19, and 20. So, in this example, the fresh
 * ingredient ID ranges consider a total of 14 ingredient IDs to be fresh.
 * <p>
 * Process the database file again. How many ingredient IDs are considered to
 * be fresh according to the fresh ingredient ID ranges?
 */
public class CafeteriaP2 {
	public static void main(String[] args) throws FileNotFoundException {
		java.io.File file = new File("D5_Cafeteria/input.txt");
		Scanner in = new Scanner(file);
		
		ArrayList<long[]> ranges = new ArrayList<>();
		while(in.hasNext()){
			String ipt = in.nextLine();
			if(ipt.isEmpty()){
				break;
			}
			String[] input = ipt.split("-");
			ranges.add(new long[]{Long.parseLong(input[0]), Long.parseLong(input[1])});
		}
		
		int fresh = 0;
		while(in.hasNext()){
			long id = Long.parseLong(in.nextLine());
			boolean spoiled = true;
			for(long[] i: ranges){
				if(i[0] <= id && id <= i[1]){
					spoiled = false;
					fresh++;
					System.out.println("Ingredient ID "+id+" is fresh because it falls into range "+i[0]+"-"+i[1]+".");
					break;
				}
			}
			if(spoiled){
				System.out.println("Ingredient ID "+id+" is spoiled!");
			}
		}
		System.out.println(fresh +" of the ingredients IDs are fresh!");
	}
}
