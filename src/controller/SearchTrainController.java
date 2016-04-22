package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import utils.MyX509TrustManager;


@Controller
public class SearchTrainController implements X509TrustManager
{

	private static String QUERY_RUL = "https://kyfw.12306.cn/otn/lcxxcx/query";

	@RequestMapping(value = "searchTrain", method = RequestMethod.POST)
	public 
	@ResponseBody String  searchTrain(HttpServletRequest request/**, HttpServletResponse response, PrintWriter pw*/)
	{
		StringBuffer sb = new StringBuffer();
		String from_Station = request.getParameter("fromStationText"); 
		String to_station = request.getParameter("toStationText"); 
		String queryDate = request.getParameter("train_start_date"); 
		String purpose_codes = request.getParameter("purpose_codes");  
		try
		{
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			String param = "?purpose_codes=" + purpose_codes + "&queryDate=" + queryDate + "&from_station=" + from_Station + "&to_station=" + to_station;
			System.out.println("URL:"+QUERY_RUL + param);
			URL url = new URL(QUERY_RUL + param);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setSSLSocketFactory(ssf);
			InputStreamReader in = new InputStreamReader(con.getInputStream(), "utf-8");
			BufferedReader bfreader = new BufferedReader(in);
			String line = "";
			while ((line = bfreader.readLine()) != null)
			{
				sb.append(line);
			}
			System.out.println(sb.toString());
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString();
	}

	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException
	{
		// TODO Auto-generated method stub
	}

	@Override
	public X509Certificate[] getAcceptedIssuers()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
