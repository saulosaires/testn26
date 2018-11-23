package com.n26.helper;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.n26.exceptions.InvalidJsonException;
import com.n26.models.Transaction;

public class TransactionDeserializer extends JsonDeserializer<Transaction> {

	 
	
	@Override
	public Transaction deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, InvalidJsonException {

		try {
			JsonNode node = jp.getCodec().readTree(jp);

			BigDecimal amount = readAmount(node.get("amount").asText());
			ZonedDateTime time = readDate(node.get("timestamp").asText());

			return new Transaction(amount, time);

		} catch (Exception e) {
			 throw new InvalidJsonException("Invalid Json ");
		}
	}

	private BigDecimal readAmount(String strAmount) {
		
		try {
 		return new BigDecimal(strAmount);
		}catch(NumberFormatException  e) {
			return null;
		}
	}
	
	private ZonedDateTime readDate(String strDate) {
		try {
		return ZonedDateTime.parse(strDate, DateTimeFormatter.ISO_DATE_TIME);
		}catch(Exception e) {
			return null;
		}
	}
	
	
	
}

