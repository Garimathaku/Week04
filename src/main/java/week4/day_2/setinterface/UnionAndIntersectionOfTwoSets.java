package week4.day_2.setinterface;


import java.util.*;

class UnionAndIntersectionOfTwoSets<T> {
    private Set<T> set1;
    private Set<T> set2;
    //constructor
    public UnionAndIntersectionOfTwoSets(Set<T> set1, Set<T> set2) {
        this.set1 = set1;
        this.set2 = set2;
    }

    public Set<T> getUnion() {
        Set<T> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }

    public Set<T> getIntersection() {
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }
    //main method
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        UnionAndIntersectionOfTwoSets<Integer> operations = new UnionAndIntersectionOfTwoSets<>(set1, set2);

        System.out.println("Union: " + operations.getUnion());
        System.out.println("Intersection: " + operations.getIntersection());
    }
}

