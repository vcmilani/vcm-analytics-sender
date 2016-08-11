package com.vcmdevelop.analytics.info;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.vcmdevelop.analytics.annotation.AnalyticsRequest;
import com.vcmdevelop.analytics.objs.AnalyticsUser;

/**
 * Social Interactions.
 *
 * @author victor
 *
 */
public class AnalyticsSocialInteractions extends AnalyticsInfo {

	/**
	 * Social hit type.
	 */
	@AnalyticsRequest(parameter = "t")
	private final String trackingType = "social";

	/**
	 * Social Action. <br />
	 * <strong>Required.</strong> <br />
	 * Ex: like
	 */
	@AnalyticsRequest(parameter = "sa")
	public String socialAction;

	/**
	 * Social Network. <br />
	 * <strong>Required.</strong> <br />
	 * Ex: acebook
	 */
	@AnalyticsRequest(parameter = "sn")
	public String socialNetwork;

	/**
	 * Social Target. <br />
	 * <strong>Required.</strong> <br />
	 * Ex: home
	 */
	@AnalyticsRequest(parameter = "st")
	public String socialTarget;

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
	public AnalyticsSocialInteractions(final HttpServletRequest request,
	                                   final AnalyticsUser analyticsUser,
	                                   final Locale locale) {
		super(request, analyticsUser, locale);
	}

	@Override
	public String getTrackingType() {
		return trackingType;
	}

}
