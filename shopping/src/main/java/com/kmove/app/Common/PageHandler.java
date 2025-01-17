package com.kmove.app.Common;

import com.kmove.app.User.vo.SearchCondition;

/**
 * 페이지네이션을 처리하기 위한 클래스
 */
public class PageHandler {
    // 페이지네이션 관련 기본 속성들
    private int totalCnt;      // 전체 게시물/회원 수
    private int navSize = 10;  // 페이지 네비게이션 크기 (한 번에 보여줄 페이지 번호의 개수)
    private int totalPage;     // 전체 페이지 수
    
    // 페이지 네비게이션 관련 속성들
    private int beginPage;     // 네비게이션의 시작 페이지 번호
    private int endPage;       // 네비게이션의 마지막 페이지 번호
    private boolean showPrev;  // 이전 페이지 네비게이션 보여줄지 여부
    private boolean showNext;  // 다음 페이지 네비게이션 보여줄지 여부
    
    // 검색 조건 객체 (페이지 크기와 현재 페이지 정보 포함)
    private SearchCondition sc;
    
    /**
     * 기본 생성자 - 페이지 크기를 10으로 고정
     * @param totalCnt 전체 항목 수
     * @param page 현재 페이지 번호
     */
    public PageHandler(int totalCnt, int page) {
        this(totalCnt, new SearchCondition(page, 10));
    }

    /**
     * 페이지 크기를 지정할 수 있는 생성자
     * @param totalCnt 전체 항목 수
     * @param page 현재 페이지 번호
     * @param pageSize 페이지당 항목 수
     */
    public PageHandler(int totalCnt, int page, int pageSize) {
        this(totalCnt, new SearchCondition(page, pageSize));
    }

    /**
     * SearchCondition을 받는 주 생성자
     * @param totalCnt 전체 항목 수
     * @param sc 검색 조건 객체
     */
    public PageHandler(int totalCnt, SearchCondition sc) {
        this.totalCnt = totalCnt;
        this.sc = sc;
        
        doPaging(totalCnt, sc);
    }
    
    /**
     * 페이지네이션 정보를 계산하는 메서드
     * @param totalCnt 전체 항목 수
     * @param sc 검색 조건 객체
     */
    public void doPaging(int totalCnt, SearchCondition sc) {
        // 전체 페이지 수 계산 (올림 처리)
        this.totalPage = (int)Math.ceil(totalCnt/(double)sc.getPageSize());
        
        // 네비게이션 시작 페이지 계산
        this.beginPage = (sc.getPage() - 1) / navSize * navSize + 1;
        
        // 네비게이션 끝 페이지 계산 (totalPage를 넘지 않도록)
        this.endPage = Math.min(beginPage + navSize - 1, totalPage);
        
        // 이전/다음 네비게이션 표시 여부 결정
        this.showPrev = beginPage != 1;
        this.showNext = endPage != totalPage;
        
        // 현재 페이지가 총 페이지 수를 넘지 않도록 조정
        this.sc.setPage(Math.min(sc.getPage(), totalPage));
    }
    
    // Getter와 Setter 메서드들
    public int getTotalCnt() { return totalCnt; }
    public void setTotalCnt(int totalCnt) { this.totalCnt = totalCnt; }
    public int getNavSize() { return navSize; }
    public void setNavSize(int navSize) { this.navSize = navSize; }
    public int getTotalPage() { return totalPage; }
    public void setTotalPage(int totalPage) { this.totalPage = totalPage; }
    public int getBeginPage() { return beginPage; }
    public void setBeginPage(int beginPage) { this.beginPage = beginPage; }
    public int getEndPage() { return endPage; }
    public void setEndPage(int endPage) { this.endPage = endPage; }
    public boolean isShowPrev() { return showPrev; }
    public void setShowPrev(boolean showPrev) { this.showPrev = showPrev; }
    public boolean isShowNext() { return showNext; }
    public void setShowNext(boolean showNext) { this.showNext = showNext; }
    public SearchCondition getSc() { return sc; }
    public void setSc(SearchCondition sc) { this.sc = sc; }
    
    @Override
    public String toString() {
        return "PageHandler [totalCnt=" + totalCnt + ", navSize=" + navSize + ", totalPage="
                + totalPage + ", beginPage=" + beginPage + ", endPage=" + endPage + ", showPrev="
                + showPrev + ", showNext=" + showNext + "]";
    }
}