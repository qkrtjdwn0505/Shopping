package com.kmove.app.Common;
import java.util.Calendar;

/**
 * ä��(�Ϸù�ȣ ����)�� ���� ��ƿ��Ƽ Ŭ����
 */
public class Chaebun {
   // �� ��ƼƼ�� ���ξ� ��� ����
   public static final String USER = "U";     // ����� ���ξ�
   public static final String BOARD = "B";    // �Խ��� ���ξ�
   public static final String COMMENT= "C";   // ��� ���ξ�
   
   /**
    * ���� ��¥�� "YYYYMMDD" ������ ���ڿ��� ��ȯ�ϴ� �޼ҵ�
    */
   public static String getDate() {
      Calendar cal = Calendar.getInstance();  // ���� ��¥�� �ð� ������ ������
      System.out.println("cal >> " + cal);   // ������ ���
      String date = "";                      // ��ȯ�� ��¥ ���ڿ� �ʱ�ȭ
      
      // ��, ��, �� ���� ����
      int year_ = cal.get(Calendar.YEAR);           // ���� �⵵
      int month_ = cal.get(Calendar.MONTH) + 1;     // ���� �� (0���� �����ϹǷ� +1)
      int day_ = cal.get(Calendar.DAY_OF_MONTH);    // ���� ��
      
      // �������� ���ڿ��� ��ȯ
      String year = String.valueOf(year_);  
      
      // ���� �� �ڸ����� ��� �տ� 0�� ���� (��: 1 -> 01)
      String month = String.valueOf(month_);
      if (month.length() == 1) {
         month = "0" + month;
      }
      
      // ���� �� �ڸ����� ��� �տ� 0�� ���� (��: 5 -> 05)
      String day = String.valueOf(day_);
      if (day.length() == 1) {
         day = "0" + day; 
      }
      
      // ���������� ��+��+�� ������ ���ڿ� ����
      date = year + month + day;
      System.out.println("date >> " + date);  // ������ ���
      
      return date;
   }
   
   /**
    * �Ϸù�ȣ�� �� �ڸ� �������� ��ȯ�ϴ� �޼ҵ�
    * @param maxno ��ȯ�� �Ϸù�ȣ
    * @return �� �ڸ��� ��ȯ�� �Ϸù�ȣ (��: 1 -> 001)
    */
   public static String getNo(String maxno) {
      System.out.println("maxno >> " + maxno);  // ������ ���
      
      // �� �ڸ� ������ ��� �տ� 00�� ����
      if (maxno.length() == 1) {
         maxno = "00" + maxno;
      // �� �ڸ� ������ ��� �տ� 0�� ����
      } else if (maxno.length() == 2) {
         maxno = "0" + maxno;
      }
      
      System.out.println("maxno >> " + maxno);  // ������ ���
      
      return maxno;
   }
   
   /**
    * ����� ��ȣ�� �����ϴ� �޼ҵ�
    * @param maxno ���� �ִ� �Ϸù�ȣ
    * @return ������ ����� ��ȣ (��: U20240705001)
    */
   public static String getUno(String maxno) {
      // ����� ���ξ� + ���糯¥ + �Ϸù�ȣ ����
      String uno = Chaebun.USER + Chaebun.getDate() + Chaebun.getNo(maxno);
      return uno;
   }
   
   /**
    * �Խñ� ��ȣ�� �����ϴ� �޼ҵ�
    * @param maxno ���� �ִ� �Ϸù�ȣ
    * @return ������ �Խñ� ��ȣ (��: B20240705001)
    */
   public static String getBno(String maxno) {
      // �Խñ� ���ξ� + ���糯¥ + �Ϸù�ȣ ����
      String bno = Chaebun.BOARD + Chaebun.getDate() + Chaebun.getNo(maxno);
      return bno; 
   }
   
   /**
    * ��� ��ȣ�� �����ϴ� �޼ҵ�
    * @param maxno ���� �ִ� �Ϸù�ȣ
    * @return ������ ��� ��ȣ (��: C20240705001)
    */
   public static String getCno(String maxno ) {
      // ��� ���ξ� + ���糯¥ + �Ϸù�ȣ ����
      String cno = Chaebun.COMMENT + Chaebun.getDate() + Chaebun.getNo(maxno);
      return cno; 
   }
}