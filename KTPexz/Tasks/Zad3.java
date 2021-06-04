import java.util.Scanner;
import static java.lang.Math.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import static java.lang.System.*;

public class Zad3 {
	public static double average( double nums[]){
		double sum = 0.0;
		double avg = 0.0;
		for (int i=0; i<nums.length; i++){
			sum += nums[i];
		}
		avg = sum / nums.length;
		return avg;

	}
	public static boolean doesBrickFit (int a, int b, int c, int w, int h){
		if (w>=a && h>=b || w>=b && h>=a
			|| w>=a && h>=c || w>=c && h>=a 
		|| w>=c && h>=b || w>=b && h>=c)
			return true;
				else
			return false;
	}
	public static void reverseCase(String s){
		String f="";
		for(int i=0;i<s.length();i++){
		char c = s.charAt(i);
        boolean h=Character.isUpperCase(c);
        if (h){c=Character.toLowerCase(c);}
        else{c=Character.toUpperCase(c);}
        f+=c;
	}
    System.out.println(f);    

	}
	public static String rps(String a, String b){
		if (a.equals("rock") && b.equals("scissors") || a.equals("scissors") && b.equals("paper") || a.equals("paper") && b.equals("rock"))
			return "Player 1 wins";
		else 
			if (a.equals(b))
				return "TIE";
		else
			return "Player 2 wins";
	}
	public static String[][] millionsRounding(String[]... a)
	{
		for(int i=0; i<a.length; i++)
		{
			BigDecimal r=new BigDecimal(a[i][1]);
			r=r.divide(new BigDecimal("1000000")).setScale(0, RoundingMode.HALF_UP);
			a[i][1]=r.toString()+"000000";
		}
		return a;
	}
	public static void otherSides(int f){
		double []a=new double[2];
		double n=3.0;
		a[0]=f*2;
		a[1]=Math.pow(f,1/n);
		System.out.printf("2 zad->[%.2f,%.2f ]\n",a[0],a[1]);
	}
	public static void inatorInator() {
		String s ="aeigfhe";
		char a=s.charAt(s.length()-1);
		int y=s.length()-1;
		if(a == 'a' || a == 'A' || a == 'e' || a == 'E' || a == 'i' || a == 'I' || a == 'o' || a == 'O' || a == 'u' || a == 'U') {System.out.println("6 zad->" + s +"-inator " + s.length() + "000");}
				else {System.out.println("6 zad->"+ s +"inator " + y + "000");
			}
		}
				public static void warOfNumbers(){
		int [] a=new int[] {1,3,6,5,1};
		int d=0, c=0;
		for(int i= 0; i<=a.length-1; i++){
			if (a[i]%2==0) {d+=a[i];}
				else {c+=a[i];}
		}
		System.out.println("4 zad->"+Math.abs(d-c));
	}
		public static void totalDistance(double a, double b, int s, boolean r){
			if (r){System.out.println("zad8->"+(a*100)/(b*(1+s*0.05)*1.1));}
			else{System.out.println("Zad8->"+(a*100)/(b*(1+s*0.05)));}
	}
	public static void parityAnalysis(int h){
		boolean w= h%2==0?true:false;
		int k=0, l=h;
		double p=0,z=0;
		while (l!=0){
			 k++;
			 l=l/10;
			
		}
	
		while (k>0){
			 p=h;
			 
			 z=z+p;
			k--;
		}
		boolean r=z%2==0?true:false;
		if (w==r){System.out.println("Zad10-> true");}
		else {System.out.println("Zad10-> false");}
		
	}


	public static void main(String [] args){
		Scanner v= new Scanner(System.in);
		int m=v.nextInt();
		String a = "scissors";
		String b = "paper";
		double l[] =new double [] {2, 3, 2, 3};
	double c = average(l);
	System.out.println("mean () -> " + c);
	boolean brick = doesBrickFit(1,1,1,1,1);
	System.out.println("doesBrickFit(1,1,1,1,1) ->" + brick);
	String g ="aaaBBB";
	reverseCase(g);
	System.out.println(rps(a,b));
	System.out.println(Arrays.deepToString(millionsRounding(new String[] {"St.Petersburg", "9000000"},new String[] {"Otawa", "1500000"})));
	otherSides(m);
		warOfNumbers();
		inatorInator();
		double q=v.nextDouble();
		double w=v.nextDouble();
		int t=v.nextInt();
		boolean j = v.nextBoolean();
		totalDistance(q,w,t,j);
		
		int t2=v.nextInt();
		parityAnalysis(t2);


}
}