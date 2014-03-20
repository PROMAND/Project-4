package pl.byd.wsg.promand.project4;

/**
 * Created by Paladin on 3/19/14.
 */
public class DataFromLinkedin {
    private static long id;
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

    public String getNullResult()
    {
        return nullResult;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        if (firstName != null) {
            return firstName;
        }else
        {
            return nullResult;
        }
    }

    public void setFirstName(String firstName) {
            this.firstName = firstName;
    }

    public String getLastName() {
        if (lastName != null) {
            return lastName;
        }else
        {
            return nullResult;
        }
    }

    public void setLastName(String lastName) {
            this.lastName = lastName;
    }

    public String getEducation() {
        if (education != null) {
            return education;
        }else
        {
            return nullResult;
        }
    }

    public void setEducation(String education) {
            this.education = education;
    }

    public String getInterests() {
        if (interests != null) {
            return interests;
        }else
        {
            return nullResult;
        }
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getDateOfBirth() {
        if (dateOfBirth != null) {
            return dateOfBirth;
        }else
        {
            return nullResult;
        }
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCertifications() {
        if (certifications != null) {
            return certifications;
        }else
        {
            return nullResult;
        }
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    public String getIndusty() {
        if (industy != null) {
            return industy;
        }else
        {
            return nullResult;
        }
    }

    public void setIndusty(String industy) {
        this.industy = industy;
    }

    public String getLanguages() {
        if (languages != null) {
            return languages;
        }else
        {
            return nullResult;
        }
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getMainAddress() {
        if (mainAddress != null) {
            return mainAddress;
        }else
        {
            return nullResult;
        }
    }

    public void setMainAddress(String mainAddress) {
        this.mainAddress = mainAddress;
    }

    public String getSkills() {
        if (skills != null) {
            return skills;
        }else
        {
            return nullResult;
        }
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSpecialities() {
        if (specialities != null) {
            return specialities;
        }else
        {
            return nullResult;
        }
    }

    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }

}
