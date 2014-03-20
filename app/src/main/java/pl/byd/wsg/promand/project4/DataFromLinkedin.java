package pl.byd.wsg.promand.project4;

import com.google.code.linkedinapi.schema.Certifications;
import com.google.code.linkedinapi.schema.DateOfBirth;
import com.google.code.linkedinapi.schema.Education;
import com.google.code.linkedinapi.schema.Educations;
import com.google.code.linkedinapi.schema.Languages;
import com.google.code.linkedinapi.schema.Skills;

import javax.security.cert.Certificate;

/**
 * Created by Paladin on 3/19/14.
 */
public class DataFromLinkedin {
    private static final long id = 0;
    private String firstName;
    private String lastName;
    private String education;
    private String interests;
    private String dateOfBirth ; // should convert to actual age ? mb
    private String certifications;
    private String industy;
    private String languages; // mb should be list
    private String mainAddress;
    private String skills; // mb should be list
    private String specialities; // mb should be list or we can use general expressions
    private String nullResult = "empty";

    public long getId() {
        return id;
    }


    public String getFirstName() {
            return isNull(firstName);
    }

    public void setFirstName(String firstName) {
            this.firstName = firstName;
    }

    public String getLastName() {
            return isNull(lastName);
    }

    public void setLastName(String lastName) {
            this.lastName = lastName;
    }

    public String getEducation() {
            return isNull(education);
    }

    public void setEducation(Educations education) {
        this.education = education.getEducationList().get(0).getSchoolName()+" "+education.getEducationList().get(0).getFieldOfStudy();
    }

    public String getInterests() {
            return isNull(interests);
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getDateOfBirth() {
            return isNull(dateOfBirth);
    }

    public void setDateOfBirth(DateOfBirth dateOfBirth) {
        this.dateOfBirth = dateOfBirth.getDay().toString()+" "+dateOfBirth.getMonth().toString()+" "+dateOfBirth.getYear().toString();
    }

    public String getCertifications() {
        return isNull(certifications);
    }

    public void setCertifications(Certifications certifications) {
        this.certifications = certifications.getCertificationList().get(0).getName();
    }

    public String getIndusty() {
            return isNull(industy);
    }

    public void setIndusty(String industy) {
        this.industy = industy;
    }

    public String getLanguages() {
            return isNull(languages);
    }

    public void setLanguages(Languages languages) {
        this.languages = languages.getLanguageList().get(0).getLanguage().getName();
    }

    public String getMainAddress() {
            return isNull(mainAddress);
    }

    public void setMainAddress(String mainAddress) {
        this.mainAddress = mainAddress;
    }

    public String getSkills() {
            return isNull(skills);
    }

    public void setSkills(Skills skills) {
        this.skills = skills.getSkillList().get(0).getSkill().getName();
    }

    public String getSpecialities() {
            return isNull(specialities);
    }

    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }
    // returns some value if database doesnt provide data
    private String isNull(String arg)
    {
        if (arg != null)
        {
            return arg;
        }
        else {
            return nullResult;
        }
    }

}
