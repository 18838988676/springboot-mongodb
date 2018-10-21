package cn.com.wmc.entity;



import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by nbfujx on 2017-12-07.
 */

//collection document的名字有下面几种方式：
//
//1. 默认为类名，并且首字母小写。　　比如com.test.Person -> person
//
//2. 通过在类名上增加标记@Document 来指定。
//
//3. 在执行操作时，把collectionname作为参数传递进去。

@Document(collection="User")
public class User implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    private Long id;
    private String username;
    private Integer age;

    public User(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "\"User:{\"id\":\""+id+"\",\"username\":\""+username+"\",\"age\":\""+age+"\"}\"";
    }
}