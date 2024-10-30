package edu.miu.cse.model;

import java.time.LocalDate;

public class PensionPlan {

    private final String planReferenceNumber;

    private final LocalDate enrollmentDate;

    private final double monthlyContribution;

    public String getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public double getMonthlyContribution() {
        return monthlyContribution;
    }

    public PensionPlan(String planReferenceNumber, LocalDate enrollmentDate, double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }
}
