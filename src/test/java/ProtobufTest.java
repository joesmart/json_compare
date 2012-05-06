import com.example.tutorial.AddressBookProtos;
import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: ZouYanjian
 * Date: 12-5-5
 * Time: 下午11:53
 * To change this template use File | Settings | File Templates.
 */
public class ProtobufTest {
    @Test
    public void protobufShouldFastThanGson() {
        for(int i=0;i<10;i++)
        protobufConvert();
    }

    private void protobufConvert() {
        AddressBookProtos.Person.Builder person = AddressBookProtos.Person.newBuilder();
        AddressBookProtos.Person.PhoneNumber.Builder phoneNumber = AddressBookProtos.Person.PhoneNumber.newBuilder().setNumber("12323123").setType(AddressBookProtos.Person.PhoneType.MOBILE);
        person.setEmail("zouyan@1232.com");
        person.setId(10+ new Random().nextInt());
        person.setName("按时打发大师发"+new Date(System.currentTimeMillis())+System.currentTimeMillis());
        person.addPhone(phoneNumber);

        Stopwatch stopwatch = new Stopwatch();
        AddressBookProtos.AddressBook.Builder addressBook = AddressBookProtos.AddressBook.newBuilder();
        addressBook.addPerson(person);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            stopwatch.start();
            addressBook.build().writeTo(outputStream);
            stopwatch.stop();
            System.out.println("protobuf serialize time:" + stopwatch);
            //System.out.println(addressBook.build().toString());
            stopwatch.reset();
            stopwatch.start();
            AddressBookProtos.AddressBook newAddressBook = AddressBookProtos.AddressBook.parseFrom(outputStream.toByteArray());
            stopwatch.stop();
            System.out.println("protobuf deserialize time:" + stopwatch);
           // System.out.println(newAddressBook.toString());
          //  System.out.println(newAddressBook.getPerson(0).getName());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
