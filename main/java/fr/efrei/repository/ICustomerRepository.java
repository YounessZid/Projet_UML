package fr.efrei.repository;
import java.util.*;
import fr.efrei.domain.Customer;

public interface ICustomerRepository extends IRepository<Customer, Integer>{
    public List<Customer> getAll();
}
