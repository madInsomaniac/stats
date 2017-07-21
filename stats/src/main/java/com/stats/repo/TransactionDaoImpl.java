package com.stats.repo;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stats.domain.Transaction;
import com.stats.rest.response.StatsResponse;

@Repository
public class TransactionDaoImpl implements TransactionDao {

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	private SessionFactory sessionFactory;
	private Session session;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}

	@Transactional
	public boolean saveTransaction(Transaction T) {
		boolean success = false;

		Integer id = null;
		id = (Integer) template.save(T);

		if (id == null) {
			success = false;
		} else {
			success = true;
		}

		return success;
	}

	public List<Object[]> getStats() {

		Long current_time = System.currentTimeMillis() / 1000; // current time
																// in seconds
		Long current_time_less_60 = current_time - 60; // 60 secs before current
														// time

		Query sql = getSession().createSQLQuery(
				"SELECT SUM(amount),AVG(amount),MAX(amount),MIN(amount),COUNT(tid) FROM TRANSACTIONS T where T.TIMESTAMP between ? and ?");

		// BigInteger b1 = new BigInteger("1500532882000");
		// BigInteger b2 = new BigInteger("1500532883000");

		sql.setParameter(0, current_time_less_60);
		sql.setParameter(1, current_time);
		List<Object[]> results = sql.list();
		session.close();

		return results;
	}

}
