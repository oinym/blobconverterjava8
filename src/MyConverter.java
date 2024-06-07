import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;

public abstract class MyConverter {
    
    
    static Blob convertToBlob(Object obj) throws IOException, SQLException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        byte[] bytes = bos.toByteArray();
        return new SerialBlob(bytes);
    }
    
    public static Object convertToObject(Blob blob) throws IOException, ClassNotFoundException, SQLException {
        byte[] bytes = blob.getBytes(1, (int) blob.length());
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
    
    private static byte[] serialize(Person person) throws Exception{
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(person);
            out.flush();
            return bos.toByteArray();
        }
    }
    private static Person desirialize(byte[] bytes){
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        
        try (ObjectInput in = new ObjectInputStream(bis)) {
            Person person=(Person) in.readObject();
            return person;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    

}


