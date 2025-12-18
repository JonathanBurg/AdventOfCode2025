/*
 * Secret Entrance
 *
 * 2025 Advent of Code
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <html> <head>
 * <title>Gift Shop</title>
 * <style>
 * .glow{
 * color: White;
 * size: 18px;
 * text-shadow: 0 0 2px white, 0px 0px 2px white;
 * }
 * .num{
 * color:#D0D0D0;
 * size:22px;
 * }
 * .newArea{
 * color:Yellow;
 * size:24px;
 * text-shadow: 0 0 2px Yellow, 0px 0px 3px Yellow;
 * }
 * .probHead{
 * size:25px;
 * color: White;
 * }
 * </style></head>
 * <body style="color:#C0C0C0; background-color:#0f0f22; size:22px"><p>
 * <span class=probHead>--- Day 1: Secret Entrance ---</span>
 * <p>
 * You arrive at the secret entrance to the North Pole base ready to start<br>
 * decorating. Unfortunately, the <span class=glow>password</span> seems to have been changed, so you<br>
 * can't get in. A document taped to the wall helpfully explains:
 * <p>
 * "Due to new security protocols, the password is locked in the safe below.<br>
 * Please see the attached document for the new combination."
 * <p>
 * The safe has a dial with only an arrow on it; around the dial are the<br>
 * numbers <code class=num>0</code> through <code class=num>99</code> in order. As you turn the dial, it makes a small <span class=glow>click</span><br>
 * noise as it reaches each number.
 * <p>
 * The attached document (your puzzle input) contains a sequence of <span class=glow>rotations</span>,<br>
 * one per line, which tell you how to open the safe. A rotation starts with<br>
 * an <code class=num>L</code> or <code class=num>R</code> which indicates whether the rotation should be to the left<br>
 * (toward lower numbers) or to the <span class=glow>right</span> (toward higher numbers). Then, the<br>
 * rotation has a <span class=glow>distance</span> value which indicates how many clicks the dial<br>
 * should be rotated in that direction.
 * <p>
 * So, if the dial were pointing at <code class=num>11</code>, a rotation of <code class=num>R8</code> would cause the dial<br>
 * to point at <code class=num>19</code>. After that, a rotation of <code class=num>L19</code> would cause it to point at <code class=num>0</code>.
 * <p>
 * Because the dial is a circle, turning the dial <span class=glow>left from <code class=num>0</code></span> one click makes<br>
 * it point at <code class=num>99</code>. Similarly, turning the dial <span class=glow>right from <code class=num>99</code></span> one click makes<br>
 * it point at <code class=num>0</code>.
 * <p>
 * So, if the dial were pointing at <code class=num>5</code>, a rotation of <code class=num>L10</code> would cause it to<br>
 * point at <code class=num>95</code>. After that, a rotation of <code class=num>R5</code> could cause it to point at <code class=num>0</code>.
 * <p>
 * The dial starts by pointing at <code class=num>50</code>.
 * <p>
 * You could follow the instructions, but your recent required official North<br>
 * Pole secret entrance security training seminar taught you that the safe is<br>
 * actually a decoy. The actual password is <span class=glow>the number of times the dial is<br>
 * left pointing at <code class=num>0</code> after any rotation in the sequence</span>.
 * <p>
 * For example, suppose the attached document contained the following<br>
 * rotations:
 * <p>
 * <code class=num>L68</code><br>
 * <code class=num>L30</code><br>
 * <code class=num>R48</code><br>
 * <code class=num>L5</code><br>
 * <code class=num>R60</code><br>
 * <code class=num>L55</code><br>
 * <code class=num>L1</code><br>
 * <code class=num>L99</code><br>
 * <code class=num>R14</code><br>
 * <code class=num>L82</code>
 * <p>
 * Following these rotations would cause the dial to move as follows:
 * <p>
 * - The dial starts by pointing at <code class=num>50</code>.<br>
 * - The dial is rotated <code class=num>L68</code> to point at <code class=num>82</code>.<br>
 * - The dial is rotated <code class=num>L30</code> to point at <code class=num>52</code>.<br>
 * - The dial is rotated <code class=num>R48</code> to point at <code class=glow>0</code>.<br>
 * - The dial is rotated <code class=num>L5</code> to point at <code class=num>95</code>.<br>
 * - The dial is rotated <code class=num>R60</code> to point at <code class=num>55</code>.<br>
 * - The dial is rotated <code class=num>L55</code> to point at <code class=glow>0</code>.<br>
 * - The dial is rotated <code class=num>L1</code> to point at <code class=num>99</code>.<br>
 * - The dial is rotated <code class=num>L99</code> to point at <code class=glow>0</code>.<br>
 * - The dial is rotated <code class=num>R14</code> to point at <code class=num>14</code>.<br>
 * - The dial is rotated <code class=num>L82</code> to point at <code class=num>32</code>.
 * <p>
 * Because the dial points at <code class=num>0</code> a total of three times during this process,<br>
 * the password in this example is <code class=glow>3</code>.
 * <p>
 * Analyze the rotations in your attached document. <span class=glow>What's the actual password<br>
 * to open the door?</span>
 * </p></body></html>
 *
 * @author Jonathan Burgener
 * @version December 7, 2025
 */

