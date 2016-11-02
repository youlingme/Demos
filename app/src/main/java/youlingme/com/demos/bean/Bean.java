package youlingme.com.demos.bean;

/**
 * Created by wanghan on 16/10/26.
 */
public class Bean {

    private String name;
    private Class intentClass;

    public Bean(String name, Class intentClass) {
        this.name = name;
        this.intentClass = intentClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getIntentClass() {
        return intentClass;
    }

    public void setIntentClass(Class intentClass) {
        this.intentClass = intentClass;
    }
}
