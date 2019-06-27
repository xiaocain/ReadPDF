package com.JCEX.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.apache.commons.codec.binary.Base64;

import net.sf.json.JSONException;


public class TestorderForecasts {
    
//	public static void searchOrderInfo(String testid,String address,String postcode,String city) throws Exception {
		public static void searchOrderInfo() throws Exception {
		String service = "orderPayment";
		// data_body 2005208043 511716
		// appkey:717236 2005192002
		String data1 =

		// "<?xml version=\"1.0\" encoding=\"utf-8\"?><esc><head><messageId>18806684247</messageId><messageTime>2016-12-01 16:24:40 GMT 08:00</messageTime><messageWay>request</messageWay><sender>ALIBABA</sender><version>1.0</version><serviceName>orderPayment</serviceName></head><body><orderId>2005208043</orderId><serviceType>EXPRESS</serviceType><paySummary><amount>0.03</amount><currency>CNY</currency><paymentMethod>ALIPAY_ONLINE</paymentMethod><payer></payer><payTime>2016-12-01 16:24:40 GMT 08:00</payTime><payeeAccount>wlsellers@alibaba-inc.com</payeeAccount></paySummary></body></esc>";

		// "IBCCredentials";hermes DHL
		//
		"{\"Data\":{\"netcompanyname\": \"NIUMEN\",\"packages\": ["
				+ "{\"paymentmethod\": \"PP\",\"branchoffice\": \"\",\"waybillnumber\": \"TEST0106\","
				+ "\"referencenumber\": \"\",\"transfernumber\": \"\",\"productid\": \"\",\"productname\": \"\","
				+ "\"servicetype\": \"\", \"pickupservice\": [{\"pickupaddress\": \"\",\"pickupcontacts\": \"\","
				+ "\"pickupcontactnumber\": \"\",\"pickupstaff\": \"\",\"pickupamount\": \"\","
				+ "\"operatingcost\": \"\",\"expresscompany\": \"JCEX\",\"expressnumber\": \"\","
				+ "\"deliverypayment\": \"\",\"pickupRemark\": \"\", \"estimatedtimeofarrival\": \"\","
				+ "\"receivewarehouseaddress\": \"\",\"receivewarehousecontact\": \"\","
				+ "\"receivewarehousephone\": \"\"}],\"expressnetwork\": \"\",\"estimatedfee\": \"\","
				+ "\"feenotes\": \"\",\"feenotesperson\": \"\",\"feenotestime\": \"\",\"operationnotes\": \"\","
				+ "\"operationnotesperson\": \"\", \"operationnotestime\": \"\",\"returnsign\": \"\","
				+ "\"returnperson\": \"\",\"returntime\": \"\",\"returnreason\": \"\", \"receivewarehouse\": \"\","
				+ "\"status\": \"\",\"waybillcompleted\": \"\",\"inputname\": \"\",\"inputtime\": \"2017-03-15 20:35:55\","
				+ "\"senderinformation\": [{\"sendername\": \"TONY'S\",\"senderchinesename\": \"常州宝艾斯国际贸易有限公司\","
				+ "\"sendercompany\": \"CHANGZHOU RATTM MOTOR INTERNATION CO.,LTD\",\"senderphone\": \"+86-13506124578\","
				+ "\"sendercountry\": \"CN\",\"sendercity\": \"\",\"sendertown\": \"\","
				+ "\"senderpostcode\": \"\",\"senderaddress\": \"RM316,BUILDING 2,SANJING INDUSTRY PARK,NO 25 CHANG JIANG ROAD,NEW AREA,CHANGZHOU,JIANGSU,CHINA\","
				+ "\"sendercustomsregistrationcode\": \"\",\"sendercustomsoperatingunits\": \"\",\"senderproxycode\": \"\" }],"
				+ "\"recipientinformation\": ["
				+ "{\"recipientname\": \"Soma Kristin\","
				+ "\"recipientphone\": \"0427712602\","
				+ "\"recipientcountry\": \"RU\","
				+ "\"recipientpostcode\": \"427629\","
				+ "\"recipientcity\": \"GLAZOV\","
				+ "\"recipientstate\": \"GLAZOV\","
				+ "\"recipienttown\": \"\","
				+ "\"recipientemail\":\"\","
				+ "\"recipienthousenumber\": \"\",\"recipientaddress\": \"DRAGUNOVA 72A 62  62   GLAZOV, UDM\","
				+ "\"recipientcompany\": \"TEST jcex\",\"recipientdutyparagraph\": \"\"}"
				+ "],"
				+ "\"invoiceinformation\": ["

//				+ "{\"chinesename\":\"ww\","
//				+ "\"englishname\":\"testPM\","
//				+ "\"hscode\":\"12\","
//				+ "\"inpieces\":\"4\","
//				+ "\"unitpriceamount\":\"3.00\","
//				+ "\"declarationamount\":\"12.00\","
//				+ "\"declarationcurrency\":\"USD\","
//				+ "\"materialquality\":null,"
//				+ "\"purpose\":null,"
//				+ "\"measurementunit\":null,"
//				+ "\"specificationmodel\":null},"
				// + "{\"chinesename\":\"111\","
				// + "\"englishname\":\"ttxc\","
				// + "\"hscode\":\"23\","
				// + "\"inpieces\":\"100\","
				// + "\"unitpriceamount\":\"23.00\","
				// + "\"declarationamount\":\"2.00\","
				// + "\"declarationcurrency\":\"USD\","
				// + "\"materialquality\":null,"
				// + "\"purpose\":null,"
				// + "\"measurementunit\":null,"
				// + "\"specificationmodel\":null},"
				// + "{\"chinesename\":\"快很快就结婚\","
				// + "\"englishname\":\"TRRE\","
				// + "\"hscode\":\"kjjggfdd\","
				// + "\"inpieces\":\"6\","
				// + "\"unitpriceamount\":\"45.00\","
				// + "\"declarationamount\":\"45.00\","
				// + "\"declarationcurrency\":\"USD\","
				// + "\"materialquality\":null,"
				// + "\"purpose\":null,"
				// + "\"measurementunit\":null,"
				// + "\"specificationmodel\":null},"
				+ "{\"chinesename\":\"测试\","
				+ "\"englishname\":\"test\","
				+ "\"hscode\":\"4560000000\","
				+ "\"inpieces\":\"5\","
				+ "\"unitpriceamount\":\"4.00\","
				+ "\"declarationamount\":\"20.00\","
				+ "\"declarationcurrency\":\"USD\","
				+ "\"materialquality\":null,"
				+ "\"purpose\":null,"
				+ "\"measurementunit\":null,"
				+ "\"specificationmodel\":null}],"
				+ "\"weightinformation\": ["
				+ "{\"weightmethod\": \"\",\"totalpackages\": \"1\",\"itemtype\": \"文件1\",\"totalweight\": \"11\",\"totalvolumeweight\": \"7.92\",\"totalchargeableweight\": \"7.6\"}"
				+ "],"
				+ "\"detailpackage\":["
				// +
				// "{\"actualweight\":\"0.600\",\"length\":\"20.0\",\"width\":\"20.0\",\"height\":\"20.0\",\"volume\":\"72.000\",\"volumeweight\":\"0.014\"},"
				// +
				// "{\"actualweight\":\"1.000\",\"length\":\"3.0\",\"width\":\"3.0\",\"height\":\"12.0\",\"volume\":\"1.000\",\"volumeweight\":\"0.022\"},"
				// +
				// "{\"actualweight\":\"12.000\",\"length\":\"2.0\",\"width\":\"1.0\",\"height\":\"12.0\",\"volume\":\"24.000\",\"volumeweight\":\"0.005\"},"
				// +
				// "{\"actualweight\":\"12.000\",\"length\":\"2.0\",\"width\":\"2.0\",\"height\":\"12.0\",\"volume\":\"48.000\",\"volumeweight\":\"0.010\"},"
				+ "{\"actualweight\": \"0.6\",\"length\": \"46\",\"width\": \"41\",\"height\": \"21\",\"volume\": \"39606\",\"volumeweight\": \"7.92\"}],"
				+ "\"specialservice\": [{\"servicename\": \"\",\"costamount\": \"1\",\"costcurrency\": \"AUD\","
				+ "\"description\": null}]}]}}";

		String data2 = "{\"Data\":{\"netcompanyname\":\"UKMAIL\","//ROYALMAIL
				+ "\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,"
				+ "\"waybillnumber\":\"TEST4237001\",\"referencenumber\":\"\","
				+ "\"transfernumber\":null,\"productid\":null,\"productname\":null,"
				+ "\"servicetype\":null,\"pickupservice\":null,\"expressnetwork\":null,"
				+ "\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,"
				+ "\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,"
				+ "\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,"
				+ "\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,"
				+ "\"status\":null,\"waybillcompleted\":null,\"inputname\":null,"
				+ "\"inputtime\":null,"
				+ "\"accountinformation\":["
				+ "{\"accountusername\":\"xiaodong@jcex.com\","
				+ "\"accountpassword\":\"xiaodong@jcex\","
				+ "\"accountnumber\":\"70543954\","
				+ "\"accountpin\":\"342215\","
				+ "\"accountentity\":\"HKG\","
				+ "\"accountcountryCode\":\"HK\","
				+ "\"accountcity\":\"Hong Kong\","
				+ "\"accountpostcode\":\"999077\"}],"
				+ "\"senderinformation\":["
				+ "{\"sendername\":\"ALEX GAO\","
				+ "\"senderchinesename\":\"ZHONGHANG RD.\","
				+ "\"sendercompany\":\"ZHONGHANG RD.\","
				+ "\"senderphone\":\"13686871955\","
				+ "\"sendercountry\":\"CN\","
				+ "\"sendercity\":\"hangzhou\","
				+ "\"sendertown\":\"\","
				+ "\"senderpostcode\":\"310000\","
				+ "\"senderaddress\":\"FU TIAN DISTRICT,SBLIC\","
				+ "\"sendercustomsregistrationcode\":null,"
				+ "\"sendercustomsoperatingunits\":null,"
				+ "\"senderproxycode\":null}],"
				+ "\"recipientinformation\":["
				+ "{\"recipientname\": \"LISA DEEPROSE\","
				+ "\"recipientphone\": \"07715423252\","
				+ "\"recipientcountry\": \"GB\","
				+ "\"recipientpostcode\": \"RH2 9SS\","// 91723
				+ "\"recipientcity\": \"REIGATE\","
				+ "\"recipientstate\": \"SURREY\", "
				+ "\"recipienttown\": \"\", "
				+ "\"recipienthousenumber\":\"\","
				+ "\"recipientaddress\":\"JELLYFISH CONNECT JELLYFISH HOUSE 31 LONDON ROAD\","
				+ "\"recipientcompany\":\"JELLYFISH CONNECT JELLYFISH HOUSE\","
				+ "\"recipientdutyparagraph\":null}],"
				+ "\"invoiceinformation\":["
				// + "{\"chinesename\":\"测试\","
				// + "\"englishname\":\"testPM\","
				// + "\"hscode\":\"\","
				// + "\"inpieces\":\"4\","
				// + "\"unitpriceamount\":\"12.00\","
				// + "\"declarationamount\":\"12.00\","
				// + "\"declarationcurrency\":\"USD\","
				// + "\"materialquality\":null,"
				// + "\"purpose\":null,"
				// + "\"measurementunit\":null,"
				// + "\"specificationmodel\":null},"
				// + "{\"chinesename\":\"111\","
				// + "\"englishname\":\"ttxc\","
				// + "\"hscode\":\"23\","
				// + "\"inpieces\":\"100\","
				// + "\"unitpriceamount\":\"23.00\","
				// + "\"declarationamount\":\"2.00\","
				// + "\"declarationcurrency\":\"USD\","
				// + "\"materialquality\":null,"
				// + "\"purpose\":null,"
				// + "\"measurementunit\":null,"
				// + "\"specificationmodel\":null},"
//				+ "{\"chinesename\":\"快\","
//				+ "\"englishname\":\"TRRE\","
//				+ "\"hscode\":\"3210000000\","
//				+ "\"inpieces\":\"1\","
//				+ "\"unitpriceamount\":\"9.00\","
//				+ "\"declarationamount\":\"9.00\","
//				+ "\"declarationcurrency\":\"USD\","
//				+ "\"materialquality\":null,"
//				+ "\"purpose\":null,"
//				+ "\"measurementunit\":null,"
//				+ "\"specificationmodel\":null},"
				+ "{\"chinesename\":\"测试\","
				+ "\"englishname\":\"LADY SHOES\","
				+ "\"hscode\":\"3210000000\","
				+ "\"inpieces\":\"1\","
				+ "\"unitpriceamount\":\"5.00\","
				+ "\"declarationamount\":\"5.00\","
				+ "\"declarationcurrency\":\"USD\","
				+ "\"materialquality\":null,"
				+ "\"purpose\":null,"
				+ "\"measurementunit\":null,"
				+ "\"specificationmodel\":null}],"
				+ "\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\",\"itemtype\":\"PAK袋\","
				+ "\"totalweight\":\"1.000\",\"totalvolumeweight\":\"0.200\",\"totalchargeableweight\":\"0.200\"}],"
				+ "\"detailpackage\":["
				+
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"1.00\",\"child_number\":\"test011\",\"length\":\"10\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\", "
				// +
				// "\"item\": [" +
				// "{\"englishname\": \"test11\"," +
				// "\"hscode\": \"3214568972\", " +
				// "\"inpieces\": \"1\"," +
				// "\"unitpriceamount\": \"350\"," +
				// "\"unitpriceweight\": \"1\"," +
				// "\"declarationamount\": \"3.5\"," +
				// "\"declarationcurrency\": \"USD\"}," +
				// "{\"englishname\": \"test12\"," +
				// "\"hscode\": \"15864215987\"," +
				// "\"inpieces\": \"2\", " +
				// "\"unitpriceamount\": \"350\"," +
				// "\"unitpriceweight\": \"1\"," +
				// "\"declarationamount\": \"7\"," +
				// "\"declarationcurrency\": \"USD\"}]}," +
				"{\"actualweight\":\"1.00\",\"child_number\":\"1\",\"length\":\"4\",\"width\":\"43\",\"height\":\"43.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\","
				+ "\"item\": ["
				+ "{\"englishname\": \"test21\","
				+ "\"hscode\": \"1234567890\", "
				+ "\"inpieces\": \"4\","
				+ "\"unitpriceamount\": \"25\","
				+ "\"unitpriceweight\": \"\","
				+ "\"declarationamount\": \"50\","
				+ "\"declarationcurrency\": \"USD\"},"
				+ "{\"englishname\": \"test22\","
				+ "\"hscode\": \"1234566541\","
				+ "\"inpieces\": \"10\", "
				+ "\"unitpriceamount\": \"500\","
				+ "\"unitpriceweight\": \"0.1\","
				+ "\"declarationamount\": \"50\","
				+ "\"declarationcurrency\": \"USD\"}"
				+ "]}"
				+

				"],"
				+ "\"specialservice\":[{\"servicename\":null,\"costamount\":null,\"description\":null}]}]}}";

		String data3 = "{\"Data\":{\"netcompanyname\":\"BONDED\",\"packages\":[" +
				"{\"paymentmethod\":\"null\",\"branchoffice\":\"\"," +
				"\"waybillnumber\":\"TEST20180605001\",\"referencenumber\":\"XM3ZW4034405\",\"transfernumber\":\"\",\"productid\":\"\",\"productname\":\"\",\"servicetype\":\"\",\"pickupservice\":[],\"expressnetwork\":\"\",\"estimatedfee\":\"\",\"feenotes\":\"\",\"feenotesperson\":\"\",\"feenotestime\":\"\",\"operationnotes\":\"\",\"operationnotesperson\":\"\",\"operationnotestime\":\"\",\"returnsign\":\"\",\"returnperson\":\"\",\"returntime\":\"\",\"returnreason\":\"\",\"receivewarehouse\":\"\",\"status\":\"\",\"waybillcompleted\":\"\",\"inputname\":\"\",\"inputtime\":\"\",\"senderinformation\":[{\"sendername\":\"Zhu Bin\",\"senderchinesename\":\"\",\"sendercompany\":\"\",\"senderphone\":\"13815588433\",\"sendercountry\":\"CN\",\"sendercity\":\"Yanchengshi\",\"sendertown\":\"\",\"senderpostcode\":\"224001\",\"senderaddress\":\"No.99, West Huanghai Road\",\"sendercustomsregistrationcode\":\"\",\"sendercustomsoperatingunits\":\"\",\"senderproxycode\":\"\",\"senderemail\":\"null\"}],\"recipientinformation\":[{\"recipientname\":\"BENOIST Henry\",\"recipientphone\":\"33671106020\",\"recipientcountry\":\"FR\",\"recipientpostcode\":\"28500\",\"recipientcity\":\"VERNOUILLET\",\"recipientstate\":\"　\",\"recipienttown\":\"\",\"recipienthousenumber\":\"\",\"recipientaddress\":\"6,Impasse Paul VALERY Les Grandes Vauvettes\",\"recipientcompany\":\"BENOIST Henry\",\"recipientdutyparagraph\":\"\",\"recipientemail\":\"\"}],\"invoiceinformation\":[{\"chinesename\":\"舞鞋\",\"englishname\":\"Dance shoes\",\"hscode\":\"6402200000\",\"inpieces\":\"1\",\"unitpriceamount\":\"18.00\",\"declarationamount\":\"18.00\",\"declarationcurrency\":\"USD\",\"materialquality\":\"null\",\"purpose\":\"null\",\"measurementunit\":\"null\",\"specificationmodel\":\"\"}],\"weightinformation\":[{\"weightmethod\":\"null\",\"totalpackages\":\"1\",\"itemtype\":\"PAK袋\",\"totalweight\":\"0.38\",\"totalvolumeweight\":\"0\",\"totalchargeableweight\":\"0.38\"}],\"detailpackage\":[{\"actualweight\":\"0.38\",\"length\":\"0.0\",\"width\":\"0.0\",\"height\":\"0.0\",\"volume\":\"null\",\"volumeweight\":\"null\",\"item\":[]}],\"specialservice\":[{\"servicename\":\"null\",\"costamount\":\"0.0\",\"costcurrency\":\"null\",\"description\":\"null\"}]}]}}";
		
		String data7 = "{\"Data\":{\"netcompanyname\":\"BONDED\",\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,\"waybillnumber\":\"JCR2005330098IN\",\"referencenumber\":\"JCR2005330098IN\",\"transfernumber\":null,\"productid\":null,\"productname\":null,\"servicetype\":null,\"pickupservice\":[],\"expressnetwork\":null,\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,\"status\":null,\"waybillcompleted\":null,\"inputname\":null,\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"SUN FANG\",\"senderchinesename\":\"FreeFisher\",\"sendercompany\":\"FreeFisher\",\"senderphone\":\"15021409036\",\"sendercountry\":\"CN\",\"sendercity\":\"SHANGHAI\",\"sendertown\":\"\",\"senderpostcode\":\"200071\",\"senderaddress\":\"ROOM 302 NO.999 JIANGYUE RD\",\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,\"senderproxycode\":null,\"senderemail\":\"\"}],\"recipientinformation\":[{\"recipientname\":\"ULRIKE KROMER\",\"recipientphone\":\"03612626836\",\"recipientcountry\":\"DE\",\"recipientpostcode\":\"99084\",\"recipientcity\":\"Erfurt\",\"recipientstate\":\"Thüringen\",\"recipienttown\":\"\",\"recipienthousenumber\":null,\"recipientaddress\":\"Evangelische Grundschule Erfurt Regierungsstr. 42a\",\"recipientcompany\":\"ULRIKE KROMER\",\"recipientdutyparagraph\":null,\"recipientcertificatecode\":\"\",\"recipientemail\":\"\"}],\"invoiceinformation\":[{\"chinesename\":\"骑行服\",\"englishname\":\"Riding clothes\",\"hscode\":\"6211439000\",\"inpieces\":\"1\",\"unitpriceamount\":\"16.00\",\"declarationamount\":\"16.00\",\"declarationcurrency\":\"USD\",\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null,\"invoice_weight\":\"0.000\"}],\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\",\"itemtype\":\"纸箱\",\"totalweight\":\"0.480\",\"totalvolumeweight\":\"0.000\",\"totalchargeableweight\":\"0.500\"}],\"detailpackage\":[{\"actualweight\":\"0.480\",\"length\":\"0.0\",\"width\":\"0.0\",\"height\":\"0.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\",\"child_number\":\"JCR2005330098IN\",\"goodsname\":\"\",\"trackno\":\"\",\"item\":[]}],\"specialservice\":[{\"servicename\":\"申报价值等级1\",\"costamount\":\"16.00\",\"costcurrency\":\"\",\"description\":\"\"}]}]}}";
		
		
		String data8 = "{\"Data\":{\"customerid\":\"8DD39425-178E-44FA-8232-D254FAC16391\","
				+ "\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,"
				+ "\"waybillnumber\":\"8\",\"referencenumber\":\"\","
				+ "\"transfernumber\":null,\"productid\":null,\"productname\":null,\"networkid\":null,\"networkname\":\"test渠道名称\","
				+ "\"servicetype\":null,\"pickupservice\":null,\"expressnetwork\":null,"
				+ "\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,"
				+ "\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,"
				+ "\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,"
				+ "\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,"
				+ "\"status\":null,\"waybillcompleted\":null,\"inputname\":null,"
				+ "\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"ALEX GAO\","
				+ "\"senderchinesename\":\"ZHONGHANG RD.\",\"sendercompany\":\"ZHONGHANG RD.\","
				+ "\"senderphone\":\"13686871955\",\"sendercountry\":\"CN\",\"sendercity\":\"sssqqq\","
				+ "\"sendertown\":\"\",\"senderpostcode\":\"\",\"senderaddress\":\"FU TIAN DISTRICT,SHENZHEN DUHUI100 BUILDING B 23S ROOM SHENZHEN CHINA.PEOPLES\u0027S REPUBLIC\","
				+ "\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,"
				+ "\"senderproxycode\":null}],"
				+ "\"recipientinformation\":["
				+ "{\"recipientname\": \"AMAZON CO UK\","
				+ "\"recipientphone\": \"111\","
				+ "\"recipientcountry\": \"SG\","
				+ "\"recipientpostcode\": \"92704\","
				+ "\"recipientcity\": \"Santa Ana\","
				+ "\"recipientstate\": \"CA\", "
				+ "\"recipienttown\": \"Swansea\", "
				+ "\"recipienthousenumber\":\"\","
				+ "\"recipientaddress\":\"3310 West MacArthur Blvd\","
				+ "\"recipientcompany\":\"TESE name\","
				+ "\"recipientdutyparagraph\":null}],"
				+ "\"invoiceinformation\":["
				+ "{\"chinesename\":\"ss\","
				+ "\"englishname\":\"testPM\","
				+ "\"hscode\":\"12\","
				+ "\"inpieces\":\"4\","
				+ "\"unitpriceamount\":\"12.00\","
				+ "\"declarationamount\":\"12.00\","
				+ "\"declarationcurrency\":\"USD\","
				+ "\"materialquality\":null,"
				+ "\"purpose\":null,"
				+ "\"measurementunit\":null,"
				+ "\"specificationmodel\":null},"
				+ "{\"chinesename\":\"111\","
				+ "\"englishname\":\"ttxc\","
				+ "\"hscode\":\"23\","
				+ "\"inpieces\":\"100\","
				+ "\"unitpriceamount\":\"23.00\","
				+ "\"declarationamount\":\"2.00\","
				+ "\"declarationcurrency\":\"USD\","
				+ "\"materialquality\":null,"
				+ "\"purpose\":null,"
				+ "\"measurementunit\":null,"
				+ "\"specificationmodel\":null},"
				+ "{\"chinesename\":\"快很快就结婚\","
				+ "\"englishname\":\"TRRE\","
				+ "\"hscode\":\"kjjggfdd\","
				+ "\"inpieces\":\"6\","
				+ "\"unitpriceamount\":\"45.00\","
				+ "\"declarationamount\":\"45.00\","
				+ "\"declarationcurrency\":\"USD\","
				+ "\"materialquality\":null,"
				+ "\"purpose\":null,"
				+ "\"measurementunit\":null,"
				+ "\"specificationmodel\":null},"
				+ "{\"chinesename\":\"111\","
				+ "\"englishname\":\"456\","
				+ "\"hscode\":\"456\","
				+ "\"inpieces\":\"5\","
				+ "\"unitpriceamount\":\"456.00\","
				+ "\"declarationamount\":\"456.00\","
				+ "\"declarationcurrency\":\"USD\","
				+ "\"materialquality\":null,"
				+ "\"purpose\":null,"
				+ "\"measurementunit\":null,"
				+ "\"specificationmodel\":null}],"
				+ "\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\",\"itemtype\":null,"
				+ "\"totalweight\":\"0.9\",\"totalvolumeweight\":\"0.200\",\"totalchargeableweight\":\"5.000\"}],"
				+ "\"detailpackage\":["
				// +
				// "{\"actualweight\":\"0.600\",\"length\":\"1.0\",\"width\":\"1.0\",\"height\":\"1.0\",\"volume\":\"72.000\",\"volumeweight\":\"0.014\"},"
				// +
				// "{\"actualweight\":\"1.000\",\"length\":\"3.0\",\"width\":\"3.0\",\"height\":\"12.0\",\"volume\":\"1.000\",\"volumeweight\":\"0.022\"},"
				// +
				// "{\"actualweight\":\"12.000\",\"length\":\"2.0\",\"width\":\"1.0\",\"height\":\"12.0\",\"volume\":\"24.000\",\"volumeweight\":\"0.005\"},"
				// +
				// "{\"actualweight\":\"12.000\",\"length\":\"2.0\",\"width\":\"2.0\",\"height\":\"12.0\",\"volume\":\"48.000\",\"volumeweight\":\"0.010\"},"
				+ "{\"actualweight\":\"0.400\",\"length\":\"2.0\",\"width\":\"12.0\",\"height\":\"21.0\",\"volume\":\"5.000\",\"volumeweight\":\"10.735\"}"
				+ "],"
				+ "\"specialservice\":[{\"servicename\":null,\"costamount\":null,\"description\":\"\"}]}]}}";

		String data5 = "{\"Data\":{\"netcompanyname\":\"UPSUPDATE\",\"packages\":[{\"waybillnumber\":\"3095952\"}]}}";
		String data6 = "{\"Data\":{\"netcompanyname\":\"USDHLCLOSEOUT\",\"packages\":[{\"isall\":\"all\",\"waybillnumber\":[]}]}}";

		String data_body2 = "<esc><head><messageId>18814307611</messageId><messageTime>2017-03-09 17:00:31 GMT+08:00</messageTime><messageWay>request</messageWay><sender>ALIBABA</sender><version>1.0</version><serviceName>orderForecast</serviceName></head><body><orderId>2005860110</orderId><serviceType>EXPRESS</serviceType><sellerNote>asst01@abc-tex.com</sellerNote><email>asst01@abc-tex.com</email><isCustomsClearance>N</isCustomsClearance><departurePlace>JC_HZ</departurePlace><destinationCountry>FR</destinationCountry><serviceList><domesticTransportation><deliveryCount>1</deliveryCount><logisticsInfoList><logisticsInfo><logisticsCompany>SHENTONG</logisticsCompany><logisticsNo>402385072717</logisticsNo></logisticsInfo></logisticsInfoList></domesticTransportation><warehouseService><warehouse>JC_HZ</warehouse></warehouseService><internationalExpress><logisticsCompanyService>JC</logisticsCompanyService></internationalExpress></serviceList><contactInfo><consignee><companyName></companyName><name>Grolleau franck</name><country>FR</country><province>BOISSIEU</province><city>LUCE</city><address>LPBDA - GROLLEAU Franck 3 R. du Gen. Alain de BOISSIEU 28110 LUCE FRANCE</address><zip>28110</zip><phoneNumber>33-652042656</phoneNumber></consignee><shipper><companyName>嘉兴艾比升纺织品有限公司</companyName><name>李庆</name><phoneNumber></phoneNumber><mobile>15988212503</mobile></shipper></contactInfo><consignmentInfo><goodsSummary><totalPackageQuantity>1</totalPackageQuantity><totalDeclaredValue>10</totalDeclaredValue><totalDeclaredCurrency>USD</totalDeclaredCurrency><mixedPackage>false</mixedPackage></goodsSummary><goodsDeclarationList><goodsDeclaration><nameChinese>全涤纶面料</nameChinese><nameEnglish>100 polyester fabric</nameEnglish><hscode>60053700</hscode><nature></nature><statutoryQuantity>1</statutoryQuantity></goodsDeclaration></goodsDeclarationList></consignmentInfo></body></esc>";
		// 156000800016407
		String lable = "{\"customerid\":\"8DD39425-178E-44FA-8232-D254FAC16391\",\"shipmentid\":\"2b3b0907-3f2e-42e1-a7b6-2d0cce2ddca9\",\"issignaturerequired\":\"0\",\"outputs\":\"LABEL_PDF\"}";

		String data33 = "{\"Data\": {\"customerid\": \"8DD39425-178E-44FA-8232-D254FAC16391\",\"packages\": [{\"paymentmethod\": \"PP\",\"branchoffice\": \"\",\"waybillnumber\": \"\",\"referencenumber\": \"ZYW0037-85-5922\",\"transfernumber\": \"\",\"productid\": \"\",\"productname\": \"\",\"servicetype\": \"PPS\",\"pickupservice\": [{\"pickupaddress\": \"\",\"pickupcontacts\": \"\",\"pickupcontactnumber\": \"\",\"pickupstaff\": \"\",\"pickupamount\": \"\",\"operatingcost\": \"\",\"expresscompany\": \"\",\"expressnumber\": \"\",\"deliverypayment\": \"\",\"pickupRemark\": \"\",\"estimatedtimeofarrival\": \"\",\"receivewarehouseaddress\": \"\",\"receivewarehousecontact\": \"\",\"receivewarehousephone\": \"\"}],\"expressnetwork\": \"\",\"estimatedfee\": \"\",\"feenotes\": \"\",\"feenotesperson\": \"\",\"feenotestime\": \"\",\"operationnotes\": \"\",\"operationnotesperson\": \"\",\"operationnotestime\": \"\",\"returnsign\": \"\",\"returnperson\": \"\",\"returntime\": \"\",\"returnreason\": \"\",\"receivewarehouse\": \"\",\"status\": \"\",\"waybillcompleted\": \"\",\"inputname\": \"\",\"inputtime\":\"\",\"senderinformation\": [{\"sendername\": \"cuifeng\",\"senderchinesename\": \"123\",\"sendercompany\": \"123\",\"senderphone\": \"13958050719\",\"sendercountry\": \"CN\",\"sendercity\": \"beijing\",\"sendertown\": \"haidian\",\"senderpostcode\": \"100000\",\"senderaddress\": \"cuibairoad#7 301\",\"sendercustomsregistrationcode\": \"\",\"sendercustomsoperatingunits\": \"\",\"senderproxycode\": \"\"}],\"recipientinformation\": [{\"recipientname\": \"eee\",\"recipientphone\":\"\",\"recipientcountry\": \"US\",\"recipientpostcode\": \"89134-2343\",\"recipientcity\": \"LAS VEGAS\",\"recipientstate\": \"CA\",\"recipienttown\": \"LAS VEGAS\",\"recipienthousenumber\": \"\",\"recipientaddress\": \"NV1996 \",\"recipientcompany\": \"\",\"recipientdutyparagraph\": \"\"}],\"invoiceinformation\": [{\"chinesename\": \"梳子\",\"englishname\": \"comb\",\"hscode\": \"\",\"inpieces\": 2,\"unitpriceamount\": 3.79,\"declarationamount\": 5,\"declarationcurrency\": \"USD\",\"materialquality\": \"\",\"purpose\":\"\",\"measurementunit\": \"\",\"specificationmodel\": \"\"}],\"weightinformation\": [{\"weightmethod\": \"2\",\"totalpackages\": \"2\",\"itemtype\": \"2\",\"totalweight\": \"\",\"totalvolumeweight\": \"\",\"totalchargeableweight\": \"\"}],\"detailpackage\": [{\"actualweight\": \"0.2\",\"length\": \"10\",\"width\": \"10\",\"height\": \"10\",\"volume\": \"100\",\"volumeweight\": \"\"}],\"specialservice\": [{\"servicename\": \"1\",\"costamount\": \"\",\"description\": \"\"}]}]}}";
		String data4 = "{\"customerid\": \"8DD39425-178E-44FA-8232-D254FAC16391\",\"shipmentid\": \"2b3b0907-3f2e-42e1-a7b6-2d0cce2ddca9\",\"issignaturerequired\": \"1\",\"outputs\": \"LABEL_PDF\"}";

		String track = "{ \"customerid\": \"-1\",\"waybillnumber\":\"5391201622\",\"isdisplaydetail\":\"false\",\"provider\":\"\" }";
		String getjcexbillno = "{ \"customername\": \"HZ1001\",\"productname\": \"HZ1001\",\"recipientcity\":\"ca\",\"recipientpostcode\":\"1001\",\"recipientcountry\":\"US\" }";
		String getorder = "{ \"channel\": \"JC-USUPS(C)\",\"waybillnumber\":\"863107755\"}";
		String service1 = "orderForecast";
		String data_body1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<esc>" + "<head>" + "<messageId>18810692049</messageId>"
				+ "<messageTime>2017-01-17 04:00:12 GMT 08:00</messageTime>"
				+ "<messageWay>request</messageWay>"
				+ "<sender>ALIBABA</sender>" + "<version>1.0</version>"
				+ "<serviceName>orderForecast</serviceName>" + "</head>"
				+ "<body>" + "<orderId>TEST201711231001</orderId>"
				+ "<serviceType>EXPRESS</serviceType>"
				+ "<sellerNote>测试测试测试</sellerNote>"
				+ "<email>weisioaia@134.com</email>"
				+ "<isCustomsClearance>Y</isCustomsClearance>"
				+ "<departurePlace>JC_HZ</departurePlace>"
				+ "<destinationCountry>US</destinationCountry>"
				+ "<serviceList>" + "<domesticTransportation>"
				+ "<deliveryCount>1</deliveryCount>" + "<logisticsInfoList>"
				+ "<logisticsInfo>"
				+ "<logisticsCompany>EMS</logisticsCompany>"
				+ "<logisticsNo>1212</logisticsNo>" + "</logisticsInfo>"
				+ "</logisticsInfoList>" + "</domesticTransportation>"
				+ "<warehouseService>" + "<warehouse>JC_HZ</warehouse>"
				+ "</warehouseService>" + "<internationalExpress>"
				+ "<logisticsCompanyService>JC</logisticsCompanyService>"
				+ "</internationalExpress>" + "</serviceList>"
				+ "<contactInfo>" + "<consignee>"
				+ "<companyName>cnee company name</companyName>"
				+ "<name>cnee linkman</name>" + "<country>RU</country>"
				+ "<province>fj</province>" + "<city>pt</city>"
				+ "<address>address</address>" + "<zip>152020</zip>"
				+ "<phoneNumber>86-0571-88888888</phoneNumber>"
				+ "</consignee>" + "<shipper>"
				+ "<companyName>alilsis</companyName>" + "<name>xiaoia</name>"
				+ "<phoneNumber>13189892332</phoneNumber>"
				+ "<mobile>1212</mobile>" + "</shipper>" + "</contactInfo>"
				+ "<consignmentInfo>" + "<goodsSummary>"
				+ "<totalPackageQuantity>1</totalPackageQuantity>"
				+ "<totalDeclaredValue>12</totalDeclaredValue>"
				+ "<totalDeclaredCurrency>USD</totalDeclaredCurrency>"
				+ "<mixedPackage>false</mixedPackage>" + "</goodsSummary>"
				+ "<goodsDeclarationList>" + "<goodsDeclaration>"
				+ "<nameChinese>ali123测试账号中文商品描述快递</nameChinese>"
				+ "<nameEnglish>1</nameEnglish>"
				+ "<hscode>3402130090</hscode>" + "<nature></nature>"
				+ "<statutoryQuantity>1</statutoryQuantity>"
				+ "</goodsDeclaration>" + "</goodsDeclarationList>"
				+ "</consignmentInfo>" + "</body>" + "</esc>";

		String alitest = "<esc><head><messageId>18830280791</messageId><messageTime>2017-07-20 14:00:10 GMT 08:00</messageTime><messageWay>request</messageWay><sender>ALIBABA</sender><version>1.0</version><serviceName>orderForecast</serviceName></head><body><orderId>2006682811</orderId><serviceType>EXPRESS</serviceType><sellerNote>fanxi10@ncfanxi.com</sellerNote><email>fanxi10@ncfanxi.com</email><isCustomsClearance>N</isCustomsClearance><departurePlace>JC_SH</departurePlace><destinationCountry>AU</destinationCountry><serviceList><domesticTransportation><deliveryCount>1</deliveryCount><logisticsInfoList><logisticsInfo><logisticsCompany>YUNDA</logisticsCompany><logisticsNo>1202278172985</logisticsNo></logisticsInfo></logisticsInfoList></domesticTransportation><warehouseService><warehouse>JC_SH</warehouse></warehouseService><internationalExpress><logisticsCompanyService>JC</logisticsCompanyService></internationalExpress></serviceList><contactInfo><consignee><companyName>FOREVER NEW CLOTHING PTY LTD</companyName><name>Level 4, Building 8, 576 Swan Street, Richmond, VIC 3121 P: 61 3 9859 9111</name><country>AU</country><province>Richmond</province><city>Swan Street</city><address>Level 4, Building 8, 576 Swan Street, Richmond, VIC 3121 P: 61 3 9859 9111</address><zip>3121P</zip><phoneNumber>61-398599111</phoneNumber></consignee><shipper><companyName>南昌凡西</companyName><name>COCO</name><phoneNumber></phoneNumber><mobile>8618702502764</mobile></shipper></contactInfo><consignmentInfo><goodsSummary><totalPackageQuantity>1</totalPackageQuantity><totalDeclaredValue>24</totalDeclaredValue><totalDeclaredCurrency>USD</totalDeclaredCurrency><mixedPackage>false</mixedPackage></goodsSummary><goodsDeclarationList><goodsDeclaration><nameChinese>珠宝展示架</nameChinese><nameEnglish>jewelry display stand</nameEnglish><hscode>42029200</hscode><nature></nature><statutoryQuantity>3</statutoryQuantity></goodsDeclaration></goodsDeclarationList></consignmentInfo></body></esc>";

		// 一票多品名
		String alitest2 = "<?xml version=\"1.0\" encoding=\"utf-8\"?><esc><head><messageId>18823528135</messageId>"
				+ "<messageTime>2017-05-16 07:57:12 GMT 08:00</messageTime><messageWay>request</messageWay><sender>ALIBABA</sender>"
				+ "<version>1.0</version><serviceName>orderForecast</serviceName></head><body><orderId>TEST20180408001</orderId>"
				+ "<serviceType>EXPRESS</serviceType><sellerNote>测试件</sellerNote><email>517576705@qq.com</email>"
				+ "<isCustomsClearance>N</isCustomsClearance><departurePlace>JC_SZV</departurePlace>"
				+ "<destinationCountry>DE</destinationCountry><serviceList><domesticTransportation><deliveryCount>1</deliveryCount>"
				+ "<logisticsInfoList><logisticsInfo><logisticsCompany>SHENTONG</logisticsCompany><logisticsNo>123123123</logisticsNo>"
				+ "</logisticsInfo></logisticsInfoList></domesticTransportation><warehouseService><warehouse>JC_SZV</warehouse>"
				+ "</warehouseService><internationalExpress><logisticsCompanyService>JC</logisticsCompanyService></internationalExpress>"
				+ "</serviceList><contactInfo><consignee><companyName>Emmermann Training</companyName><name>Dimo Emmermann</name>"
				+ "<country>ZA</country><province>brakpan</province><city>brakpan</city>"
				+ "<address>Jahnstrabe 1,Northeim,Lower Saxony ,37154 Germany</address><zip>1541</zip>"
				+ "<phoneNumber>0049-171-7596160</phoneNumber></consignee><shipper><companyName>南京耀皮</companyName>"
				+ "<name>张存</name><phoneNumber></phoneNumber><mobile>18651750049</mobile></shipper></contactInfo>"
				+ "<consignmentInfo><goodsSummary><totalPackageQuantity>1</totalPackageQuantity>"
				+ "<totalDeclaredValue>14</totalDeclaredValue><totalDeclaredCurrency>CNY</totalDeclaredCurrency>"
				+ "<mixedPackage>false</mixedPackage></goodsSummary><goodsDeclarationList><goodsDeclaration>"
				+ "<nameChinese>竞技体育用钢丝绳</nameChinese><nameEnglish>crossfit speed rope</nameEnglish>"
				+ "<hscode>95069190</hscode><nature></nature><statutoryQuantity>1</statutoryQuantity>"
				+ "</goodsDeclaration><goodsDeclaration><nameChinese>举重护掌</nameChinese>"
				+ "<nameEnglish>weightlifting palm protector</nameEnglish><hscode>95069190</hscode>"
				+ "<nature></nature><statutoryQuantity>1</statutoryQuantity></goodsDeclaration>"
				+ "<goodsDeclaration><nameChinese>健身用按摩球</nameChinese><nameEnglish>crossfit massage ball</nameEnglish>"
				+ "<hscode>95066900</hscode><nature></nature><statutoryQuantity>1</statutoryQuantity></goodsDeclaration>"
				+ "<goodsDeclaration><nameChinese>健身运动胶贴</nameChinese><nameEnglish>sports tape</nameEnglish>"
				+ "<hscode>30051090</hscode><nature></nature><statutoryQuantity>1</statutoryQuantity></goodsDeclaration>"
				+ "</goodsDeclarationList></consignmentInfo></body></esc>";

		// String alitestpay =
		// "<?xml version=\"1.0\" encoding=\"utf-8\"?><esc><head><messageId>18830494870</messageId>"
		// +
		// "<messageTime>2017-07-20 08:20:39 GMT+08:00</messageTime><messageWay>request</messageWay>"
		// +
		// "<sender>ALIBABA</sender><version>1.0</version><serviceName>orderPayment</serviceName>"
		// +
		// "</head><body><orderId>TEST201707310007</orderId><serviceType>EXPRESS</serviceType><paySummary>"
		// +
		// "<amount>0.01</amount><currency>CNY</currency><paymentMethod>ALIPAY_ONLINE</paymentMethod>"
		// +
		// "<payer>SUPPLIER</payer><payTime>2017-07-20 08:20:38 GMT+08:00</payTime><payeeAccount>测试付款</payeeAccount>"
		// + "</paySummary></body></esc>";

		String alitestcancel = "<?xml version=\"1.0\" encoding=\"utf-8\"?><esc><head><messageId>18830498297</messageId>"
				+ "<messageTime>2017-07-20 10:03:43 GMT 08:00</messageTime><messageWay>request</messageWay><sender>ALIBABA</sender>"
				+ "<version>1.0</version><serviceName>cancelOrder</serviceName></head><body><orderId>TEST201711201001</orderId>"
				+ "<reason><codeList><code>OTHER</code></codeList></reason></body></esc>";

		String data9 = "{\"Data\":{\"netcompanyname\":\"ECDCBE\","
				+ // JCNL(UPS商业) ROYALMAIL createManifestROYALMAIL
				"\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,"
				+ "\"waybillnumber\":\"test20180915005\","
				+ // 100000001
				"\"referencenumber\":\"TESTML20170502\","
				+ "\"transfernumber\":null,\"productid\":null,"
				+ "\"productname\":null,\"servicetype\":null,"
				+ "\"pickupservice\":[],\"expressnetwork\":null,"
				+ "\"estimatedfee\":null,\"feenotes\":null,"
				+ "\"feenotesperson\":null,\"feenotestime\":null,"
				+ "\"operationnotes\":null,\"operationnotesperson\":null,"
				+ "\"operationnotestime\":null,\"returnsign\":null,"
				+ "\"returnperson\":null,\"returntime\":null,"
				+ "\"returnreason\":null,\"receivewarehouse\":null,"
				+ "\"status\":null,\"waybillcompleted\":null,"
				+ "\"inputname\":null,\"inputtime\":null,"
				+ "\"senderinformation\":[{\"sendername\":\"SHAN\","
				+ "\"senderchinesename\":\"STAR POWER TRADING CO LTD\","
				+ "\"sendercompany\":\"STAR POWER TRADING CO LTD\","
				+ "\"senderphone\":\"862163082079\",\"sendercountry\":\"CN\","
				+ "\"sendercity\":\"hangzhou\",\"sendertown\":\"\","
				+ "\"senderpostcode\":\"310000\",\"senderaddress\":\"NO 19 LANE 1058 ROOM 102 SHANGHAI\","
				+ "\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,"
				+ "\"senderproxycode\":null}],"
				+ "\"recipientinformation\":["
				+ "{\"recipientname\":\"MICK\","
				+ "\"recipientphone\":\"0039335731011\","
				+ // 07448817254
				"\"recipientcountry\":\"BE\","
				+ "\"recipientpostcode\":\"2440\","
				+ // KY11 8ST Buckshaw Village PR7 7DL GB 1 LNGHAM PLACE LANCS
				"\"recipientcity\":\"GEEL\","
				+ // STADTLOHN 48703 DE DUFKAMPSTRASSE 20
				"\"recipientstate\":\"VLAANDEREN\","
				+ "\"recipienttown\":\"\","
				+ "\"recipienthousenumber\":null,"
				+ "\"recipientaddress\":\"145 MOLSEWEG GEEL ANTWERPEN\","
				+ "\"recipientcompany\":\"TEST_JCEX\","
				+ "\"recipientemail\":\"TEST@qq.com\","
				+ "\"recipientdutyparagraph\":null}],"
				+ "\"invoiceinformation\":["
				+

				"{\"chinesename\":\"女士连衣裙\",\"englishname\":\"WOMEN'S CHIFFON DRESS\","
				+ "\"hscode\":\"\",\"inpieces\":\"1\",\"unitpriceamount\":\"3.00\","
				+ "\"declarationamount\":\"3.00\",\"declarationcurrency\":\"USD\","
				+ "\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,"
				+ "\"specificationmodel\":null}"
				+

				"],\"weightinformation\":["
				+ "{\"weightmethod\":null,\"totalpackages\":\"2\",\"itemtype\":\"袋子\","
				+ "\"totalweight\":\"0.50\",\"totalvolumeweight\":\"0.000\",\"totalchargeableweight\":\"0.500\"}],"
				+ "\"detailpackage\":["
				
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				+ "{\"actualweight\":\"1.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\", "
				+ "\"item\": ["
				+ "{\"englishname\": \"test11\","
				+ "\"hscode\": \"\", "
				+ "\"inpieces\": \"1\","
				+ "\"unitpriceamount\": \"350\","
				+ "\"unitpriceweight\": \"1\","
				+ "\"declarationamount\": \"3.5\","
				+ "\"declarationcurrency\": \"USD\"},"
				+ "{\"englishname\": \"test12\","
				+ "\"hscode\": \"\","
				+ "\"inpieces\": \"2\", "
				+ "\"unitpriceamount\": \"350\","
				+ "\"unitpriceweight\": \"1\","
				+ "\"declarationamount\": \"7\","
				+ "\"declarationcurrency\": \"USD\"}]},"
				+ "{\"actualweight\":\"1.00\",\"child_number\":\"test022\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\","
				+ "\"item\": ["
				+ "{\"englishname\": \"test21\","
				+ "\"hscode\": \"\", "
				+ "\"inpieces\": \"99\","
				+ "\"unitpriceamount\": \"200\","
				+ "\"unitpriceweight\": \"0.01\","
				+ "\"declarationamount\": \"50\","
				+ "\"declarationcurrency\": \"USD\"},"
				+ "{\"englishname\": \"test22\","
				+ "\"hscode\": \"\","
				+ "\"inpieces\": \"10\", "
				+ "\"unitpriceamount\": \"500\","
				+ "\"unitpriceweight\": \"0.1\","
				+ "\"declarationamount\": \"50\","
				+ "\"declarationcurrency\": \"USD\"}"
				+ "]}"
				+

				"],"
				+ "\"specialservice\":[{\"servicename\":null,\"costamount\":null,\"description\":null}]}]}}";

		String newjcex = "{\"Data\":{\"apiplatform\":\"pintaimingcheng7\",\"jcexkey\":\"NET\",\"customerid\":\"8DD39425-178E-44FA-8232-D254FAC16391\","
				+ "\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,\"waybillnumber\":\"test00011\","
				+ "\"referencenumber\":\"TESTML20170502\",\"transfernumber\":null,\"productid\":\"DPD\","
				+ "\"productname\":\"英国DPD\",\"servicetype\":null,\"pickupservice\":[],\"expressnetwork\":null,"
				+ "\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,\"feenotestime\":null,"
				+ "\"operationnotes\":null,\"operationnotesperson\":null,\"operationnotestime\":null,"
				+ "\"returnsign\":null,\"returnperson\":null,\"returntime\":null,\"returnreason\":null,"
				+ "\"receivewarehouse\":null,\"status\":null,\"waybillcompleted\":null,\"inputname\":null,"
				+ "\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"SHAN\","
				+ "\"senderchinesename\":\"STAR POWER TRADING CO LTD\",\"sendercompany\":\"STAR POWER TRADING CO LTD\","
				+ "\"senderphone\":\"862163082079\",\"sendercountry\":\"CN\",\"sendercity\":\"hangzhou\","
				+ "\"sendertown\":\"\",\"senderpostcode\":\"310000\",\"senderaddress\":\"NO 19 LANE 1058 ROOM 102 SHANGHAI\","
				+ "\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,\"senderproxycode\":null}],"
				+ "\"recipientinformation\":[{\"recipientname\":\"MICK\",\"recipientphone\":\"07448817254\","
				+ "\"recipientcountry\":\"GB\",\"recipientpostcode\":\"KY11 8ST\",\"recipientcity\":\"Dunfermline\","
				+ "\"recipientstate\":\"Chorley\",\"recipienttown\":\"\",\"recipienthousenumber\":null,"
				+ "\"recipientaddress\":\"UK FIFE DUNFERMLINE AMAZON FULFILMENT CENTRE  AMAZON WAY\","
				+ "\"recipientcompany\":\"TEST_JCEX\",\"recipientemail\":\"\",\"recipientdutyparagraph\":null}],"
				+ "\"invoiceinformation\":[{\"chinesename\":\"女士连衣裙\",\"englishname\":\"WOMEN\u0027S CHIFFON DRESS\","
				+ "\"hscode\":\"6204430010\",\"inpieces\":\"1\",\"unitpriceamount\":\"32.00\","
				+ "\"declarationamount\":\"23.00\",\"declarationcurrency\":\"\",\"materialquality\":null,"
				+ "\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null}],"
				+ "\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\","
				+ "\"itemtype\":\"袋子\",\"totalweight\":\"0.50\"}],"
				+ "\"detailpackage\":["
				+ "{\"actualweight\":\"1.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\", \"item\": [{\"englishname\": \"test11\",\"hscode\": \"3214568972\",\"inpieces\": \"1\",\"unitpriceamount\": \"350\",\"unitpriceweight\": \"1\",\"declarationamount\": \"3.5\",\"declarationcurrency\": \"USD\"},{\"englishname\": \"test12\",\"hscode\": \"15864215987\",\"inpieces\": \"2\", \"unitpriceamount\": \"350\",\"unitpriceweight\": \"1\",\"declarationamount\": \"7\",\"declarationcurrency\": \"USD\"}]},{\"actualweight\":\"1.00\",\"child_number\":\"test022\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\",\"item\": [{\"englishname\": \"test21\",\"hscode\": \"1234567890\", \"inpieces\": \"99\",\"unitpriceamount\": \"200\",\"unitpriceweight\": \"0.01\",\"declarationamount\": \"50\",\"declarationcurrency\": \"USD\"},{\"englishname\": \"test22\",\"hscode\": \"1234566541\",\"inpieces\": \"10\", \"unitpriceamount\": \"500\",\"unitpriceweight\": \"0.1\",\"declarationamount\": \"50\",\"declarationcurrency\": \"USD\"}]}],\"specialservice\":[{\"servicename\":null,\"costamount\":null,\"description\":null}]}]}}";

		String dianzifp = "{\"main\":[{\"groupFlag\":\"JCWL\",\"storeCode\":\"100\",\"posNo\":\"3855\",\"posDate\":\"20170920\",\"itemName\":\"国内派件费\",\"amountWithTax\":44.00,\"outerDiscountWithTax\":null,\"invoiceType\":\"CE\",\"miAccount\":null,\"saleCheckId\":null,\"remark\":null,\"cashierName\":\"\",\"checkerName\":\"\",\"invoicerName\":\"\",\"originInvoiceNo\":\"\",\"originInvoiceCode\":\"\",\"email\":\"\",\"details\":[{\"itemName\":\"国内派件费\",\"quantity\":1,\"unitPrice\":44.0000,\"outerDiscountTax\":null,\"volunCode\":\"3040409030000000000\",\"amountWithTax\":44.0000,\"taxRate\":6,\"itemCode\":\"006\",\"barCode\":\"JCTEST201708011\",\"taxPre\":\"0\",\"taxPreCon\":\"6%\"}]}],\"title\":[{\"name\":\"个人\",\"taxerId\":\"0\",\"bankName\":\"\",\"bankAccount\":\"0\",\"companyAddr\":\"\",\"companyPhone\":\"12345678901\"}],\"user\":[{\"mobilePhone\":\"\"}]}";
		String dianziback = "{\"sellerInvoiceMain\":{\"invoicerName\":\"张吉莉\",\"purchaserBankAccount\":\"\",\"sellerName\":\"航信培训企业\",\"sellerNo\":\"1014\",\"sellerAddress\":\"北京市徐汇区北纬路30号\",\"remark\":\"\",\"tenantCode\":\"Walmart\",\"purchaserAddress\":\"\",\"purchaserNo\":\"\",\"purchaserBankInfo\":\" \",\"sellerBankInfo\":\"中国工商银行(徐汇海淀支行营业部) 622298987689454\",\"sellerAddrTel\":\"北京市徐汇区北纬路30号 (010)83156339\",\"redNotificationNo\":\" \",\"invoiceType\":\"c\",\"sellerTel\":\"(010)83156339\",\"invoiceNo\":\"50623594\",\"cashierName\":\"万小平\",\"originInvoiceCode\":\"\",\"amountWithoutTax\":8.46,\"settlementNo\":\"20170823100526515IZH\",\"purchaserTel\":\"\",\"invoiceCode\":\"4400154620\",\"purchaserName\":\"个人\",\"purchaserBankName\":\"\",\"taxRate\":6,\"sellerTaxNo\":\"440002999999437\",\"purchaserTaxNo\":\"\",\"originInvoiceNo\":\"\",\"sellerBankAccount\":\"622298987689454\",\"purchaserAddrTel\":\"\",\"paperDrewDate\":\"20170820\",\"checkerName\":\"小米\",\"taxAmount\":0.51,\"amountWithTax\":8.97,\"sellerBankName\":\"中国工商银行(徐汇海淀支行营业部)\",\"status\":\"1\",\"pdfUrl\":\"null\"},\"sellerInvoiceDetails\":[{\"unitPrice\":0.943333333333333,\"amountWithoutTax\":8.49,\"itemSpec\":\"\",\"quantity\":9,\"goodsTaxNo\":\"1010101030000000000\",\"cargoCode\":\"\",\"settlementItemId\":\"20170823100526515IZH0000\",\"quantityUnit\":\"个.\",\"deductions\":0,\"taxRate\":6,\"cargoName\":\"糯玉米#\",\"taxAmount\":0.51,\"amountWithTax\":9},{\"unitPrice\":0,\"amountWithoutTax\":-0.03,\"itemSpec\":\"\",\"quantity\":0,\"goodsTaxNo\":\"1010101030000000000\",\"cargoCode\":\"\",\"settlementItemId\":\"\",\"quantityUnit\":\"\",\"deductions\":0,\"taxRate\":6,\"cargoName\":\"糯玉米#\",\"taxAmount\":0,\"amountWithTax\":-0.03}]}";

		// String hldata =
		// "{\"Data\":{\"netcompanyname\": \"JCGB(Y商业-FBA)-SHA\",\"packages\": [{\"paymentmethod\": \"PP\",\"branchoffice\": \"\",\"waybillnumber\": \"869930773\",\"referencenumber\": \"\",\"transfernumber\": \"\",\"productid\": \"\",\"productname\": \"\",\"servicetype\": \"\", \"pickupservice\": [{\"pickupaddress\": \"\",\"pickupcontacts\": \"\",\"pickupcontactnumber\": \"\",\"pickupstaff\": \"\",\"pickupamount\": \"\",\"operatingcost\": \"\",\"expresscompany\": \"JCEX\",\"expressnumber\": \"\",\"deliverypayment\": \"\",\"pickupRemark\": \"\", \"estimatedtimeofarrival\": \"\",\"receivewarehouseaddress\": \"\",\"receivewarehousecontact\": \"\",\"receivewarehousephone\": \"\"}],\"expressnetwork\": \"\",\"estimatedfee\": \"\",\"feenotes\": \"\",\"feenotesperson\": \"\",\"feenotestime\": \"\",\"operationnotes\": \"\",\"operationnotesperson\": \"\", \"operationnotestime\": \"\",\"returnsign\": \"\",\"returnperson\": \"\",\"returntime\": \"\",\"returnreason\": "", \"receivewarehouse\": \"\",\"status\": \"\",\"waybillcompleted\": \"\",\"inputname\": \"\",\"inputtime\": \"2017-06-06 17:42:47\",\"senderinformation\": [{\"sendername\": \"sun ma\",\"senderchinesename\": \"上海辰德网络科技有限公司\",\"sendercompany\": \"\",\"senderphone\": \"13764247540\",\"sendercountry\": \"CN\","sendercity": "","sendertown": "","senderpostcode": "","senderaddress": "NO
		// 1225 TONGPU ROAD
		// SHANGHAI","sendercustomsregistrationcode": "","sendercustomsoperatingunits": "","senderproxycode": "" }],"recipientinformation": [{"recipientname": "AMAZON","recipientphone": "08444444","recipientcountry": "GB","recipientpostcode": "KY118ST","recipientcity": "Dunfermline","recipientstate": "Scotland","recipienttown": "Dunfermline","recipienthousenumber": "","recipientaddress": "UK
		// FIFE DUNFERMLINE AMAZON FULFILMENT CENTRE AMAZON WAY
		// ","recipientcompany": "AMAZON","recipientdutyparagraph": ""}],"invoiceinformation": [{"chinesename": "杠铃塑料卡扣/不锈钢理发工具/
		// 鱼缸磁力刷","englishname": "BARBELL PLASTIC BUCKLE/STAINLESS STEEL HAIR
		// TOOL/FISH CYLINDER MAGNETIC
		// BRUSH","hscode": "3926909090","inpieces": "114","unitpriceamount": "1.5","declarationamount": \"171\", \"declarationcurrency\": \"\",\"materialquality\": \"\",\"purpose\": \"\",\"measurementunit\": \"\",\"specificationmodel\": \"\"}],\"weightinformation\": [{\"weightmethod\": \"\",\"totalpackages\": \"5\",\"itemtype\": \"\",\"totalweight\": \"114.3\",\"totalvolumeweight\": \"66.76\",\"totalchargeableweight\": \"114.3\"}],   \"detailpackage\": [                                  {                                \"actualweight\": \"22.86\",\"volumeweight\": \"16.10\",\"length\": \"60\",\"width\": \"46\",\"height\": \"35\",\"volume\": \"96600\"}, {                                \"actualweight\": \"22.86\",\"volumeweight\": \"21.16\",\"length\": \"60\",\"width\": \"46\",\"height\": \"46\",\"volume\": \"126960\"}, {                                \"actualweight\": \"22.86\",\"volumeweight\": \"11.00\",\"length\": \"55\",\"width\": \"40\",\"height\": \"30\",\"volume\": \"66000\"}, {                                \"actualweight\": \"22.86\",\"volumeweight\": \"11.00\",\"length\": \"55\",\"width\": \"40\",\"height\": \"30\",\"volume\": \"66000\"}, {                                \"actualweight\": \"22.86\",\"volumeweight\": \"7.50\",\"length\": \"30\",\"width\": \"30\",\"height\": \"50\",\"volume\": \"45000\"}    ],                                \"specialservice\": [{\"servicename\": \"\",\"costamount\": \"\",\"costcurrency\": \"\",\"description\": null}]}]}}";

		String hlwarp = "{\"Data\":{\"netcompanyname\":\"JCNLUPDATEANDWARP\",\"packages\":[{\"shipment_client_reference\":\"580-13248561\",\"waybillnumber\":[5206079753,5367022579,5396704979,5394958232,5206079766,984498826,3889219460,3889219191,3889219471,5396704971,\"TCDPDHK0030314\",980990651,2688008290,\"KYFBAEUD0030178\",8179185399,2688064738,981243480,\"FBA11XBPQM002\",\"FBA11XBJSD002\",\"FBA11WQS2T\",\"FBA11X5FQ2\",\"FBA11X4S22\",168098335,168098302,168098372,\"FBA0190000100\",\"FBA11XBPQM003\"]}]}}";

		String alitrackjson = "{\"cpCode\":\"xxx\",\"mailNo\":\"2007368445\"}";
		String alitrackxml = "<request><cpCode>xxx</cpCode><mailNo>2007368445</mailNo></request>";

		String eguoru = "{\"Data\":{\"netcompanyname\":\"SINESPM(LAX)\","
				+ "\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,"
				+ "\"waybillnumber\":\"TEST36\",\"referencenumber\":\"\","
				+ "\"transfernumber\":null,\"productid\":null,\"productname\":null,"
				+ "\"servicetype\":null,\"pickupservice\":null,\"expressnetwork\":null,"
				+ "\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,"
				+ "\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,"
				+ "\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,"
				+ "\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,"
				+ "\"status\":null,\"waybillcompleted\":null,\"inputname\":null,"
				+ "\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"ALEX GAO\","
				+ "\"senderchinesename\":\"ZHONGHANG RD.\",\"sendercompany\":\"ZHONGHANG RD.\","
				+ "\"senderphone\":\"13686871955\",\"sendercountry\":\"CN\",\"sendercity\":\"\","
				+ "\"sendertown\":\"\",\"senderpostcode\":\"\",\"senderaddress\":\"FU TIAN DISTRICT,SHENZHEN DUHUI100 BUILDING B 23S ROOM SHENZHEN CHINA.PEOPLES\u0027S REPUBLIC\","
				+ "\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,"
				+ "\"senderproxycode\":null}],"
				+ "\"recipientinformation\":["
				+ "{\"recipientname\": \"Maxine Lam\","
				+ "\"recipientphone\": \"1-949-4139959\","
				+ "\"recipientcountry\":\"US\"," 
				+ "\"recipientpostcode\":\"72166\"," 
				+ "\"recipientcity\":\"as\"," 
				+ "\"recipientstate\":\"bz\"," 
				+ "\"recipienttown\": \"\", "
				+ "\"recipienthousenumber\":\"\","
				+ "\"recipientaddress\":\"107 W San Bernardino Rd\","
				+ "\"recipientcompany\":\"PANTOS LOGISTICS SINGAPORE PTE LTD\","
				+ "\"recipientdutyparagraph\":null}],"
				+ "\"invoiceinformation\":["
				// + "{\"chinesename\":\"测试\","
				// + "\"englishname\":\"testPM\","
				// + "\"hscode\":\"\","
				// + "\"inpieces\":\"4\","
				// + "\"unitpriceamount\":\"12.00\","
				// + "\"declarationamount\":\"12.00\","
				// + "\"declarationcurrency\":\"USD\","
				// + "\"materialquality\":null,"
				// + "\"purpose\":null,"
				// + "\"measurementunit\":null,"
				// + "\"specificationmodel\":null},"
				// + "{\"chinesename\":\"111\","
				// + "\"englishname\":\"ttxc\","
				// + "\"hscode\":\"23\","
				// + "\"inpieces\":\"100\","
				// + "\"unitpriceamount\":\"23.00\","
				// + "\"declarationamount\":\"2.00\","
				// + "\"declarationcurrency\":\"USD\","
				// + "\"materialquality\":null,"
				// + "\"purpose\":null,"
				// + "\"measurementunit\":null,"
				// + "\"specificationmodel\":null},"
				// + "{\"chinesename\":\"快很快就结婚\","
				// + "\"englishname\":\"TRRE\","
				// + "\"hscode\":\"kjjggfdd\","
				// + "\"inpieces\":\"6\","
				// + "\"unitpriceamount\":\"45.00\","
				// + "\"declarationamount\":\"45.00\","
				// + "\"declarationcurrency\":\"USD\","
				// + "\"materialquality\":null,"
				// + "\"purpose\":null,"
				// + "\"measurementunit\":null,"
				// + "\"specificationmodel\":null},"
				+ "{\"chinesename\":\"测试\","
				+ "\"englishname\":\"LADY SHOES\","
				+ "\"hscode\":\"\","
				+ "\"inpieces\":\"1\","
				+ "\"unitpriceamount\":\"2.00\","
				+ "\"declarationamount\":\"2.00\","
				+ "\"declarationcurrency\":\"USD\","
				+ "\"materialquality\":null,"
				+ "\"purpose\":null,"
				+ "\"measurementunit\":null,"
				+ "\"specificationmodel\":null}],"
				+ "\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\",\"itemtype\":\"PAK袋\","
				+ "\"totalweight\":\"10\",\"totalvolumeweight\":\"0.200\",\"totalchargeableweight\":\"5.000\"}],"
				+ "\"detailpackage\":["
				+
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"1.00\",\"child_number\":\"test011\",\"length\":\"10\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\", "
				// +
				// "\"item\": [" +
				// "{\"englishname\": \"test11\"," +
				// "\"hscode\": \"3214568972\", " +
				// "\"inpieces\": \"1\"," +
				// "\"unitpriceamount\": \"350\"," +
				// "\"unitpriceweight\": \"1\"," +
				// "\"declarationamount\": \"3.5\"," +
				// "\"declarationcurrency\": \"USD\"}," +
				// "{\"englishname\": \"test12\"," +
				// "\"hscode\": \"15864215987\"," +
				// "\"inpieces\": \"2\", " +
				// "\"unitpriceamount\": \"350\"," +
				// "\"unitpriceweight\": \"1\"," +
				// "\"declarationamount\": \"7\"," +
				// "\"declarationcurrency\": \"USD\"}]}," +
				"{\"actualweight\":\"10.00\",\"child_number\":\"1\",\"length\":\"10.0\",\"width\":\"2.00\",\"height\":\"10.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\","
				+ "\"item\": ["
				+ "{\"englishname\": \"test21\","
				+ "\"hscode\": \"1234567890\", "
				+ "\"inpieces\": \"4\","
				+ "\"unitpriceamount\": \"25\","
				+ "\"unitpriceweight\": \"\","
				+ "\"declarationamount\": \"50\","
				+ "\"declarationcurrency\": \"USD\"},"
				+ "{\"englishname\": \"test22\","
				+ "\"hscode\": \"1234566541\","
				+ "\"inpieces\": \"10\", "
				+ "\"unitpriceamount\": \"500\","
				+ "\"unitpriceweight\": \"0.1\","
				+ "\"declarationamount\": \"50\","
				+ "\"declarationcurrency\": \"USD\"}"
				+ "]}"
				+

				"],"
				+ "\"specialservice\":[{\"servicename\":null,\"costamount\":null,\"description\":null}]}]}}";
        
		
//		String BONDED = "{\"Data\":{\"netcompanyname\":\"GFSAPI\","
//				+ "\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,"
//				+ "\"waybillnumber\":\""+testid+"\",\"referencenumber\":\"\","
//				+ "\"transfernumber\":null,\"productid\":null,\"productname\":null,"
//				+ "\"servicetype\":null,\"pickupservice\":null,\"expressnetwork\":null,"
//				+ "\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,"
//				+ "\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,"
//				+ "\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,"
//				+ "\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,"
//				+ "\"status\":null,\"waybillcompleted\":null,\"inputname\":null,"
//				+ "\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"ALEX GAO\","
//				+ "\"senderchinesename\":\"ZHONGHANG RD.\",\"sendercompany\":\"ZHONGHANG RD.\","
//				+ "\"senderphone\":\"13686871955\",\"sendercountry\":\"CN\",\"sendercity\":\"\","
//				+ "\"sendertown\":\"\",\"senderpostcode\":\"\",\"senderaddress\":\"FU TIAN DISTRICT,SHENZHEN DUHUI100 BUILDING B 23S ROOM SHENZHEN CHINA.PEOPLES\u0027S REPUBLIC\","
//				+ "\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,"
//				+ "\"senderproxycode\":null}],"
//				+ "\"recipientinformation\":["
//				+ "{\"recipientname\":\"Emmanuel Macron\","
//				+ "\"recipientphone\":\"072545862623\","
//				+ // 07448817254
//				"\"recipientcountry\":\"DE\","
//				+ "\"recipientpostcode\":\""+postcode+"\","// 2440
//				+ // KY11 8ST Buckshaw Village PR7 7DL GB 1 LNGHAM PLACE LANCS
//				"\"recipientcity\":\""+city+"\","
//				+ // STADTLOHN 48703 DE DUFKAMPSTRASSE 20
//				"\"recipientstate\":\"\","
//				+ "\"recipienttown\":\"\","
//				+ "\"recipienthousenumber\":\"\","
//				+ "\"recipientaddress\":\""+address+"\","
//				+ "\"recipientcompany\":\"TEST_JCEX\","
//				+ "\"recipientemail\":\"\","
//				+ "\"recipientdutyparagraph\":null}],"
//				+ "\"invoiceinformation\":["
//				// + "{\"chinesename\":\"测试\","
//				// + "\"englishname\":\"testPM\","
//				// + "\"hscode\":\"\","
//				// + "\"inpieces\":\"4\","
//				// + "\"unitpriceamount\":\"12.00\","
//				// + "\"declarationamount\":\"12.00\","
//				// + "\"declarationcurrency\":\"USD\","
//				// + "\"materialquality\":null,"
//				// + "\"purpose\":null,"
//				// + "\"measurementunit\":null,"
//				// + "\"specificationmodel\":null},"
////				+ "{\"chinesename\":\"111\","
////				+ "\"englishname\":\"ttxc\","
////				+ "\"hscode\":\"\","
////				+ "\"inpieces\":\"100\","
////				+ "\"unitpriceamount\":\"23.00\","
////				+ "\"declarationamount\":\"2.00\","
////				+ "\"declarationcurrency\":\"USD\","
////				+ "\"materialquality\":null,"
////				+ "\"purpose\":null,"
////				+ "\"measurementunit\":null,"
////				+ "\"specificationmodel\":null},"
////				+ "{\"chinesename\":\"快很快就结婚\","
////				+ "\"englishname\":\"TRRE\","
////				+ "\"hscode\":\"\","
////				+ "\"inpieces\":\"6\","
////				+ "\"unitpriceamount\":\"45.00\","
////				+ "\"declarationamount\":\"15.00\","
////				+ "\"declarationcurrency\":\"USD\","
////				+ "\"materialquality\":null,"
////				+ "\"purpose\":null,"
////				+ "\"measurementunit\":null,"
////				+ "\"specificationmodel\":null},"
//				+ "{\"chinesename\":\"测试\","
//				+ "\"englishname\":\"LADY SHOES\","
//				+ "\"hscode\":\"\","
//				+ "\"inpieces\":\"1\","
//				+ "\"unitpriceamount\":\"2.00\","
//				+ "\"declarationamount\":\"2.00\","
//				+ "\"declarationcurrency\":\"USD\","
//				+ "\"materialquality\":null,"
//				+ "\"purpose\":null,"
//				+ "\"measurementunit\":null,"
//				+ "\"specificationmodel\":null}],"
//				+ "\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\",\"itemtype\":\"PAK袋\","
//				+ "\"totalweight\":\"1.6\",\"totalvolumeweight\":\"0.200\",\"totalchargeableweight\":\"5.000\"}],"
//				+ "\"detailpackage\":["
//				
//				// "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
//				// +
//				// "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
//				// +
//				// "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
//				// +
//				// "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
//				// +
//				// "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
//				// +
//				// "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
//				// +
//				// "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
//				// +
////				+ "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
//				+ "{\"actualweight\":\"1.60\",\"child_number\":\"test011\",\"length\":\"10\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\", "
//				+ "\"item\": ["
////				+ "{\"englishname\": \"test11\","
////				+ "\"hscode\": \"3214568972\", "
////				+ "\"inpieces\": \"1\","
////				+ "\"unitpriceamount\": \"350\","
////				+ "\"unitpriceweight\": \"1\","
////				+ "\"declarationamount\": \"3.5\","
////				+ "\"declarationcurrency\": \"USD\"},"
//				+ "{\"englishname\": \"test12\","
//				+ "\"hscode\": \"15864215987\","
//				+ "\"inpieces\": \"2\", "
//				+ "\"unitpriceamount\": \"350\","
//				+ "\"unitpriceweight\": \"1\","
//				+ "\"declarationamount\": \"7\","
//				+ "\"declarationcurrency\": \"USD\"}" 
//				+ "]},"
////				+ "{\"actualweight\":\"10.00\",\"child_number\":\"1\",\"length\":\"10.0\",\"width\":\"2.00\",\"height\":\"10.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\","
////				+ "\"item\": ["
////				+ "{\"englishname\": \"test21\","
////				+ "\"hscode\": \"1234567890\", "
////				+ "\"inpieces\": \"4\","
////				+ "\"unitpriceamount\": \"25\","
////				+ "\"unitpriceweight\": \"\","
////				+ "\"declarationamount\": \"50\","
////				+ "\"declarationcurrency\": \"EUR\"},"
////				+ "{\"englishname\": \"test22\","
////				+ "\"hscode\": \"1234566541\","
////				+ "\"inpieces\": \"10\", "
////				+ "\"unitpriceamount\": \"500\","
////				+ "\"unitpriceweight\": \"0.1\","
////				+ "\"declarationamount\": \"50\","
////				+ "\"declarationcurrency\": \"USD\"}"
////				+ "]}"
//				+ "],"
//				+ "\"specialservice\":[{\"servicename\":null,\"costamount\":null,\"description\":null}]}]}}";

		String testgb = "{\"Data\":{\"netcompanyname\":\"GBDHL\",\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,\"waybillnumber\":\"130107091810\",\"referencenumber\":\"130107091810\",\"transfernumber\":null,\"productid\":null,\"productname\":null,\"servicetype\":null,\"pickupservice\":[],\"expressnetwork\":null,\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,\"status\":null,\"waybillcompleted\":null,\"inputname\":null,\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"JCEX\",\"senderchinesename\":\"JCEX COMPANY\",\"sendercompany\":\"JCEX COMPANY\",\"senderphone\":\"88267860\",\"sendercountry\":\"CN\",\"sendercity\":\"NINGBO\",\"sendertown\":\"\",\"senderpostcode\":\"\",\"senderaddress\":\"NANFAN ROAD\",\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,\"senderproxycode\":null,\"senderemail\":\"\"}],\"recipientinformation\":[{\"recipientname\":\"asdfasf\",\"recipientphone\":\"asfasf\",\"recipientcountry\":\"GB\",\"recipientpostcode\":\"afasf\",\"recipientcity\":\"adfasdf\",\"recipientstate\":\"\",\"recipienttown\":null,\"recipienthousenumber\":null,\"recipientaddress\":\"asfasf\",\"recipientcompany\":\"asfasfasf\",\"recipientdutyparagraph\":null,\"recipientemail\":\"\"}],\"invoiceinformation\":[{\"chinesename\":\"文件\",\"englishname\":\"DOC\",\"hscode\":\"000\",\"inpieces\":\"1\",\"unitpriceamount\":\"1.00\",\"declarationamount\":\"1.00\",\"declarationcurrency\":\"USD\",\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null,\"invoice_weight\":null}],\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\",\"itemtype\":\"纸箱\",\"totalweight\":\"1.000\",\"totalvolumeweight\":\"0\",\"totalchargeableweight\":\"0\"}],\"detailpackage\":[{\"actualweight\":\"0\",\"length\":\"0\",\"width\":\"0\",\"height\":\"0\",\"volume\":\"0\",\"volumeweight\":0,\"child_number\":null,\"goodsname\":null,\"trackno\":null,\"item\":null}],\"specialservice\":[{\"servicename\":null,\"costamount\":null,\"description\":null}]}]}}";
		// String url = "http://api.jcex.com/ALiJcex/api/ali/back";
		// String data_body ="";

		// String data_body = XMLToString.test5();
		// System.out.println(data_body);
		// String eStr = URLEncoder.encode(data_body, "utf-8");

		String zdhcx = "{ \"customerid\": \"8DD39425-178E-44FA-8232-D254FAC16391\",\"waybillnumber\": \"78177111222\" }";

		String jcexjson = "{\"customerid\":\"-1\",\"waybillnumber\":\"TEST20170831002M\",\"isdisplaydetail\":\"false\"}";

		String jst1 = "{\"Data\":{\"customerid\":\"8DD39425-178E-44FA-8232-D254FAC16391\",\"packages\":[{\"paymentmethod\":\"\",\"branchoffice\":\"\",\"waybillnumber\":\"\",\"referencenumber\":\"SERV_4012\",\"networkname\":\"华北-佳成专线\",\"transfernumber\":\"\",\"productid\":\"\",\"productname\":\"华北-佳成专线\",\"servicetype\":\"\",\"pickupservice\":[{\"pickupaddress\":\"\",\"pickupcontacts\":\"\",\"pickupcontactnumber\":\"\",\"pickupstaff\":\"\",\"pickupamount\":\"\",\"operatingcost\":\"\",\"expresscompany\":\"\",\"expressnumber\":\"\",\"deliverypayment\":\"\",\"pickupRemark\":\"\",\"estimatedtimeofarrival\":\"\",\"receivewarehouseaddress\":\"\",\"receivewarehousecontact\":\"\",\"receivewarehousephone\":\"\"}],\"expressnetwork\":\"\",\"estimatedfee\":\"\",\"feenotes\":\"\",\"feenotesperson\":\"\",\"feenotestime\":\"\",\"operationnotes\":\"\",\"operationnotesperson\":\"\",\"operationnotestime\":\"\",\"returnsign\":\"\",\"returnperson\":\"\",\"returntime\":\"\",\"returnreason\":\"\",\"receivewarehouse\":\"\",\"status\":\"\",\"waybillcompleted\":\"\",\"inputname\":\"\",\"inputtime\":\"\",\"senderinformation\":[{\"sendername\":\"\",\"senderchinesename\":\"\",\"sendercompany\":\"\",\"senderphone\":\"\",\"sendercountry\":\"\",\"sendercity\":\"\",\"sendertown\":\"\",\"senderpostcode\":\"\",\"senderaddress\":\"\",\"sendercustomsregistrationcode\":\"\",\"sendercustomsoperatingunits\":\"\",\"senderproxycode\":\"\"}],\"recipientinformation\":[{\"recipientname\":\"AMEEN ZUBIR KASIM\",\"recipientphone\":\"0176077723\",\"recipientcountry\":\"MY\",\"recipientpostcode\":\"56000\",\"recipientcity\":\"bandar tun razak\",\"recipientstate\":\"Kuala Lumpur\",\"recipienttown\":\"\",\"recipienthousenumber\":\"\",\"recipientaddress\":\"16 lorong mewah 14,, \",\"recipientcompany\":\"\",\"recipientdutyparagraph\":\"\"}],\"invoiceinformation\":[{\"chinesename\":\"礼品纸袋子\",\"englishname\":\"gift paper bags \",\"hscode\":\"\",\"inpieces\":\"2000\",\"unitpriceamount\":\"0.01\",\"declarationamount\":\"28.36\",\"declarationcurrency\":\"USD\",\"materialquality\":\"\",\"purpose\":\"\",\"measurementunit\":\"\",\"specificationmodel\":\"\"}],\"weightinformation\":[{\"weightmethod\":\"\",\"totalpackages\":\"1\",\"itemtype\":\"2\",\"totalweight\":\"10\",\"totalvolumeweight\":\"10\",\"totalchargeableweight\":\"10\"}],\"detailpackage\":[{\"actualweight\":\"\",\"length\":\"\",\"width\":\"\",\"height\":\"\",\"volume\":\"\",\"volumeweight\":\"\"}],\"specialservice\":[{\"servicename\":\"\",\"costamount\":\"\",\"description\":\"\"}]},{\"paymentmethod\":\"\",\"branchoffice\":\"\",\"waybillnumber\":\"\",\"referencenumber\":\"SERV_4012\",\"networkname\":\"华北-佳成专线\",\"transfernumber\":\"\",\"productid\":\"\",\"productname\":\"华北-佳成专线\",\"servicetype\":\"\",\"pickupservice\":[{\"pickupaddress\":\"\",\"pickupcontacts\":\"\",\"pickupcontactnumber\":\"\",\"pickupstaff\":\"\",\"pickupamount\":\"\",\"operatingcost\":\"\",\"expresscompany\":\"\",\"expressnumber\":\"\",\"deliverypayment\":\"\",\"pickupRemark\":\"\",\"estimatedtimeofarrival\":\"\",\"receivewarehouseaddress\":\"\",\"receivewarehousecontact\":\"\",\"receivewarehousephone\":\"\"}],\"expressnetwork\":\"\",\"estimatedfee\":\"\",\"feenotes\":\"\",\"feenotesperson\":\"\",\"feenotestime\":\"\",\"operationnotes\":\"\",\"operationnotesperson\":\"\",\"operationnotestime\":\"\",\"returnsign\":\"\",\"returnperson\":\"\",\"returntime\":\"\",\"returnreason\":\"\",\"receivewarehouse\":\"\",\"status\":\"\",\"waybillcompleted\":\"\",\"inputname\":\"\",\"inputtime\":\"\",\"senderinformation\":[{\"sendername\":\"\",\"senderchinesename\":\"\",\"sendercompany\":\"\",\"senderphone\":\"\",\"sendercountry\":\"\",\"sendercity\":\"\",\"sendertown\":\"\",\"senderpostcode\":\"\",\"senderaddress\":\"\",\"sendercustomsregistrationcode\":\"\",\"sendercustomsoperatingunits\":\"\",\"senderproxycode\":\"\"}],\"recipientinformation\":[{\"recipientname\":\"AMEEN ZUBIR KASIM\",\"recipientphone\":\"0176077723\",\"recipientcountry\":\"MY\",\"recipientpostcode\":\"56000\",\"recipientcity\":\"bandar tun razak\",\"recipientstate\":\"Kuala Lumpur\",\"recipienttown\":\"\",\"recipienthousenumber\":\"\",\"recipientaddress\":\"16 lorong mewah 14,, \",\"recipientcompany\":\"\",\"recipientdutyparagraph\":\"\"}],\"invoiceinformation\":[{\"chinesename\":\"礼品纸袋子\",\"englishname\":\"gift paper bags \",\"hscode\":\"\",\"inpieces\":\"2000\",\"unitpriceamount\":\"0.01\",\"declarationamount\":\"28.36\",\"declarationcurrency\":\"USD\",\"materialquality\":\"\",\"purpose\":\"\",\"measurementunit\":\"\",\"specificationmodel\":\"\"}],\"weightinformation\":[{\"weightmethod\":\"\",\"totalpackages\":\"1\",\"itemtype\":\"2\",\"totalweight\":\"10\",\"totalvolumeweight\":\"10\",\"totalchargeableweight\":\"10\"}],\"detailpackage\":[{\"actualweight\":\"\",\"length\":\"\",\"width\":\"\",\"height\":\"\",\"volume\":\"\",\"volumeweight\":\"\"}],\"specialservice\":[{\"servicename\":\"\",\"costamount\":\"\",\"description\":\"\"}]}]}}";

		String aramex = "{\"Data\":{\"netcompanyname\":\"MYARAMEX\",\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,\"waybillnumber\":\"117607092122\",\"referencenumber\":\"117607092122\",\"transfernumber\":null,\"productid\":null,\"productname\":null,\"servicetype\":null,\"pickupservice\":[],\"expressnetwork\":null,\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,\"status\":null,\"waybillcompleted\":null,\"inputname\":null,\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"Nancy\",\"senderchinesename\":\"Nancy\",\"sendercompany\":\"Nancy\",\"senderphone\":\"15906563026\",\"sendercountry\":\"CN\",\"sendercity\":\"linbo\",\"sendertown\":\"\",\"senderpostcode\":\"315100\",\"senderaddress\":\"test\",\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,\"senderproxycode\":null,\"senderemail\":\"\"}],\"recipientinformation\":[{\"recipientname\":\"Peter \",\"recipientphone\":\"64 21 959 958\",\"recipientcountry\":\"NZ\",\"recipientpostcode\":\"1746\",\"recipientcity\":\"Auckland\",\"recipientstate\":\"\",\"recipienttown\":null,\"recipienthousenumber\":null,\"recipientaddress\":\"22 Honan Place, Avondale, Auckland, 1746,New Zealand  \",\"recipientcompany\":\"Maclon Industries NZ Ltd \",\"recipientdutyparagraph\":null,\"recipientemail\":\"peters@maclon.co.nz\"}],\"invoiceinformation\":[{\"chinesename\":\"文件\",\"englishname\":\"document\",\"hscode\":\"0\",\"inpieces\":\"1\",\"unitpriceamount\":\"1.00\",\"declarationamount\":\"1.00\",\"declarationcurrency\":\"USD\",\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null,\"invoice_weight\":\"0\"}],\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\",\"itemtype\":\"PAC袋\",\"totalweight\":\"0.500\",\"totalvolumeweight\":\"0\",\"totalchargeableweight\":\"0\"}],\"detailpackage\":[{\"actualweight\":\"0.5\",\"length\":\"0\",\"width\":\"0\",\"height\":\"0\",\"volume\":\"0\",\"volumeweight\":\"0\",\"child_number\":\"\",\"goodsname\":\"\",\"trackno\":\"\",\"item\":null}],\"specialservice\":[{\"servicename\":null,\"costamount\":null,\"description\":null}]}]}}";

		String dhl = "{\"Data\":{\"netcompanyname\":\"SAMDHL\",\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,\"waybillnumber\":\"6880627513\",\"referencenumber\":\"6880627513\",\"transfernumber\":null,\"productid\":null,\"productname\":null,\"servicetype\":null,\"pickupservice\":[],\"expressnetwork\":null,\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,\"status\":null,\"waybillcompleted\":null,\"inputname\":null,\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"BEJING BAIDE RUBBER PLASTIC PRODUCTS CO LTD\",\"senderchinesename\":\"BEJING BAIDE RUBBER PLASTIC PRODUCTS CO LTD\",\"sendercompany\":\"BEJING BAIDE RUBBER PLASTIC PRODUCTS CO LTD\",\"senderphone\":\"111111\",\"sendercountry\":\"CN\",\"sendercity\":\"BEJING\",\"sendertown\":\"\",\"senderpostcode\":\"100176\",\"senderaddress\":\"ROOM 602 BUILDING 1 NO 19 OFRONGHUA SOUTH ROAD BDA\",\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,\"senderproxycode\":null,\"senderemail\":\"\"}],\"recipientinformation\":[{\"recipientname\":\"KANG ZHENG\",\"recipientphone\":\"07404474796\",\"recipientcountry\":\"BH\",\"recipientpostcode\":\"71000\",\"recipientcity\":\"LONDON\",\"recipientstate\":\"LONDON\",\"recipienttown\":\"\",\"recipienthousenumber\":null,\"recipientaddress\":\"ROOM 1710 24 OLD JAMAICA RD BERMONDSEY\",\"recipientcompany\":\"KANG ZHENG\",\"recipientdutyparagraph\":null,\"recipientemail\":\"\"}],\"invoiceinformation\":[{\"chinesename\":\"包装盒\",\"englishname\":\"PACKINGBOX\",\"hscode\":\"\",\"inpieces\":\"8000\",\"unitpriceamount\":\"0.10\",\"declarationamount\":\"800.00\",\"declarationcurrency\":\"USD\",\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null,\"invoice_weight\":\"17.800\"}],\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"3\",\"itemtype\":\"ֽФ\",\"totalweight\":\"55.400\",\"totalvolumeweight\":\"22.032\",\"totalchargeableweight\":\"56.000\"}],\"detailpackage\":[{\"actualweight\":\"17.800\",\"length\":\"24.0\",\"width\":\"34.0\",\"height\":\"54.0\",\"volume\":\"44064.000\",\"volumeweight\":\"7.344\",\"child_number\":\"6880627513-001\",\"goodsname\":\"\",\"trackno\":\"\",\"item\":[{\"englishname\":\"PACKINGBOX\",\"hscode\":\"\",\"inpieces\":\"8000\",\"unitpriceamount\":\"0.100000\",\"unitpriceweight\":\"17.800\",\"declarationamount\":\"800.00\",\"declarationcurrency\":\"USD\"}]},{\"actualweight\":\"19.150\",\"length\":\"24.0\",\"width\":\"34.0\",\"height\":\"54.0\",\"volume\":\"44064.000\",\"volumeweight\":\"7.344\",\"child_number\":\"6880627513-002\",\"goodsname\":\"\",\"trackno\":\"\",\"item\":[]},{\"actualweight\":\"18.450\",\"length\":\"24.0\",\"width\":\"34.0\",\"height\":\"54.0\",\"volume\":\"44064.000\",\"volumeweight\":\"7.344\",\"child_number\":\"6880627513-003\",\"goodsname\":\"\",\"trackno\":\"\",\"item\":[]}],\"specialservice\":[{\"servicename\":null,\"costamount\":\"\",\"description\":null}]}]}}";

		String HL = "{\"Data\":{\"netcompanyname\":\"HL\",\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,\"waybillnumber\":\"6880627513\",\"referencenumber\":\"6880627513\",\"transfernumber\":null,\"productid\":null,\"productname\":null,\"servicetype\":null,\"pickupservice\":[],\"expressnetwork\":null,\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,\"status\":null,\"waybillcompleted\":null,\"inputname\":null,\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"BEJING BAIDE RUBBER PLASTIC PRODUCTS CO LTD\",\"senderchinesename\":\"BEJING BAIDE RUBBER PLASTIC PRODUCTS CO LTD\",\"sendercompany\":\"BEJING BAIDE RUBBER PLASTIC PRODUCTS CO LTD\",\"senderphone\":\"111111\",\"sendercountry\":\"CN\",\"sendercity\":\"BEJING\",\"sendertown\":\"\",\"senderpostcode\":\"100176\",\"senderaddress\":\"ROOM 602 BUILDING 1 NO 19 OFRONGHUA SOUTH ROAD BDA\",\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,\"senderproxycode\":null,\"senderemail\":\"\"}],\"recipientinformation\":[{\"recipientname\":\"KANG ZHENG\",\"recipientphone\":\"07404474796\",\"recipientcountry\":\"CN\",\"recipientpostcode\":\"210016\",\"recipientcity\":\"NJ\",\"recipientstate\":\"NJ\",\"recipienttown\":\"\",\"recipienthousenumber\":null,\"recipientaddress\":\"南京日报社\",\"recipientcompany\":\"KANG ZHENG\",\"recipientdutyparagraph\":null,\"recipientemail\":\"\"}],\"invoiceinformation\":[{\"chinesename\":\"包装盒\",\"englishname\":\"PACKINGBOX\",\"hscode\":\"\",\"inpieces\":\"8000\",\"unitpriceamount\":\"0.10\",\"declarationamount\":\"800.00\",\"declarationcurrency\":\"USD\",\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null,\"invoice_weight\":\"17.800\"}],\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"3\",\"itemtype\":\"ֽФ\",\"totalweight\":\"55.400\",\"totalvolumeweight\":\"22.032\",\"totalchargeableweight\":\"56.000\"}],\"detailpackage\":[{\"actualweight\":\"17.800\",\"length\":\"24.0\",\"width\":\"34.0\",\"height\":\"54.0\",\"volume\":\"44064.000\",\"volumeweight\":\"7.344\",\"child_number\":\"6880627513-001\",\"goodsname\":\"\",\"trackno\":\"\",\"item\":[{\"englishname\":\"PACKINGBOX\",\"hscode\":\"\",\"inpieces\":\"8000\",\"unitpriceamount\":\"0.100000\",\"unitpriceweight\":\"17.800\",\"declarationamount\":\"800.00\",\"declarationcurrency\":\"USD\"}]},{\"actualweight\":\"19.150\",\"length\":\"24.0\",\"width\":\"34.0\",\"height\":\"54.0\",\"volume\":\"44064.000\",\"volumeweight\":\"7.344\",\"child_number\":\"6880627513-002\",\"goodsname\":\"\",\"trackno\":\"\",\"item\":[]},{\"actualweight\":\"18.450\",\"length\":\"24.0\",\"width\":\"34.0\",\"height\":\"54.0\",\"volume\":\"44064.000\",\"volumeweight\":\"7.344\",\"child_number\":\"6880627513-003\",\"goodsname\":\"\",\"trackno\":\"\",\"item\":[]}],\"specialservice\":[{\"servicename\":null,\"costamount\":\"\",\"description\":null}]}]}}";
		
		String mabangtest = "{\"Data\":{\"apiplatform\":\"平台名称\",\"jcexkey\":\"NET2\",\"customerid\":\"8DD39425-178E-44FA-8232-D254FAC16391\",\"customer\":\"ZYW0037\",\"packages\":[{\"productid\":\"HK-ARAMEX\",\"productname\":\"华南-香港ARAMEX\",\"networkname\":\"ARAMEX\",\"referencenumber\":\"test99-pat-1193368-287997\",\"pickupservice\":[],\"senderinformation\":[{\"sendername\":\"InterFocus Inc\",\"senderphone\":\"18362906318\",\"sendercountry\":\"CN\",\"sendercity\":\"ShenZhen\",\"sendertown\":\"Baoan\",\"senderaddress\":\"Bao'an District of Shenzhen City Shajing Town, Central Asia Silicon Valley A District B, 2nd Floor\"}],\"recipientinformation\":[{\"recipientname\":\"Jasmine Saba\",\"recipientphone\":\"\",\"recipientcountry\":\"IL\",\"recipientpostcode\":\"1601503\",\"recipientcity\":\"Nazareth\",\"recipientstate\":\"\",\"recipientaddress\":\"6034/6 box 10890 \"}],\"invoiceinformation\":[{\"chinesename\":\" \",\"englishname\":\"Kids Shirt\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":2.4983333333333,\"declarationamount\":2.4983333333333,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Kids Tops\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":2.4983333333333,\"declarationamount\":2.4983333333333,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Kids  Bottoms\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":2.4983333333333,\"declarationamount\":2.4983333333333,\"declarationcurrency\":\"USD\"}],\"weightinformation\":[{\"weightmethod\":\"1\",\"totalpackages\":\"1\",\"itemtype\":\"纸箱\",\"totalweight\":\"0.764\"}],\"detailpackage\":[{\"actualweight\":\"0.764\",\"length\":\"0\",\"width\":\"0\",\"height\":\"0\",\"volume\":\"0\",\"volumeweight\":\"0\",\"item\":[]}],\"specialservice\":[{\"servicename\":\"1\",\"costamount\":\"0\",\"costcurrency\":null,\"description\":\"\"}]}]}}";

		String newjcextest2 = "{\"Data\":{\"apiplatform\":\"TEST\","
				+ "\"jcexkey\":\"NET\",\"customerid\":\"04D289BA-0292-495F-AA03-FE5BB33DE38F\","
				+ "\"customer\":\"JCTEST\",\"packages\":["
				+ "{\"paymentmethod\":null,\"branchoffice\":null,\"waybillnumber\":\"\","
				+ "\"platnumber\":\"\",\"referencenumber\":\"WNB20171107161229\","
				+ "\"transfernumber\":null,\"productid\":\"TESTUPS\","
				+ "\"productname\":\"TESTUPS\",\"servicetype\":null,"
				+ "\"pickupservice\":null,\"expressnetwork\":null,"
				+ "\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,"
				+ "\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,"
				+ "\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,"
				+ "\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,"
				+ "\"status\":null,\"waybillcompleted\":null,\"inputname\":null,\"inputtime\":null,"
				+ "\"senderinformation\":[{\"sendername\":\"yalin\",\"senderchinesename\":\"yalin\","
				+ "\"sendercompany\":\"All the nations at speeds\","
				+ "\"senderphone\":\"18924666475\","
				+ "\"sendercountry\":\"CN\",\"sendercity\":\"Shenzhen\","
				+ "\"sendertown\":\"Longhua\",\"senderpostcode\":\"518000\","
				+ "\"senderaddress\":\"Warehouse no.4, kaiton new district\","
				+ "\"senderemail\":null,\"sendercustomsregistrationcode\":null,"
				+ "\"sendercustomsoperatingunits\":null,\"senderproxycode\":null}],"
				+ "\"recipientinformation\":[{\"recipientname\": \"AMAZON CO UK\","
				+ "\"recipientphone\": \"111\","
				+ "\"recipientcountry\": \"SG\","
				+ "\"recipientpostcode\": \"92704\","
				+ "\"recipientcity\": \"Santa Ana\","
				+ "\"recipientstate\": \"CA\", "
				+ "\"recipienttown\": \"Swansea\", "
				+ "\"recipienthousenumber\":\"\","
				+ "\"recipientaddress\":\"3310 West MacArthur Blvd\","
				+ "\"recipientcompany\":\"TESE name\","
				+ "\"recipientdutyparagraph\":null}],"
				+ "\"invoiceinformation\":[" + "{\"chinesename\":\"书\","
				+ "\"englishname\":\"Books\"," + "\"hscode\":null,"
				+ "\"inpieces\":1," + "\"unitpriceamount\":\"6\","
				+ "\"declarationamount\":\"6\","
				+ "\"declarationcurrency\":\"USD\","
				+ "\"materialquality\":null," + "\"purpose\":null,"
				+ "\"measurementunit\":null," + "\"specificationmodel\":null},"
				+ "{\"chinesename\":\"铅笔\"," + "\"englishname\":\"Pencils\","
				+ "\"hscode\":null," + "\"inpieces\":20,"
				+ "\"unitpriceamount\":\"2\"," + "\"declarationamount\":\"2\","
				+ "\"declarationcurrency\":\"USD\","
				+ "\"materialquality\":null," + "\"purpose\":null,"
				+ "\"measurementunit\":null," + "\"specificationmodel\":null},"
				+ "{\"chinesename\":\"笔\"," + "\"englishname\":\"Pen\","
				+ "\"hscode\":null," + "\"inpieces\":1,"
				+ "\"unitpriceamount\":\"0.45\","
				+ "\"declarationamount\":\"0.45\","
				+ "\"declarationcurrency\":\"USD\","
				+ "\"materialquality\":null,\"purpose\":null,"
				+ "\"measurementunit\":null,"
				+ "\"specificationmodel\":null}]," + "\"weightinformation\":["
				+ "{\"weightmethod\":null," + "\"totalpackages\":2,"
				+ "\"itemtype\":\"袋子\"," + "\"totalweight\":\"0.45\"}],"
				+ "\"detailpackage\":[" + "{\"actualweight\":\"12\","
				+ "\"child_number\":\"WNB20171107161229B01\","
				+ "\"length\":\"45\"," + "\"width\":\"34\","
				+ "\"height\":\"20\"," + "\"volume\":0,"
				+ "\"volumeweight\":0," + "\"item\":["
				+ "{\"englishname\":\"Books\"," + "\"hscode\":\"\","
				+ "\"inpieces\":\"2\"," + "\"unitpriceamount\":\"6\","
				+ "\"unitpriceweight\":\"0.2\","
				+ "\"declarationamount\":\"6\","
				+ "\"declarationcurrency\":\"USD\"},"
				+ "{\"englishname\":\"Pencils\"," + "\"hscode\":\"\","
				+ "\"inpieces\":\"20\"," + "\"unitpriceamount\":\"2\","
				+ "\"unitpriceweight\":\"0.2\","
				+ "\"declarationamount\":\"2\","
				+ "\"declarationcurrency\":\"USD\"}]},"
				+ "{\"actualweight\":\"8.334\","
				+ "\"child_number\":\"WNB20171107161229B02\","
				+ "\"length\":\"40\"," + "\"width\":\"30\","
				+ "\"height\":\"20\"," + "\"volume\":0,"
				+ "\"volumeweight\":0," + "\"item\":["
				+ "{\"englishname\":\"Pen\"," + "\"hscode\":\"\","
				+ "\"inpieces\":\"1\"," + "\"unitpriceamount\":\"0.45\","
				+ "\"unitpriceweight\":\"0.05\","
				+ "\"declarationamount\":\"0.45\","
				+ "\"declarationcurrency\":\"USD\"}]}],"
				+ "\"specialservice\":[{\"servicename\":null,"
				+ "\"costamount\":0," + "\"costcurrency\":null,"
				+ "\"description\":null}]}]}}";

		String hkdhl = "{\"Data\":{\"netcompanyname\":\"SFIBS\",\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,\"waybillnumber\":\"TEST2017102401001\",\"referencenumber\":\"TEST2017102401001\",\"transfernumber\":null,\"productid\":null,\"productname\":null,\"servicetype\":null,\"pickupservice\":[],\"expressnetwork\":null,\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,\"status\":null,\"waybillcompleted\":null,\"inputname\":null,\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"1\",\"senderchinesename\":\"YCHEN\",\"sendercompany\":\"YCHEN\",\"senderphone\":\"518000\",\"sendercountry\":\"CN\",\"sendercity\":\"SHENZHEN\",\"sendertown\":\"\",\"senderpostcode\":\"\",\"senderaddress\":\"BAOAN DISTRICT SHENZHEN FUYON\",\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,\"senderproxycode\":null,\"senderemail\":\"\"}],\"recipientinformation\":[{\"recipientname\":\"MAXINE LAM\",\"recipientphone\":\"1-949-4139959\",\"recipientcountry\":\"US\",\"recipientpostcode\":\"91723\",\"recipientcity\":\"COVINA\",\"recipientstate\":\"CA\",\"recipienttown\":\"\",\"recipienthousenumber\":null,\"recipientaddress\":\"137 W SAN BERNARDINO RD\",\"recipientcompany\":\"PANTOS LOGISTICS SINGAPORE PTE LTD\",\"recipientdutyparagraph\":null,\"recipientemail\":\"\"}],\"invoiceinformation\":[{\"chinesename\":\"笔\",\"englishname\":\"PEN\",\"hscode\":\"\",\"inpieces\":\"5\",\"unitpriceamount\":\"4.00\",\"declarationamount\":\"20.00\",\"declarationcurrency\":\"USD\",\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null,\"invoice_weight\":\"0.000\"}],\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\",\"itemtype\":\"纸箱\",\"totalweight\":\"1.500\",\"totalvolumeweight\":\"0.000\",\"totalchargeableweight\":\"1.500\"}],\"detailpackage\":[{\"actualweight\":\"1.500\",\"length\":\"0.0\",\"width\":\"0.0\",\"height\":\"0.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\",\"child_number\":\"TEST2017102401001\",\"goodsname\":\"\",\"trackno\":\"\",\"item\":[{\"englishname\":\"PEN\",\"hscode\":\"\",\"inpieces\":\"5\",\"unitpriceamount\":\"4.000000\",\"unitpriceweight\":\"0.000\",\"declarationamount\":\"20.00\",\"declarationcurrency\":\"USD\"}]}],\"specialservice\":[{\"servicename\":\"申报价值等级1\",\"costamount\":\"20.00\",\"costcurrency\":\"\",\"description\":\"\"}]}]}}";

		String matest = "{\"Data\":{\"apiplatform\":\"mabang\",\"jcexkey\":\"NET2\",\"customer\":\"HZ1293\",\"customerid\":\"E833F38F-22A8-4ED0-ADE0-03D7371F484A\",\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,\"waybillnumber\":\"\",\"referencenumber\":\"891729729628559\",\"transfernumber\":null,\"productid\":\"PK0746\",\"productname\":\"佳成小包-佳邮宝(华东区)\",\"servicetype\":null,\"pickupservice\":[],\"expressnetwork\":null,\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,\"status\":null,\"waybillcompleted\":null,\"inputname\":null,\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"Cheney zhang\",\"senderchinesename\":\"Cheney zhang\",\"sendercompany\":\"Cheney zhang\",\"senderphone\":\"0571-88610804\",\"sendercountry\":\"CN\",\"sendercity\":\"杭州市\",\"sendertown\":\"\",\"senderpostcode\":\"311121\",\"senderaddress\":\"余杭街道科技大道8-2号6幢2楼西 浙江省杭州市余杭街道科技大道8-2号6幢2楼西Cheney zhang\",\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,\"senderemail\":null,\"senderproxycode\":null}],\"recipientinformation\":[{\"recipientname\":\"MUDET jean-luc\",\"recipientphone\":\"0493313748\",\"recipientcountry\":\"FR\",\"recipientpostcode\":\"06700\",\"recipientcity\":\"St Laurent Du Var\",\"recipientstate\":\"St Laurent Du Var\",\"recipienttown\":\"\",\"recipienthousenumber\":null,\"recipientaddress\":\"956 Boulevard Jean Ossola \",\"recipientcompany\":\"MUDET jean-luc\",\"recipientemail\":\"\",\"recipientdutyparagraph\":null}],\"invoiceinformation\":[{\"chinesename\":\"男裤\",\"englishname\":\"Mens pants\",\"hscode\":\"6101200010\",\"inpieces\":\"1\",\"unitpriceamount\":\"5.0\",\"declarationamount\":\"5.00\",\"declarationcurrency\":\"USD\",\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null},{\"chinesename\":\"男裤\",\"englishname\":\"Mens pants\",\"hscode\":\"6101200010\",\"inpieces\":\"1\",\"unitpriceamount\":\"5.0\",\"declarationamount\":\"5.00\",\"declarationcurrency\":\"USD\",\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null},{\"chinesename\":\"男裤\",\"englishname\":\"Mens pants\",\"hscode\":\"6101200010\",\"inpieces\":\"1\",\"unitpriceamount\":\"5.0\",\"declarationamount\":\"5.00\",\"declarationcurrency\":\"USD\",\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null},{\"chinesename\":\"裤子\",\"englishname\":\"pants\",\"hscode\":\"\",\"inpieces\":\"1\",\"unitpriceamount\":\"5.0\",\"declarationamount\":\"5.00\",\"declarationcurrency\":\"USD\",\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null}],\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\",\"itemtype\":\"PAK袋\",\"totalweight\":\"0.0034\"}],\"detailpackage\":[{\"actualweight\":\"0.0034\",\"child_number\":\"\",\"length\":\"1.0\",\"width\":\"1.0\",\"height\":\"1.0\",\"volume\":\"0\",\"volumeweight\":\"0\",\"item\":[]}],\"specialservice\":[{\"servicename\":null,\"costamount\":\"0\",\"costcurrency\":null,\"description\":null}]}]}}";

		String labeltest = "{ \"customerid\": \"8DD39425-178E-44FA-8232-D254FAC16391\",\"shipmentid\": \"7e96d1cf-6064-4997-a87c-f6f4945e32bb\",\"issignaturerequired\": \"\",\"outputs\": \"LABEL_PDF\"}";

		String alitestpay = "<?xml version=\"1.0\" encoding=\"utf-8\"?><esc><head><messageId>18830494870</messageId>"
				+ "<messageTime>2017-07-20 08:20:39 GMT+08:00</messageTime><messageWay>request</messageWay>"
				+ "<sender>ALIBABA</sender><version>1.0</version><serviceName>orderPayment</serviceName>"
				+ "</head><body><orderId>TEST20180408003</orderId><serviceType>EXPRESS</serviceType><paySummary>"
				+ "<amount>0.01</amount><currency>CNY</currency><paymentMethod>ALIPAY_ONLINE</paymentMethod>"
				+ "<payer>SUPPLIER</payer><payTime>2017-07-20 08:20:38 GMT+08:00</payTime><payeeAccount>测试付款</payeeAccount>"
				+ "</paySummary></body></esc>";

		String testt111 = "<esc><head><messageId>18855640371</messageId><messageTime>2017-11-2018:00:18GMT08:00</messageTime>"
				+ "<messageWay>request</messageWay><sender>ALIBABA</sender><version>1.0</version>"
				+ "<serviceName>orderForecast</serviceName></head><body>"
				+ "<orderId>TEST2007486330</orderId>"
				+ "<serviceType>EXPRESS</serviceType><sellerNote>快递是速尔快递christina@e2woo.com</sellerNote><email>christina@e2woo.com</email><isCustomsClearance>N</isCustomsClearance><departurePlace>JC_HZ</departurePlace><destinationCountry>MY</destinationCountry><serviceList><domesticTransportation><deliveryCount>1</deliveryCount><logisticsInfoList><logisticsInfo><logisticsCompany>OTHER</logisticsCompany><logisticsNo>880355777673</logisticsNo></logisticsInfo></logisticsInfoList></domesticTransportation><warehouseService><warehouse>JC_HZ</warehouse></warehouseService><internationalExpress><logisticsCompanyService>JC</logisticsCompanyService></internationalExpress></serviceList><contactInfo><consignee><companyName></companyName><name>nabilaruseli</name><country>MY</country><province>terengganu</province><city>dungun</city><address>no48,jlntmnmurniperdana,tmnmurniperdanafasa2bkossederhana23100paka,dungun,terengganu,malaysia</address><zip>23100</zip><phoneNumber>60-01-69762028</phoneNumber></consignee><shipper><companyName>上海精致服饰有限公司</companyName><name>Christina</name><phoneNumber></phoneNumber><mobile>18006632650</mobile></shipper></contactInfo><consignmentInfo><goodsSummary><totalPackageQuantity>1</totalPackageQuantity><totalDeclaredValue>45</totalDeclaredValue><totalDeclaredCurrency>USD</totalDeclaredCurrency><mixedPackage>false</mixedPackage></goodsSummary><goodsDeclarationList><goodsDeclaration><nameChinese>童装</nameChinese><nameEnglish>Kidclothes</nameEnglish><hscode>6104530090</hscode><nature></nature><statutoryQuantity>30</statutoryQuantity></goodsDeclaration></goodsDeclarationList></consignmentInfo></body></esc>";

		String testird = "{\"Data\":{\"netcompanyname\":\"HKARAMEX\",\"packages\":["
				+ "{\"paymentmethod\":\"PP\",\"branchoffice\":\"\",\"waybillnumber\":\"JHtest123456\","
				+ "\"referencenumber\":\"\",\"transfernumber\":\"\",\"productid\":\"\",\"productname\":\"\","
				+ "\"servicetype\":\"\",\"pickupservice\":[{\"pickupaddress\":\"\",\"pickupcontacts\":\"\","
				+ "\"pickupcontactnumber\":\"\",\"pickupstaff\":\"\",\"pickupamount\":\"\",\"operatingcost\":\"\","
				+ "\"expresscompany\":\"JUNHUI\",\"expressnumber\":\"\",\"deliverypayment\":\"\","
				+ "\"pickupRemark\":\"\",\"estimatedtimeofarrival\":\"\","
				+ "\"receivewarehouseaddress\":\"\",\"receivewarehousecontact\":\"\","
				+ "\"receivewarehousephone\":\"\"}],\"expressnetwork\":\"\","
				+ "\"estimatedfee\":\"\",\"feenotes\":\"\",\"feenotesperson\":\"\","
				+ "\"feenotestime\":\"\",\"operationnotes\":\"\",\"operationnotesperson\":\"\","
				+ "\"operationnotestime\":\"\",\"returnsign\":\"\",\"returnperson\":\"\","
				+ "\"returntime\":\"\",\"returnreason\":\"\",\"receivewarehouse\":\"\",\"status\":\"\","
				+ "\"waybillcompleted\":\"\",\"inputname\":\"\",\"inputtime\":\"2017-12-01 11:20:25\",\"senderinformation\":[{\"sendername\":\"Junhui\",\"senderchinesename\":\"\",\"sendercompany\":\"UN-Line Freight Agency Co., Ltd.\",\"senderphone\":\"\",\"sendercountry\":\"HK\",\"sendercity\":\"\",\"sendertown\":\"\",\"senderpostcode\":\"518100\",\"senderaddress\":\"Xinrui erqu Hourui Village Xixiang Bao'an Shenzhen\",\"sendercustomsregistrationcode\":\"\",\"sendercustomsoperatingunits\":\"\",\"senderproxycode\":\"\"}],\"accountinformation\":[{\"accountusername\":\"vip@un-line.com\",\"accountpassword\":\"Jhgj@1234\",\"accountnumber\":\"130803142\",\"accountpin\":\"665165\",\"accountentity\":\"HKG\",\"accountcountryCode\":\"HKG\",\"accountcity\":\"Hong Kong\",\"accountpostcode\":\"邮编\"}],\"recipientinformation\":[{\"recipientname\":\"test\",\"recipientphone\":\"\",\"recipientcountry\":\"IN\",\"recipientpostcode\":\"144003\",\"recipientcity\":\"JALANDHAR\",\"recipientstate\":\"VIR\",\"recipienttown\":\"JALANDHAR\",\"recipienthousenumber\":\"\",\"recipientaddress\":\"THE BAGH HOTEL AGRA AND ACHERA ROAD BHARATPUR RAJASTHAN\",\"recipientcompany\":\"test\",\"recipientdutyparagraph\":\"\"}],\"invoiceinformation\":[{\"chinesename\":\"中文\",\"englishname\":\"英文章\",\"hscode\":\"s223\",\"inpieces\":\"1\",\"unitpriceamount\":\"12\",\"declarationamount\":\"12\",\"declarationcurrency\":\"USD\",\"materialquality\":\"\",\"purpose\":\"\",\"measurementunit\":\"\",\"specificationmodel\":\"\"},{\"chinesename\":\"ddd\",\"englishname\":\"dfdf\",\"hscode\":\"12\",\"inpieces\":\"2\",\"unitpriceamount\":\"11.5\",\"declarationamount\":\"23\",\"declarationcurrency\":\"USD\",\"materialquality\":\"\",\"purpose\":\"\",\"measurementunit\":\"\",\"specificationmodel\":\"\"}],\"weightinformation\":[{\"weightmethod\":\"\",\"totalpackages\":\"1\",\"itemtype\":\"\",\"totalweight\":\"1\",\"totalvolumeweight\":\"\",\"totalchargeableweight\":\"1\"}],\"detailpackage\":[{\"actualweight\":\"1\",\"length\":\"\",\"width\":\"\",\"height\":\"\",\"volume\":\"\",\"volumeweight\":\"\"}],\"specialservice\":[{\"servicename\":\"\",\"costamount\":\"\",\"costcurrency\":\"\",\"description\":null}]}]}}";

		// System.out.println(encodeParam);
		// String url = "http://api.jcex.com/JcexJson/api/notify/sendmsg";

		String banmatest = "{\"Data\":{\"netcompanyname\":\"BANMA\",\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,\"waybillnumber\":\"88011521\",\"referencenumber\":\"88011521\",\"transfernumber\":null,\"productid\":null,\"productname\":null,\"servicetype\":null,\"pickupservice\":[],\"expressnetwork\":null,\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,\"status\":null,\"waybillcompleted\":null,\"inputname\":null,\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"gaoyang\",\"senderchinesename\":\"jiacheng\",\"sendercompany\":\"jiacheng\",\"senderphone\":\"18969048607\",\"sendercountry\":\"CN\",\"sendercity\":\"hangzhou\",\"sendertown\":\"\",\"senderpostcode\":\"310000\",\"senderaddress\":\"jiu he lu 28\",\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,\"senderproxycode\":null,\"senderemail\":\"\"}],\"recipientinformation\":[{\"recipientname\":\"YUHUA CHEN\",\"recipientphone\":\"12159396903\",\"recipientcountry\":\"US\",\"recipientpostcode\":\"18045\",\"recipientcity\":\"EASTON\",\"recipientstate\":\"PA\",\"recipienttown\":null,\"recipienthousenumber\":null,\"recipientaddress\":\"4084 WINFIELD TER EASTON  PA 18045\",\"recipientcompany\":\"YUHUA CHEN\",\"recipientdutyparagraph\":null,\"recipientemail\":\"\"}],\"invoiceinformation\":[{\"chinesename\":\"外套/摆件\",\"englishname\":\"sun\",\"hscode\":\"6204320090\",\"inpieces\":\"10\",\"unitpriceamount\":\"5.00\",\"declarationamount\":\"50.00\",\"declarationcurrency\":\"USD\",\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null,\"invoice_weight\":\"0\"}],\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\",\"itemtype\":\"PAK袋\",\"totalweight\":\"0.500\",\"totalvolumeweight\":\"0\",\"totalchargeableweight\":\"0\"}],\"detailpackage\":[{\"actualweight\":\"0.500\",\"length\":\"12.0\",\"width\":\"14.0\",\"height\":\"13.0\",\"volume\":\"2184.000\",\"volumeweight\":\"0\",\"child_number\":\"88011521001\",\"goodsname\":\"\",\"trackno\":\"\",\"item\":[{\"englishname\":\"sun\",\"hscode\":\"6204320090\",\"inpieces\":\"10\",\"unitpriceamount\":\"5.0000\",\"unitpriceweight\":\"0\",\"declarationamount\":\"50.00\",\"declarationcurrency\":\"USD\"}]}],\"specialservice\":[{\"servicename\":null,\"costamount\":null,\"description\":null}]}]}}";

		String testhk = "{\"Data\":{\"customer\":\"SZ6088\",\"apiplatform\":\"Dress\",\"packages\":[{\"waybillnumber\":\"\",\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\",\"itemtype\":\"BAG\",\"totalweight\":\"0.0\"}],\"recipientinformation\":[{\"recipientphone\":\"3476679619\",\"recipientcountry\":\"US\",\"recipienthousenumber\":null,\"recipientpostcode\":\"11411\",\"recipientaddress\":\"116-36 217th street cambria heights \",\"recipientemail\":\"\",\"recipientcompany\":\" \",\"recipientdutyparagraph\":null,\"recipienttown\":\" \",\"recipientname\":\"Hyacinth  Sharpe\",\"recipientcity\":\"Queens \",\"recipientstate\":\"New York\"}],\"referencenumber\":\"J5-180510984100007518\",\"transfernumber\":null,\"paymentmethod\":null,\"productname\":\"DHL\",\"senderinformation\":[{\"sendercity\":\"SUZHOU\",\"sendercountry\":\"CN\",\"senderproxycode\":null,\"sendername\":\"LEI HUI\",\"sendercustomsregistrationcode\":null,\"sendercompany\":\"SUZHOU JUJIE INFORMATION TECHNOLOGY CO. LTD.\",\"senderaddress\":\"TIAN LIN ROAD\",\"senderemail\":\"\",\"sendercustomsoperatingunits\":null,\"senderpostcode\":\" \",\"sendertown\":\" \",\"senderphone\":\"67070938\",\"senderchinesename\":\"SUZHOU JUJIE INFORMATION TECHNOLOGY CO. LTD.\"}],\"specialservice\":[{\"costamount\":0,\"servicename\":null,\"description\":null,\"costcurrency\":null}],\"detailpackage\":[{\"child_number\":\"\",\"item\":[{\"unitpriceweight\":\"1\",\"declarationcurrency\":\"USD\",\"unitpriceamount\":\"15\",\"declarationamount\":\"15\",\"englishname\":\"Prom Dress\",\"inpieces\":\"1\",\"hscode\":\" \"}],\"volumeweight\":\"0\",\"height\":\"0\",\"volume\":\"0\",\"width\":\"0\",\"length\":\"0\",\"actualweight\":\"0.0\"}],\"invoiceinformation\":[{\"materialquality\":null,\"specificationmodel\":null,\"declarationcurrency\":\"USD\",\"measurementunit\":null,\"chinesename\":\"LIFU\",\"purpose\":null,\"unitpriceamount\":\"15\",\"declarationamount\":\"15\",\"englishname\":\"Prom Dress\",\"inpieces\":\"1\",\"hscode\":\" \"}],\"branchoffice\":null,\"platnumber\":\"\",\"productid\":\"JCEX-001\"}],\"jcexkey\":\"NET\",\"customerid\":\"5B37E955-B883-47E4-8C04-5F74B1BDFE1E\"}}";
		
		String login = "{\"Data\":{\"apiplatform\":\"TEST\",\"customertype\":\"JM\",\"billnotype\":\"JM\",\"jcexkey\":\"NET\",\"customer\":\"HGH02001\",\"customerid\":\"123456\",\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,\"waybillnumber\":\"\",\"referencenumber\":\"891803142076262\",\"transfernumber\":null,\"productid\":\"PK0938\",\"productname\":\"\",\"servicetype\":null,\"pickupservice\":[],\"expressnetwork\":null,\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,\"status\":null,\"waybillcompleted\":null,\"inputname\":null,\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"方可\",\"senderchinesename\":\"方可\",\"sendercompany\":\"方可\",\"senderphone\":\"15957376829\",\"sendercountry\":\"CN\",\"sendercity\":\"hangzhou\",\"sendertown\":\"\",\"senderpostcode\":\"311211\",\"senderaddress\":\"萧山区商函分公司\",\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,\"senderemail\":null,\"senderproxycode\":null}],\"recipientinformation\":[{\"recipientname\":\"joi r rodriguez\",\"recipientphone\":\"816 304 5015\",\"recipientcountry\":\"US\",\"recipientpostcode\":\"34240\",\"recipientcity\":\"lakewood ranch\",\"recipientstate\":\"fl\",\"recipienttown\":\"\",\"recipienthousenumber\":null,\"recipientaddress\":\"8374 market street , #182 \",\"recipientcompany\":\"joi r rodriguez\",\"recipientemail\":\"\",\"recipientdutyparagraph\":null}],\"invoiceinformation\":[{\"chinesename\":\"切菜器\",\"englishname\":\"Slicer\",\"hscode\":\"\",\"inpieces\":\"1\",\"unitpriceamount\":\"5.0\",\"declarationamount\":\"5.00\",\"declarationcurrency\":\"USD\",\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null}],\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\",\"itemtype\":\"PAK袋\",\"totalweight\":\"1.25\"}],\"detailpackage\":[{\"actualweight\":\"1.25\",\"child_number\":\"\",\"length\":\"1.0\",\"width\":\"1.0\",\"height\":\"1.0\",\"volume\":\"0\",\"volumeweight\":\"0\",\"item\":[]}],\"specialservice\":[{\"servicename\":null,\"costamount\":\"0\",\"costcurrency\":null,\"description\":null}]}]}}";

		String encodeParam1 = "{\"Data\":{\"netcompanyname\":\"RUETSHOU\",\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,\"waybillnumber\":\"test2008093868\",\"referencenumber\":\"test2008093868\",\"transfernumber\":null,\"productid\":null,\"productname\":null,\"servicetype\":null,\"pickupservice\":[],\"expressnetwork\":null,\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,\"status\":null,\"waybillcompleted\":null,\"inputname\":null,\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"俞君来\",\"senderchinesename\":\"LINAN HOFFREY AUTO REPAIR EQUIPMENT CO. LTD\",\"sendercompany\":\"LINAN HOFFREY AUTO REPAIR EQUIPMENT CO. LTD\",\"senderphone\":\"18258039762\",\"sendercountry\":\"CN\",\"sendercity\":\"HANGZHOU\",\"sendertown\":\"\",\"senderpostcode\":\"\",\"senderaddress\":\"HANGZHOU\",\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,\"senderproxycode\":null,\"senderemail\":\"\"}],\"recipientinformation\":[{\"recipientname\":\"ELENA MOLOSHINA\",\"recipientphone\":\"781232030802263\",\"recipientcountry\":\"RU\",\"recipientpostcode\":\"197183\",\"recipientcity\":\"ST PETERSBURG\",\"recipientstate\":\"SAINT PETERSBURG\",\"recipienttown\":\"\",\"recipienthousenumber\":null,\"recipientaddress\":\"ZAUSADEBNAYA ST 15 LITER B OFFICE 7\",\"recipientcompany\":\"ELENA MOLOSHINA\",\"recipientdutyparagraph\":null,\"recipientcertificatecode\":\"\",\"recipientemail\":\"\"}],\"invoiceinformation\":[{\"chinesename\":\"钢丝\",\"englishname\":\"STEEL WIRE\",\"hscode\":\"8431310090\",\"inpieces\":\"2\",\"unitpriceamount\":\"10.00\",\"declarationamount\":\"20.00\",\"declarationcurrency\":\"USD\",\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null,\"invoice_weight\":\"6.760\"}],\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\",\"itemtype\":\"纸箱\",\"totalweight\":\"6.760\",\"totalvolumeweight\":\"0.000\",\"totalchargeableweight\":\"7.000\"}],\"detailpackage\":[{\"actualweight\":\"6.760\",\"length\":\"0.0\",\"width\":\"0.0\",\"height\":\"0.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\",\"child_number\":\"2008093868\",\"goodsname\":\"\",\"trackno\":\"\",\"item\":[{\"englishname\":\"STEEL WIRE\",\"hscode\":\"8431310090\",\"inpieces\":\"2\",\"unitpriceamount\":\"10.000000\",\"unitpriceweight\":\"6.760\",\"declarationamount\":\"20.00\",\"declarationcurrency\":\"USD\"}]}],\"specialservice\":[{\"servicename\":\"申报价值等级1\",\"costamount\":\"20.00\",\"costcurrency\":\"\",\"description\":\"\"}]}]}}";

		String BONDED = "{\"Data\":{\"netcompanyname\":\"EMSAPI\","
				+ "\"packages\":[{\"paymentmethod\":null,\"branchoffice\":null,"
				+ "\"waybillnumber\":\"TESTJCEX007845\",\"referencenumber\":\"\","
				+ "\"transfernumber\":null,\"productid\":null,\"productname\":null,"
				+ "\"servicetype\":null,\"pickupservice\":null,\"expressnetwork\":null,"
				+ "\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,"
				+ "\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,"
				+ "\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,"
				+ "\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,"
				+ "\"status\":null,\"waybillcompleted\":null,\"inputname\":null,"
				+ "\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"ALEX GAO\","
				+ "\"senderchinesename\":\"ZHONGHANG RD.\",\"sendercompany\":\"ZHONGHANG RD.\","
				+ "\"senderphone\":\"13686871955\",\"sendercountry\":\"CN\",\"sendercity\":\"\","
				+ "\"sendertown\":\"\",\"senderpostcode\":\"\",\"senderaddress\":\"FU TIAN DISTRICT,SHENZHEN DUHUI100 BUILDING B 23S ROOM SHENZHEN CHINA.PEOPLES\u0027S REPUBLIC\","
				+ "\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,"
				+ "\"senderproxycode\":null}],"
				+ "\"recipientinformation\":["
				+ "{\"recipientname\":\"Emmanuel Macron\","
				+ "\"recipientphone\":\"2008906354\","
				+ // 07448817254
				"\"recipientcountry\":\"US\","
				+ "\"recipientpostcode\":\"91564\","// 2440
				+ // KY11 8ST Buckshaw Village PR7 7DL GB 1 LNGHAM PLACE LANCS
				"\"recipientcity\":\"NEUENDETTELSAU\","
				+ // STADTLOHN 48703 DE DUFKAMPSTRASSE 20
				"\"recipientstate\":\"FROSCHLACH\","
				+ "\"recipienttown\":\"\","
				+ "\"recipienthousenumber\":\"\","
				+ "\"recipientaddress\":\"91564 NEUENDETTELSAU FROSCHLACH 36C\","
				+ "\"recipientcompany\":\"TEST_JCEX\","
				+ "\"recipientemail\":\"\","
				+ "\"recipientdutyparagraph\":null}],"
				+ "\"invoiceinformation\":["
				// + "{\"chinesename\":\"测试\","
				// + "\"englishname\":\"testPM\","
				// + "\"hscode\":\"\","
				// + "\"inpieces\":\"4\","
				// + "\"unitpriceamount\":\"12.00\","
				// + "\"declarationamount\":\"12.00\","
				// + "\"declarationcurrency\":\"USD\","
				// + "\"materialquality\":null,"
				// + "\"purpose\":null,"
				// + "\"measurementunit\":null,"
				// + "\"specificationmodel\":null},"
//				+ "{\"chinesename\":\"111\","
//				+ "\"englishname\":\"ttxc\","
//				+ "\"hscode\":\"\","
//				+ "\"inpieces\":\"100\","
//				+ "\"unitpriceamount\":\"23.00\","
//				+ "\"declarationamount\":\"2.00\","
//				+ "\"declarationcurrency\":\"USD\","
//				+ "\"materialquality\":null,"
//				+ "\"purpose\":null,"
//				+ "\"measurementunit\":null,"
//				+ "\"specificationmodel\":null},"
//				+ "{\"chinesename\":\"快很快就结婚\","
//				+ "\"englishname\":\"TRRE\","
//				+ "\"hscode\":\"\","
//				+ "\"inpieces\":\"6\","
//				+ "\"unitpriceamount\":\"45.00\","
//				+ "\"declarationamount\":\"15.00\","
//				+ "\"declarationcurrency\":\"USD\","
//				+ "\"materialquality\":null,"
//				+ "\"purpose\":null,"
//				+ "\"measurementunit\":null,"
//				+ "\"specificationmodel\":null},"
				+ "{\"chinesename\":\"萨达\","
				+ "\"englishname\":\"L55448\","
				+ "\"hscode\":\"\","
				+ "\"inpieces\":\"1\","
				+ "\"unitpriceamount\":\"2\","
				+ "\"declarationamount\":\"2\","
				+ "\"declarationcurrency\":\"USD\","
				+ "\"materialquality\":null,"
				+ "\"purpose\":null,"
				+ "\"measurementunit\":null,"
				+ "\"specificationmodel\":null}],"
				+ "\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\",\"itemtype\":\"PAK袋\","
				+ "\"totalweight\":\"1\",\"totalvolumeweight\":\"0.200\",\"totalchargeableweight\":\"5.000\"}],"
				+ "\"detailpackage\":["
				
				// "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
				// "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				// +
//				+ "{\"actualweight\":\"10.00\",\"child_number\":\"test011\",\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\"},"
				+ "{\"actualweight\":\"1.60\",\"child_number\":\"test011\",\"length\":\"10\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\", "
				+ "\"item\": ["
//				+ "{\"englishname\": \"test11\","
//				+ "\"hscode\": \"3214568972\", "
//				+ "\"inpieces\": \"1\","
//				+ "\"unitpriceamount\": \"350\","
//				+ "\"unitpriceweight\": \"1\","
//				+ "\"declarationamount\": \"3.5\","
//				+ "\"declarationcurrency\": \"USD\"},"
				+ "{\"englishname\": \"\","
				+ "\"hscode\": \"\","
				+ "\"inpieces\": \"\", "
				+ "\"unitpriceamount\": \"\","
				+ "\"unitpriceweight\": \"\","
				+ "\"declarationamount\": \"\","
				+ "\"declarationcurrency\": \"\"}" 
				+ "]},"
//				+ "{\"actualweight\":\"10.00\",\"child_number\":\"1\",\"length\":\"10.0\",\"width\":\"2.00\",\"height\":\"10.0\",\"volume\":\"0.000\",\"volumeweight\":\"0.000\","
//				+ "\"item\": ["
//				+ "{\"englishname\": \"test21\","
//				+ "\"hscode\": \"1234567890\", "
//				+ "\"inpieces\": \"4\","
//				+ "\"unitpriceamount\": \"25\","
//				+ "\"unitpriceweight\": \"\","
//				+ "\"declarationamount\": \"50\","
//				+ "\"declarationcurrency\": \"EUR\"},"
//				+ "{\"englishname\": \"test22\","
//				+ "\"hscode\": \"1234566541\","
//				+ "\"inpieces\": \"10\", "
//				+ "\"unitpriceamount\": \"500\","
//				+ "\"unitpriceweight\": \"0.1\","
//				+ "\"declarationamount\": \"50\","
//				+ "\"declarationcurrency\": \"USD\"}"
//				+ "]}"
				+ "],"
				+ "\"specialservice\":[{\"servicename\":null,\"costamount\":null,\"description\":null}]}]}}";
		
		String logins = "{\"customerid\": \"-1\",\"waybillnumber\": \"991845260\",\"isdisplaydetail\": \"\" }";
		
//		String url = "http://api.jcex.com:8080/JcexJson/api/notify/sendmsg";
//		 String url = "http://localhost:8080/JcexJson/api/notify/sendmsg";//
		// 佳成
		// String url = "http://www.vtp.netdespatch.com/NDServe/XAServer";
		// String url="http://115.238.63.131:8080/Hermes/api/hermes/sendmsg";
//		 String url
//		 ="http://api.jcex.com/ExternalInterface/api/external/sendmsg";
		// String url
		// ="http://115.238.63.130:8080/ExternalInterface/api/external/sendmsg";
//		 String url =
//		 "http://localhost:8080/ExternalInterface/api/external/sendmsg";//总接口
		// String url =
		// "http://api.jcex.com/TESTExternalInterface/api/external/sendmsg";//
		// String url =
		// "http://localhost:8080/KUOSHIInterface/api/kuoshi/sendmsg";//阔石
		// String url =
		// "http://api.jcex.com/KUOSHIInterface/api/kuoshi/sendmsg";//阔石
		// String url =
		// "http://localhost:8080/ESpostalinterface/api/espostal/sendmsg";//西班牙邮政
		// String url =
		// "http://api.jcex.com/ESpostalinterface/api/espostal/sendmsg";//西班牙邮政

		// String url = "http://localhost:8080/Aramex02/api/aramex/sendmsg";
		// String url = "http://localhost:8080/HLUPS/api/hlups/sendmsg";//荷兰UPS
//		 String url = "http://api.jcex.com:8080/NewSineSPM/SineSPM/sendmsg";//塞音
//		 String url = "http://localhost:8080/NewSineSPM/SineSPM/sendmsg";//塞音

//		 String url = "http://localhost:8080/ALiJcex/api/ali/back";
		
		 
//		 String url = "http://api.jcex.com/ALiJcex/api/ali/back";
		// String url = "http://localhost:8080/DekeDHP/api/deke/sendmsg";
		// String url
		// ="http://localhost:8080/AramexHttpClient/api/aramex/sendmsg";//aramex
		// String url =
		// "http://219.133.55.75:8080/ThirdpartyAramex/api/aramex/sendmsg";//
		// 第三方aramex
		// String url =
		// "http://localhost:8080/ThirdpartyAramex/api/aramex/sendmsg";//
		// 第三方aramex
		// String url
		// ="http://api.jcex.com/AramexHttpClient/api/aramex/sendmsg";
//		 String url = "http://localhost:8080/Royal/api/royal/sendmsg";//皇邮
		
//		 String url = "http://localhost:8080/GFSAPI/api/gfs/sendmsg";//GFS
//		 String url = "http://api.jcex.com:8080/GFSAPI/api/gfs/sendmsg";//GFS

//		 String url = "http://localhost:8080/NiuMenERP/NiuMen/sendmsg";//钮门
//		 String url = "http://47.89.53.171:8080/UKmail/UKmail/sendmsg";//UKMAIL
		// String url =
		// "http://localhost:8080/MYFedEx/api/myfedex/sendmsg";//MY联邦
		// String url =
		// "http://localhost:8080/ETONGSHOU/api/etshou/sendmsg";//俄通收

		// String url =
		// "http://api.jcex.com/NEWJCEXInterface/api/newjcex/sendmsg";
		// String url =
		// "http://localhost:8080/NEWJCEXInterface/api/newjcex/sendmsg";//佳成新接口
		// String url =
		// "http://localhost:8080/TongtuInterface/api/tongtu/sendmsg";//通途
		// String url =
		// "http://localhost:8080/USDHLInterface/api/usdhl/sendmsg";//美国DHL
		// String url = "http://localhost:8080/ALiTrackInterface/ali/track";
		// String url = "http://api.jcex.com/ALiTrackInterface/ali/track";
		// String url = "https://api.pactrak.com/authority/token";
		// String url = "http://localhost:8080/NJYouZheng/api/njyz/sendmsg";
		// String url = "http://localhost:8080/GBUPS/api/gbups/sendmsg";//英国UPS

		// String url = "http://localhost:8080/SFIBS/api/sfibs/sendmsg";//顺丰

		// String url =
		// "http://115.238.63.130:8080/GBUPS/api/gbups/sendmsg";//英国UPS

		// String url = "http://localhost:8080/GBUPS/api/gbups/sendmsg";//英国UPS

		// String url =
		// "http://localhost:8080/AirCityInterface/api/aircity/sendmsg";//acp

		// String url =
		// "http://localhost:8080/JcexJsonTrackDB/api/notify/sendmsg";
		// String url =
		// "http://api.jcex.com/JcexJsonTrackDB/api/notify/sendmsg";

		// String url =
		// "http://localhost:8080/TESTSG/api/apiServlet/sendMessage";

		// String url = "http://localhost:8080/JCEXINVOICE/api/invoice/sendmsg";
		// String url = "http://api.jcex.com/JCEXINVOICE/api/invoice/sendmsg";
		// String url =
		// "http://192.187.123.146:8080/JCEXDHL/api/jcexdhl/sendmsg";

		// String url = "http://47.89.53.171:8080/JCEXDHL/api/jcexdhl/sendmsg";
//		 String url = "http://localhost:8080/JCEXOUTDHL/api/outdhl/sendmsg";
//		 String url = "http://localhost:8080/JCEXDHL/api/jcexdhl/sendmsg";
//		 String url = "http://115.238.63.131:8080/HLApi/api/sendmsg";
		 String url = "http://localhost:8080/READPDFF/PDFtoExecl/sada";
//		 String url =
//		 "http://localhost:8080/DEANDITInterface/api/bended/sendmsg";//B2C号码段访问地址
//		 String url =
//		 "http://api.jcex.com/DEANDITInterface/api/bended/sendmsg";//B2C号码段访问地址
		// 
		// String url = "http://localhost:8080/JCEXPCAE/api/jcexpcae/sendmsg";

		// String url = "http://api.jcex.com/JCEXDHL/api/jcexdhl/sendmsg";

		// String url =
		// "http://localhost:8080/JCEXLETIANUSDHL/api/letian/sendmsg";
//		 String url =
//		 "http://localhost:8080/BONDEDInterface/api/bonded/sendmsg";
//		 String url =
//		 "http://115.238.63.130:8080/BONDEDInterface/api/bonded/sendmsg";
//		 String url =
//		 "http://47.89.53.171:8080/BONDEDInterface/api/bonded/sendmsg";
//		 String url =
//		 "http://api.jcex.com/BONDEDInterface/api/bonded/sendmsg";
//		 String url =
//		 "http://localhost:8080/Apparcel/api/apparcel/sendmsg";//斑马
		// String url = "http://localhost:8080/YILONGEMS/api/deke/sendmsg";
		// String url = "http://api.jcex.com/YILONGEMS/api/deke/sendmsg";
		// String url = "http://localhost:8080/FTL-OMS/shipments/exportpdfa";//
		// 法翔
		// String url = "http://api.jcex.com/FTL-OMS/shipments/exportpdfa";// 法翔

//		 String url = "http://localhost:8080/ECDCBE/api/ecdcbe/sendmsg";//
//		 String url = "http://api.jcex.com/ECDCBE/api/ecdcbe/sendmsg";//

//		 String url =
//		 "http://localhost:8080/JCEXCHANNELInterface/api/jcexchannel/sendmsg";//佳成新接口
//		 String url =
//		 "http://api.jcex.com/JCEXCHANNELInterface/api/jcexchannel/sendmsg";//佳成新接口

		// String url =
		// "http://localhost:8080/JCInterface/api/jc/sendmsg";//佳成新接口
//		 String url =
//		 "http://localhost:8080/JMSInterface/api/jms/sendmsg";//佳成新接口
		// String url =
		// "http://115.238.63.130:8080/JMSInterface/api/jms/sendmsg";//佳成新接口
		// String url =
		// "http://120.79.10.142:8090/JCInterface/api/jc/sendmsg";//佳成新接口
//		String url = "http://47.89.53.171:8080/DubaiTrack/Dubai/sendmsg";//迪拜轨迹
//		 String url =
//		 "http://localhost:8080/HNAnjunInterface/api/anjun/sendmsg";//华南皇邮

//		 String url = "http://localhost:8080/JCWishPost/api/wish"; //wishceshi 
//		 String url = "http://api.jcex.com/JCWishPost/api/wish"; //wishceshi 
//		 String url = "http://47.89.53.171:8080/JCWishPost/api/wish/weight"; //wishceshi复重
//		 String url = "http://api.jcex.com/JCWishPost/api/wish/weight"; //wishceshi复重

		// String json =
		// "{\"service\":\""+service+"\",\"data_body\":\""+data_body+"\"}";
		// StringBuilder builder = new StringBuilder();
		// builder.append(json);
		//
		// byte[] signByte = builder.toString().getBytes("UTF-8");
		// String sendjson = new String(signByte, "UTF-8");
		// String sendjson = ByteUtil.toString(signByte).replace(" ", "");

		String man = "{\"Data\":{\"apiplatform\":\"e商赢\",\"jcexkey\":\"NET2\",\"customerid\":\"3673F13D-7715-4E43-96AE-1C1F49443744\",\"customer\":\"SZ0518\",\"packages\":[{\"referencenumber\":\"SMY-51-12468\",\"productid\":\"PK1032\",\"productname\":\"礼服\",\"senderinformation\":[{}],\"recipientinformation\":[{\"recipientname\":\"sandra taylor\",\"recipientphone\":\"01205761914\",\"recipientcountry\":\"GB\",\"recipientpostcode\":\"pe22 0nx\",\"recipientcity\":\"boston\",\"recipientstate\":\"Lincolnshire\",\"recipienttown\":\"\",\"recipientaddress\":\"chatsworth church road frestion\",\"recipientcompany\":\"sandra taylor\"}],\"invoiceinformation\":[{\"chinesename\":\"礼服\",\"englishname\":\"DRESS\",\"hscode\":\"6204430010\",\"inpieces\":\"1\",\"unitpriceamount\":\"50\",\"declarationamount\":\"50\",\"declarationcurrency\":\"USD\"}],\"weightinformation\":[{\"totalpackages\":\"1\",\"itemtype\":\"袋子\",\"totalweight\":0.5}],\"detailpackage\":[{\"actualweight\":0.5,\"length\":\"10.0\",\"width\":\"40.0\",\"height\":\"20.0\",\"volume\":\"0\",\"volumeweight\":\"0\",\"item\":[{\"englishname\":\"dress\",\"hscode\":\"3214568972\",\"inpieces\":\"1\",\"unitpriceamount\":\"50\",\"unitpriceweight\":\"1\",\"declarationamount\":\"3.5\",\"declarationcurrency\":\"USD\"}]}],\"specialservice\":[{\"servicename\":null,\"costamount\":\"0\",\"costcurrency\":null,\"description\":null}]}]}}";
		
		String fys = "{\"Data\":{\"customerid\":\"22C32058-2497-4D4C-88C4-844A2DD7B7F3\",\"packages\":[{\"networkname\":\"JCEX-日本专线\",\"referencenumber\":\"test05-2430226-792614\",\"pickupservice\":[],\"senderinformation\":[{\"sendername\":\"InterFocus Inc\",\"senderphone\":\"18362906318\",\"sendercountry\":\"CN\",\"sendercity\":\"ShenZhen\",\"sendertown\":\"Baoan\",\"senderaddress\":\"Bao'an District of Shenzhen City Shajing Town, Central Asia Silicon Valley A District B, 2nd Floor\"}],\"recipientinformation\":[{\"recipientname\":\"KANA KAWANO\",\"recipientphone\":\"08043292151\",\"recipientcountry\":\"JP\",\"recipientpostcode\":\"142-0062\",\"recipientcity\":\"shinagawa-ku\",\"recipientstate\":\"TOKYO\",\"recipientaddress\":\"1-7-14 koyama\"}],\"invoiceinformation\":[{\"chinesename\":\" \",\"englishname\":\"Banana Print Tassel Decor Sleeveless Dress for Little Girls\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":1.665,\"declarationamount\":1.665,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Beautiful Zip-up Hooded Cloud Jacket for Baby and Toddler Girl\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":2.8316666666667,\"declarationamount\":2.8316666666667,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Sweet Lace Trim Ruffled Long-sleeve Dress for Baby Girl and Girl\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":1.8316666666667,\"declarationamount\":1.8316666666667,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Classic Ruffle-sleeve Dress for Baby Girls\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":1.3316666666667,\"declarationamount\":1.3316666666667,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Fresh Floral Pattern Short-sleeve Dress for Baby and Toddler Girl\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":1.165,\"declarationamount\":1.165,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Elegant Backless Bow Lace Dress for Baby and Toddler Girl\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":1.9983333333333,\"declarationamount\":1.9983333333333,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"3-piece Sweet Ruffled Pink Top and Headband, Rip Jeans for Baby Girl/Girl\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":2.4983333333333,\"declarationamount\":2.4983333333333,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Pretty Floral Doll Collar Dress for Baby and Toddler Girl\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":0.83166666666667,\"declarationamount\":0.83166666666667,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Cheerful Animal Print Bow Dress for Baby and Toddler Girl\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":0.99833333333333,\"declarationamount\":0.99833333333333,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Baby/Kid's Pineapple Cotton Pants/Bottom (Unisex)\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":0.99833333333333,\"declarationamount\":0.99833333333333,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Sweet Cherry Print Ruffled Long-sleeve Dress for Baby Girl/Girl\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":1.665,\"declarationamount\":1.665,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Colorful Pear Print Tank Top for Baby and Toddler\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":1.165,\"declarationamount\":1.165,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Sweet Floral Pattern Sleeveless Dress for Baby and Toddler Girl\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":0.99833333333333,\"declarationamount\":0.99833333333333,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Baby Girl's Sweet Floral Printed Short-sleeve Dress in Blue\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":2.165,\"declarationamount\":2.165,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Cute Carrot Print Long-sleeve Pullover for Toddler and Baby\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":2.4983333333333,\"declarationamount\":2.4983333333333,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Lovely Floral Flounced Shoulder Dress for Baby and Toddler Girl\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":1.3316666666667,\"declarationamount\":1.3316666666667,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Sweet Floral Southwest Long-sleeve Dress for Baby Girls\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":3.3316666666667,\"declarationamount\":3.3316666666667,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Adorable Bear Design Hooded Fleece Coat for Baby\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":2.665,\"declarationamount\":2.665,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"3-piece Cute Ruffle Sleeves Bodysuit, Flamingo Print Pants and Headband for Baby Girl\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":1.9983333333333,\"declarationamount\":1.9983333333333,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Sweet Ruffled Striped Long-sleeve Dress for Girls\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":1.665,\"declarationamount\":1.665,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Pretty Deer Print Short-sleeve Bodysuit for Baby Girl\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":1.665,\"declarationamount\":1.665,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Pretty Floral Pattern Short-sleeve Bodysuit for Baby Girl( Without Accessory)\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":1.8316666666667,\"declarationamount\":1.8316666666667,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Stylish Floral Print Bodysuit with Headband for Baby Girl\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":1.665,\"declarationamount\":1.665,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"2-piece Bright Stripes Floral Hooded Top and Pants for Baby Girl\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":1.665,\"declarationamount\":1.665,\"declarationcurrency\":\"USD\"},{\"chinesename\":\" \",\"englishname\":\"Pretty Striped Floral Hoodie and Pants Set for Baby Girl\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":1.665,\"declarationamount\":1.665,\"declarationcurrency\":\"USD\"}],\"weightinformation\":[{\"weightmethod\":\"1\",\"totalpackages\":\"1\",\"itemtype\":\"2\",\"totalweight\":\"3.343\"}],\"detailpackage\":[{\"actualweight\":\"3.343\",\"length\":\"0\",\"width\":\"0\",\"height\":\"0\",\"volume\":\"0\",\"volumeweight\":\"0\",\"item\":[]}],\"specialservice\":[{\"servicename\":\"1\",\"costamount\":\"0\",\"costcurrency\":null,\"description\":\"\"}]}]}}";

		String fsy2 = "{\"Data\":{\"customerid\":\"04D289BA-0292-495F-AA03-FE5BB33DE38F\",\"apiplatform\":\"店小秘\",\"jcexkey\":\"NET\",\"customer\":\"JCTEST\",\"packages\":[{\"productid\":\"PK0877\",\"expressnetwork\":null,\"waybillnumber\":null,\"transfernumber\":null,\"feenotes\":null,\"operationnotestime\":null,\"specialservice\":[{\"servicename\":null,\"costamount\":0,\"costcurrency\":null,\"description\":null}],\"networkname\":null,\"productname\":\"佳成专线\",\"inputtime\":null,\"inputname\":null,\"operationnotes\":null,\"invoiceinformation\":[{\"chinesename\":\"猫砂盆\",\"englishname\":\"Litter Box\",\"hscode\":\"3926909090\",\"inpieces\":1,\"unitpriceamount\":0.0,\"declarationamount\":20.0,\"declarationcurrency\":\"USD\",\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null}],\"recipientinformation\":[{\"recipientname\":\"三宅是修\",\"recipientphone\":\"09023553000\",\"recipientcountry\":\"JP\",\"recipientpostcode\":\"612-0875\",\"recipientcity\":\"京都府\",\"recipientstate\":\"京都府\",\"recipienttown\":\"\",\"recipientaddress\":\"京都市伏見区深草枯木町\",\"recipientcompany\":\"三宅是修\",\"recipientemail\":\"\",\"recipientdutyparagraph\":null}],\"referencenumber\":\"XM6KXL010000R1\",\"returnreason\":null,\"receivewarehouse\":null,\"returnsign\":null,\"servicetype\":null,\"estimatedfee\":null,\"operationnotesperson\":null,\"feenotestime\":null,\"branchoffice\":null,\"waybillcompleted\":null,\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":1,\"totalweight\":15.0,\"itemtype\":\"PAK袋\"}],\"detailpackage\":[{\"actualweight\":15.0,\"child_number\":null,\"length\":0,\"width\":0,\"height\":0,\"volume\":0,\"volumeweight\":0,\"item\":[]}],\"feenotesperson\":null,\"paymentmethod\":null,\"returnperson\":null,\"senderinformation\":[{\"sendername\":\"ninglonggen\",\"senderchinesename\":\"pidan\",\"sendercompany\":\"pidan\",\"senderphone\":\"13962316234\",\"sendercountry\":\"CN\",\"sendercity\":\"Suzhoushi\",\"sendertown\":\"\",\"senderpostcode\":\"215500\",\"senderaddress\":\"Warehousngshu Suzhou Jiangsu Province\",\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,\"senderproxycode\":null}],\"returntime\":null,\"status\":null}]}}";

		String costs = "{\"customercode\":\"SZ9060\",\"countrycode\":\"GB\",\"city\":\"\",\"postcode\":\"\",\"pieces\":\"1\",\"grossweight\":\"2\",\"volumeweight\":\"\",\"cargotypename\":\"\",\"extraservicecode\":\"\"}";

		String royal = "{\"Data\":{\"apiplatform\":\"amazon11\",\"jcexkey\":\"NET2\",\"customerid\":\"17112413-3164-11e8-a361-70106fada4c2\",\"customer\":\"YW6201\",\"packages\":[{\"paymentmethod\":\"PP\",\"branchoffice\":\"\",\"waybillnumber\":\"\",\"referencenumber\":\"YW6201-60465382\",\"transfernumber\":\"\",\"productid\":\"PK0746\",\"productname\":\"\",\"servicetype\":\"\",\"pickupservice\":[{\"pickupaddress\":\"\",\"pickupcontacts\":\"\",\"pickupcontactnumber\":\"\",\"pickupstaff\":\"\",\"pickupamount\":\"\",\"operatingcost\":\"\",\"expresscompany\":\"\",\"expressnumber\":\"\",\"deliverypayment\":\"\",\"pickupRemark\":\"\",\"estimatedtimeofarrival\":\"\",\"receivewarehouseaddress\":\"\",\"receivewarehousecontact\":\"\",\"receivewarehousephone\":\"\"}],\"expressnetwork\":\"\",\"estimatedfee\":\"\",\"feenotes\":\"\",\"feenotesperson\":\"\",\"feenotestime\":\"\",\"operationnotes\":\"\",\"operationnotesperson\":\"\",\"operationnotestime\":\"\",\"returnsign\":\"\",\"returnperson\":\"\",\"returntime\":\"\",\"returnreason\":\"\",\"receivewarehouse\":\"\",\"status\":\"\",\"waybillcompleted\":\"\",\"inputname\":\"\",\"inputtime\":\"\",\"senderinformation\":[{\"sendername\":\"\",\"senderchinesename\":\"\",\"sendercompany\":\"\",\"senderphone\":\"\",\"sendercountry\":\"\",\"sendercity\":\"\",\"sendertown\":\"\",\"senderpostcode\":\"\",\"senderaddress\":\"\",\"sendercustomsregistrationcode\":\"\",\"sendercustomsoperatingunits\":\"\",\"senderproxycode\":\"\",\"senderemail\":\"\"}],\"recipientinformation\":[{\"recipientname\":\"Monja Michel\",\"recipientphone\":\"063184230018\",\"recipientcountry\":\"DE\",\"recipientpostcode\":\"67657\",\"recipientcity\":\"Kaiserslautern\",\"recipientstate\":\"Rheinland-Pfalz\",\"recipienttown\":\"Kaiserslautern\",\"recipienthousenumber\":\"\",\"recipientaddress\":\"Daniel-H?berle-Str. 17 \",\"recipientcompany\":\"Monja Michel\",\"recipientdutyparagraph\":\"\",\"recipientemail\":\"0kwgc4hpymg16cz@marketplace.amazon.de\"}],\"invoiceinformation\":[{\"chinesename\":\"卫衣\",\"englishname\":\"Hoodie\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":3.00,\"declarationamount\":3.00,\"declarationcurrency\":\"USD\",\"materialquality\":\"95%涤+5%氨纶\",\"purpose\":\"\",\"measurementunit\":\"\",\"specificationmodel\":\"\"}],\"weightinformation\":[{\"weightmethod\":\"半抛\",\"totalpackages\":\"1\",\"itemtype\":\"包裹\",\"totalweight\":\"0.28\",\"totalvolumeweight\":\"10\",\"totalchargeableweight\":\"0.28\"}],\"detailpackage\":[{\"actualweight\":\"0.28\",\"fbanumber\":\"\",\"length\":\"10\",\"width\":\"10\",\"height\":\"10\",\"volume\":\"100\",\"volumeweight\":\"10\",\"item\":[{\"englishname\":\"Hoodie\",\"hscode\":\"\",\"inpieces\":1,\"unitpriceamount\":3.00,\"unitpriceweight\":0.28,\"declarationamount\":3.00,\"declarationcurrency\":\"USD\"}]}],\"specialservice\":[{\"servicename\":\"\",\"costamount\":\"0\",\"costcurrency\":\"\",\"description\":\"\"}]}]}}";
		
		
		String ssy = "{\"Data\":{\"apiplatform\":\"佳成国际平台\",\"jcexkey\":\"\",\"customerid\":\"27110432-1FC9-49B3-B318-13754B23E9D1\",\"customer\":\"SH0112\",\"packages\":[{\"waybillnumber\":\"\",\"platnumber\":\"\",\"referencenumber\":\"ZX04121249861\",\"productid\":\"PK1032\",\"productname\":\"null\",\"servicetype\":\"null\",\"pickupservice\":\"[]\",\"expressnetwork\":\"null\",\"estimatedfee\":\"null\",\"feenotes\":\"null\",\"feenotesperson\":\"null\",\"feenotestime\":\"null\",\"operationnotes\":\"null\",\"operationnotesperson\":\"null\",\"operationnotestime\":\"null\",\"returnsign\":\"null\",\"returnperson\":\"null\",\"returntime\":\"null\",\"returnreason\":\"null\",\"receivewarehouse\":\"null\",\"status\":\"null\",\"waybillcompleted\":\"null\",\"inputname\":\"null\",\"inputtime\":\"null\",\"senderinformation\":[{\"sendername\":\"\",\"senderchinesename\":\"\",\"sendercompany\":\"\",\"senderphone\":\"\",\"sendercountry\":\"\",\"sendertown\":\"\",\"senderaddress\":\"\",\"senderemail\":\"\",\"sendercustomsregistrationcode\":\"null\",\"sendercustomsoperatingunits\":\"null\",\"senderproxycode\":\"null\"}],\"recipientinformation\":[{\"recipientname\":\"MR. WALTER C. BROWN\",\"recipientphone\":\"0\",\"recipientcountry\":\"GB\",\"recipientpostcode\":\"EC1Y 8SY\",\"recipientcity\":\"LONDON\",\"recipientstate\":\"LONDON\",\"recipienttown\":\"\",\"recipienthousenumber\":\"null\",\"recipientaddress\":\"49 FEATHERSTONE STREET\",\"recipientcompany\":\"\",\"recipientemail\":\"\",\"recipientdutyparagraph\":\"null\"}],\"invoiceinformation\":[{\"chinesename\":\"鞋子\",\"englishname\":\"SHOE\",\"hscode\":\"\",\"inpieces\":\"1\",\"unitpriceamount\":\"5.0\",\"declarationamount\":\"5\",\"declarationcurrency\":\"USD\",\"materialquality\":\"null\",\"purpose\":\"null\",\"measurementunit\":\"null\",\"specificationmodel\":\"null\"}],\"weightinformation\":[{\"weightmethod\":\"null\",\"totalpackages\":\"1\",\"itemtype\":\"包裹\",\"totalweight\":\"1.000\"}],\"detailpackage\":[{\"actualweight\":\"1.000\",\"child_number\":\"\",\"length\":\"10.0\",\"width\":\"10.0\",\"height\":\"10.0\",\"volume\":\"0\",\"volumeweight\":\"0\",\"item\":[{\"englishname\":\"SHOE\",\"hscode\":\"\",\"inpieces\":\"1\",\"unitpriceamount\":\"5.0\",\"unitpriceweight\":\"1.000\",\"declarationamount\":\"5\",\"declarationcurrency\":\"USD\"}]}],\"specialservice\":[{\"servicename\":\"null\",\"costamount\":\"0\",\"costcurrency\":\"null\",\"description\":\"null\"}]}]}}";
		
		String ss = "{\"Data\":{\"apiplatform\":\"平台名称\",\"customer\":\"JCTEST\",\"customerid\":\"04D289BA-0292-495F-AA03-FE5BB33DE38F\",\"jcexkey\":\"NET\",\"packages\":[{\"detailpackage\":[{\"volume\":\"0\",\"item\":[{\"declarationcurrency\":\"USD\",\"englishname\":\"1pair Magnetic Silicone Slimming Toe Ring for...\",\"unitpriceweight\":0.012,\"inpieces\":1,\"unitpriceamount\":0.24,\"declarationamount\":0.24}],\"child_number\":\"\",\"actualweight\":0.012,\"volumeweight\":\"0\",\"length\":15.0,\"width\":9.0,\"height\":1.5}],\"invoiceinformation\":[{\"declarationcurrency\":\"USD\",\"englishname\":\"1pair Magnetic Silicone Slimming Toe Ring for...\",\"inpieces\":1,\"unitpriceamount\":0.24,\"chinesename\":\"1双磁石硅胶足部按摩脚趾环脂肪燃烧减肥瘦身指环\",\"declarationamount\":0.24,\"measurementunit\":\"PCE\"}],\"pickupservice\":[],\"platnumber\":\"\",\"productid\":\"PK0044\",\"productname\":\"华南-阿联酋专线(含税)-普货\",\"recipientinformation\":[{\"recipientstate\":\"Western Cape\",\"recipientcountry\":\"South Africa\",\"recipientpostcode\":\"7441\",\"recipientemail\":\"\",\"recipientcity\":\"Cape Town\",\"recipientaddress\":\"Sienna Drive Burgundy Estate The Palm Flat 8\",\"recipientname\":\"Lawrence Feder\",\"recipientcompany\":\"Lawrence Feder\",\"recipientphone\":\"0649048844\"}],\"referencenumber\":\"PK52412310055542\",\"senderinformation\":[{\"sendername\":\"chenli\",\"senderchinesename\":\"HUANJINKEJI\",\"sendercountry\":\"CN\",\"senderphone\":\"15818701103\",\"senderpostcode\":\"518000\",\"senderaddress\":\"5th Floor, Dizuang Digital Technology Park, No. 9 Jia Zi Tong, Guangming New District, Shenzhen\",\"sendercompany\":\"HUANJINKEJI\",\"sendercity\":\"Shenzhen\"}],\"specialservice\":[{\"costamount\":0}],\"waybillnumber\":\"\",\"weightinformation\":[{\"itemtype\":\"4\",\"totalweight\":0.012,\"totalpackages\":\"1\"}]}]}}";
		
		String strxml="{\" customer\":\"S\",\"labeltype\":\"10_15\",\"billno\":\"2006111262\"}";
		
		String wish2 = "{\"sname\":\"REGIESTERED\",\"parcel\":{\"weight\":0.15,\"categories_en\":[],\"price_unit\":\"dollar\",\"parcel_type\":1,\"dimension_unit\":\"cm\",\"category_en\":\"\",\"declare_value\":1.2,\"price_currency\":\"usd\",\"description_local\":\"\\\\u745c\\\\u4f3d\\\\u88e4\",\"width\":null,\"weight_unit\":\"kg\",\"categories_local\":[],\"category_local\":null,\"description_en\":\"Yoga pants\",\"height\":null,\"has_battery\":false,\"length\":null,\"product_list\":[{\"weight\":0.15,\"categories_en\":[],\"height\":null,\"product_url\":null,\"origin_country\":\"CN\",\"category_en\":\"\",\"origin_country_code\":\"CHN\",\"has_metal\":false,\"sku\":null,\"description_local\":\"\\\\u745c\\\\u4f3d\\\\u88e4\",\"is_liquid\":false,\"unit_en\":null,\"is_flammable\":false,\"width\":null,\"country_of_origin_code\":null,\"categories_local\":[],\"category_local\":null,\"is_powder\":false,\"description_en\":\"Yoga pants\",\"name_local\":null,\"image_urls\":[],\"wish_product_id\":null,\"name_en\":null,\"wish_transaction_id\":null,\"unit_local\":null,\"has_battery\":false,\"value\":1.2,\"length\":null,\"image_url\":\"https:\\\\/\\\\/www.wish.com\\\\/c\\\\/561f48726475cc5873cda03e\",\"piece\":null,\"quantity\":1}]},\"order_time\":\"2018-05-30T12:16:47.206Z\",\"order_id\":\"5b0e962fb0b70309229f6f4e\",\"timestamp\":\"2018-05-30T12:54:29.089Z\",\"paid_with_wish\":false,\"is_test\":true,\"operation_center_code\":null,\"return_info\":{\"return_action_out_country\":0,\"return_action_in_country\":2},\"pickup_type\":1,\"sender\":{\"company\":null,\"zipcode\":\"310000\",\"address_local\":{\"province\":\"Guangdong\",\"country\":\"\\\\u4e2d\\\\u56fd\",\"name\":\"BAIYING SHENZHEN TRADING COMPANY LIMITED\",\"street_address1\":\"Floor 5, Building A, No.10 of East Area Weikangde Industrial Park Shangxue Technology City Longgang\",\"city\":\"Shenzhen\"},\"phone\":\"15989136708\",\"country_code\":\"CHN\",\"address_en\":{\"province\":\"Guangdong\",\"country\":\"China\",\"name\":\"Baiying shenzhen trading company limited\",\"street_address1\":\"Floor 5, building a, no.10 of east area weikangde industrial park shangxue technology city longgang\",\"city\":\"Shenzhen\"},\"email\":null},\"carrier_code\":50,\"otype\":\"50-1\",\"payment_account\":{\"username\":\"shiqi\",\"phone_number\":\"12345\",\"contact_name\":\"shiqi\",\"id\":\"591185160e36e6d296fbddaf\",\"email\":\"shiqi@contextlogic.com\"},\"pickup\":{\"company\":null,\"zipcode\":null,\"address_local\":{\"province\":\"\\\\u5e7f\\\\u4e1c\\\\u7701\",\"country\":\"\\\\u4e2d\\\\u56fd\",\"name\":\"\\\\u5468\\\\u4e16\\\\u68ee\",\"street_address1\":\"\\\\u5e7f\\\\u4e1c\\\\u7701\\\\u4e2d\\\\u5c71\\\\u5e02\\\\u4e09\\\\u89d2\\\\u9547\\\\u91d1\\\\u4e09\\\\u5927\\\\u9053\\\\u4e1c\\\\u4e09\\\\u5341\\\\u4e5d\\\\u53f7\\\\u4e4b\\\\u4e00\\\\u5229\\\\u6717\\\\u8fbe\\\\u4ed3\\\\u5e93\\\\uff08\\\\u8bda\\\\u6cf0\\\\u5bf9\\\\u9762\\\\uff09\",\"city\":\"\\\\u4e2d\\\\u5c71\\\\u5e02\"},\"phone\":\"13763813216\",\"country_code\":\"CHN\",\"address_en\":{\"province\":\"Guangdongsheng\",\"country\":\"China\",\"name\":\"Zhoushisen\",\"street_address1\":\"Guangdongshengzhongshanshisanjiaozhenjinsandadaodongsanshijiuhaozhiyililangdacangku\\\\uff08chengtaiduimian\\\\uff09\",\"city\":\"Zhongshanshi\"},\"email\":null},\"tracking_id\":\"WOSP001680315495GBR\",\"receiver\":{\"company\":null,\"zipcode\":\"AA9A 9AA\",\"address_local\":{\"province\":\"New Jersey\",\"country\":\"\\\\u82f1\\\\u56fd\",\"name\":\"Carlota Lopez\",\"street_address1\":\"54 ann st apt#1\",\"city\":\"Passaic\"},\"phone\":\"11111111\",\"country_code\":\"GBR\",\"address_en\":{\"province\":\"New jersey\",\"country\":\"United kingdom\",\"name\":\"Carlota lopez\",\"street_address1\":\"54 ann st apt#1\",\"city\":\"Passaic\"},\"email\":null},\"carry_type\":2,\"api_key\":\"6294daf1-5293-11e8-b5e7-6c92bf20e5cd\",\"stype\":1,\"sys_user\":\"wishshiqi43547S\"}";
		
		
		String ceshi = "{\"pickup_type\":2,\"carry_type\":2,\"sname\":\"REGISTERED\"," +
				"\"parcel\":{\"price_currency\":\"usd\",\"has_battery\":false,\"categories_local\":[]," +
				"\"category_local\":null,\"weight\":null,\"categories_en\":[],\"price_unit\":\"dollar\"," +
				"\"parcel_type\":1,\"description_en\":\"Book\",\"dimension_unit\":\"cm\",\"height\":null," +
				"\"width\":null,\"length\":null," +
				"\"product_list\":[{\"weight\":0.5,\"categories_en\":[],\"height\":null,\"product_url\":null," +
				"\"country_of_origin_code\":null,\"category_en\":\"\",\"origin_country_code\":\"CHN\"," +
				"\"has_metal\":false,\"sku\":null,\"wish_transaction_id\":null,\"is_liquid\":false,\"unit_en\":null," +
				"\"is_flammable\":false,\"width\":null,\"origin_country\":\"cn\",\"categories_local\":[]," +
				"\"category_local\":null,\"is_powder\":false,\"description_en\":\"Book\",\"name_local\":null," +
				"\"image_urls\":[],\"wish_product_id\":null,\"name_en\":null,\"description_local\":\"\\\\u4e66\"," +
				"\"unit_local\":null,\"has_battery\":false,\"value\":3.0,\"length\":null,\"image_url\":null," +
				"\"piece\":null,\"quantity\":2}],\"category_en\":\"\",\"description_local\":\"\\\\u4e66\"," +
				"\"declare_value\":6.0,\"weight_unit\":\"kg\"},\"order_time\":\"2018-05-04T04:01:53.361Z\"," +
				"\"order_id\":\"5aebdb3177a4411ad28d215c\",\"timestamp\":\"2018-05-04T04:01:56.278Z\"," +
				"\"carrier_code\":50,\"pickup\":{\"company\":null,\"zipcode\":null,\"email\":null," +
				"\"phone\":\"13299267581\",\"country_code\":\"CHN\",\"address_en\":{\"province\":\"Shanghai\"," +
				"\"country\":\"China\",\"name\":\"Mashiqi\"," +
				"\"street_address1\":\"Nanjingxilu1515haojializhongxin2zuo18lou\",\"city\":\"Shanghai\"}," +
				"\"address_local\":{\"province\":\"\\\\u4e0a\\\\u6d77\",\"country\":\"\\\\u4e2d\\\\u56fd\"," +
				"\"name\":\"\\\\u9a6c\\\\u8bd7\\\\u7426\"," +
				"\"street_address1\":\"\\\\u5357\\\\u4eac\\\\u897f\\\\u8def1515\\\\u53f7\\\\u5609\\\\u91cc\\\\u4e2d\\\\u5fc33\\\\u5ea725\\\\u697c\",\"city\":\"\\\\u4e0a\\\\u6d77\"}}," +
				"\"is_test\":true,\"otype\":\"50-1\",\"sys_user\":\"wishshiqi43547S\",\"stype\":1," +
				"\"tracking_id\":\"WOSP000000042085GBR\",\"receiver\":{\"company\":null,\"zipcode\":\"100101\",\"email\":null," +
				"\"phone\":\"111\",\"country_code\":\"GBR\",\"address_en\":{\"province\":\"Provice\",\"country\":\"United states\"," +
				"\"name\":\"Joycejiatest1\",\"street_address1\":\"Street1\",\"city\":\"City\"}," +
				"\"address_local\":{\"province\":\"Provice\",\"country\":\"\\\\u7f8e\\\\u56fd\",\"name\":\"JoyceJiaTest1\"," +
				"\"street_address1\":\"Street1\",\"city\":\"City\"}},\"operation_center_code\":null," +
				"\"api_key\":\"04D289BA-0292-495F-AA03-FE5BB33DE38F\"," +
				"\"payment_account\":{\"username\":\"shiqi\",\"phone_number\":\"12345\",\"contact_name\":\"shiqi\",\"id\":\"591185160e36e6d296fbddaf\",\"email\":\"gaomo@wish.com\"},\"return_info\":{\"return_action_out_country\":0,\"return_action_in_country\":2},\"sender\":{\"company\":null,\"zipcode\":\"200011\",\"email\":null,\"phone\":\"1315341252\",\"country_code\":\"CHN\",\"address_en\":{\"province\":\"Shanghai\",\"country\":\"China\",\"name\":\"Shiqi ma\",\"street_address1\":\"Jingan district, jiali center, building 3, fl25\",\"city\":\"Shanghai\"},\"address_local\":{\"province\":\"Shanghai\",\"country\":\"\\\\u4e2d\\\\u56fd\",\"name\":\"Shiqi Ma\",\"street_address1\":\"Jingan district, Jiali center, Building 3, fl25\",\"city\":\"Shanghai\"}}}";
		
		String wish = "{\"sname\":\"sdad\",\"parcel\":{\"weight\":0.6,\"categories_en\":[],\"price_unit\":\"dollar\"," +
				"\"parcel_type\":1,\"dimension_unit\":\"cm\",\"category_en\":\"\",\"declare_value\":1.2," +
				"\"price_currency\":\"usd\",\"description_local\":\"\\\\u745c\\\\u4f3d\\\\u88e4\",\"width\":null," +
				"\"weight_unit\":\"kg\",\"categories_local\":[],\"category_local\":null," +
				"\"description_en\":\"Yoga pants\",\"height\":null,\"has_battery\":false,\"length\":null," +
				"\"product_list\":[{\"weight\":0.15,\"categories_en\":[],\"height\":null,\"product_url\":null," +
				"\"origin_country\":\"CN\",\"category_en\":\"\",\"origin_country_code\":\"CHN\",\"has_metal\":false," +
				"\"sku\":null,\"description_local\":\"\\\\u745c\\\\u4f3d\\\\u88e4\",\"is_liquid\":false," +
				"\"unit_en\":null,\"is_flammable\":false,\"width\":null,\"country_of_origin_code\":null," +
				"\"categories_local\":[],\"category_local\":null,\"is_powder\":false," +
				"\"description_en\":\"Yoga pants\",\"name_local\":null,\"image_urls\":[],\"wish_product_id\":null," +
				"\"name_en\":null,\"wish_transaction_id\":null,\"unit_local\":null,\"has_battery\":false," +
				"\"value\":1.2,\"length\":null,\"image_url\":\"5873cda03e\",\"piece\":null,\"quantity\":1}]}," +
				"\"order_time\":\"2018-05-30T12:16:47.206Z\",\"order_id\":\"5b0e962fb0b70309229f6f4e\"," +
				"\"timestamp\":\"2018-05-30T12:54:29.089Z\",\"paid_with_wish\":false,\"is_test\":true," +
				"\"operation_center_code\":null," +
				"\"return_info\":{\"return_action_out_country\":0," +
				"\"return_action_in_country\":2}," +
				"\"pickup_type\":1,\"sender\":{\"company\":\"sdada\"," +
				"\"zipcode\":\"310000\",\"address_local\":{\"province\":\"Guangdong\"," +
				"\"country\":\"\\\\u4e2d\\\\u56fd\",\"name\":\"BAIYING\"," +
				"\"street_address1\":\"Floor 5, Build Longgang\",\"city\":\"Shenzhen\"}," +
				"\"phone\":\"15989136708\",\"country_code\":\"CHN\",\"address_en\":{\"province\":\"Guangdong\"," +
				"\"country\":\"China\",\"name\":\"Baiying\",\"street_address1\":\"Flotechnggang\"," +
				"\"city\":\"Shenzhen\"},\"email\":\"shiqi@contextlogic.com\"},\"carrier_code\":50,\"otype\":\"50-1\"," +
				"\"payment_account\":{\"username\":\"shiqi\",\"phone_number\":\"12345\",\"contact_name\":\"shiqi\"," +
				"\"id\":\"591185160e36e6d296fbddaf\",\"email\":\"shiqi@contextlogic.com\"}," +
				"\"pickup\":{\"company\":\"sda\",\"zipcode\":null,\"address_local\":{\"province\":\"\\7701\"," +
				"\"country\":\"\\\\u4e2d\\\\u56fd\",\"name\":\"\\\\u5468\",\"street_address1\":\"\\\\uff09\"," +
				"\"city\":\"\\\\u4e2d\\\\u5c71\\\\u5e02\"},\"phone\":\"13763813216\",\"country_code\":\"CHN\"," +
				"\"address_en\":{\"province\":\"Guangdongsheng\",\"country\":\"China\",\"name\":\"Zhoushisen\"," +
				"\"street_address1\":\"Guangdi\",\"city\":\"Zhongshanshi\"},\"email\":\"shiqi@contextlogic.com\"}," +
				"\"tracking_id\":\"WOSP001680315495GBR\"," +
				"\"receiver\":{\"company\":\"\",\"zipcode\":\"AA9A 9AA\"," +
				"\"address_local\":{\"province\":\"New Jersey\",\"country\":\"\\\\u82f1\\\\u56fd\"," +
				"\"name\":\"Carlota Lopez\",\"street_address1\":\"54 ann st apt#1\",\"city\":\"Passaic\"}," +
				"\"phone\":\"11111111\",\"country_code\":\"GBR\",\"address_en\":{\"province\":\"New jersey\"," +
				"\"country\":\"United kingdom\",\"name\":\"Carlota lopez\",\"street_address1\":\"54 ann st apt#1\"," +
				"\"city\":\"Passaic\"},\"email\":\"shiqi@contextlogic.com\"},\"carry_type\":2," +
				"\"api_key\":\"04D289BA-0292-495F-AA03-FE5BB33DE38F\",\"stype\":1,\"sys_user\":\"wishshiqi43547S\"}";
        
		
		String deuceshi = "{\"Data\":{\"apiplatform\":\"JC\",\"jcexkey\":\"NET2\",\"customerid\":\"C785E4C8-9E17-4858-AA86-E2F214FBFEC8\",\"customer\":\"SH0302\",\"packages\":[{\"paymentmethod\":\"PP\",\"branchoffice\":null,\"waybillnumber\":\"\",\"platnumber\":\"\",\"referencenumber\":\" IRUK60699\",\"transfernumber\":null,\"productid\":\"PK1033\",\"productname\":\"\",\"servicetype\":null,\"pickupservice\":[],\"expressnetwork\":null,\"estimatedfee\":null,\"feenotes\":null,\"feenotesperson\":null,\"feenotestime\":null,\"operationnotes\":null,\"operationnotesperson\":null,\"operationnotestime\":null,\"returnsign\":null,\"returnperson\":null,\"returntime\":null,\"returnreason\":null,\"receivewarehouse\":null,\"status\":null,\"waybillcompleted\":null,\"inputname\":null,\"inputtime\":null,\"senderinformation\":[{\"sendername\":\"Suzhou JiSu Mdt InfoTech Ltd\",\"senderchinesename\":\"STARPOWERTRADINGCOLTD\",\"sendercompany\":\"STARPOWERTRADINGCOLTD\",\"senderphone\":\"862163082079\",\"sendercountry\":\"CN\",\"sendercity\":\"hangzhou\",\"sendertown\":\"\",\"senderpostcode\":\"310000\",\"senderaddress\":\"NO19LANE1058ROOM102SHANGHAI\",\"senderemail\":\"\",\"sendercustomsregistrationcode\":null,\"sendercustomsoperatingunits\":null,\"senderproxycode\":null}],\"recipientinformation\":[{\"recipientname\":\"Isabel Falk\",\"recipientphone\":\"05258931655\",\"recipientcountry\":\"DE\",\"recipientpostcode\":\"33154\",\"recipientcity\":\"Salzkotten\",\"recipientstate\":\"Nordrhein-Westfalen\",\"recipienttown\":\"\",\"recipienthousenumber\":null,\"recipientaddress\":\"Pastor-Epke-Str. 11\",\"recipientcompany\":\"\",\"recipientemail\":\"\",\"recipientdutyparagraph\":null}],\"invoiceinformation\":[{\"chinesename\":\"女士衣服\",\"englishname\":\"Women clothes\",\"hscode\":\"6204430090\",\"inpieces\":\"1\",\"unitpriceamount\":\"15.00\",\"declarationamount\":\"15\",\"declarationcurrency\":\"USD\",\"materialquality\":null,\"purpose\":null,\"measurementunit\":null,\"specificationmodel\":null}],\"weightinformation\":[{\"weightmethod\":null,\"totalpackages\":\"1\",\"itemtype\":\"1\",\"totalweight\":\"1.367\"}],\"detailpackage\":[{\"actualweight\":\"1.367\",\"child_number\":\"\",\"length\":\"1\",\"width\":\"1\",\"height\":\"1\",\"volume\":\"1\",\"volumeweight\":\"0\",\"item\":[{\"englishname\":\"Women clothes\",\"hscode\":\"6204430090\",\"inpieces\":\"1\",\"unitpriceamount\":\"15.00\",\"unitpriceweight\":\"1.367\",\"declarationamount\":\"15\",\"declarationcurrency\":\"USD\"}]}],\"specialservice\":[{\"servicename\":null,\"costamount\":0,\"costcurrency\":null,\"description\":null}]}]}}";
		
		String reqjson = "{\"api_key\":\"JHBia2RmMiQxMDAkYXUyOU53WWdSTWg1ai9GLkQ0SHd2ZyRBeS9rSWJhN2g3NHY0RElvcVl0VWFoZE1nOWs=\",\"tracking_id\":\"WOSP000000041861GBR\",\"carrier_code\":50,\"carry_type\":1,\"pickup_info\":{\"status\":0,\"message\":\"puckup success\",\"timestamp\":\"2018-05-14T16:41:04:000Z\",\"logistics_order_code\":\"877386683\",\"operation_center_code\":\"SC-SH\",\"has_battery\":false,\"weight\":0.5}}";
		
		String decode1 = URLEncoder.encode(BONDED, "UTF-8");//BONDED
		Base64 base64 = new Base64();
		byte[] base64Bs = base64.encode(decode1.getBytes("UTF-8"));
		String encodeParam = new String(base64Bs, "UTF-8");
		// System.out.println("==" + encodeParam);
		// String decode1 = URLEncoder.encode(data1, "UTF-8");
		
		
		
		String result = http(url,"5","sdad");
//		 String result = http(url, "geterplabels", encodeParam);
//		 String result = httptwo(url, wish);
        System.out.println(result);
		// String result = http(url, service, data_body);
		// new String(result.getBytes("ISO-8859-1"),"utf-8")
//		System.out.println("地址         "+address+"    "+result);
		// System.out.println(data9);
	}

