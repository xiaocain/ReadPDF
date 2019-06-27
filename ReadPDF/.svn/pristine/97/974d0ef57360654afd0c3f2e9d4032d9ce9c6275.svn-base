package com.JCEX.utils;



import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

@Component
public class HttpUtils {
		
	//
	public  String httpGet(String url)
	{
		String result = null;
		try {
			CloseableHttpClient  client=createHttpsClient();
			URL url2 = new URL(url);
			URI uri = url2.toURI();
			HttpGet httpget=new HttpGet(uri);
			httpget.setHeader("version", "international_eub_us_1.1");
			httpget.setHeader("authenticate", "hzjcgj_4a94ac65f52b38f48d41c5f3739a9c97");
			CloseableHttpResponse response=client.execute(httpget);
			HttpEntity entity=response.getEntity();
			if(entity!=null)
			{
				result=EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
	public String searchPCA(String data_body)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String json = URLEncoder.encode(data_body, "UTF-8");

		String vAaoyouPCAaccessKey = "ef763f2acc6b8b6f1694b4903b2ab1cb070ee6af5b5c528c43caef6ac4821357";
		String url = "http://api.pcaexpress.com.au/shipment";
		String api_id = "jcex";
		String method = "update";

		StringBuilder builder = new StringBuilder();
		builder.append(vAaoyouPCAaccessKey).append("api_idjcexdata")
				.append(data_body).append("methodupdate")
				.append(vAaoyouPCAaccessKey);
		//System.out.println(builder.toString());
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] md5 = md.digest(builder.toString().getBytes("UTF-8"));
		String sign = ByteUtil.toString(md5).replace(" ", "");
		//System.out.println(sign);
		// byte[] signByte = Digests.md5(builder.toString().getBytes("UTF-8"));
		// String sign = ByteUtil.toString(signByte).replace(" ", "");

		// String sign=
		// MD5Print(MD5String(vAaoyouPCAaccessKey+"api_idjcexdata"+data_body+"methodcreate"+vAaoyouPCAaccessKey));
		String result = httpPCA(url, api_id, json, method, sign);
		return result;
	}
	
	private String httpPCA(String httpUrl, String api_id, String json,
			String method, String sign) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);// 是否输入参数
			// connection.setRequestProperty("Charset", "UTF-8");
			// connection.setRequestProperty("Accept","application/json");
			// connection.addRequestProperty("User-Agent",
			// "Mozilla/4.0(compatible;MSIE5.5;Windows NT; DigExt)");
			// connection.setRequestProperty("Content-type","application/x-www-form-urlencoded");
			StringBuffer params = new StringBuffer();
			params.append("api_id=").append(api_id).append("&data=")
					.append(json).append("&method=").append(method)
					.append("&sign=").append(sign);
			//System.out.println(url + "?" + params.toString());
			connection.setConnectTimeout(30000);
			connection.setReadTimeout(30000);
			connection.connect();
			connection.getOutputStream().write(params.toString().getBytes());
			InputStream is;
			try {
				is = connection.getInputStream();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				is = connection.getErrorStream();
			}
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	//key:value
		public   String KeyValue(String url,String requesetBody)
		{
			String result = null;
			try {
				CloseableHttpClient client=createHttpsClient();
				HttpPost httppost=new HttpPost(url);
//				httppost.setHeader("SOAPAction","\"http://tempuri.org/IShipServiceFromSine/GetHubInfoByCustomerID\"");
				httppost.setHeader("Content-Type","text/html;charset=GBK");
				List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			    if(requesetBody!=null){
			           nvps.add(new BasicNameValuePair("param",requesetBody));
			    }
			    httppost.setEntity(new UrlEncodedFormEntity(nvps));
//				httppost.setHeader("Accept","application/json");
//				StringEntity requestbody=new UrlEncodedFormEntity(nvps,);
//				httppost.setEntity(requestbody);
			    RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build();
			    httppost.setConfig(requestConfig);
				CloseableHttpResponse response=client.execute(httppost);
//				System.out.println(response.getStatusLine().getStatusCode());  //
				HttpEntity entity=response.getEntity();
				if(entity!=null)
				{
					result=EntityUtils.toString(entity);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return result;
		}
	   //key value的形式
		public String http(String httpUrl, String api, String encodeParam) {
			BufferedReader reader = null;
			String result = null;
			StringBuffer sbf = new StringBuffer();
			try {
				URL url = new URL(httpUrl);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.setDoOutput(true);// 是否输入参数
				StringBuffer params = new StringBuffer();
				params.append("PrintType=" + api).append("&order_id=").append(encodeParam);
				connection.setConnectTimeout(30000);
				connection.setReadTimeout(30000);
				connection.connect();
				connection.getOutputStream().write(params.toString().getBytes());
				InputStream is = connection.getInputStream();
				reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				String strRead = null;
				while ((strRead = reader.readLine()) != null) {
					sbf.append(strRead);
					sbf.append("\r\n");
				}
				reader.close();
				result = sbf.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			return result;
		}
		//key value的形式
		public String http(String httpUrl, String requestBody) {
			BufferedReader reader = null;
			String result = null;
			StringBuffer sbf = new StringBuffer();
			try {
				URL url = new URL(httpUrl);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.setDoOutput(true);// 是否输入参数
				StringBuffer params = new StringBuffer();
				params.append("param=" + requestBody);
				connection.setConnectTimeout(30000);
				connection.setReadTimeout(30000);
				connection.connect();
				connection.getOutputStream().write(params.toString().getBytes());
				InputStream is = connection.getInputStream();
				reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				String strRead = null;
				while ((strRead = reader.readLine()) != null) {
					sbf.append(strRead);
					sbf.append("\r\n");
				}
				reader.close();
				result = sbf.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			return result;
		}
		
	
	//Label Request 
	public   String httpPost(String url,String requesetBody)
	{
		String result = null;
		try {
			CloseableHttpClient client=createHttpsClient();
			HttpPost httppost=new HttpPost(url);
//			httppost.setHeader("SOAPAction","\"http://tempuri.org/IShipServiceFromSine/GetHubInfoByCustomerID\"");
//			httppost.setHeader("Content-Type","text/html;charset=UTF-8");
//			httppost.setHeader("version","international_eub_us_1.1");
//			httppost.setHeader("authenticate","njzzr528_3f0be74493b9393590a78d68efca1e92");
			httppost.setHeader("Content-Type","application/json");
			StringEntity requestbody=new StringEntity(requesetBody,"UTF-8");
			httppost.setEntity(requestbody);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build();
			httppost.setConfig(requestConfig);
			CloseableHttpResponse response=client.execute(httppost);
//			System.out.println(response.getStatusLine().getStatusCode());  //
			HttpEntity entity=response.getEntity();
			if(entity!=null)
			{
				result=EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	//SSL验证֤
	public static CloseableHttpClient createHttpsClient() throws Exception {
		X509TrustManager x509mgr = new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] xcs, String string) {
			}

			public void checkServerTrusted(X509Certificate[] xcs, String string) {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, new TrustManager[] { x509mgr },new java.security.SecureRandom());
		
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		
		return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	}
	
}
