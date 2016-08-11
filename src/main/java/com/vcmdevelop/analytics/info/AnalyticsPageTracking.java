package com.vcmdevelop.analytics.info;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.vcmdevelop.analytics.annotation.AnalyticsRequest;
import com.vcmdevelop.analytics.objs.AnalyticsUser;

/**
 * Page Tracking
 *
 * @author victor
 *
 */
public class AnalyticsPageTracking extends AnalyticsInfo {

	/**
	 * Pageview hit type.
	 */
	@AnalyticsRequest(parameter = "t")
	private final String trackingType = "pageview";

	/**
	 * Page The path portion of the page URL. Should begin with '/'. For 'pageview' hits, either &dl or both &dh and &dp
	 * have to be specified for the hit to be valid. Example value: /foo Example usage: dp=%2Ffoo
	 */
	@AnalyticsRequest(parameter = "dp")
	public String page;

	/**
	 * Title The title of the page / document. Example value: Settings Example. usage: dt=Settings
	 */
	@AnalyticsRequest(parameter = "dt")
	public String title;

	// public AnalyticsPageTracking() {
	// super();
	// }

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
	public AnalyticsPageTracking(final HttpServletRequest request,
	                             final AnalyticsUser analyticsUser,
	                             final Locale locale) {
		super(request, analyticsUser, locale);
	}

	@Override
	public String getTrackingType() {
		return trackingType;
	}

}
