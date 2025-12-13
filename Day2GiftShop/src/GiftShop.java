import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
//FFE4C4

/**
 * <html> <head>
 * <title>Gift Shop - Advent of Code 2025</title>
 * <style>
 * .glow{
 * color: White;
 * text-shadow: 0 0 2px white, 0px 0px 2px white;
 * }
 * .num{
 * color:#D0D0D0;
 * }
 * .newArea{
 * color:Yellow;
 * text-shadow: 0 0 2px Yellow, 0px 0px 3px Yellow;
 * }
 * .probHead{
 * color: White;
 * }
 * </style></head>
 *
 * <body style="color:#E2E2E2; background-color:#0f0f22"><p>
 * <span class=probHead>--- Day 2: Gift Shop ---</span>
 * <p>
 * You get inside and take the elevator to its only other stop: the gift shop.<br>
 * "Thank you for visiting the North Pole!" gleefully exclaims a nearby sign.<br>
 * You aren't sure who is even allowed to visit the North Pole, but you know<br>
 * you can access the lobby through here, and from there you can access the<br>
 * rest of the North Pole base.
 * <p>
 * As you make your way through the surprisingly extensive selection, one of<br>
 * the clerks recognize you and asks for your help.
 * <p>
 * As it turns out, one of the younger Elves was playing on a gift shop<br>
 * computer and managed to add a whole bunch of invalid product IDs to their<br>
 * gift shop database! Surely, it would be no trouble for you to identify the<br>
 * invalid product IDs for them, right?
 * <p>
 * They've even checked most of the product ID ranges already; they only have<br>
 * a few product ID ranges (your puzzle input) that you'll need to check. For<br>
 * example:
 * <p>
 * <code class=num>11-22,95-115,998-1012,1188511880-1188511890,222220-222224,</code><br>
 * <code class=num>1698522-1698528,446443-446449,38593856-38593862,565653-565659,</code><br>
 * <code class=num>824824821-824824827,2121212118-2121212124</code>
 * <p>
 * (The ID ranges are wrapped here for legibility; in your input, they appear<br>
 * on a single long line.)
 * <p>
 * The ranges are separated by commas (<code class=num>,</code>); each range gives its <span class=glow>first ID</span> and<br>
 * <span class=glow>last ID</span> separated by a dash (<code class=num>-</code>).
 * <p>
 * Since the young Elf was just doing silly patterns, you can find the invalid<br>
 * IDs by looking for any ID which is made only of some sequence of digits<br>
 * repeated twice. So, <code class=num>55</code> (<code class=num>5</code> twice), <code class=num>6464</code> (<code class=num>64</code> twice), and <code class=num>123123</code> (<code class=num>123</code> twice)<br>
 * would all be invalid IDs.
 * <p>
 * None of the numbers have leading zeroes; <code class=num>0101</code> isn't an ID at all. (<code class=num>101</code> is a<br>
 * <span class=glow>valid</span> ID that you would ignore.)
 * <p>
 * Your job is to find all of the invalid IDs that appear in the given ranges.<br>
 * In the above example:
 * <p>
 * &nbsp;&nbsp;- <code class=num>11-22</code> has two invalid IDs, <code class=glow>11</code> and <code class=glow>22</code>.<br>
 * &nbsp;&nbsp;- <code class=num>95-115</code> has one invalid ID, <code class=glow>99</code>.<br>
 * &nbsp;&nbsp;- <code class=num>998-1012</code> has one invalid ID, <code class=glow>1010</code>.<br>
 * &nbsp;&nbsp;- <code class=num>1188511880-1188511890</code> has one invalid ID, <code class=glow>1188511885</code>.<br>
 * &nbsp;&nbsp;- <code class=num>222220-222224</code> has one invalid ID, <code class=glow>222222</code>.<br>
 * &nbsp;&nbsp;- <code class=num>1698522-1698528</code> contains no invalid IDs.<br>
 * &nbsp;&nbsp;- <code class=num>446443-446449</code> has one invalid ID, <code class=glow>446446</code>.<br>
 * &nbsp;&nbsp;- <code class=num>38593856-38593862</code> has one invalid ID, <code class=glow>38593859</code>.<br>
 * &nbsp;&nbsp;- The rest of the ranges contain no invalid IDs.
 * <p>
 * Adding up all the invalid IDs in this example produces <code class=glow>1227775554</code>.
 * <p>
 * <span class=glow>What do you get if you add up all of the invalid IDs?</span>
 * <p>
 * Your puzzle answer was <code class=num>29940924880</code>.
 * <p class=newArea>
 * The first half of this puzzle is complete! It provides one gold star: *
 * <p class=probHead>
 * --- Part Two ---
 * <p>
 * The clerk quickly discovers that there are still invalid IDs in the ranges<br>
 * in your list. Maybe the young Elf was doing other silly patterns as well?
 * <p>
 * Now, an ID is invalid if it is made only of some sequence of digits<br>
 * repeated <span class=glow>at least</span> twice. So, <code class=num>12341234</code> (<code class=num>1234</code> two times), <code class=num>123123123</code> (<code class=num>123</code><br>
 * three times), <code class=num>1212121212</code>? (<code class=num>12</code> five times), and <code class=num>1111111</code> (<code class=num>1</code> seven times) are<br>
 * all invalid IDs.
 * <p>
 * From the same example as before:
 * <p>
 * &nbsp;&nbsp;- <code class=num>11-22</code> still has two invalid IDs, <code class=glow>11</code> and <code class=glow>22</code>.<br>
 * &nbsp;&nbsp;- <code class=num>95-115</code> now has two invalid IDs, <code class=glow>99</code> and <code class=glow>111</code>.<br>
 * &nbsp;&nbsp;- <code class=num>998-1012</code> now has two invalid IDs, <code class=glow>999</code> and <code class=glow>1010</code>.<br>
 * &nbsp;&nbsp;- <code class=num>1188511880-1188511890</code> still has one invalid ID, <code class=glow>1188511885</code>.<br>
 * &nbsp;&nbsp;- <code class=num>222220-222224</code> still has one invalid ID, <code class=glow>222222</code>.<br>
 * &nbsp;&nbsp;- <code class=num>1698522-1698528</code> still contains no invalid IDs.<br>
 * &nbsp;&nbsp;- <code class=num>446443-446449</code> still has one invalid ID, <code class=glow>446446</code>.<br>
 * &nbsp;&nbsp;- <code class=num>38593856-38593862</code> still has one invalid ID, <code class=glow>38593859</code>.<br>
 * &nbsp;&nbsp;- <code class=num>565653-565659</code> now has one invalid ID, <code class=glow>565656</code>.<br>
 * &nbsp;&nbsp;- <code class=num>824824821-824824827</code> now has one invalid ID, <code class=glow>824824824</code>.<br>
 * &nbsp;&nbsp;- <code class=num>2121212118-2121212124</code> now has one invalid ID, <code class=glow>2121212121</code>.
 * <p>
 * Adding up all the invalid IDs in this example produces <code class=glow>4174379265</code>.
 * <p class=glow>
 * What do you get if you add up all of the invalid IDs using these new rules?
 * </p></body></html>
 *
 * @author Jonathan Burgener
 * @version December 7, 2025
 */
