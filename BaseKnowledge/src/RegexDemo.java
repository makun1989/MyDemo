
public class RegexDemo {
	public static void main(String[] args) {
//		String MEM_REGEX="/d{1,7} kB: .* \\(pid [0-9]{1,5} / activities\\)";
//		System.out.println("35039 kB: com.gm.gmaudio (pid 4103 / activities)".matches(MEM_REGEX));
		
		//0% 4103/com.gm.gmaudio: 0% user + 0% kernel / faults: 2452 minor
		String flo="[0-9]{1,5}[.]?[0-9]{0,2}";
		String CPU_REGEX=flo+"% [0-9]{1,5}/.*: "+flo+"% user \\+ "+flo+"% kernel / faults: [0-9]{1,5} minor";
		System.out.println("0% 4103/com.gm.gmaudio: 0% user + 0% kernel / faults: 2452 minor".matches(CPU_REGEX));
		//System.out.println("0% 4103/com.gm.gmaudio: 0% user + ".matches(flo+"% [0-9]{1,5}/.*: "+flo+"% user \\+ "));
		
//		System.out.println("35039 kB: com.gm.gmaudio (pid".matches("[0-9]{1,7} kB: .* \\(pid "));
	}
}
