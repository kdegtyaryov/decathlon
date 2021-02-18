package org.example.decathlon.model.utils;

import org.example.decathlon.model.AthleteResults;
import org.example.decathlon.model.input.AthleteResultsReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Konstanin Degtyaryov on 17.02.2021.
 */
public class DecathlonResultProcessor {
    private AthleteResultsReader athleteResultsReader;

    public static List<AthleteResults> processResults(AthleteResultsReader athleteResultsReader) {
        List<AthleteResults> sortedResults = new ArrayList(athleteResultsReader.read());

        sortedResults.sort(new Comparator<AthleteResults>() {
            @Override
            public int compare(AthleteResults o1, AthleteResults o2) {
                return Integer.compare(o2.getTotalScore(), o1.getTotalScore());
            }
        });

        evalPlace(0, 0, "", sortedResults, new ArrayList<AthleteResults>());
        return sortedResults;
    }

    private static void evalPlace(int idx, int prevTotalScore, String prevPlace, List<AthleteResults> allResults, List<AthleteResults> placeResults) {
        // Stop count
        if (idx >= allResults.size()) {
            if (placeResults != null) {
                placeResults.stream().forEach(a -> a.setPlace(prevPlace));
            }
            return;
        }

        // Continue result group
        if (Integer.compare(prevTotalScore, allResults.get(idx).getTotalScore()) == 0) {
            placeResults.add(allResults.get(idx));
            String newPlace = prevPlace + "-" + (idx+1);
            evalPlace(idx+1, prevTotalScore, newPlace, allResults, placeResults);
        }
        // New result group
        else {
            // Save previous results
            if (placeResults != null) {
                placeResults.stream().forEach(a -> a.setPlace(prevPlace));
            }

            // Create new result group
            List<AthleteResults> newPlaceResults = new ArrayList<AthleteResults>();
            newPlaceResults.add(allResults.get(idx));
            String newPlace = Integer.toString(idx + 1);
            int newResults = allResults.get(idx).getTotalScore();
            evalPlace(idx+1, newResults, newPlace, allResults, newPlaceResults);
        }
    }
}
