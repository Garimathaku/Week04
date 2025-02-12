package week4.day_2.mapinterface;

import java.util.*;


class designVotingSystem<T> {
    private Map<T, Integer> votes = new HashMap<>();
    private Map<T, Integer> voteOrder = new LinkedHashMap<>();
    private TreeMap<T, Integer> sortedVotes = new TreeMap<>();

    public void vote(T candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
        sortedVotes.put(candidate, sortedVotes.getOrDefault(candidate, 0) + 1);
    }
    //method to display result
    public void displayResults() {
        System.out.println("Vote Count (Original Order): " + voteOrder);
        System.out.println("Vote Count (Sorted Order): " + sortedVotes);
    }
}
//Main class
public class VotingSystem {
    public static void main(String[] args) {
        designVotingSystem<String> voting = new designVotingSystem<>();
        voting.vote("xyz");
        voting.vote("abc");
        voting.vote("xyzc");
        voting.vote("fgh");
        voting.vote("ijk");
        voting.displayResults();
    }
}

