package com.vcmdevelop.analytics.info;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.vcmdevelop.analytics.objs.AnalyticsUser;

/**
 * Social Interactions.
 *
 * @author victor
 *
 */
public class AnalyticsSocialInteractionsBuilder {

	private HttpServletRequest request;
	private AnalyticsUser analyticsUser;
	private Locale locale;
	private String socialAction;
	private String socialNetwork;
	private String socialTarget;

	public AnalyticsSocialInteractions build() throws NullPointerException {
		if (request == null)
			throw new NullPointerException("Request null");
		if (locale == null)
			throw new NullPointerException("Locale null");

		final AnalyticsSocialInteractions analyticsSocialInteractions = new AnalyticsSocialInteractions(request,
		        analyticsUser, locale);
		analyticsSocialInteractions.socialAction = socialAction;
		analyticsSocialInteractions.socialNetwork = socialNetwork;
		analyticsSocialInteractions.socialTarget = socialTarget;

		return analyticsSocialInteractions;
	}

	public AnalyticsSocialInteractionsBuilder setRequest(final HttpServletRequest request) {
		this.request = request;
		return this;
	}

	public AnalyticsSocialInteractionsBuilder setAnalyticsUser(final AnalyticsUser analyticsUser) {
		this.analyticsUser = analyticsUser;
		return this;
	}

	public AnalyticsSocialInteractionsBuilder setLocale(final Locale locale) {
		this.locale = locale;
		return this;
	}

	/**
	 * Social Action. <br />
	 * <strong>Required.</strong> <br />
	 * Ex: like
	 */
	public void setSocialAction(final String socialAction) {
		this.socialAction = socialAction;
	}

	/**
	 * Social Network. <br />
	 * <strong>Required.</strong> <br />
	 * Ex: acebook
	 */
	public void setSocialNetwork(final String socialNetwork) {
		this.socialNetwork = socialNetwork;
	}

	/**
	 * Social Target. <br />
	 * <strong>Required.</strong> <br />
	 * Ex: home
	 */
	public void setSocialTarget(final String socialTarget) {
		this.socialTarget = socialTarget;
	}

}
