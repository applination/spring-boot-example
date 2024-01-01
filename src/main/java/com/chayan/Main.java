package com.chayan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {

    // temp DB
    public static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        // populate the db
        Customer alex = new Customer(
                1,
                "Alex Zone",
                "alex@alexzone.com",
                25
        );
        customers.add(alex);

        Customer jon = new Customer(
                2,
                "Jonita Gandhi",
                "jonita@gandhi.com",
                25
        );
        customers.add(jon);
    }

    public static void main(String[] args) {
        System.out.println(customers);
        SpringApplication.run(Main.class, args);
    }

    // Customer Model
    static class Customer {
        private Integer customerId;
        private String name;
        private String email;
        private Integer age;

        // Default Constructor
        public Customer() {}

        // Constructor
        public Customer(Integer customerId, String name, String email, Integer age) {
            this.customerId = customerId;
            this.name = name;
            this.email = email;
            this.age = age;
        }

        // Getter and Setter
        public Integer getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Integer customerId) {
            this.customerId = customerId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        // equals() and hashCode()
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return Objects.equals(customerId, customer.customerId)
                    && Objects.equals(name, customer.name)
                    && Objects.equals(email, customer.email)
                    && Objects.equals(age, customer.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(customerId, name, email, age);
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customerId=" + customerId +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
