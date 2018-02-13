import java.util.*;

public class IteratorPractice {
	public static void printStrings(List<String> list, String s) {
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String test = iterator.next();
			if (s.length() <= test.length()) {
				String temp = test.substring(0, s.length());
				if (temp.equals(s))
					System.out.print(s);
			}
		}
	}
	public static void printStrings2(String[] list, String s) {
		ArrayIterator<String> iterator = new ArrayIterator<String>(list);
		while (iterator.hasNext()) {
			String test = iterator.next();
			if (s.length() <= test.length()) {
				String temp = test.substring(0, s.length());
				if (temp.equals(s))
					System.out.print(s);
			}
		}
	}
	public static void removeRepetitions(List<String> list) {
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String s = iterator.next();
			if (iterator.hasNext() && s.equals(iterator.next()))
				iterator.remove();
		}
	}
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print("Enter a string: ");
			scan.nextLine();
		}
		String s = new String("his");
		printStrings(list, s);
		
		String[] list2 = {};
		for (int i = 0; i < 5; i++) {
			System.out.print("Enter a string: ");
			scan.nextLine();
		}
		printStrings2(list2, s);
		
		removeRepetitions(list);
		
		scan.close();
	}
}
