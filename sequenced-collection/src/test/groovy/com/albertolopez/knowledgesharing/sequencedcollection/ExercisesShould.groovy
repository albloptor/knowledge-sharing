package com.albertolopez.knowledgesharing.sequencedcollection


import spock.lang.Specification
import spock.lang.Subject

class ExercisesShould extends Specification {

    @Subject
    def exercises = new Exercises()

    def "get first element from a list"() {
        expect:
        exercises.getFirstElementFromList(numbers) == result

        where:
        numbers         || result
        [0, 1, 2, 3, 4] || 0
        [4, 5, 0, 3, 1] || 4
    }

    def "get last element from a list"() {
        expect:
        exercises.getLastElementFromList(numbers) == result

        where:
        numbers         || result
        [0, 1, 2, 3, 4] || 4
        [4, 5, 0, 3, 1] || 1
    }

    def "reverse a list"() {
        expect:
        exercises.reverseList(numbers) == result

        where:
        numbers         || result
        [0, 1, 2, 3, 4] || [4, 3, 2, 1, 0]
        [4, 5, 0, 3, 1] || [1, 3, 0, 5, 4]
    }

    def "get first element from a sorted set"() {
        given:
        def sortedSet = new TreeSet(numbers)

        expect:
        exercises.getFirstElementFromSortedSet(sortedSet) == result

        where:
        numbers         || result
        [1, 1, 2, 3, 4] || 1
        [4, 5, 0, 3, 1] || 0
    }

    def "get last element from a sorted set"() {
        given:
        def sortedSet = new TreeSet(numbers)

        expect:
        exercises.getLastElementFromSortedSet(sortedSet) == result

        where:
        numbers         || result
        [1, 1, 2, 3, 4] || 4
        [4, 5, 0, 3, 1] || 5
    }

    def "get first element from a linked hash set"() {
        given:
        def linkedHashSet = new LinkedHashSet(numbers)

        expect:
        exercises.getFirstElementFromLinkedHashSet(linkedHashSet) == result

        where:
        numbers         || result
        [0, 1, 2, 3, 4] || 0
        [4, 5, 0, 3, 1] || 4
    }

    def "get last element from a linked hash set"() {
        given:
        def linkedHashSet = new LinkedHashSet(numbers)

        expect:
        exercises.getLastElementFromLinkedHashSet(linkedHashSet) == result

        where:
        numbers         || result
        [0, 1, 2, 3, 4] || 4
        [4, 5, 0, 3, 1] || 1
    }

    def "get first element from a double-ended queue"() {
        given:
        def deque = new ArrayDeque(numbers)

        expect:
        exercises.getFirstElementFromDeque(deque) == result

        where:
        numbers         || result
        [0, 1, 2, 3, 4] || 0
        [4, 5, 0, 3, 1] || 4
    }

    def "get last element from a double-ended queue"() {
        given:
        def deque = new ArrayDeque(numbers)

        expect:
        exercises.getLastElementFromDeque(deque) == result

        where:
        numbers         || result
        [0, 1, 2, 3, 4] || 4
        [4, 5, 0, 3, 1] || 1
    }
}
