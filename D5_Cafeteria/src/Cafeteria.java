import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 */
public class Cafeteria {
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
