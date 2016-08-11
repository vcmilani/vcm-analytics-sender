package com.vcmdevelop.analytics.info;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.vcmdevelop.analytics.annotation.AnalyticsRequest;
import com.vcmdevelop.analytics.objs.AnalyticsUser;

/**
 * User TIming Tracking
 *
 * @author victor
 *
 */
public class AnalyticsUserTimingTracking extends AnalyticsInfo {

	/**
	 * Timing hit type.
	 */
	@AnalyticsRequest(parameter = "t")
	private final String trackingType = "timing";

	/**
	 * Timing category. Ex: jsonLoader.
	 */
	@AnalyticsRequest(parameter = "utc")
	public String timingCategory;
	/**
	 * Timing variable. Ex: load
	 */
	@AnalyticsRequest(parameter = "utv")
	public String timingVariable;
	/**
	 * Timing time.
	 */
	@AnalyticsRequest(parameter = "utt")
	public int timingTime;
	/**
	 * Timing label. Ex: jQuery
	 */
	@AnalyticsRequest(parameter = "utl")
	public String timingLabel;

	/**
	 * DNS load time. <br />
	 * These values are part of browser load times
	 */
	@AnalyticsRequest(parameter = "dns")
	public int dnsLoadTime;
	/**
	 * Page download time. <br />
	 * These values are part of browser load times
	 */
	@AnalyticsRequest(parameter = "pdt")
	public int pageDownloadTime;
	/**
	 * Redirect time. <br />
	 * These values are part of browser load times
	 */
	@AnalyticsRequest(parameter = "rrt")
	public int redirectTime;
	/**
	 * TCP connect time. <br />
	 * These values are part of browser load times
	 */
	@AnalyticsRequest(parameter = "tcp")
	public int tcpConnectTime;
	/**
	 * Server response time. <br />
	 * These values are part of browser load times
	 */
	@AnalyticsRequest(parameter = "srt")
	public int serverResponseTime;

	/**
	 * Construtor do PageTracking
	 *
	 * @param request
	 *            HttpRequest
	 * @param userKey
	 *            Strig usada para localizar o AnalyticsUser na session
	 * @param page
	 *            Pagina a ser rastreada
	 * @param title
	 *            Titulo da página
	 * @param locale
	 *            Localização para dados complementares
	 */
	public AnalyticsUserTimingTracking(final HttpServletRequest request,
	                                   final AnalyticsUser analyticsUser,
	                                   final Locale locale) {
		super(request, analyticsUser, locale);
	}

	@Override
	public String getTrackingType() {
		return trackingType;
	}

}
