package com.vcmdevelop.analytics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.vcmdevelop.analytics.info.AnalyticsInfo;
import com.vcmdevelop.analytics.setup.AnalyticsSetupData;

/**
 * Classe responsável por facilitar o inicio do envio das estatisticas para o Google Analytics. Os envios serão enviados
 * sequencialmente, ficando na fila caso se acomule.
 *
 * <pre>
 * Ex: a primeira vez, de preferencia quando a aplicação subir
 * AnalyticsTracker.init("domain.com", "UA-XXXXXXX-X", "USER");
 *
 * Toda vez que desejar monitorar algo:<br>
 * AnalyticsTracker.send(new AnalyticsPageTrackingBuilder().setRequest(request)
 * 			.setLocale(locale).setPage("home").setTitle("Feed").build());
 * </pre>
 *
 * @author Victor
 *
 */
public class AnalyticsTracker {

	private static final Logger log = Logger.getLogger(AnalyticsTracker.class);

	private static ExecutorService pool;

	public static void send(final AnalyticsInfo analyticsInfo) {
		try {
			if (pool == null) {
				final Logger log = Logger.getLogger(AnalyticsTracker.class);
				log.info("TrackingId not defined. Please access the init method!");
				return;
			}
			final AnalyticsSender analyticsSender = new AnalyticsSender(analyticsInfo);
			pool.execute(analyticsSender);
		} catch (final Throwable e) {
			if (e.getMessage().contains("org/apache/http/conn/HttpClientConnectionManager")) {
				log.error("Verify org.apache.httpcomponents:httpclient dependency!", e);
			}
			log.error("Analytics send error!", e);
		}
	}

	/**
	 * Configura os valores do endereço do site e o ID do Google Analytics
	 *
	 * @param documentHostname
	 * @param trackingId
	 * @param userKey
	 */
	public static void init(final String documentHostname, final String trackingId) {
		AnalyticsSetupData.documentHostname = documentHostname;
		AnalyticsSetupData.trackingId = trackingId;

		if (pool == null) {
			pool = Executors.newSingleThreadExecutor();
		}
	}

	/**
	 * Finaliza o envio de requisições. As requisições que estão na fila serão finalizadas.
	 */
	public static void shutdown() {
		pool.shutdown();
	}
}
