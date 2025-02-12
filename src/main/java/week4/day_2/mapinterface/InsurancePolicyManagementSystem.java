package week4.day_2.mapinterface;


import java.time.LocalDate;
import java.util.*;


class Policy<T> {
    private T policyNumber;
    private String policyHolder;
    private LocalDate expiryDate;

    public Policy(T policyNumber, String policyHolder, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
    }

    public T getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolder() {
        return policyHolder;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber=" + policyNumber +
                ", policyHolder='" + policyHolder + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}

// Insurance Policy Management System
class PolicyManager<T> {
    private Map<T, Policy<T>> policyMap = new HashMap<>();
    private Map<T, Policy<T>> orderedPolicyMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, Policy<T>> sortedByExpiry = new TreeMap<>();

    // Add Policy
    public void addPolicy(Policy<T> policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedByExpiry.put(policy.getExpiryDate(), policy);
    }

    // Retrieve Policy by Number
    public Policy<T> getPolicyByNumber(T policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List Policies Expiring in Next 30 Days
    public List<Policy<T>> getPoliciesExpiringSoon() {
        List<Policy<T>> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        for (Map.Entry<LocalDate, Policy<T>> entry : sortedByExpiry.entrySet()) {
            if (entry.getKey().isAfter(today) && entry.getKey().isBefore(next30Days)) {
                expiringPolicies.add(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    // List Policies for a Specific Policyholder
    public List<Policy<T>> getPoliciesByHolder(String policyHolder) {
        List<Policy<T>> holderPolicies = new ArrayList<>();
        for (Policy<T> policy : policyMap.values()) {
            if (policy.getPolicyHolder().equalsIgnoreCase(policyHolder)) {
                holderPolicies.add(policy);
            }
        }
        return holderPolicies;
    }

    // Remove Expired Policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        sortedByExpiry.entrySet().removeIf(entry -> entry.getKey().isBefore(today));
        policyMap.entrySet().removeIf(entry -> entry.getValue().getExpiryDate().isBefore(today));
        orderedPolicyMap.entrySet().removeIf(entry -> entry.getValue().getExpiryDate().isBefore(today));
    }

    // Display all policies
    public void displayAllPolicies() {
        for (Policy<T> policy : orderedPolicyMap.values()) {
            System.out.println(policy);
        }
    }
}

// Main Class to Test
public class InsurancePolicyManagementSystem {
    public static void main(String[] args) {
        PolicyManager<String> manager = new PolicyManager<>();

        // Adding Policies
        manager.addPolicy(new Policy<>("9001", "abc", LocalDate.of(2025, 5, 20)));
        manager.addPolicy(new Policy<>("9002", "xyz", LocalDate.of(2024, 3, 15)));
        manager.addPolicy(new Policy<>("9003", "pqr", LocalDate.of(2024, 2, 25)));
        manager.addPolicy(new Policy<>("9004", "ijk", LocalDate.of(2024, 4, 10)));

        // Display all policies
        System.out.println("All Policies:");
        manager.displayAllPolicies();

        // Retrieve Policy by Number
        System.out.println("\nFetching Policy P1002:");
        System.out.println(manager.getPolicyByNumber("P1002"));

        // Policies Expiring in Next 30 Days
        System.out.println("\nPolicies Expiring in Next 30 Days:");
        List<Policy<String>> expiringPolicies = manager.getPoliciesExpiringSoon();
        expiringPolicies.forEach(System.out::println);

        // Policies for a Specific Policyholder
        System.out.println("\nPolicies for ijk:");
        List<Policy<String>> alicePolicies = manager.getPoliciesByHolder("Alice");
        alicePolicies.forEach(System.out::println);

        // Remove Expired Policies
        System.out.println("\nRemoving Expired Policies...");
        manager.removeExpiredPolicies();

        // Display remaining policies
        System.out.println("\nRemaining Policies:");
        manager.displayAllPolicies();
    }
}

