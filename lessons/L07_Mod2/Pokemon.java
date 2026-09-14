/******************************************************************************
 *  Compilation:  javac Pokemon.java
 *  Execution:    java Pokemon N
 *
 *  Estimates the number of booster packs you would need to buy
 *    to get all 102 original Pokemon cards
 *
 *  The given N is the number of trials to average over
 *
 *  
 *
 *  Note: We are assuming that each card is equally likely
 *
 ******************************************************************************/

public class Pokemon {

    public static void main(String[] args) {
		final int NUM_CARDS = 102;
		final int CARDS_PER_PACK = 11;

		// Arg 1: Number of Trials to run
        int numTrials = Integer.parseInt(args[0]); 

		double totalPacks = 0;
		int minPacks = Integer.MAX_VALUE;
		int maxPacks = Integer.MIN_VALUE;

		for (int t = 0; t < numTrials; t++) {
			int packs = 0;  

			// Simulate number of packs needed to get 102 cards

			minPacks = Math.min(minPacks, packs);
			maxPacks = Math.max(maxPacks, packs);

			System.out.printf("  Trial %2d: %3d packs\n", t, packs);
			totalPacks += packs;
		}

        System.out.printf("Average number of packs: %.1f\n", totalPacks / numTrials);
        System.out.printf("Maximum number of packs: %d\n", maxPacks);
        System.out.printf("Minimum number of packs: %d\n", minPacks);
    }
}
