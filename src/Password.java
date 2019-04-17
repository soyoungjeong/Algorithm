import java.util.Arrays;
import java.util.Scanner;

public class Password {
    static boolean check(String b){
        int m = 0;
        int j = 0;
        for(int i = 0; i < b.length(); i++){
            if(b.charAt(i) == 'a' || b.charAt(i) == 'e' || b.charAt(i) == 'i' ||
                    b.charAt(i) == 'o' || b.charAt(i) == 'u'){
                m += 1;
            }
            else j += 1;
        }
        if(m >= 1 && j >= 2) return true;
        else return false;
    }
    static void go(String[] a,String b, int index, int l){
        if(b.length() == l) {
            if(check(b)){
                System.out.println(b);
            }
            return ;
        }
        if(index >= a.length) return ;
        go(a, b+a[index], index + 1, l);
        go(a, b,index + 1, l);
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int l = scan.nextInt();
        int c = scan.nextInt();
        String[] a = new String[c];

        for(int i = 0; i < c; i++){
            a[i] = scan.next();
        }
        Arrays.sort(a);

        go(a, "", 0, l);
    }
}
