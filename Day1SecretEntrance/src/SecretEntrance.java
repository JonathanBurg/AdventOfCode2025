/*
 * Secret Entrance
 * Jonathan Burgener
 * December 7, 2025
 * 2025 Advent of Code
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Problem:
 * <p style="color:#C0C0C0">
 * You arrive at the secret entrance to the North Pole base ready to start<br>
 * decorating. Unfortunately, the <b style="color:White">password</b> seems to have been changed, so you<br>
 * can't get in. A document taped to the wall helpfully explains:
 * <p style="color:#C0C0C0">
 * "Due to new security protocols, the password is locked in the safe below.<br>
 * Please see the attached document for the new combination."
 * <p style="color:#C0C0C0">
 * The safe has a dial with only an arrow on it; around the dial are the<br>
 * numbers <code style="color:#FFE4C4">0</code> through <code style="color:#FFE4C4">99</code> in order. As you turn the dial, it makes a small <b style="color:White">click</b><br>
 * noise as it reaches each number.
 * <p style="color:#C0C0C0">
 * The attached document (your puzzle input) contains a sequence of <b style="color:White">rotations</b>,<br>
 * one per line, which tell you how to open the safe. A rotation starts with<br>
 * an <code style="color:#FFE4C4">L</code> or <code style="color:#FFE4C4">R</code> which indicates whether the rotation should be to the left<br>
 * (toward lower numbers) or to the <b style="color:White">right</b> (toward higher numbers). Then, the<br>
 * rotation has a <b style="color:White">distance</b> value which indicates how many clicks the dial<br>
 * should be rotated in that direction.
 * <p style="color:#C0C0C0">
 * So, if the dial were pointing at <code style="color:#FFE4C4">11</code>, a rotation of <code style="color:#FFE4C4">R8</code> would cause the dial<br>
 * to point at <code style="color:#FFE4C4">19</code>. After that, a rotation of <code style="color:#FFE4C4">L19</code> would cause it to point at <code style="color:#FFE4C4">0</code>.
 * <p style="color:#C0C0C0">
 * Because the dial is a circle, turning the dial <b style="color:White">left from <code style="color:#FFE4C4">0</code></b> one click makes<br>
 * it point at <code style="color:#FFE4C4">99</code>. Similarly, turning the dial <b style="color:White">right from <code style="color:#FFE4C4">99</code></b> one click makes<br>
 * it point at <code style="color:#FFE4C4">0</code>.
 * <p style="color:#C0C0C0">
 * So, if the dial were pointing at <code style="color:#FFE4C4">5</code>, a rotation of <code style="color:#FFE4C4">L10</code> would cause it to<br>
 * point at <code style="color:#FFE4C4">95</code>. After that, a rotation of <code style="color:#FFE4C4">R5</code> could cause it to point at <code style="color:#FFE4C4">0</code>.
 * <p style="color:#C0C0C0">
 * The dial starts by pointing at <code style="color:#FFE4C4">50</code>.
 * <p style="color:#C0C0C0">
 * You could follow the instructions, but your recent required official North<br>
 * Pole secret entrance security training seminar taught you that the safe is<br>
 * actually a decoy. The actual password is <b style="color:White">the number of times the dial is<br>
 * left pointing at <code style="color:#FFE4C4">0</code> after any rotation in the sequence</b>.
 * <p style="color:#C0C0C0">
 * For example, suppose the attached document contained the following<br>
 * rotations:
 * <p style="color:#C0C0C0">
 * <code style="color:#FFE4C4">L68</code><br>
 * <code style="color:#FFE4C4">L30</code><br>
 * <code style="color:#FFE4C4">R48</code><br>
 * <code style="color:#FFE4C4">L5</code><br>
 * <code style="color:#FFE4C4">R60</code><br>
 * <code style="color:#FFE4C4">L55</code><br>
 * <code style="color:#FFE4C4">L1</code><br>
 * <code style="color:#FFE4C4">L99</code><br>
 * <code style="color:#FFE4C4">R14</code><br>
 * <code style="color:#FFE4C4">L82</code>
 * <p style="color:#C0C0C0">
 * Following these rotations would cause the dial to move as follows:
 * <p style="color:#C0C0C0">
 * - The dial starts by pointing at <code style="color:#FFE4C4">50</code>.<br>
 * - The dial is rotated <code style="color:#FFE4C4">L68</code> to point at <code style="color:#FFE4C4">82</code>.<br>
 * - The dial is rotated <code style="color:#FFE4C4">L30</code> to point at <code style="color:#FFE4C4">52</code>.<br>
 * - The dial is rotated <code style="color:#FFE4C4">R48</code> to point at <code><b style="color:White">0</b></code>.<br>
 * - The dial is rotated <code style="color:#FFE4C4">L5</code> to point at <code style="color:#FFE4C4">95</code>.<br>
 * - The dial is rotated <code style="color:#FFE4C4">R60</code> to point at <code style="color:#FFE4C4">55</code>.<br>
 * - The dial is rotated <code style="color:#FFE4C4">L55</code> to point at <code><b style="color:White">0</b></code>.<br>
 * - The dial is rotated <code style="color:#FFE4C4">L1</code> to point at <code style="color:#FFE4C4">99</code>.<br>
 * - The dial is rotated <code style="color:#FFE4C4">L99</code> to point at <code><b style="color:White">0</b></code>.<br>
 * - The dial is rotated <code style="color:#FFE4C4">R14</code> to point at <code style="color:#FFE4C4">14</code>.<br>
 * - The dial is rotated <code style="color:#FFE4C4">L82</code> to point at <code style="color:#FFE4C4">32</code>.
 * <p style="color:#C0C0C0">
 * Because the dial points at <code style="color:#FFE4C4">0</code> a total of three times during this process,<br>
 * the password in this example is <code><b style="color:White">3</b></code>.
 * <p style="color:#C0C0C0">
 * Analyze the rotations in your attached document. <b style="color:White">What's the actual password<br>
 * to open the door?</b>
 *
 */

public class SecretEntrance {
	public static int curNum = 50;
	public static int password = 0;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner pause = new Scanner(System.in);
		java.io.File file = new File("Day1SecretEntrance/input.txt");
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
			else if(rotation.charAt(0) != 'R'){
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
	
	public static void updateNum(int increment) {
		System.out.print("(" + curNum + ", " + increment + ", ");
		if(Math.abs(increment)>90){
			int n = curNum;
			int j = 1;
			if(increment<0) j = -1;
			for(int i =0; i < Math.abs(increment); i++){
				n += j;
				if(n<=-1) n=99;
				if(n>=100) n=0;
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
	
	public static final String RESET = "\u001B[0m";
	public static final String WHITE = "\u001B[37m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BOLD = "\u001B[1m";
}