package sg.edu.iss.team1.service;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sg.edu.iss.team1.model.Transaction;
import sg.edu.iss.team1.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Resource
	TransactionRepository trepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.edu.iss.team1test.service.TransactionService#findAllTransaction()
	 */
	@Override
	@Transactional
	public ArrayList<Transaction> findAllTransaction() {
		ArrayList<Transaction> l = (ArrayList<Transaction>) trepo.findAll();
		return l;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.edu.iss.team1test.service.TransactionService#findTransaction(int)
	 */
	@Override
	@Transactional
	public Transaction findTransaction(int transactionID) {
		return trepo.findOne(transactionID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sg.edu.iss.team1test.service.TransactionService#createTransaction(sg.edu.iss.
	 * team1test.model.Transaction)
	 */
	@Override
	@Transactional
	public Transaction createTransaction(Transaction t) {
		return trepo.saveAndFlush(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sg.edu.iss.team1test.service.TransactionService#changeTransaction(sg.edu.iss.
	 * team1test.model.Transaction)
	 */
	@Override
	@Transactional
	public Transaction changeTransaction(Transaction t) {
		return trepo.saveAndFlush(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sg.edu.iss.team1test.service.TransactionService#removeTransaction(sg.edu.iss.
	 * team1test.model.Transaction)
	 */
	@Override
	@Transactional
	public void removeTransaction(Transaction t) {
		trepo.delete(t);
	}

	@Override
	@Transactional
	public long count() {
		return trepo.count();
	}

	@Override
	public ArrayList<Transaction> findTransactionByProduct(Integer pnum) {
		ArrayList<Transaction> l = trepo.findTransactionByProduct(pnum);
		return l;
	}
}
