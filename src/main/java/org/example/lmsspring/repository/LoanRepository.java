package org.example.lmsspring.repository;
import org.example.lmsspring.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LoanRepository extends JpaRepository<Loan,Integer> {
}