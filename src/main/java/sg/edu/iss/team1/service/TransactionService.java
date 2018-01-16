package sg.edu.iss.team1.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import sg.edu.iss.team1.model.Transaction;

public interface TransactionService {

	ArrayList<Transaction> findAllTransaction();

	Transaction findTransaction(int transactionID);

	Transaction createTransaction(Transaction t);

	Transaction changeTransaction(Transaction t);

	void removeTransaction(Transaction t);

	long count();

	ArrayList<Transaction> findTransactionByProduct(Integer pnum);

}