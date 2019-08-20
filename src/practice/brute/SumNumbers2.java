package practice.brute;

import java.util.Scanner;

//2003번 다른 풀이 200ms 빨라짐
public class SumNumbers2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n + 1];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int sum = a[0];
        int ans = 0;
        while (left <= right && right < n) {
            if (sum < s) {
                right += 1;
                sum += a[right];
            } else if (sum == s) {
                ans += 1;
                right += 1;
                sum += a[right];
            } else if (sum > s) {
                sum -= a[left];
                left += 1;
                if (left > right && left < n) {
                    right = left;
                    sum = a[left];
                }
            }
        }
        System.out.println(ans);
    }
}
