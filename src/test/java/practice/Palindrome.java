package practice;

public class Palindrome {

	public boolean isPalindrome(int x) {
		String sb = new StringBuffer(x+"").reverse().toString();
		if(Integer.parseInt(sb) == x)
			return true;
		
		return false;
	}
	
	/*public boolean isPalindrome(int x) {
		int n = 0;
		int temp = x;
		String str = "";
		List<Integer> l = new ArrayList<Integer>();
		while(x>0) {
			n = x % 10;
			l.add(n);
			x = x/10;
		}
		x = temp;
		if(l.get(0)+"" == "-") {
			return false;
		}else {
			Collections.reverse(l);
			for (int integer : l) {
				str = str + integer;
			}
			int revInt = Integer.parseInt(str);
			if(revInt == x )
				return true;
		}
		
		
	}*/
	
	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		boolean flag = palindrome.isPalindrome(1211);
		System.out.println(flag);
	}
}
