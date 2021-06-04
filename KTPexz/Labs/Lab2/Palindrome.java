import java.util.Scanner;
public class Palindrome {
	public static String reverseString(String s){
		String r = "";
    // берем символы исходной строки с конца строки до начала
    // и добавляем ее в начала строки-результата (переменная r)
    for (int i = s.length() - 1; i >= 0; --i) 
    	r += s.charAt(i);
    return r;
	}
	public static boolean isPalindrome(String s){
		if(s.equals(reverseString(s))){
            System.out.println("- is Palindrome");
        }else{
            System.out.println("- is not Palindrome");
        }
        return s.equals(reverseString(s));
	}

 public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
        String s=scan.next();
        isPalindrome(s);
} }
