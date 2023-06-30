package com.riadhgharbi.MongoDBProject.service;

import com.riadhgharbi.MongoDBProject.model.Expense;
import com.riadhgharbi.MongoDBProject.repository.ExpenseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ExpenseService {
    private final ExpenseRepo expenseRepo;


    //Replaces the Required Args Constructor Annotation (most likely from Lombok that removes boilerplate code
    //but let's do it the old way
    public ExpenseService (ExpenseRepo expenseRepo)
    {
        this.expenseRepo = expenseRepo;
    }
    public void addExpense(Expense e){
        expenseRepo.insert(e);
    }

    public void updateExpense(Expense e)
    {
        Expense savedExpense = expenseRepo.findById(e.getId())
                .orElseThrow(() ->
                        new RuntimeException(
                                String.format("Cannot Find Expense by ID %s", e.getId())
                        ));
        savedExpense.setExpenseAmount(e.getExpenseAmount());
        savedExpense.setExpenseName(e.getExpenseName());
        savedExpense.setExpenseCategory(e.getExpenseCategory());

        expenseRepo.save(savedExpense);
    }

    public List<Expense> getAllExpenses()
    {
        return expenseRepo.findAll();
    }
    public Expense getExpenseByName(String name){
        return expenseRepo.findByName(name).orElseThrow(() ->
                new RuntimeException(String.format("Cannot Find Expense by name %s", name)));
    }
    public void deleteExpense(String id)
    {
         expenseRepo.deleteById(id);
    }
}
