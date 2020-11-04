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

        @OneToMany
        @JoinColumn
        private List<Job> jobs=new ArrayList<>();

        @NotNull
        @Size (max = 50)
        private String location;




        public String getLocation () {
            return location;
        }

        public void setLocation (String location){
            this.location = location;
        }

        public Employer() {

    }
}
