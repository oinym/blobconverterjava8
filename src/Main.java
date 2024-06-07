import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting");
        Person person=new Person("john","doe",25,"john.doe@gmail.com");
        
        try {
            Blob newBlob=MyConverter.convertToBlob(person);
            System.out.println(newBlob);
            Person newPerson= (Person) MyConverter.convertToObject(newBlob);
            System.out.println(newPerson.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End");
        
    }
}
