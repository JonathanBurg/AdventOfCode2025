import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <head>
 * <style>
 * .glow{
 * color: #FFFFFF:
 * font-style: normal;
 * text-shadow: 0 0 2px #FFFFFF, 0px 0px 2px #FFFFFF;
 * }
 * .num{
 * color:#ADBDC9;
 * background-color:#10101A
 * }
 * code {
 * position:relative;
 * display: inline-block;
 * margin: 0;
 * padding: 3;
 * background: #10101a
 * }
 * code::before {
 * z-indent: -1;
 * content: "";
 * position: absolute;
 * display: block;
 * left: -2px;
 * right: -2px;
 * top: 3px;
 * bottom: 0px;
 * border: 1px solid #333340;
 * }
 * .newArea{
 * color:Yellow;
 * text-shadow: 0 0 2px Yellow, 0px 0px 3px Yellow;
 * }
 * .probHead{
 * color: White;
 * }
 * </style></head>
 * <body style="color:#F2F2F2; background-color:#0f0f22">
 * <span class=probHead>--- Day 3: Lobby ---</span>
 * <p>
 * --- Day 4: Printing Department ---
 * <p>
 * You ride the escalator down to the printing department. They're clearly<br>
 * getting ready for Christmas; they have lots of large rolls of paper<br>
 * everywhere, and there's even a massive printer in the corner (to handle the<br>
 * really big print jobs).
 * <p>
 * Decorating here will be easy: they can make their own decorations. What you<br>
 * really need is a way to get further into the North Pole base while the<br>
 * elevators are offline.
 * <p>
 * "Actually, maybe we can help with that," one of the Elves replies when you<br>
 * ask for help. "We're pretty sure there's a cafeteria on the other side of<br>
 * the back wall. If we could break through the wall, you'd be able to keep<br>
 * moving. It's too bad all of our forklifts are so busy moving those big<br>
 * rolls of paper around."
 * <p>
 * If you can optimize the work the forklifts are doing, maybe they would have<br>
 * time to spare to break through the wall.
 * <p>
 * The rolls of paper (<code class=num>@</code>) are arranged on a large grid; the Elves even have a<br>
 * helpful diagram (your puzzle input) indicating where everything is located.
 * <p>
 * For example:
 * <p>
 * ..@@.@@@@.<br>
 * &#064;@@.@.@.@@<br>
 * &#064;@@@@.@.@@<br>
 * &#064;.@@@@..@.<br>
 * &#064;@.@@@@.@@<br>
 * .@@@@@@@.@<br>
 * .@.@.@.@@@<br>
 * &#064;.@@@.@@@@<br>
 * .@@@@@@@@.<br>
 * &#064;.@.@@@.@.
 * <p>
 * The forklifts can only access a roll of paper if there are <span class=glow>fewer than four<br>
 * rolls of paper</span> in the eight adjacent positions. If you can figure out which<br>
 * rolls of paper the forklifts can access, they'll spend less time looking<br>
 * and more time breaking down the wall to the cafeteria.
 * <p>
 * In this example, there are <code class=glow>13</code> rolls of paper that can be accessed by a<br>
 * forklift (marked with <code class=num>x</code>):
 * <p><code class=num>
 * ..xx.xx@x.<br>
 * x@@.@.@.@@<br>
 * &#064;@@@@.x.@@<br>
 * &#064;.@@@@..@.<br>
 * x@.@@@@.@x<br>
 * .@@@@@@@.@<br>
 * .@.@.@.@@@<br>
 * x.@@@.@@@@<br>
 * .@@@@@@@@.<br>
 * x.x.@@@.x.
 * </code><p>
 * Consider your complete diagram of the paper roll locations. How many rolls<br>
 * of paper can be accessed by a forklift?
 */
public class PrintingDepartmentP2 {
	public static void main(String[] args) throws FileNotFoundException {
		java.io.File file = new File("D4_PrintingDepartment/input.txt");
		Scanner in = new Scanner(file);
		//Scanner pause = new Scanner(System.in);
		ArrayList<char[]> rolls = new ArrayList<>();
		int access = 0;
		
		while(in.hasNext()) {
			rolls.add(in.nextLine().toCharArray());
		}
		
		rolls.add(0, new char[rolls.get(1).length]);
		rolls.add(rolls.size(), new char[rolls.get(1).length]);
		for(int i = 0; i < rolls.get(1).length; i++) {
			rolls.get(0)[i] = '.';
			rolls.get(rolls.size() - 1)[i] = '.';
		}
		
		for(int i = 1; i < rolls.size() - 1; i++) {
			for(int j = 1; j < rolls.get(i).length - 1; j++) {
				int s = 9;
				//String paused = pause.nextLine();
				for(int k = -1; k <= 1; k++) {
					for(int l = -1; l <= 1; l++) {
						if(rolls.get(i + k)[j + l] == '.') {
							s--;
						}
						//System.out.print(cafeteria.get(i + k)[j + l]);
					}
					//System.out.println();
				}
				//System.out.print(s<=4);
				if(s <= 4 && rolls.get(i)[j] == '@') {
					rolls.get(i)[j] = 'x';
					access++;
					//System.out.print("  x");
				}
				//System.out.println();
			}
			int s = 6;
			int e = 6;
			for(int k = -1; k <= 1; k++) {
				for(int l = 0; l <= 1; l++) {
					char[] cur = rolls.get(i + k);
					if(cur[l] == '.') {
						s--;
					}
					if(cur[cur.length - 1 - l] == '.') {
						e--;
					}
				}
			}
			if(s <= 4 && rolls.get(i)[0] == '@') {
				rolls.get(i)[0] = 'x';
				access++;
			}
			if(e <= 4 && rolls.get(i)[rolls.get(i).length - 1] == '@') {
				rolls.get(i)[rolls.get(i).length - 1] = 'x';
				access++;
			}
			System.out.println(String.valueOf(rolls.get(i)));
		}
		
		System.out.println("\nThere are " + access + " rolls of paper that can be accessed.");
		
	}
}
