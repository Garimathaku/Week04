package week4.day_1;

import java.util.*;

// Define an abstract class JobRole
abstract class JobRole {
    protected String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public abstract void evaluateResume();
}

//  Create specific job role classes
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    @Override
    public void evaluateResume() {
        System.out.println("Evaluating resume for Software Engineer: " + candidateName);
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    @Override
    public void evaluateResume() {
        System.out.println("Evaluating resume for Data Scientist: " + candidateName);
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }

    @Override
    public void evaluateResume() {
        System.out.println("Evaluating resume for Product Manager: " + candidateName);
    }
}

//Implement a generic class Resume<T extends JobRole>
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void processResume() {
        jobRole.evaluateResume();
    }
}

// Wildcard method to handle multiple job roles
class ResumeScreeningPipeline {
    public static void processMultipleResumes(List<? extends JobRole> jobRoles) {
        for (JobRole jobRole : jobRoles) {
            jobRole.evaluateResume();
        }
    }
}
public class AIDrivenResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice"));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob"));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie"));

        // Process individual resumes
        seResume.processResume();
        dsResume.processResume();
        pmResume.processResume();

        // Process multiple resumes using wildcard method
        List<JobRole> jobRoles = Arrays.asList(new SoftwareEngineer("David"), new DataScientist("Eve"), new ProductManager("Frank"));
        ResumeScreeningPipeline.processMultipleResumes(jobRoles);
    }
}

