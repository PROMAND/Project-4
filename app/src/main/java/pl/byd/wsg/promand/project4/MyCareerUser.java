package pl.byd.wsg.promand.project4;

/**
 * Created by Marika on 18.03.14.
 */
public class MyCareerUser {
    private static long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private String trainings;
    private String education;
    private String interests;
    private String strongSides;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTrainings() {
        return trainings;
    }

    public void setTrainings(String trainings) {
        this.trainings = trainings;
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

    public String getStrongSides() {
        return strongSides;
    }

    public void setStrongSides(String strongSides) {
        this.strongSides = strongSides;
    }

    @Override
    public String toString() {

        try {
            return "CV \n\n" + "First name: " + getFirstName()
                    + "\n\n Last Name: " + getLastName()
                    + "\n\n Age: " + getAge().toString()
                    + "\n\n Gender: " + getGender()
                    + "\n\n Education: " + getEducation()
                    + "\n\n Trainings: " + getTrainings()
                    + "\n\n Interests: " + getInterests()
                    + "\n\n Strong sides: " + getStrongSides();
        }
        catch (NullPointerException e)
        {
            return "Please fill data forms to preview cv";
        }
        catch (Exception e)
        {
            return "Sorry students to drunk to attend interviews";
        }
    }

}

