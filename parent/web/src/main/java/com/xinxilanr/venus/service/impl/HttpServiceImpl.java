/**
 * 
 */
package com.xinxilanr.venus.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xinxilanr.venus.service.HttpService;

/**
 * @author norris
 *
 */
@Component
public class HttpServiceImpl implements HttpService {
	private static final Logger logger = LoggerFactory.getLogger(HttpServiceImpl.class);
	@Value("${google.recaptcha.secretkey}")
	private String recaptchaSecretKey;
	@Override
	public boolean verifyRecaptcha(String recaptchaResponse) {
		return verifyRecaptcha(recaptchaResponse, null);
	}
	@Override
	public boolean verifyRecaptcha(String recaptchaResponse, String endUserIp) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost("https://www.google.com/recaptcha/api/siteverify");
			List<NameValuePair> params = new ArrayList<>();
			params.add(new BasicNameValuePair("secret", recaptchaSecretKey));
			params.add(new BasicNameValuePair("response", recaptchaResponse));
			Optional.ofNullable(endUserIp).ifPresent(e -> params.add(new BasicNameValuePair("remoteip", endUserIp)));
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			
			CloseableHttpResponse response = httpclient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
				return (Boolean)new ObjectMapper().readValue(response.getEntity().getContent(), HashMap.class).get("success");
			}
		} catch (Exception e) {
			logger.error("recaptcha verification", e);
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				logger.error("recaptcha verification, closing http client.", e);
			}
		}
		return false;
	}
}
