package com.isadorastrottmann.apicrudcustomer.stubs;

import com.isadorastrottmann.apicrudcustomer.model.dto.CustomerDto;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public class CustomerDtoStub {

    public static CustomerDto getNoIdCustomerDtoSutb() {
        return new CustomerDto(
                "",
                "isadora",
                "51 987654321",
                1999,
                9,
                23,
                "isadora@email.com",
                "123456");
    }

    public static CustomerDto getRandomIdCustomerDtoSutb() {
        var id = new ObjectId().toString();
        return new CustomerDto(
                id,
                "isadora "+id,
                "51 99876-5432",
                1999,
                9,
                23,
                "isadora"+id+"@email.com",
                "123456");
    }

    public static CustomerDto getWrongPhoneCustomerDtoSutb() {
        var id = new ObjectId().toString();
        return new CustomerDto(
                id,
                "isadora "+id,
                "51 6587432",
                1999,
                9,
                23,
                "isadora"+id+"@email.com",
                "123456");
    }

    public static CustomerDto getInvalidBirthDateCustomerDtoSutb() {
        var id = new ObjectId().toString();
        return new CustomerDto(
                id,
                "isadora "+id,
                "51 987654321",
                LocalDateTime.now().getYear(),
                9,
                23,
                "isadora"+id+"@email.com",
                "123456");
    }


}
