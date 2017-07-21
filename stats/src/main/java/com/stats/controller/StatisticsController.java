package com.stats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stats.domain.Transaction;
import com.stats.rest.response.StatsResponse;
import com.stats.service.TransactionService;

@Controller
public class StatisticsController {

	@Autowired
	private TransactionService transervice;

	@RequestMapping(value = "/transactions", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveTransaction(@RequestBody Transaction tran) {

		double amount = tran.getAmount();
		Long timestamp = tran.getTimestamp();
		int response_status = transervice.addTransation(amount, timestamp);

		return new ResponseEntity<>(HttpStatus.valueOf(response_status));
	}

	@RequestMapping(value = "/statistics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody StatsResponse getStatistics() {

		return transervice.getStats();
	}

}
