package com.albertolopez.knowledgesharing.sequencedcollection;

import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SortedSet;

public class Exercises {

    public int getFirstElementFromList(List<Integer> numbers) {
        //return numbers.get(0);
        return numbers.getFirst();
    }

    public int getLastElementFromList(List<Integer> numbers) {
        //return numbers.get(numbers.size() - 1);
        return numbers.getLast();
    }

    public List<Integer> reverseList(List<Integer> numbers) {
        /*List<Integer> reversedList = new ArrayList<>(numbers);
        Collections.reverse(reversedList);
        return reversedList;*/
        return numbers.reversed();
    }

    public Integer getFirstElementFromSortedSet(SortedSet<Integer> numbers) {
        //return numbers.first();
        return numbers.getFirst();
    }

    public Integer getLastElementFromSortedSet(SortedSet<Integer> numbers) {
        //return numbers.last();
        return numbers.getLast();
    }

    public Integer getFirstElementFromDeque(Deque<Integer> numbers) {
        return numbers.getFirst();
    }

    public Integer getLastElementFromDeque(Deque<Integer> numbers) {
        return numbers.getLast();
    }

    public int getFirstElementFromLinkedHashSet(LinkedHashSet<Integer> numbers) {
        //return numbers.iterator().next();
        return numbers.getFirst();
    }

    public int getLastElementFromLinkedHashSet(LinkedHashSet<Integer> numbers) {
        //return reverseList(List.copyOf(numbers)).get(0);
        return numbers.getLast();
    }

}
