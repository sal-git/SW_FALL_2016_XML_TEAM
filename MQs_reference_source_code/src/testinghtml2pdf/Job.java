/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinghtml2pdf;

/**
 *
 * @author MQ0162246
 */
public class Job {

    private String employer;
    private String supervisor;
    private String city;
    private String state;
    private String description;
    private String years;

    public Job(String employer, String supervisor, String city, String state, String description, String years) {
        this.employer = employer;
        this.supervisor = supervisor;
        this.city = city;
        this.state = state;
        this.description = description;
        this.years = years;
    }

    /**
     * @return the employer
     */
    public String getEmployer() {
        return employer;
    }

    /**
     * @param employer the employer to set
     */
    public void setEmployer(String employer) {
        this.employer = employer;
    }

    /**
     * @return the supervisor
     */
    public String getSupervisor() {
        return supervisor;
    }

    /**
     * @param supervisor the supervisor to set
     */
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the years
     */
    public String getYears() {
        return years;
    }

    /**
     * @param years the years to set
     */
    public void setYears(String years) {
        this.years = years;
    }
}
