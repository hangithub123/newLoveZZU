package com.zzu.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component(value="societyResults")
public class SocietyResults {

	int number;
	List result;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public List getResult() {
		return result;
	}
	public void setResult(List result) {
		this.result = result;
	}
}
