package sg.edu.iss.team1.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team1.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	@Query("SELECT t FROM Transaction t WHERE t.partNumber = :pnum")
	ArrayList<Transaction> findTransactionByProduct(@Param("pnum") Integer pnum);
}
