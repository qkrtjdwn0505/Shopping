package com.kmove.app.Common;
import java.util.Calendar;

/**
 * 채번(일련번호 생성)을 위한 유틸리티 클래스
 */
public class Chaebun {
   // 각 엔티티의 접두어 상수 정의
   public static final String USER = "U";     // 사용자 접두어
   public static final String BOARD = "B";    // 게시판 접두어
   public static final String COMMENT= "C";   // 댓글 접두어
   
   /**
    * 현재 날짜를 "YYYYMMDD" 형식의 문자열로 반환하는 메소드
    */
   public static String getDate() {
      Calendar cal = Calendar.getInstance();  // 현재 날짜와 시간 정보를 가져옴
      System.out.println("cal >> " + cal);   // 디버깅용 출력
      String date = "";                      // 반환할 날짜 문자열 초기화
      
      // 년, 월, 일 정보 추출
      int year_ = cal.get(Calendar.YEAR);           // 현재 년도
      int month_ = cal.get(Calendar.MONTH) + 1;     // 현재 월 (0부터 시작하므로 +1)
      int day_ = cal.get(Calendar.DAY_OF_MONTH);    // 현재 일
      
      // 정수값을 문자열로 변환
      String year = String.valueOf(year_);  
      
      // 월이 한 자리수인 경우 앞에 0을 붙임 (예: 1 -> 01)
      String month = String.valueOf(month_);
      if (month.length() == 1) {
         month = "0" + month;
      }
      
      // 일이 한 자리수인 경우 앞에 0을 붙임 (예: 5 -> 05)
      String day = String.valueOf(day_);
      if (day.length() == 1) {
         day = "0" + day; 
      }
      
      // 최종적으로 년+월+일 형태의 문자열 생성
      date = year + month + day;
      System.out.println("date >> " + date);  // 디버깅용 출력
      
      return date;
   }
   
   /**
    * 일련번호를 세 자리 형식으로 변환하는 메소드
    * @param maxno 변환할 일련번호
    * @return 세 자리로 변환된 일련번호 (예: 1 -> 001)
    */
   public static String getNo(String maxno) {
      System.out.println("maxno >> " + maxno);  // 디버깅용 출력
      
      // 한 자리 숫자인 경우 앞에 00을 붙임
      if (maxno.length() == 1) {
         maxno = "00" + maxno;
      // 두 자리 숫자인 경우 앞에 0을 붙임
      } else if (maxno.length() == 2) {
         maxno = "0" + maxno;
      }
      
      System.out.println("maxno >> " + maxno);  // 디버깅용 출력
      
      return maxno;
   }
   
   /**
    * 사용자 번호를 생성하는 메소드
    * @param maxno 현재 최대 일련번호
    * @return 생성된 사용자 번호 (예: U20240705001)
    */
   public static String getUno(String maxno) {
      // 사용자 접두어 + 현재날짜 + 일련번호 조합
      String uno = Chaebun.USER + Chaebun.getDate() + Chaebun.getNo(maxno);
      return uno;
   }
   
   /**
    * 게시글 번호를 생성하는 메소드
    * @param maxno 현재 최대 일련번호
    * @return 생성된 게시글 번호 (예: B20240705001)
    */
   public static String getBno(String maxno) {
      // 게시글 접두어 + 현재날짜 + 일련번호 조합
      String bno = Chaebun.BOARD + Chaebun.getDate() + Chaebun.getNo(maxno);
      return bno; 
   }
   
   /**
    * 댓글 번호를 생성하는 메소드
    * @param maxno 현재 최대 일련번호
    * @return 생성된 댓글 번호 (예: C20240705001)
    */
   public static String getCno(String maxno ) {
      // 댓글 접두어 + 현재날짜 + 일련번호 조합
      String cno = Chaebun.COMMENT + Chaebun.getDate() + Chaebun.getNo(maxno);
      return cno; 
   }
}