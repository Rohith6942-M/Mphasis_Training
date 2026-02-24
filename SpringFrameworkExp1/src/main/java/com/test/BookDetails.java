package com.test;

public class BookDetails {
	
	private int pages;
	private String publisher;
	private int p_year;
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getP_year() {
		return p_year;
	}
	public void setP_year(int p_year) {
		this.p_year = p_year;
	}
	@Override
	public String toString() {
		return "BookDetails [pages=" + pages + ", publisher=" + publisher + ", p_year=" + p_year + "]";
	}
	
	

}
