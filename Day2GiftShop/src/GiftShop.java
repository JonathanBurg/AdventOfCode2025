/*
 * Gift Shop
 * Jonathan Burgener
 * December 7, 2025
 * 2025 Advent of Code
 */

/**
 * <html>
 * <head><title>Gift Shop</title></head>
 * <header>--- Day 2: Gift Shop ---</header>
 * <body><p style="color:#C0C0C0">
 * You get inside and take the elevator to its only other stop: the gift shop.<br>
 * "Thank you for visiting the North Pole!" gleefully exclaims a nearby sign.<br>
 * You aren't sure who is even allowed to visit the North Pole, but you know<br>
 * you can access the lobby through here, and from there you can access the<br>
 * rest of the North Pole base.
 * <p style="color:#C0C0C0">
 * As you make your way through the surprisingly extensive selection, one of<br>
 * the clerks recognizes you and asks for your help.
 * <p style="color:#C0C0C0">
 * As it turns out, one of the younger Elves was playing on a gift shop<br>
 * computer and managed to add a whole bunch of invalid product IDs to their<br>
 * gift shop database! Surely, it would be no trouble for you to identify the<br>
 * invalid product IDs for them, right?
 * <p style="color:#C0C0C0">
 * They've even checked most of the product ID ranges already; they only have<br>
 * a few product ID ranges (your puzzle input) that you'll need to check. For<br>
 * example:
 * <p style="color:#C0C0C0">
 * <code style="color:#F5F5DC">11-22,95-115,998-1012,1188511880-1188511890,222220-222224,</code><br>
 * <code style="color:#F5F5DC">1698522-1698528,446443-446449,38593856-38593862,565653-565659,</code><br>
 * <code style="color:#F5F5DC">824824821-824824827,2121212118-2121212124</code>
 * <p style="color:#C0C0C0">
 * (The ID ranges are wrapped here for legibility; in your input, they appear<br>
 * on a single long line.)
 * <p style="color:#C0C0C0">
 * The ranges are separated by commas (,); each range gives its first ID and<br>
 * last ID separated by a dash (-).
 * <p style="color:#C0C0C0">
 * Since the young Elf was just doing silly patterns, you can find the invalid<br>
 * IDs by looking for any ID which is made only of some sequence of digits<br>
 * repeated twice. So, 55 (5 twice), 6464 (64 twice), and 123123 (123 twice)<br>
 * would all be invalid IDs.
 * <p style="color:#C0C0C0">
 * None of the numbers have leading zeroes; 0101 isn't an ID at all. (101 is a<br>
 * valid ID that you would ignore.)
 * <p style="color:#C0C0C0">
 * Your job is to find all of the invalid IDs that appear in the given ranges.<br>
 * In the above example:
 * <p style="color:#C0C0C0">
 * 11-22 has two invalid IDs, 11 and 22.<br>
 * 95-115 has one invalid ID, 99.<br>
 * 998-1012 has one invalid ID, 1010.<br>
 * 1188511880-1188511890 has one invalid ID, 1188511885.<br>
 * 222220-222224 has one invalid ID, 222222.<br>
 * 1698522-1698528 contains no invalid IDs.<br>
 * 446443-446449 has one invalid ID, 446446.<br>
 * 38593856-38593862 has one invalid ID, 38593859.<br>
 * The rest of the ranges contain no invalid IDs.
 * <p style="color:#C0C0C0">
 * Adding up all the invalid IDs in this example produces 1227775554.
 * <p style="color:#C0C0C0">
 * What do you get if you add up all of the invalid IDs?
 * </p></body></html>
 */
public class GiftShop {
	public static void main(String[] args) {
	
	}
}
