package DSA_Basics.gcr_codebase.sorting_Algo.scenario_based;

import java.util.*;

public class Top3Medalists {

    public static void main(String args[]) {

        int score[] = {64,25,12,22,11,95,88,99,76};

        Arrays.sort(score);

        System.out.println("Gold : " + score[score.length-1]);
        System.out.println("Silver : " + score[score.length-2]);
        System.out.println("Bronze : " + score[score.length-3]);
    }
}
