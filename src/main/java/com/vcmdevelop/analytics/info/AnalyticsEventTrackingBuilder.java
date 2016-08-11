package com.vcmdevelop.analytics.info;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.vcmdevelop.analytics.objs.AnalyticsUser;

/**
 *
 * Event Tracking.
 *
 * @author victor
 *
 */
public class AnalyticsEventTrackingBuilder {

	private HttpServletRequest request;
	private AnalyticsUser analyticsUser;
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

		final AnalyticsEventTracking analyticsEventTracking = new AnalyticsEventTracking(request, analyticsUser,
		        locale);
		analyticsEventTracking.eventCategory = eventCategory;
		analyticsEventTracking.eventAction = eventAction;
		analyticsEventTracking.eventLabel = eventLabel;
		analyticsEventTracking.eventValue = eventValue;

		return analyticsEventTracking;
	}

	public AnalyticsEventTrackingBuilder setRequest(final HttpServletRequest request) {
		this.request = request;
		return this;
	}

	public AnalyticsEventTrackingBuilder setAnalyticsUser(final AnalyticsUser analyticsUser) {
		this.analyticsUser = analyticsUser;
		return this;
	}

	public AnalyticsEventTrackingBuilder setLocale(final Locale locale) {
		this.locale = locale;
		return this;
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
