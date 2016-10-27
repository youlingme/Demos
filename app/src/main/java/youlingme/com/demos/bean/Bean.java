package youlingme.com.demos.bean;

/**
 * Created by wanghan on 16/10/26.
 */
public class Bean {

    private String name;
    private Class className;

    public Bean(String name, Class className) {
        this.name = name;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getClassName() {
        return className;
    }

    public void setClassName(Class className) {
        this.className = className;
    }
}
