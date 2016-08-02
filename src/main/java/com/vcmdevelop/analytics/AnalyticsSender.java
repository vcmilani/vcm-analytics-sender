package com.vcmdevelop.analytics;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.log4j.Logger;

import com.vcmdevelop.analytics.annotation.AnalyticsRequest;
import com.vcmdevelop.analytics.info.AnalyticsInfo;
import com.vcmdevelop.analytics.setup.AnalyticsSetupData;

/**
 * Responsável por enviar as estatisticas para o Google Analytics
 *
 * @author Victor
 *
 */
class AnalyticsSender implements Runnable {

	private static final HttpClient httpClient;
	static {
		//
		final List<Header> headers = new ArrayList<>();
		headers.add(new BasicHeader(HttpHeaders.CONNECTION, "close"));
		// headers.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING,
		// "gzip,deflate"));
		headers.add(new BasicHeader(HttpHeaders.CONTENT_TYPE, "text/xml"));
		// headers.add(new BasicHeader(HttpHeaders.HOST,
		// "brcwbcc53.sa.bm.net"));
		headers.add(new BasicHeader(HttpHeaders.USER_AGENT, "Apache-HttpClient/4.1.1"));
		httpClient = HttpClients.custom().setDefaultHeaders(headers)
		                        .setConnectionManager(new PoolingHttpClientConnectionManager()).build();
	}

	private final Logger log = Logger.getLogger(getClass());
	private final AnalyticsInfo _analyticsInfo;

	AnalyticsSender(final AnalyticsInfo analyticsInfo) {
		_analyticsInfo = analyticsInfo;
	}

	private String resolveAnalyticsInfo() throws IllegalArgumentException, IllegalAccessException {
		final StringBuilder requestMessage = new StringBuilder();

		final List<?> listClassTemp = ClassUtils.getAllSuperclasses(_analyticsInfo.getClass());
		final List<Class<?>> listClass = new ArrayList<>();

		for (final Object o : listClassTemp) {
			listClass.add((Class<?>) o);
		}
		listClass.add(_analyticsInfo.getClass());

		for (final Class<?> obj : listClass) {
			for (final Field field : obj.getDeclaredFields()) {
				// final Class<?> type = field.getType();
				// final String name = field.getName();
				final AnalyticsRequest analyticsRequest = field.getAnnotation(AnalyticsRequest.class);

				if (analyticsRequest != null) {
					if (requestMessage.toString().length() > 0)
						requestMessage.append("&");

					requestMessage.append(analyticsRequest.parameter());
					requestMessage.append("=");

					// requestMessage.append(String.valueOf(field.get(_analyticsInfo)));

					// TODO testar isso aqui!!!
					field.setAccessible(true);
					requestMessage.append(field.get(_analyticsInfo));
				}
			}
		}

		return requestMessage.toString();
	}

	@Override
	public void run() {
		try {
			if (validateSetup()) {
				final HttpPost httpPost = new HttpPost(AnalyticsSetupData.googleAnalyticsUrl);

				final String messageRequest = resolveAnalyticsInfo();
				if (messageRequest != null) {
					httpPost.setEntity(new StringEntity(messageRequest));
					final HttpResponse httpResponse = httpClient.execute(httpPost);

					String body;
					final ByteArrayOutputStream out = new ByteArrayOutputStream();
					try {
						httpResponse.getEntity().writeTo(out);
						body = out.toString();
					} finally {
						out.close();
					}

					log.debug(String.format("[Analytics] Response code %s, body %s",
					                        httpResponse.getStatusLine().getStatusCode(),
					                        body));
				} else {
					log.error("Analytics requestMessage null");
				}
			}
		} catch (final Exception e) {
			log.error("Analytics error", e);
		}
	}

	private boolean validateSetup() {
		boolean validate = true;
		if (StringUtils.isEmpty(AnalyticsSetupData.googleAnalyticsUrl)) {
			validate = false;
			log.info("[Analytics] URL para o Google não está definida. Analytics desabilitado.");
		} else if (StringUtils.isEmpty(AnalyticsSetupData.documentHostname)) {
			validate = false;
			log.info("[Analytics] URL do site cliente não está definido. Analytics desabilitado.");
		} else if (StringUtils.isEmpty(AnalyticsSetupData.trackingId)) {
			validate = false;
			log.info("[Analytics] Tracking ID não está definido. Analytics desabilitado.");
		}

		return validate;
	}

}
