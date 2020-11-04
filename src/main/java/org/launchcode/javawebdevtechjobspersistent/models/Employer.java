package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

        @NotNull
        @Size (max = 50)
        private String location;

        @OneToMany
        @JoinColumn
        private List<Job> jobs() {

            ArrayList<Job> jobs = new ArrayList<>();
            return jobs;

        }

        public String getLocation () {
            return location;
        }

        public void setLocation (String location){
            this.location = location;
        }

    public Employer() {

    }
}
