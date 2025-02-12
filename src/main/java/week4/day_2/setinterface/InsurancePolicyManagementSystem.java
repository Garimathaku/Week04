package week4.day_2.setinterface;

import java.util.*;


class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    // Constructor
    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getters
    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public Date getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmount() { return premiumAmount; }

    // Override equals() and hashCode() to ensure uniqueness based on policy number
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy policy = (InsurancePolicy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // Implement compareTo for TreeSet sorting by expiry date
    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    // Override toString for easy display
    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Holder: " + policyholderName + ", Expiry: " + expiryDate + ", Type: " + coverageType + ", Premium: " + premiumAmount;
    }
}

// Main class implementing the system
public class InsurancePolicyManagementSystem {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    // Method to add a policy to all sets
    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Retrieve all unique policies
    public void displayAllPolicies() {
        System.out.println("All Unique Policies:");
        for (InsurancePolicy policy : hashSetPolicies) {
            System.out.println(policy);
        }
    }

    // Retrieve policies expiring within the next 30 days
    public void displayExpiringSoon() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date thresholdDate = calendar.getTime();

        System.out.println("Policies Expiring Soon:");
        for (InsurancePolicy policy : treeSetPolicies) {
            if (policy.getExpiryDate().before(thresholdDate)) {
                System.out.println(policy);
            }
        }
    }

    // Retrieve policies based on coverage type
    public void displayPoliciesByCoverage(String coverageType) {
        System.out.println("Policies with coverage type: " + coverageType);
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    // Identify duplicate policies based on policy number
    public void displayDuplicatePolicies() {
        Map<String, Integer> policyCount = new HashMap<>();
        for (InsurancePolicy policy : hashSetPolicies) {
            policyCount.put(policy.getPolicyNumber(), policyCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }

        System.out.println("Duplicate Policies:");
        for (Map.Entry<String, Integer> entry : policyCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Policy Number: " + entry.getKey() + " appears " + entry.getValue() + " times.");
            }
        }
    }

    // Compare performance of different sets
    public void comparePerformance() {
        int numPolicies = 100000;
        Random random = new Random();
        long startTime, endTime;

        System.out.println("Performance Comparison:");

        // HashSet Performance
        startTime = System.nanoTime();
        Set<InsurancePolicy> testHashSet = new HashSet<>();
        for (int i = 0; i < numPolicies; i++) {
            testHashSet.add(new InsurancePolicy("P" + i, "Holder" + i, new Date(), "Auto", random.nextDouble() * 1000));
        }
        endTime = System.nanoTime();
        System.out.println("HashSet Insert Time: " + (endTime - startTime) / 1e6 + " ms");

        // LinkedHashSet Performance
        startTime = System.nanoTime();
        Set<InsurancePolicy> testLinkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < numPolicies; i++) {
            testLinkedHashSet.add(new InsurancePolicy("P" + i, "Holder" + i, new Date(), "Auto", random.nextDouble() * 1000));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Insert Time: " + (endTime - startTime) / 1e6 + " ms");

        // TreeSet Performance
        startTime = System.nanoTime();
        Set<InsurancePolicy> testTreeSet = new TreeSet<>();
        for (int i = 0; i < numPolicies; i++) {
            testTreeSet.add(new InsurancePolicy("P" + i, "Holder" + i, new Date(), "Auto", random.nextDouble() * 1000));
        }
        endTime = System.nanoTime();
        System.out.println("TreeSet Insert Time: " + (endTime - startTime) / 1e6 + " ms");
    }

    // Main method
    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();
        system.addPolicy(new InsurancePolicy("1234", "ABC", new Date(), "Health", 600.0));
        system.addPolicy(new InsurancePolicy("5456", "XYZ", new Date(), "life", 900.0));

        system.displayAllPolicies();
        system.displayExpiringSoon();
        system.displayPoliciesByCoverage("life");
        system.displayDuplicatePolicies();
        system.comparePerformance();
    }
}

