package com.zzu.entity;

import java.util.List;
import org.springframework.stereotype.Component;
@Component(value="results")
public class Results {

	int number;
	List results;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public List getResults() {
		return results;
	}
	public void setResults(List results) {
		this.results = results;
	}
	
}
