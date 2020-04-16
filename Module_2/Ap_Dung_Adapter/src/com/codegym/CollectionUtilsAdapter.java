package com.codegym;

import java.util.*;

public class CollectionUtilsAdapter {
    private CollectionUtils collectionUtils;

    public CollectionUtilsAdapter(CollectionUtils collectionUtils) {
        this.collectionUtils = collectionUtils;
    }

    public void printMaxValue(List<Integer> numbers) {
        int max = collectionUtils.findMax(numbers);
        System.out.println("Max value is: " + max);
    }
}
