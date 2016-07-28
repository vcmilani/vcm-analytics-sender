package com.vcmdevelop.analytics.info;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 * Page Tracking
 *
 * @author victor
 *
 */
public class AnalyticsPageTrackingBuilder {

	private HttpServletRequest request;
	private Locale locale;
	public String page;
	public String title;

	public AnalyticsPageTracking build() throws NullPointerException {
		if (request == null)
			throw new NullPointerException("Request null");
		if (locale == null)
			throw new NullPointerException("Locale null");

		final AnalyticsPageTracking analyticsPageTracking = new AnalyticsPageTracking(request, locale);
		analyticsPageTracking.page = page;
		analyticsPageTracking.title = title;

		return analyticsPageTracking;
	}

	public AnalyticsPageTrackingBuilder setRequest(final HttpServletRequest request) {
		this.request = request;
		return this;
	}

	public AnalyticsPageTrackingBuilder setLocale(final Locale locale) {
		this.locale = locale;
		return this;
	}

	/**
	 * Page The path portion of the page URL. Should begin with '/'. For
	 * 'pageview' hits, either &dl or both &dh and &dp have to be specified for
	 * the hit to be valid. Example value: /foo Example usage: dp=%2Ffoo
	 */
	public AnalyticsPageTrackingBuilder setPage(final String page) {
		this.page = page;
		return this;
	}

	/**
	 * Title The title of the page / document. Example value: Settings Example.
	 * usage: dt=Settings
	 */
	public AnalyticsPageTrackingBuilder setTitle(final String title) {
		this.title = title;
		return this;
	}

}
