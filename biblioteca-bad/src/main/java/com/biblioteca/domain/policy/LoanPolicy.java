package com.biblioteca.domain.policy;

import com.biblioteca.domain.model.Book;
import com.biblioteca.domain.model.User;


//Abstracción prematura - "por si cambian las políticas"
 
public interface LoanPolicy {
    boolean canLoan(Book book, User user);
    int getLoanDurationDays();
    int getMaxLoansPerUser();
}
