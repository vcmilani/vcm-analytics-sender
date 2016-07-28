package com.vcmdevelop.analytics.info;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 * User TIming Tracking
 *
 * @author victor
 *
 */
public class AnalyticsUserTimingTrackingBuilder {
	private HttpServletRequest request;
	private Locale locale;

	private String timingCategory;
	private String timingVariable;
	private int timingTime;
	private String timingLabel;

	private int dnsLoadTime;
	private int pageDownloadTime;
	private int redirectTime;
	private int tcpConnectTime;
	private int serverResponseTime;

	public AnalyticsUserTimingTracking build() throws NullPointerException {
		if (request == null)
			throw new NullPointerException("Request null");
		if (locale == null)
			throw new NullPointerException("Locale null");

		final AnalyticsUserTimingTracking analyticsUserTimingTracking = new AnalyticsUserTimingTracking(request,
				locale);
		analyticsUserTimingTracking.timingCategory = timingCategory;
		analyticsUserTimingTracking.timingVariable = timingVariable;
		analyticsUserTimingTracking.timingTime = timingTime;
		analyticsUserTimingTracking.timingLabel = timingLabel;
		analyticsUserTimingTracking.dnsLoadTime = dnsLoadTime;
		analyticsUserTimingTracking.pageDownloadTime = pageDownloadTime;
		analyticsUserTimingTracking.redirectTime = redirectTime;
		analyticsUserTimingTracking.tcpConnectTime = tcpConnectTime;
		analyticsUserTimingTracking.serverResponseTime = serverResponseTime;

		return analyticsUserTimingTracking;
	}

	/**
	 * Timing category. Ex: jsonLoader.
	 */
	public AnalyticsUserTimingTrackingBuilder setTimingCategory(final String timingCategory) {
		this.timingCategory = timingCategory;
		return this;
	}

	/**
	 * Timing variable. Ex: load
	 */
	public AnalyticsUserTimingTrackingBuilder setTimingVariable(final String timingVariable) {
		this.timingVariable = timingVariable;
		return this;
	}

	/**
	 * Timing time.
	 */
	public AnalyticsUserTimingTrackingBuilder setTimingTime(final int timingTime) {
		this.timingTime = timingTime;
		return this;
	}

	/**
	 * Timing label. Ex: jQuery
	 */
	public AnalyticsUserTimingTrackingBuilder setTimingLabel(final String timingLabel) {
		this.timingLabel = timingLabel;
		return this;
	}

	/**
	 * DNS load time. <br />
	 * These values are part of browser load times
	 */
	public AnalyticsUserTimingTrackingBuilder setDnsLoadTime(final int dnsLoadTime) {
		this.dnsLoadTime = dnsLoadTime;
		return this;
	}

	/**
	 * Page download time. <br />
	 * These values are part of browser load times
	 */
	public AnalyticsUserTimingTrackingBuilder setPageDownloadTime(final int pageDownloadTime) {
		this.pageDownloadTime = pageDownloadTime;
		return this;
	}

	/**
	 * Redirect time. <br />
	 * These values are part of browser load times
	 */
	public AnalyticsUserTimingTrackingBuilder setRedirectTime(final int redirectTime) {
		this.redirectTime = redirectTime;
		return this;
	}

	/**
	 * TCP connect time. <br />
	 * These values are part of browser load times
	 */
	public AnalyticsUserTimingTrackingBuilder setTcpConnectTime(final int tcpConnectTime) {
		this.tcpConnectTime = tcpConnectTime;
		return this;
	}

	/**
	 * Server response time. <br />
	 * These values are part of browser load times
	 */
	public AnalyticsUserTimingTrackingBuilder setServerResponseTime(final int serverResponseTime) {
		this.serverResponseTime = serverResponseTime;
		return this;
	}
}