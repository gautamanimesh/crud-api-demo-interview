package com.example.cruddemo.repository;

import com.example.cruddemo.entity.Customer;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeRepository extends CouchbaseRepository<Customer, String> {
    @Query("#{#n1ql.selectEntity}")
    List<Customer> findAllCustomers();
}
