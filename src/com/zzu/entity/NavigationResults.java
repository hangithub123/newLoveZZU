package com.zzu.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component(value="navigationResults")
public class NavigationResults {

	List result;

	public List getResult() {
		return result;
	}

	public void setResult(List result) {
		this.result = result;
	}
}
