package bruteforce;

import java.util.*;

public class Big_7568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		int[][] bigList = new int[test_case][2];
		
		for(int i=0; i<test_case; i++) {
			bigList[i][0] = sc.nextInt();
			bigList[i][1] = sc.nextInt();
		}
		
		int[] rank = new int[test_case];
		for(int i=0; i<test_case; i++) {
			int biggerCount = 0;
			int weight = bigList[i][0];
			int height = bigList[i][1];
			for(int j=0; j<test_case; j++) {
				if(i==j) continue;
				if(weight < bigList[j][0] && height < bigList[j][1])
					biggerCount += 1;
			}

			rank[i] = biggerCount + 1;
		}
		
		for(int i=0; i<rank.length; i++) {
			System.out.print(rank[i] + " ");
		}
	}
}
