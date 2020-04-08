package com.codegym;

import java.util.*;

public class IncreasingOrderMaxLength {
    public void findIncreasingMaxLength(String sourceString) {
        List<List<Character>> LIS = new ArrayList<>();
        char[] arrayChar = sourceString.toCharArray();
		for (int i = 0; i < arrayChar.length; i++) {
			LIS.add(i, new ArrayList<>());
		}

		LIS.get(0).add(arrayChar[0]);

		for (int i = 1; i < arrayChar.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (arrayChar[j] < arrayChar[i] && LIS.get(j).size() > LIS.get(i).size()) {
					LIS.set(i, new ArrayList<>(LIS.get(j)));
				}
			}

			LIS.get(i).add(arrayChar[i]);
		}

		int j = 0;
		for (int i = 0; i < arrayChar.length; i++) {
			if (LIS.get(j).size() < LIS.get(i).size()) {
				j = i;
			}
        }
        
		System.out.print(LIS.get(j));
    }
}