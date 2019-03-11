package com.jcex.test.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;


public class acceptJson {
	public static void main(String[] args) throws UnsupportedEncodingException {
		long time = System.currentTimeMillis() / 1000L;
		System.out.println("time = " + time);
		String json="{" +
				"\"code\":\"891904445917976\"," +
				"\"changeStatus\":\"sent\"," +
				"\"expressChannelCode\":\"1234564788\"}";
		System.out.println("json = " + json);
		Base64 base64 = new Base64();
		byte[] as = base64.encode(json.getBytes("UTF-8"));
		String encodeParams = new String(as, "UTF-8");

		System.out.println("encodeParams = " + encodeParams);
		String sign="";
		String apiKey = "47cee86605f77509a6167691d9d75cfe";
		try {
			sign = getMD5Str(("api=api.biaoju.order.update&apiAccountId="
					+ "3763" + "&encodeParams=" + encodeParams + "&timestamp="
					+ time + apiKey));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String http = http(encodeParams, "3763", sign, time);
		System.out.println("sign = " + sign);
		System.out.println("http = " + http);
	}


	public static String accept(String code,String billno)
			throws UnsupportedEncodingException {

		String json = "{\"code\":\""
				+ code
				+ "\",\"changeStatus\":\"accept\",\"supplierInnerCode\":\""
				+ billno
				+ "\",\"labelHTMLUrl\":{\"b10_10\":{\"a\":\"\",\"c\":\"\",\"p\":\"\",\"i\":\"\",\"ac\":\"\"},\"a4\":{\"a\":\"\",\"c\":\"\",\"p\":\"\",\"i\":\"\",\"ac\":\"\"}},"
				+ "\"labelPDFUrl\":{\"b10_10\":{\"a\":\"http://api.jcex.com:8081/"
				+ billno
				+ ".pdf\",\"c\":\"\",\"p\":\"\",\"i\":\"\",\"ac\":\"\"},\"a4\":{\"a\":\"\",\"c\":\"\",\"p\":\"\",\"i\":\"http://api.jcex.com:8081/"
				+ billno
				+ "bill.pdf\",\"ac\":\"\"}},"
				+ "\"labelIMGUrl\":{\"b10_10\":{\"a\":\"\",\"c\":\"\",\"p\":\"\",\"i\":\"\"},\"a4\":{\"a\":\"\",\"c\":\"\",\"p\":\"\",\"i\":\"\"}}}";
        String sda="{" +
				"\"code\":\"891904445917976\"," +
				"\"changeStatus\":\" sent\"," +
				"\"expressChannelCode\":\"JCS0214029235IN\"," +
				"}";
		return result(json);
	}

	static String result(String json) throws UnsupportedEncodingException {
		String apiKey = "47cee86605f77509a6167691d9d75cfe";
		String accountId = "3763";
		Base64 base64 = new Base64();
		long time = System.currentTimeMillis() / 1000L;
		
		byte[] as = base64.encode(json.getBytes("UTF-8"));
		String encodeParams = new String(as, "UTF-8");
		String sds;
		try {
			sds = getMD5Str(("api=api.biaoju.order.update&apiAccountId="
					+ "47cee86605f77509a6167691d9d75cfe" + "&encodeParams=" + encodeParams + "&timestamp="
					+ time + apiKey).getBytes("UTF-8").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String result = http(encodeParams, accountId, new String(as)
				.replace(" ", ""), time);
//		System.out.println(result);
//		System.out.println("success");
		return result;
	}

	public static String getMD5Str(String str) throws Exception {
		try {
			// 生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(str.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			throw new Exception("MD5加密出现错误，"+e.toString());
		}
	}


	public static String http(String encodeParam, String accountId,
			String sign, long time) {
		String httpUrl = "http://www.i8956.com/interface/index.php?api=api.biaoju.order.update&apiAccountId="
				+ accountId
				+ "&encodeParams="
				+ encodeParam
				+ "&timestamp="
				+ time + "&sign=" + sign;
		System.out.println("httpUrl = " + httpUrl);
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);// �Ƿ��������
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	public static String exception(String code,String err)
			throws UnsupportedEncodingException {

		String json = "{\"code\":\""+code+"\"," +
				"\"changeStatus\":\"exception\"," +
				"\"processMessage\":\""+err+"\"}";

		return result(json);
	}
	
	public static String accept2(String code,String billno,String turnsnum,String url)
			throws UnsupportedEncodingException {

		String json = "{\"code\":\""
				+ code
				+ "\",\"changeStatus\":\"accept\",\"extetionb\":\""+turnsnum+"\",\"supplierInnerCode\":\""
				+ billno
				+ "\",\"labelHTMLUrl\":{\"b10_10\":{\"a\":\"\",\"c\":\"\",\"p\":\"\",\"i\":\"\",\"ac\":\"\"},\"a4\":{\"a\":\"\",\"c\":\"\",\"p\":\"\",\"i\":\"\",\"ac\":\"\"}},"
				+ "\"labelPDFUrl\":{\"b10_10\":{\"a\":\""
				+ url
				+ "\",\"c\":\"\",\"p\":\"\",\"i\":\"\",\"ac\":\"\"},\"a4\":{\"a\":\"\",\"c\":\"\",\"p\":\"\",\"i\":\"\",\"ac\":\"\"}},"
				+ "\"labelIMGUrl\":{\"b10_10\":{\"a\":\"\",\"c\":\"\",\"p\":\"\",\"i\":\"\"},\"a4\":{\"a\":\"\",\"c\":\"\",\"p\":\"\",\"i\":\"\"}}}";

		return result(json);
	}
}
