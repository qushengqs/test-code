import java.io.Serializable;

/**
 * @Author: senne
 * @Date: 2019/6/29 10:20
 * @Version 1.0
 */
public class Customer implements Serializable {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
