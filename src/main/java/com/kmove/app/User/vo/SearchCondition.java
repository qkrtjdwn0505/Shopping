package com.kmove.app.User.vo;
import java.util.Objects;

import org.springframework.web.util.UriComponentsBuilder;


public class SearchCondition {
	private Integer page = 1;
	private Integer pageSize = DEFALUT_PAGE_SIZE;
	private String option;
	private String keyword;
	private int offset; 
	

	public static final int MIN_PAGE_SIZE = 5;
	public static final int DEFALUT_PAGE_SIZE = 10;
	public static final int MAX_PAGE_SIZE = 50;
	

	public SearchCondition() {}
	
	public SearchCondition(Integer page,Integer pageSize) {
		this(page,pageSize,"","");
	}
	
	public SearchCondition(Integer page,Integer pageSize,String option,String keyword ) {
		this.page = page;
		this.pageSize = pageSize;
		this.option = option;
		this.keyword = keyword;
		this.offset = (page-1)*pageSize;
	}
	
	
	public int getOffset() {
		return (page==0)?page:(page-1)*pageSize;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = Objects.requireNonNullElse(pageSize, DEFALUT_PAGE_SIZE);
	}

	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	
	public String getQueryString(Integer page) {
		return UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("option", option)
				.queryParam("keyword", keyword)
				.queryParam("pageSize", pageSize)
				.build().toString();
	}
	
	
	@Override
	public String toString() {
		return "SearchCondition [page=" + page + ", pageSize=" + pageSize + ", option=" + option + ", keyword="
				+ keyword + ", offset=" + offset + "]";
	}
}
