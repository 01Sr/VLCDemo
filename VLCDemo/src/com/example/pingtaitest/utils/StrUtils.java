package com.example.pingtaitest.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ַ���������
 * @author Administrator
 *
 */
public class StrUtils {

	/**
	 * ���ַ���ת��Ϊ�ַ���
	 * @param is
	 * @return
	 */
	public static String getFromStream(InputStream is){
		byte b[] = new byte[1024];
		int len = 0;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			while((len = is.read(b))!=-1){
				baos.write(b, 0, len);
			}
			baos.close();
			String str = new String(baos.toByteArray());
			return str;
		} catch (IOException e) {
			return null;
		}
		
	}
}

