package seriable.deep.clone;

import java.io.*;

/**
 * Created by hadoop on 18-9-15
 */
public class Student implements Serializable {
    String stuName;
    int stuAge;

    public Student(String stuName, int stuAge) {
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    @Override
    public Object clone() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(bais);
            return (ois.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