	private static String http(String httpUrl, String service, String data_body)
			throws JSONException {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		try {

			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);// 是否输入参数
//			 connection.addRequestProperty("Accept",
//			 "application/json;charset=UTF-8");
			// connection.setUseCaches(false);
			 connection.setRequestProperty("Content-type",
			 "application/x-www-form-urlencoded");

			StringBuffer params = new StringBuffer();
			params.append("service=").append(service).append("&data_body=")
					.append(data_body);
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

	private static String httptwo(String httpUrl, String json) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);// 是否输入参数
			// connection.addRequestProperty("Accept",
			// "application/json;charset=UTF-8");
			// connection.setUseCaches(false);
			// connection.setRequestProperty("Content-type",
			// "application/x-java-serialized-object");

			DataOutputStream dos = new DataOutputStream(
					connection.getOutputStream());
			dos.writeBytes(json);

			// StringBuffer params = new StringBuffer();
			// params.append(json);

			connection.connect();
			// connection.getOutputStream().write(params.toString().getBytes());
			InputStream is;
			try {
				is = connection.getInputStream();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				is = connection.getErrorStream();
			}
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//			reader = new BufferedReader(new InputStreamReader(is));
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

	public static void main(String[] args) throws Exception {
		TestorderForecasts.searchOrderInfo();
	}

}
