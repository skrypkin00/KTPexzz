public class Zad2 {
	public static int oppositeHouse(int a, int b) {
		int i = 0;
		if (a == b * 2)
			return 1;
		if (a == 1)
			return b * 2;
		if (a == 2)
			return b * 2 - 1;
		while (a > 2){
			i++;
			a = a - 2;
		}
		if (a % 2 == 0)
			return b*2 - 1 - i * 2;
		else
			return b * 2 - i * 2;
	}

	public static String nameShuffle(String n){
		String name = "";
		name += " ";
		String surname = "";
		int len = n.length();
		int i = 0;
		while (len > i && n.charAt(i) != 32){
			name += n.charAt(i);
			i++;
		}
		i++;
		while (len > i){
			surname += n.charAt(i);
			i++;
		}
		return surname + name;
	}
	public static double discount(int a, int b){
		double d = b;
		double c = a * (1 - (d/100));
		return c;
	}

	public static int differenceMaxMin(int arr[]){
		int max = arr[0];
		int min = max;

		for (int i = 0; i < arr.length; i++){
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}
		return max - min;
	}

	public static int equal(int a, int b, int c){
		int eq = 0;
		if (a == b)
			eq++;
		if (a == c)
			eq++;
		if (b == c)
			eq++;
		if (eq == 1)
			eq++;
		return eq;
	}

	public static String reverse(String s){  
		int len = s.length(); 
		String str = ""; //Функция создает новую строку
		while (len > 0){ 
			str = str + s.charAt(len - 1);//начиная с конца
			len--;//записывает в нее поочередно все элементы входящей строки
		}
		return str;
	}

	public static int programmers(int a, int b, int c){
		int max = a;
		int min = a;
		if (a > b)
			min = b;
		else
			max = b;
		if (max < c)
			max = c;
		if (min > c)
			min = c;
		return max - min;
	}
	public static boolean getXO(String s){
		int len = s.length();
		int x1 = 0;
		int o1 = 0;
		for (int i = 0; i < s.length();i++){
			if (s.charAt(i) == 88 || s.charAt(i) == 120)
				x1++;
			if (s.charAt(i) == 79 || s.charAt(i) == 111)
				o1++;
		}
		if (x1 == o1)
			return true;
		else
			return false;
	}

	public static String bomb(String s){
		for (int i = 0;i < s.length();i++){
			if (s.charAt(i) == 66 || s.charAt(i) == 98)
				if (s.charAt(i + 1) == 79 || s.charAt(i + 1) == 111)
					if (s.charAt(i + 2) == 77 ||s.charAt(i + 2) == 109)
						if (s.charAt(i + 3) == 66 || s.charAt(i + 3) == 98)
							return "DUCK!";
		}
		return "Relax, there's no bomb.";
	}

	public static boolean sameASCII(String s, String n){
		int s1 = 0;
		int n1 = 0;
		for (int i = 0; i < s.length();i++){
			s1 = s1 + s.charAt(i);
		}
		for (int i = 0; i < n.length();i++){
			n1 = n1 + n.charAt(i);
		}
		if (s1 == n1)
			return true;
		else
			return false;
	}
	public static void main(String[] args){
		int nums[] = new int[] {10, 4, 1, 4, -10, -50, 32, 21};
		System.out.println(oppositeHouse(5,46));
		System.out.println(nameShuffle("Donald Trump"));
		System.out.println(discount(89, 20));
		System.out.println(differenceMaxMin(nums));
		System.out.println(equal(1,2,3));
		System.out.println(reverse("Edabit is really helpful!"));
		System.out.println( programmers(756,325,3000));
		System.out.println(getXO("xXoO"));
		System.out.println(bomb("This goes boom!!!"));
		System.out.println(sameASCII("EdAbIt", "EDABIT"));	
	}
}