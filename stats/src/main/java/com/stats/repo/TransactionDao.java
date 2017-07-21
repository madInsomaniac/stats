package com.stats.repo;

import java.util.List;

import com.stats.domain.Transaction;

public interface TransactionDao {

	public boolean saveTransaction(Transaction T);

	public List<Object[]> getStats();

}
