package com.example.ExpensesTracked_Backend;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Expenses, Integer> {

}
