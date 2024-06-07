import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    
    public Person() {
    }
    
    @Override
    public String toString() {
        return "Person{" +
                       "firstName='" + firstName + '\'' +
                       ", lastName='" + lastName + '\'' +
                       ", age=" + age +
                       ", email='" + email + '\'' +
                       '}';
    }
    
    public Person(String firstName, String lastName, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
