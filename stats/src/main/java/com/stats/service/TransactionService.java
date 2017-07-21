package com.stats.service;

import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stats.domain.Transaction;
import com.stats.repo.TransactionDao;
import com.stats.rest.response.StatsResponse;

@Service
public class TransactionService {

	@Autowired
	private TransactionDao transactiondao;

	public int addTransation(double amount, Long timestamp) {

		int response_status = 0;
		Transaction T = new Transaction();
		Long trans_time = timestamp / 1000; // divide by 1000 to get timestamp
											// in seconds
		T.setAmount(amount);
		T.setTimestamp(trans_time);

		boolean success = transactiondao.saveTransaction(T);

		if (success) {
			if (!ifTransactionIsOlderThan60(T)) {
				response_status = 201;
			} else {
				response_status = 204;
			}

		} else {
			response_status = 500;
		}

		return response_status;

	}

	public StatsResponse getStats() {

		List<Object[]> results = transactiondao.getStats();
		StatsResponse stats_resp = new StatsResponse();
		Object[] sr = results.get(0);

		stats_resp.setSum((double) sr[0]);
		stats_resp.setAvg((double) sr[1]);
		stats_resp.setMax((double) sr[2]);
		stats_resp.setMin((double) sr[3]);
		stats_resp.setCount((BigInteger) sr[4]);

		return stats_resp;
	}

	public boolean ifTransactionIsOlderThan60(Transaction T) {

		Long current_time = System.currentTimeMillis() / 1000; // divide by 1000
																// to get
																// current
																// timestamp in
																// seconds
		Long transaction_time = T.getTimestamp();

		if ((current_time - transaction_time) <= 60) {
			return false;
		} else {
			return true;
		}
	}
}
