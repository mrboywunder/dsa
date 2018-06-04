package com.dsa.dp;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class AllSubsets {

    Set<Set<Integer>> findAll(Set<Integer> input) {

        final Set<Set<Integer>> retVal = new HashSet<>();
        retVal.add(input);
        input
                .stream()
                .forEach(integer -> {
                    final Set<Integer> localCopy = new HashSet<>(input);
                    localCopy.remove(integer);
                    final Set<Set<Integer>> subsets = this.findAll(localCopy);
                    retVal.add(localCopy);
                    retVal.addAll(subsets);
                });

        return retVal;
    }

}
