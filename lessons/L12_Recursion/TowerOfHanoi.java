public class TowerOfHanoi {

	// Move n disks from peg A to peg B
	public static void moveStack(int n, int pegA, int pegB) {
		if (n == 1) {
			System.out.printf("Move 1 from Peg %d to Peg %d\n", pegA, pegB);
			return;
		}

		int spare = 6 - pegA - pegB; // get other peg

		// move disks above N to spare peg
		moveStack(n-1, pegA, spare);

		System.out.printf("Move %d from Peg %d to Peg %d\n", n, pegA, pegB);

		moveStack(n-1, spare, pegB);
	}

	public static void main(String[] args) {
		int n = 3;
		if (args.length > 0) {
			n = Integer.parseInt(args[0]);
		}

		// Move n disks from peg 1 to peg 3
		moveStack(n, 1, 3);
	}
}
