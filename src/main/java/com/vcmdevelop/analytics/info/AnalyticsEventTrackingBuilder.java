package com.vcmdevelop.analytics.info;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Event Tracking.
 *
 * @author victor
 *
 */
public class AnalyticsEventTrackingBuilder {

	private HttpServletRequest request;
	private Locale locale;
	private String eventCategory;
	private String eventAction;
	private String eventLabel;
	private String eventValue;

	public AnalyticsEventTracking build() throws NullPointerException {
		if (request == null)
			throw new NullPointerException("Request null");
		if (locale == null)
			throw new NullPointerException("Locale null");

		final AnalyticsEventTracking analyticsEventTracking = new AnalyticsEventTracking(request, locale);
		analyticsEventTracking.eventCategory = eventCategory;
		analyticsEventTracking.eventAction = eventAction;
		analyticsEventTracking.eventLabel = eventLabel;
		analyticsEventTracking.eventValue = eventValue;

		return analyticsEventTracking;
	}

	public void setRequest(final HttpServletRequest request) {
		this.request = request;
	}

	public void setLocale(final Locale locale) {
		this.locale = locale;
	}

	/**
	 * Event Category. <br />
	 * <strong>Required.</strong> <br />
	 * Ex: video
	 */
	public AnalyticsEventTrackingBuilder setEventCategory(final String eventCategory) {
		this.eventCategory = eventCategory;
		return this;
	}

	/**
	 * Event Action. <br />
	 * <strong>Required.</strong> <br />
	 * Ex: play
	 */
	public AnalyticsEventTrackingBuilder setEventAction(final String eventAction) {
		this.eventAction = eventAction;
		return this;
	}

	/**
	 * Event label. <br />
	 * Ex: holiday
	 */
	public AnalyticsEventTrackingBuilder setEventLabel(final String eventLabel) {
		this.eventLabel = eventLabel;
		return this;
	}

	/**
	 * Event Value. <br />
	 * Ex: 300
	 */
	public AnalyticsEventTrackingBuilder setEventValue(final String eventValue) {
		this.eventValue = eventValue;
		return this;
	}

}
