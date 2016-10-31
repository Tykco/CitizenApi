
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Education {

    private String studentId;
    private String yearOfGraduation;
    private String university;
    private String highestEducationLevel;

    /**
     * 
     * @return
     *     The studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * 
     * @param studentId
     *     The studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * 
     * @return
     *     The yearOfGraduation
     */
    public String getYearOfGraduation() {
        return yearOfGraduation;
    }

    /**
     * 
     * @param yearOfGraduation
     *     The yearOfGraduation
     */
    public void setYearOfGraduation(String yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    /**
     * 
     * @return
     *     The university
     */
    public String getUniversity() {
        return university;
    }

    /**
     * 
     * @param university
     *     The university
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * 
     * @return
     *     The highestEducationLevel
     */
    public String getHighestEducationLevel() {
        return highestEducationLevel;
    }

    /**
     * 
     * @param highestEducationLevel
     *     The highestEducationLevel
     */
    public void setHighestEducationLevel(String highestEducationLevel) {
        this.highestEducationLevel = highestEducationLevel;
    }

}
