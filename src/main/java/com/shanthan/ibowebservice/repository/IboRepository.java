package com.shanthan.ibowebservice.repository;

import com.shanthanc.ibo.Address;
import com.shanthanc.ibo.Ibo;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class IboRepository {

    private static final Map<String, Ibo> ibos = new HashMap<>();

    @PostConstruct
    public void initData() {
        Ibo ibo1 = new Ibo();

        Address address1 = new Address();
        address1.setAddressLine1("123 S Abc St");
        address1.setAddressLine2("Apt 123");
        address1.setCity("Chicago");
        address1.setState("IL");
        address1.setCountry("USA");
        address1.setZipCode("60608");

        ibo1.setIboNumber("71234561");
        ibo1.setName("Shanthan Cheruku");
        ibo1.setAge(32);
        ibo1.setSsn("123-45-6789");
        ibo1.setAddress(address1);

        Ibo ibo2 = new Ibo();

        Address address2 = new Address();
        address2.setAddressLine1("123 N Def St");
        address2.setAddressLine2("Apt 456");
        address2.setCity("Chicago");
        address2.setState("IL");
        address2.setCountry("USA");
        address2.setZipCode("60609");

        ibo2.setIboNumber("71234562");
        ibo2.setName("Adam Foster");
        ibo2.setAge(30);
        ibo2.setSsn("312-54-9876");
        ibo2.setAddress(address2);

        Ibo ibo3 = new Ibo();

        Address address3 = new Address();
        address3.setAddressLine1("123 E Xyz St");
        address3.setAddressLine2("Apt 981");
        address3.setCity("Chicago");
        address3.setState("IL");
        address3.setCountry("USA");
        address3.setZipCode("60616");

        ibo3.setIboNumber("71234563");
        ibo3.setName("Alexis Miller");
        ibo3.setAge(29);
        ibo3.setSsn("678-90-2345");
        ibo3.setAddress(address3);

        ibos.put(ibo1.getIboNumber(), ibo1);
        ibos.put(ibo2.getIboNumber(), ibo2);
        ibos.put(ibo3.getIboNumber(), ibo3);

    }

    public Ibo findIbo(String iboNumber) {
        Assert.notNull(iboNumber, "Must enter ibo number");
        return ibos.get(iboNumber);
    }
}
