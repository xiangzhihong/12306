package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import utils.MyX509TrustManager;

public class JunitTest {
	public static void main(String[] args) throws Exception {
		TrustManager[] tm = { new MyX509TrustManager() };
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());
		SSLSocketFactory ssf = sslContext.getSocketFactory();
		String urlStr = "https://kyfw.12306.cn/otn/lcxxcx/query?purpose_codes=ADULT&queryDate=2016-06-06&from_station=BXP&to_station=WHN";
		URL url = new URL(urlStr);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setSSLSocketFactory(ssf);
		InputStreamReader in = new InputStreamReader(con.getInputStream(),
				"utf-8");
		BufferedReader bfreader = new BufferedReader(in);
		StringBuffer sb = new StringBuffer();
		String line = "";
		while ((line = bfreader.readLine()) != null) {
			sb.append(line);
		}
		System.out.println(sb.toString());
	}
}
