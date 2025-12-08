/*
 * Gift Shop
 * Jonathan Burgener
 * December 7, 2025
 * 2025 Advent of Code
 */

import jdk.jfr.consumer.RecordedStackTrace;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <html> <head>
 * <title>Gift Shop</title>
 * <style>
 * #glow {
 * color: #fff;
 * text-shadow: 0 0 10px white, 0px 0px 5px white;
 * }
 * </style></head>
 * <header>--- Day 2: Gift Shop ---</header>
 * <body style="color:#C0C0C0">
 * <p style="color:#C0C0C0">
 * You get inside and take the elevator to its only other stop: the gift shop.<br>
 * "Thank you for visiting the North Pole!" gleefully exclaims a nearby sign.<br>
 * You aren't sure who is even allowed to visit the North Pole, but you know<br>
 * you can access the lobby through here, and from there you can access the<br>
 * rest of the North Pole base.
 * <p style="color:#C0C0C0">
 * As you make your way through the surprisingly extensive selection, one of<br>
 * the clerks recognize you and asks for your help.
 * <p style="color:#C0C0C0">
 * As it turns out, one of the younger Elves was playing on a gift shop<br>
 * computer and managed to <span class="glow">add a whole bunch</span> of invalid product IDs to their<br>
 * gift shop database! Surely, it would be no trouble for you to identify the<br>
 * invalid product IDs for them, right?
 * <p style="color:#C0C0C0">
 * They've even checked most of the product ID ranges already; they only have<br>
 * a few product ID ranges (your puzzle input) that you'll need to check. For<br>
 * example:
 * <p>
 * <code style="color:#FFE4C4">11-22,95-115,998-1012,1188511880-1188511890,222220-222224,</code><br>
 * <code style="color:#FFE4C4">1698522-1698528,446443-446449,38593856-38593862,565653-565659,</code><br>
 * <code style="color:#FFE4C4">824824821-824824827,2121212118-2121212124</code>
 * <p style="color:#C0C0C0">
 * (The ID ranges are wrapped here for legibility; in your input, they appear<br>
 * on a single long line.)
 * <p style="color:#C0C0C0">
 * The ranges are separated by commas (<code style="color:#FFE4C4">,</code>); each range gives its first ID and<br>
 * last ID separated by a dash (<code style="color:#FFE4C4">-</code>).
 * <p style="color:#C0C0C0">
 * Since the young Elf was just doing silly patterns, you can find the invalid<br>
 * IDs by looking for any ID which is made only of some sequence of digits<br>
 * repeated twice. So, <code style="color:#FFE4C4">55</code> (<code style="color:#FFE4C4">5</code> twice), <code style="color:#FFE4C4">6464</code> (<code style="color:#FFE4C4">64</code> twice), and <code style="color:#FFE4C4">123123</code> (<code style="color:#FFE4C4">123</code> twice)<br>
 * would all be invalid IDs.
 * <p style="color:#C0C0C0">
 * None of the numbers have leading zeroes; <code style="color:#FFE4C4">0101</code> isn't an ID at all. (<code style="color:#FFE4C4">101</code> is a<br>
 * valid ID that you would ignore.)
 * <p style="color:#C0C0C0">
 * Your job is to find all of the invalid IDs that appear in the given ranges.<br>
 * In the above example:
 * <p style="color:#C0C0C0">
 * <code style="color:#FFE4C4">11-22</code> has two invalid IDs, <code><b style="color:White", style="text-shadow: 0 0 10px white, 0px 0px 5px white">11</b></code> and <code><b style="color:White">22</b></code>.<br>
 * <code style="color:#FFE4C4">95-115</code> has one invalid ID, <code><b style="color:White">99</b></code>.<br>
 * <code style="color:#FFE4C4">998-1012</code> has one invalid ID, <code><b style="color:White">1010</b></code>.<br>
 * <code style="color:#FFE4C4">1188511880-1188511890</code> has one invalid ID, <code><b style="color:White">1188511885</b></code>.<br>
 * <code style="color:#FFE4C4">222220-222224</code> has one invalid ID, <code><b style="color:White">222222</b></code>.<br>
 * <code style="color:#FFE4C4">1698522-1698528</code> contains no invalid IDs.<br>
 * <code style="color:#FFE4C4">446443-446449</code> has one invalid ID, <code><b style="color:White">446446</b></code>.<br>
 * <code style="color:#FFE4C4">38593856-38593862</code> has one invalid ID, <code><b style="color:White">38593859</b></code>.<br>
 * The rest of the ranges contain no invalid IDs.
 * <p style="color:#C0C0C0">
 * Adding up all the invalid IDs in this example produces <code><b style="color:White">1227775554</b></code>.
 * <p style="color:#C0C0C0">
 * What do you get if you add up all of the invalid IDs?
 * </p></html>
 */
public class GiftShop {
	public static void main(String[] args) throws FileNotFoundException {
		java.io.File file = new File("Day2GiftShop/input.txt");
		Scanner in = new Scanner(file);
		String[] ranges = in.nextLine().split(",");
		int inv = 0;
		for(int i = 0; i < ranges.length; i++) {
			System.out.print(YELLOW + ranges[i] + RESET);
			int low = Integer.parseInt(ranges[i].split("-")[0]);
			int high = Integer.parseInt(ranges[i].split("-")[1]);
			int invalid = 0;
			ArrayList<Integer> invalids = new ArrayList<>();
			for(int n = low; n <= high; n++) {
				String num = String.valueOf(n);
				
			}
			if(invalid == 0) {
				System.out.println(WHITE + " contains no invalid IDs" + RESET);
			}
			else if(invalids.size() == 1) {
				System.out.print(WHITE + " has one invalid ID" + RESET + BOLD + invalids.get(0) + RESET);
			}
			else {
				System.out.print(WHITE + " has " + invalids.size() + " invalid IDs" + RESET);
				for(int j = 0; j < invalids.size(); j++) {
					System.out.print(WHITE + ", " + RESET + BOLD + invalids.get(j) + RESET);
				}
			}
			System.out.println(WHITE + "." + RESET);
		}
		System.out.println(WHITE + "\nSum of invalid IDs is " + RESET + BOLD + inv + RESET + WHITE + "." + RESET);
	}
	
	public static final String RESET = "\u001B[0m";
	public static final String WHITE = "\u001B[37m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BOLD = "\u001B[1m";
}