public class GiftShop {
	/**
	 * Give output for part one (true) or part two (false)
	 */
	private static final boolean PART_ONE = false;
	
	/**
	 * Finds the invalid IDs
	 *
	 * @param args Default arguments
	 * @throws FileNotFoundException Handles issue with files
	 */
	public static void main(String[] args) throws FileNotFoundException {
		java.io.File file = new File("Day2GiftShop/input.txt");
		Scanner in = new Scanner(file);
		String[] ranges = in.nextLine().split(",");
		long inv = 0;
		for(String range : ranges) {
			System.out.print(YELLOW + range + RESET);
			
			long low = Long.parseLong(range.split("-")[0]);
			long high = Long.parseLong(range.split("-")[1]);
			ArrayList<Long> invalids = new ArrayList<>();
			
			for(long n = low; n <= high; n++) {
				char[] num = String.valueOf(n).toCharArray();
				
				if(num.length % 2 == 0 && PART_ONE) {
					String[] nums = {"", ""};
					for(int j = 0; j < num.length / 2; j++) {
						nums[0] = nums[0] + num[j];
						nums[1] = nums[1] + num[j + num.length / 2];
					}
					if(nums[0].equals(nums[1])) {
						invalids.add(n);
						inv += n;
					}
				}
				else {
					ArrayList<Integer> divs = new ArrayList<>();
					for(int j = 1; j < num.length; j++) {
						if(num.length % j == 0) {
							divs.add(j);
						}
					}
					
					for(int a : divs) {
						boolean found = true;
						ArrayList<String> parts = new ArrayList<>();
						parts.add("");
						int b = 0; // Current length of section
						for(char c : num) {
							if(b >= a) {
								b = 1;
								parts.add(String.valueOf(c));
							}
							else {
								parts.set(parts.size() - 1, parts.get(parts.size() - 1) + c);
								b++;
							}
						}
						for(int d = 1; d < parts.size(); d++) {
							if(!Objects.equals(parts.get(0), parts.get(d))) {
								found = false;
								break;
							}
						}
						if(found) {
							//if(invalids.get(invalids.size()-1)!=Long.parseLong(Arrays.toString(num))) {
							invalids.add(Long.parseLong(String.valueOf(num)));
							inv += Long.parseLong(String.valueOf(num));
							break;
						}
					}
				}
			}
			if(invalids.isEmpty()) {
				System.out.print(WHITE + " contains no invalid IDs" + RESET);
			}
			else if(invalids.size() == 1) {
				System.out.print(WHITE + " has one invalid ID, " + RESET + BOLD + invalids.get(0) + RESET);
			}
			else {
				System.out.print(WHITE + " has " + invalids.size() + " invalid IDs" + RESET);
				for(Long aLong : invalids) {
					System.out.print(WHITE + ", " + RESET + BOLD + aLong + RESET);
				}
			}
			System.out.println(WHITE + "." + RESET);
		}
		System.out.println(WHITE + "\nSum of invalid IDs is " + RESET + BOLD + inv + RESET + WHITE + "." + RESET);
	}
	
	private static final String RESET = "\u001B[0m";
	private static final String WHITE = "\u001B[37m";
	private static final String YELLOW = "\u001B[33m";
	private static final String BOLD = "\u001B[1m";
}
