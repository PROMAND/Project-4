package pl.byd.wsg.promand.project4;

/**
 * Created by Marika on 20.03.14.
 */
public class LinkedInReader {
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


    public static long getId() {
        return id;
    }

    public static void setId(long id) {
        LinkedInReader.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    public String getIndusty() {
        return industy;
    }

    public void setIndusty(String industy) {
        this.industy = industy;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(String mainAddress) {
        this.mainAddress = mainAddress;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSpecialities() {
        return specialities;
    }

    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        String fname, lname, birth, addr, education, cert, lang, industry, skills, specs, interests;

        if(!getFirstName().equalsIgnoreCase("empty")){
            sb.append("CV \n\n" + " First name: " + getFirstName());
        }

        if(!getLastName().equalsIgnoreCase("empty")){
            sb.append("\n\n Last Name: " + getLastName());
        }

        if(!getDateOfBirth().equalsIgnoreCase("empty")){
            sb.append("\n\n Date Of Birth: " + getDateOfBirth());
        }

        if(!getMainAddress().equalsIgnoreCase("empty")){
            sb.append("\n\n Address: " + getMainAddress());
        }

        if(!getEducation().equalsIgnoreCase("empty")){
            sb.append("\n\n Education: " + getEducation());
        }

        if(!getCertifications().equalsIgnoreCase("empty")){
            sb.append("\n\n Certifications: " + getCertifications());
        }

        if(!getLanguages().equalsIgnoreCase("empty")){
            sb.append("\n\n Languages: " + getLanguages());
        }

        if(!getIndusty().equalsIgnoreCase("empty")){
            sb.append("\n\n Industry: " + getIndusty());
        }

        if(!getSkills().equalsIgnoreCase("empty")){
            sb.append("\n\n Skills: " + getSkills());
        }

        if(!getSpecialities().equalsIgnoreCase("empty")){
            sb.append("\n\n Specialities: " + getSpecialities());
        }

        if(!getInterests().equalsIgnoreCase("empty")){
            sb.append("\n\n Interests: " + getInterests());
        }

        return sb.toString();
    }

}
