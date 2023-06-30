package com.riadhgharbi.MongoDBProject.config;


import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.riadhgharbi.MongoDBProject.model.Expense;
import com.riadhgharbi.MongoDBProject.model.ExpenseCategory;
import com.riadhgharbi.MongoDBProject.repository.ExpenseRepo;
import io.mongock.api.annotations.ChangeUnit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "seedDatabase", author = "Riadh")
    public void seedDatabase(ExpenseRepo  expenseRepo)
    {
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(new Expense("Fast Food", ExpenseCategory.ENTERTAINMENT, BigDecimal.valueOf(30)));
        expenseList.add(new Expense("Gas", ExpenseCategory.UTILITIES, BigDecimal.valueOf(90)));
        expenseList.add(new Expense("Gym", ExpenseCategory.MISC, BigDecimal.valueOf(45)));

        expenseRepo.insert(expenseList);
    }

}
