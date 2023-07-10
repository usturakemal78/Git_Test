package techproed.day14__Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C04_Faker {
    @Test
    public void faker() {
        /*
        Faker calss'ından sahte verileri kullanabilmek için obje oluşturmamız gerekir.
         */
        Faker faker = new Faker();

        //Faker objesini kullanrak bir isim yazdırınız
        System.out.println("Isim       : "+faker.name().firstName());

        //faker kullanarak lastname yazdıralım
        System.out.println("Soyisim    : "+faker.name().lastName());

        //faker kullanarak fullname yazdıralım
        System.out.println("Tam Isim   : "+faker.name().fullName());

        //faker kullanarak adress yazdıralım
        System.out.println("Adress     : "+faker.address().fullAddress());

        //faker kullanarak tel_no yazdıralım
        System.out.println("Telefon Cep: "+faker.phoneNumber().cellPhone());
        System.out.println("Telefon Sbt: "+faker.phoneNumber().phoneNumber());

        //faker kullanarak rastgele numara yazdıralım yazdıralım
        System.out.println("Random No  : "+faker.number().digits(15));

        //faker kullanarak meslek pozisyon yazdıralım
        System.out.println("Meslek Pz. : "+faker.job().keySkills());
    }
}
