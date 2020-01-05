package dynamic;

import java.util.Scanner;

public class Padovan_9461 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int i=0; i<test_case; i++) {
			int n = sc.nextInt();
			long[] p = new long[n];
			
			p[0] = 1;
			for(int j=1; j<n; j++) {
				if(j==1 || j==2) {
					p[j] = 1;
					continue;
				}
				p[j] = p[j-2] + p[j-3];
			}
			
			System.out.println(p[n-1]);
		}
	}
}
