public class Zad1
{
	public static int remainder(int a, int b){
	int c = a % b;
	return c;
}
	public static int triArea(int a, int b){
		int c=(a*b)/2;
		return c;
}
	public static int Animals(int a,int b, int c){
		int d=a*2+b*4+c*4;
		return d;
}
	public static boolean profitableGamble(double a, int b, int c){
		if (a * b > c)
            return true;
        else
            return false;
}
	public static String operation(int n, int a, int b){
		if (n==a-b)
			return "substracted";
		else
			if (n==a/2)
				return "divided";
			else 
				if (n==a+b)
					return "added";
				else
					if (n==a*b)
						return "multiplication";
					else
						return "none";

}
	public static int ctoa(char a){
		int ascii=a;
		return ascii;
}
	public static int addUpTo(int a){
		int b=0;
		while (a>0){
			b=b+a;
			a=a-1;
		}
		return b;
	}
		public static int nextEdge(int a, int b){
		int c=a+b-1;
		return c;
	}

	public static int sumOfCubes(int[] nums){
		int b=0;
		int length=nums.length;
		for (int i=0; i<length; i++)
			b=b+nums[i]*nums[i]*nums[i];
		return b;
	}

	public static Boolean abcmath(int a, int b, int c){
		while (b>0){
			a=a+a;
			b=b-1;
		}
		if (a%c==0)
			return true;
		else
			return false;
	}

	public static void main(String[] args)
{
	int f = remainder(3,4);
	System.out.println("remainder(3,4) -> " + f);
	int e = triArea(6,3);
	System.out.println("triArea(6,3) -> " + e);
	int g = Animals(2,3,5);
	System.out.println("animals(2,3,5) -> " + g);
	boolean h = profitableGamble(0.2, 50, 9);
	System.out.println("profitableGamble(0.2,50,9) -> " + h);
	String q = operation(24,15,9);
	System.out.println("operation(24,15,9) -> " + q);
	int z = ctoa('A');
	System.out.println("ctoa('A') -> " + z);
	int w = addUpTo(10);
	System.out.println("addUpTo(10) -> " + w);
	int edge = nextEdge(8,10);
	System.out.println("nextEdge(8,10) -> " + edge);
	int nums[] = new int[] {3,4,5};
	int sum = sumOfCubes(nums);
	System.out.println("sumOfCubes([3,4,5]) -> " + sum);
	boolean abc = abcmath(1,2,3);
	System.out.println("abcmath(1,2,3) -> " + abc);

}
}