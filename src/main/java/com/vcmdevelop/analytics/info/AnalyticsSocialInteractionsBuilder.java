package com.vcmdevelop.analytics.info;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 * Social Interactions.
 *
 * @author victor
 *
 */
public class AnalyticsSocialInteractionsBuilder {

	private HttpServletRequest request;
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
				locale);
		analyticsSocialInteractions.socialAction = socialAction;
		analyticsSocialInteractions.socialNetwork = socialNetwork;
		analyticsSocialInteractions.socialTarget = socialTarget;

		return analyticsSocialInteractions;
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
