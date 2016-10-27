package com.chitra.kmt.utils;

/**
 *----------------------------------------------------------------------
 * PROJECT NAME : Java Library
 * FILE    NAME : ValidUtil.java
 * CREATED DATE : 2014. 7. 11.
 * PROGRAMMER   : PAUL LEE
 *----------------------------------------------------------------------
 * No Copyright, Just Copyleft.
 *----------------------------------------------------------------------
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ���ڿ� ������ �����ϴ� �Լ����� ��Ƴ��� Ŭ����
 * ValidUtil
 * @author PAUL LEE
 */
public class ValidUtil
{
	/**
	 * ��¥ Regular Expression ����
	 * ^([12][0-9]{3}) : �� ���ڸ��� 1 OR 2�̰� 0���� 9���� 3�ڸ�
	 * ([0][1-9]|[1][0-2]) : 0�̸� 1���� 9, 1�̸� 0���� 2
	 * ([0][1-9]|[12][0-9]|[3][0-1])$ : 0�̸� 1���� 9, 1�̳� 2�̸� 0���� 9, 3�̸� 0�̳� 1
	 */
	public static final String DATE_PATTERN     = "^([012][0-9]{3})([0][1-9]|[1][0-2])([0][1-9]|[12][0-9]|[3][0-1])$";
	/**
	 * �ð� Regular Expression ����
	 */
	public static final String TIME_PATTERN     = "^([01][0-9]|[2][0-3])([0-5][0-9])([0-5][0-9])$";
	/**
	 * �Ͻ� Regular Expression ����
	 */
	public static final String DATETIME_PATTERN = "^([12][0-9]{3})([0][1-9]|[1][0-2])([0][1-9]|[12][0-9]|[3][0-1])([01][0-9]|[2][0-3])([0-5][0-9])([0-5][0-9])$";
	/**
	 * ��ȭ Regular Expression ����
	 */
	public static final String CURRENCY_PATTERN = "^(-?[0-9]+|-?[0-9]{1,3}(,[0-9]{3})*)(.[0-9]{1,3})?$";
	/**
	 * ���� Regular Expression ����
	 */
	public static final String NUMERIC_PATTERN  = "^([-+]?[0-9]+)(.[0-9]*)?$";
	/**
	 * ���� Regular Expression ����
	 */
	public static final String NUMBER_PATTERN   = "^[0-9]+$";
	/**
	 * ���� Regular Expression ����
	 */
	public static final String RATE_PATTERN     = "^([-+]?[0-9]+)(.[0-9]{1,5})$";
	/**
	 * �̸��� Regular Expression ����
	 */
	public static final String EMAIL_PATTERN    = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*$";
	/**
	 * IP�ּ� Regular Expression ����
	 */
	public static final String IP_PATTERN       = "([0-9]{1,3}).([0-9]{1,3}).([0-9]{1,3}).([0-9]{1,3})";
	/**
	 * ������, �ܺο��� ��ü�� �ν��Ͻ�ȭ �� �� ������ ����
	 */
	private ValidUtil() {}

	/**
	 * ���ڿ��� ��¥ �������� üũ�Ѵ�.
	 * ^([12][0-9]{3}) : �� �տ� '0','1','2'�̰�, 0-9���� 3�� �߻���.
	 * ([0][1-9]|[1][0-2]) : '0'||[1-9]�̰ų� '1'||[0-2]
	 * ([0][1-9]|[12][0-9]|[3][0-1])$ : �������� '0'||1-9�̰ų�, '1','2'||[0-9]�̰ų�, '3'||[0-1]
	 * @param str �������̳� �Ǽ��� ���ڿ�
	 * @return boolean true : ���ڿ��� ���ڸ� ��Ÿ��, false : ���ڿ��� ���ڸ� ��Ÿ���� ����.
	 */
	public static boolean isDate( String str )
	{
		if( null == str || str.length() != 8 ) return false;

		return str.matches( DATE_PATTERN );
	}
	/**
	 * ���ڿ��� �ð� �������� üũ�Ѵ�.
	 * ^([01][0-9]|[2][0-3]) : �� �տ� '-', '+' ��ȣ�� ���ų� �ְ�, ���ڰ� 1���̻� �߻���.
	 * ([0-5][0-9]) : 0���� 5||0���� 9
	 * ([0-5][0-9])$ : �������� 0���� 5||0���� 9
	 * @param str �ð� ������ ���ڿ�
	 * @return boolean true : ���ڿ��� �ð��� ��Ÿ��, false : ���ڿ��� �ð��� ��Ÿ���� ����.
	 */
	public static boolean isTime( String str )
	{
		if( null == str || str.length() != 6 ) return false;

		return str.matches( TIME_PATTERN );
	}

