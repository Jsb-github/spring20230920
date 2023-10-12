package com.example.spring20230920.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyDto17Supplier {
   // suppliername, contactname, address, city, postalcode, country, phone;
    private String suppliername;
    private String contactname;
    private String address;
    private String city;
    private String postalcode;
    private String country;
    private String phone;
}
