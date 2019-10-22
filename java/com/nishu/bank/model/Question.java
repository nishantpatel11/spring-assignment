package com.nishu.bank.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question implements Serializable{

	private Integer questionId;
	private String question;
	private List answerList;
	private Set answerSet;
	private Map answerMap;

	public Question() {
		super();
	}


	public Question(Integer questionId, String question, List answerList, Set answerSet, Map answerMap) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answerList = answerList;
		this.answerSet = answerSet;
		this.answerMap = answerMap;
	}


	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	
	public List getAnswerList() {
		return answerList;
	}


	public void setAnswerList(List answerList) {
		this.answerList = answerList;
	}


	public Set getAnswerSet() {
		return answerSet;
	}


	public void setAnswerSet(Set answerSet) {
		this.answerSet = answerSet;
	}


	public Map getAnswerMap() {
		return answerMap;
	}


	public void setAnswerMap(Map answerMap) {
		this.answerMap = answerMap;
	}


	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", answerList=" + answerList
				+ ", answerSet=" + answerSet + ", answerMap=" + answerMap + "]";
	}
}
