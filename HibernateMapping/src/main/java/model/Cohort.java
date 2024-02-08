package model;

import jakarta.persistence.*;

@Entity
@Table(name="cohort")
public class Cohort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cohortId;
    private String cohortName;
    private String duration;

    public Cohort(String cohortName, String duration) {
        this.cohortName = cohortName;
        this.duration = duration;
    }

    public Cohort() {

    }

    public int getCohortId() {
        return cohortId;
    }

    public void setCohortId(int cohortId) {
        this.cohortId = cohortId;
    }

    public String getCohortName() {
        return cohortName;
    }

    public void setCohortName(String cohortName) {
        this.cohortName = cohortName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
