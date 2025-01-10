package com.kmove.app.Common;

import com.kmove.app.User.vo.SearchCondition;

/**
 * ���������̼��� ó���ϱ� ���� Ŭ����
 */
public class PageHandler {
    // ���������̼� ���� �⺻ �Ӽ���
    private int totalCnt;      // ��ü �Խù�/ȸ�� ��
    private int navSize = 10;  // ������ �׺���̼� ũ�� (�� ���� ������ ������ ��ȣ�� ����)
    private int totalPage;     // ��ü ������ ��
    
    // ������ �׺���̼� ���� �Ӽ���
    private int beginPage;     // �׺���̼��� ���� ������ ��ȣ
    private int endPage;       // �׺���̼��� ������ ������ ��ȣ
    private boolean showPrev;  // ���� ������ �׺���̼� �������� ����
    private boolean showNext;  // ���� ������ �׺���̼� �������� ����
    
    // �˻� ���� ��ü (������ ũ��� ���� ������ ���� ����)
    private SearchCondition sc;
    
    /**
     * �⺻ ������ - ������ ũ�⸦ 10���� ����
     * @param totalCnt ��ü �׸� ��
     * @param page ���� ������ ��ȣ
     */
    public PageHandler(int totalCnt, int page) {
        this(totalCnt, new SearchCondition(page, 10));
    }

    /**
     * ������ ũ�⸦ ������ �� �ִ� ������
     * @param totalCnt ��ü �׸� ��
     * @param page ���� ������ ��ȣ
     * @param pageSize �������� �׸� ��
     */
    public PageHandler(int totalCnt, int page, int pageSize) {
        this(totalCnt, new SearchCondition(page, pageSize));
    }

    /**
     * SearchCondition�� �޴� �� ������
     * @param totalCnt ��ü �׸� ��
     * @param sc �˻� ���� ��ü
     */
    public PageHandler(int totalCnt, SearchCondition sc) {
        this.totalCnt = totalCnt;
        this.sc = sc;
        
        doPaging(totalCnt, sc);
    }
    
    /**
     * ���������̼� ������ ����ϴ� �޼���
     * @param totalCnt ��ü �׸� ��
     * @param sc �˻� ���� ��ü
     */
    public void doPaging(int totalCnt, SearchCondition sc) {
        // ��ü ������ �� ��� (�ø� ó��)
        this.totalPage = (int)Math.ceil(totalCnt/(double)sc.getPageSize());
        
        // �׺���̼� ���� ������ ���
        this.beginPage = (sc.getPage() - 1) / navSize * navSize + 1;
        
        // �׺���̼� �� ������ ��� (totalPage�� ���� �ʵ���)
        this.endPage = Math.min(beginPage + navSize - 1, totalPage);
        
        // ����/���� �׺���̼� ǥ�� ���� ����
        this.showPrev = beginPage != 1;
        this.showNext = endPage != totalPage;
        
        // ���� �������� �� ������ ���� ���� �ʵ��� ����
        this.sc.setPage(Math.min(sc.getPage(), totalPage));
    }
    
    // Getter�� Setter �޼����
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