	/**
	 * ���ڿ��� �Ͻ� �������� üũ�Ѵ�.
	 * @param str
	 * @return boolean true : ���ڿ��� �Ͻø� ��Ÿ��, false : ���ڿ��� �Ͻø� ��Ÿ���� ����.
	 */
	public static boolean isDateTime( String str )
	{
		if( null == str || str.length() != 14 ) return false;

		return str.matches( DATETIME_PATTERN );
	}
	/**
	 * ���ڿ��� �������̳� �Ǽ������� üũ�Ѵ�.
	 * ^([-+]?[0-9]+) : �� �տ� '-', '+' ��ȣ�� ���ų� �ְ�, ���ڰ� 1���̻� �߻���.
	 * (.[0-9]*)?$ : �������� '.' + ���ڰ� 0�� �̻��� ������ ���ų� �߻���.
	 * @param str �������̳� �Ǽ��� ���ڿ�
	 * @return boolean true : ���ڿ��� ������, false : ���ڿ��� �������� �ƴ�.
	 */
	public static boolean isNumeric( String str )
	{
		return str.matches( NUMERIC_PATTERN );
	}
	/**
	 * ���ڿ��� ���������� üũ�Ѵ�.
	 * ^([0-9]+) : ���ڰ� 1���̻� �߻���.
	 * @param str ������ ���ڿ�
	 * @return boolean true : ���ڿ��� ������, false : ���ڿ��� �������� �ƴ�.
	 */
	public static boolean isNumber( String str )
	{
		return str.matches( NUMBER_PATTERN );
	}
	/**
	 * ���ڿ��� �ݾ� ǥ�� �������� üũ�Ѵ�.
	 * ^[0-9]+ : �� �տ� 0���� 9��� ���ڰ� �ϳ� �̻�
	 * | : �̰ų�
	 * ^[0-9]{1,3}(,[0-9]{3})* : �� �տ� 0���� 9��� ���ڰ� 1���� 3������ �̰� ,�� ���� 3���� �̷���� ������ 0�̻� �߻�
	 * (.[0-9]{1,3})?$ : �������� '.' + ���ڰ� 1�ڸ����� 3�ڸ��� �̷���� ������ 0�̰ų� 1�� �߻�
	 * @param str �ݾ��� ǥ���ϴ� ���ڿ�
	 * @return boolean true : ���ڿ��� �ݾ��� ǥ����, false : ���ڿ��� �ݾ��� ǥ������ ����.
	 */
	public static boolean isCurrency( String str )
	{
		return str.matches( CURRENCY_PATTERN );
	}

	/**
	 * ���ڿ��� ���� �������� üũ�Ѵ�.
	 * ^[0-9]+ : �� �տ� ���ڰ� 0���� 9�� 1���̻� �߻���.
	 * (.[0-9]{1,5})$ : �������� '.' + ���ڰ� 1������ 5������ ������ 1�� �߻��ؾ���.
	 * @param str ������ ǥ���ϴ� ���ڿ�
	 * @return boolean true : ���ڿ��� ������ ǥ����, false : ���ڿ��� ������ ǥ������ ����.
	 */
	public static boolean isRate( String str )
	{
		return str.matches( RATE_PATTERN );
	}

	/**
	 * ���ڿ��� �̸��� �������� üũ�Ѵ�.
	 * ^[_a-z0-9-]+(.[_a-z0-9-]+)* : �� �տ� ���ڰ� 0���� 9�� 1���̻� �߻���.
	 * *@[a-z0-9-]+(.[a-z0-9-]+)*$ : �������� '@' + ���ڰ� 1������ 5������ ������ 1�� �߻��ؾ���.
	 * @param str ������ ǥ���ϴ� ���ڿ�
	 * @return boolean true : ���ڿ��� ������ ǥ����, false : ���ڿ��� ������ ǥ������ ����.
	 */
	public static boolean isEmail( String str )
	{
		return str.matches( EMAIL_PATTERN );
	}

	/**
	 * ���Խ��� �����ϴ��� �����Ѵ�.
	 * @param regExp ���Խ� OR ���ڿ�
	 * @param str ���Խ��� �����ϴ��� �˻��� ���ڿ�
	 * @return true regExp�� ������, false �������� ����.
	 */
	public static boolean containsStr( String regExp, String str )
	{
		Pattern ptn = Pattern.compile( regExp );
		Matcher mtc = ptn.matcher( str );
		return mtc.find();
	}

	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		System.out.println( isNumber("-12345.0000") );
		System.out.println( isNumber("12345.0000") );
		System.out.println( isNumber("12345") );
		System.out.println( isNumeric("-12345.0000") );
		System.out.println( isNumeric("12345.00") );
		System.out.println( isCurrency("12,345.00") );
		System.out.println( isCurrency("-12,345.00") );
		System.out.println( isRate("0.123456") );
		System.out.println( isRate("0.12345") );
		System.out.println( isRate("1.0") );
		System.out.println( isRate("-0.5") );
		System.out.println( isEmail("prayerpaul@gmail.com") );
		System.out.println( isDate("20141718") );
		System.out.println( isDate("8482016") );
		System.out.println( isDate("20140718") );
		System.out.println( isTime("245959") );
		System.out.println( isTime("235959") );
	}

}
