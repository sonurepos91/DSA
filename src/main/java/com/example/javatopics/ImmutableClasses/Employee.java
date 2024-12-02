package com.example.javatopics.ImmutableClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Employee {
    private final String empName;
    private final int empId;
    private final List<String> phoneNumbers;
    private final Map<String, String> metadata;
    private final Address address;

    public Employee (String empName, int empId, List<String> phoneNumbers, Map<String, String> metadata, Address address) {
        this.empName = empName;
        this.empId = empId;
        this.phoneNumbers = phoneNumbers;
        this.metadata = metadata;
        this.address = address;
    }

    public String getEmpName () {
        return empName;
    }

    public int getEmpId () {
        return empId;
    }

    public List<String> getPhoneNumbers () {
        return new ArrayList<>(phoneNumbers);
    }

    //Deep Copy
    public Map<String, String> getMetadata () {
        return new HashMap<>(metadata);
    }

    public Address getAddress () throws CloneNotSupportedException {
        return (Address) address.clone();
    }

    @Override
    public String toString () {
        return "Employee{" + "empName='" + empName + '\'' + ", empId=" + empId + ", phoneNumbers=" + phoneNumbers + ", metadata=" + metadata + ", address=" + address + '}';
    }
}
