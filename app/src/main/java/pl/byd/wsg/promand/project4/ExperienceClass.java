package pl.byd.wsg.promand.project4;

/**
 * Created by Marika on 17.03.14.
 */
public class ExperienceClass {
    Integer code = null;
    String name = null;
    boolean selected = false;

    public ExperienceClass(Integer code, String name, boolean selected) {
        super();
        this.code = code;
        this.name = name;
        this.selected = selected;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