public class SecretEntrance {
	/**
	 * Selected number
	 */
	public static int curNum = 50;
	/**
	 * Final password (Number of times 0 is selected)
	 */
	public static int password = 0;
	
	/**
	 * Handles the input and the output
	 *
	 * @param args Default arguments
	 * @throws FileNotFoundException Handles issue with files
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner pause = new Scanner(System.in);
		java.io.File file = new File("D1_SecretEntrance/input.txt");
		Scanner in = new Scanner(file);
		int i = 0;
		System.out.println(WHITE + "The dial starts by pointing at " + YELLOW + curNum + WHITE + "." + RESET);
		while(in.hasNext()) {
			i++;
			String rotation = in.nextLine();
			int rot = Integer.parseInt(rotation.replaceAll("[A-Za-z]", ""));
			if(rotation.charAt(0) == 'L') {
				rot *= -1;
			}
			else if(rotation.charAt(0) != 'R') {
				pause.next();
			}
			
			updateNum(rot);
			
			System.out.print(
					WHITE + "Rotation " + i + ": The dial is rotated " + YELLOW + rotation + WHITE + " to point at " +
					RESET);
			if(curNum == 0) {
				System.out.println(RESET + BOLD + curNum + RESET + WHITE + "." + RESET);
				password++;
				System.out.println(WHITE + "Password updated to " + RESET + password + WHITE + "!" + RESET);
			}
			else {
				System.out.println(YELLOW + curNum + WHITE + "." + RESET);
			}
			
		}
		System.out.println("The password is " + BOLD + password + RESET + "!");
	}
	
	/**
	 * Changes the selected number
	 *
	 * @param increment How far to twist the dial and which direction<br>
	 *                  (- for left, + for right)
	 */
	public static void updateNum(int increment) {
		System.out.print("(" + curNum + ", " + increment + ", ");
		if(Math.abs(increment) > 90) {
			int n = curNum;
			int j = 1;
			if(increment < 0) {
				j = -1;
			}
			for(int i = 0; i < Math.abs(increment); i++) {
				n += j;
				if(n <= -1) {
					n = 99;
				}
				if(n >= 100) {
					n = 0;
				}
			}
			System.out.println(n);
		}
		curNum += increment;
		System.out.println(curNum + ")");
		if(curNum < 0) {
			curNum = Math.floorMod(curNum * -1, 100) * -1 + 100;
			//curNum += 100;
		}
		else if(curNum > 99) {
			curNum = Math.floorMod(curNum, 100);
		}
	}
	
	private static final String RESET = "\u001B[0m";
	private static final String WHITE = "\u001B[37m";
	private static final String YELLOW = "\u001B[33m";
	private static final String BOLD = "\u001B[1m";
}