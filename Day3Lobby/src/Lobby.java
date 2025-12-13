import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/***
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
 * <span class=probHead>--- Day 3: Lobby ---</span>
 * <p>
 * You descend a short staircase, enter the surprisingly vast lobby, and are<br>
 * quickly cleared by the security checkpoint. When you get to the main<br>
 * elevators, however, you discover that each one has a red light above it:<br>
 * they're all <span class=glow>offline</span>.
 * <p>
 * "Sorry about that," an Elf apologizes as she tinkers with a nearby control<br>
 * panel. "Some kind of electrical surge seems to have fried them. I'll try to<br>
 * get them online soon."
 * <p>
 * You explain your need to get further underground. "Well, you could at least<br>
 * take the escalator down to the printing department, not that you'd get much<br>
 * further than that without the elevators working. That is, you could if the<br>
 * escalator weren't also offline."
 * <p>
 * "But, don't worry! It's not fried; it just needs power. Maybe you can get<br>
 * it running while I keep working on the elevators."
 * <p>
 * There are batteries nearby that can supply emergency power to the escalator<br>
 * for just such an occasion. The batteries are each labeled with their<br>
 * joltage rating, a value from 1 to 9. You make a note of their joltage<br>
 * ratings (your puzzle input). For example:
 * <p>
 * <code class=num>987654321111111</code><br>
 * <code class=num>811111111111119</code><br>
 * <code class=num>234234234234278</code><br>
 * <code class=num>818181911112111</code><br>
 * <p>
 * The batteries are arranged into <span class=glow>banks</span>; each line of digits in your input<br>
 * corresponds to a single bank of batteries. Within each bank, you need to<br>
 * turn on <span class=glow>exactly two</span> batteries; the joltage that the bank produces is equal<br>
 * to the number formed by the digits on the batteries you've turned on. For<br>
 * example, if you have a bank like <code class=num>12345</code> and you turn on batteries <code class=num>2</code> and <code class=num>4</code>,<br>
 * the bank would produce <code class=num>24</code> jolts. (You cannot rearrange batteries.)
 * <p>
 * You'll need to find the largest possible joltage each bank can produce. In<br>
 * the above example:
 * <p>
 *   - In <code class=num><span class=glow>98</span>7654321111111</code>, you can make the largest joltage possible, <code class=glow>98</code>, by<br>
 *   turning on the first two batteries.<br>
 *   - In <code class=num><span class=glow>8</span>1111111111111<span class=glow>9</span></code>, you can make the largest joltage possible by<br>
 *   turning on the batteries labeled <code class=num>8</code> and <code class=num>9</code>, producing <code class=glow>89</code> jolts.<br>
 *   - In <code class=num>2342342342342<span class=glow>78</span></code>, you can make <code class=glow>78</code> by turning on the last two<br>
 *   batteries (marked <code class=num>7</code> and <code class=num>8</code>).<br>
 *   - In <code class=num>818181<span class=glow>9</span>1111<span class=glow>2</span>111</code>, the largest joltage you can produce is <code class=glow>92</code>.
 * <p>
 * The total output joltage is the sum of the maximum joltage from each bank,<br>
 * so in this example, the total output joltage is <code class=num>98</code> + <code class=num>89</code> + <code class=num>78</code> + <code class=num>92</code> = <code class=glow>357</code>.
 * <p>
 * There are many batteries in front of you. Find the maximum joltage possible<br>
 * from each bank; <span class=glow>what is the total output joltage?</span>
 * </p></body></html>
 * @author Jonathan Burgener
 * @version December 12, 2025
 */
public class Lobby {
	
	/**
	 * Finds the Joltage
	 *
	 * @param args Default Args
	 * @throws FileNotFoundException Handles issues with files
	 */
	public static void main(String[] args) throws FileNotFoundException {
		java.io.File file = new File("Day3Lobby/input.txt");
		Scanner in = new Scanner(file);
		ArrayList<Integer> joltage = new ArrayList<>();
		while(in.hasNext()) {
			char[] input = in.nextLine().toCharArray();
			int[] batteries = new int[input.length];
			
			// The first two numbers are the high numbers,
			// the last two are the indices of the highs
			int[] highs = {0, 0, 0, 0};
			
			for(int i = 0; i < input.length; i++) {
				batteries[i] = Integer.parseInt(String.valueOf(input[i]));
				int curNum = batteries[i];
				if(highs[0] < highs[1]) {
					highs[0] = highs[1];
					highs[1] = curNum;
					highs[2] = highs[3];
					highs[3] = i;
				}
				else if(curNum > highs[1]) {
					highs[1] = curNum;
					highs[3] = i;
				}
			}
			joltage.add(highs[0] * 10 + highs[1]);
			
			System.out.print(WHITE + "In " + RESET);
			for(int i = 0; i < input.length; i++) {
				if(i == highs[2] || i == highs[3]) {
					System.out.print(RESET + BOLD + YELLOW);
				}
				else {
					System.out.print(RESET + YELLOW);
				}
				System.out.print(batteries[i] + RESET);
			}
			System.out.println(WHITE + ", the largest joltage you can produce is " + RESET + BOLD +
			                   joltage.get(joltage.size() - 1) + RESET + WHITE + "." + RESET);
			
		}
		int total = joltage.get(0);
		joltage.remove(0);
		System.out.print(WHITE + "The total output joltage is " + RESET + total);
		for(int n : joltage) {
			System.out.print(WHITE + " + " + RESET + n + RESET);
			total += n;
		}
		System.out.println(WHITE + " = " + RESET + BOLD + total + RESET + WHITE + "." + RESET);
	}
	
	private static final String RESET = "\u001B[0m";
	private static final String WHITE = "\u001B[37m";
	private static final String YELLOW = "\u001B[33m";
	private static final String BOLD = "\u001B[1m";
}
