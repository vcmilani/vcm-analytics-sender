package com.vcmdevelop.analytics.info;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.vcmdevelop.analytics.annotation.AnalyticsRequest;



/**
 *
 * Event Tracking.
 *
 * @author victor 
 *
 */
public class AnalyticsEventTracking extends AnalyticsInfo {

	/**
	 * Event hit type.
	 */
	@AnalyticsRequest(parameter = "t")
	private final String trackingType = "event";

	/**
	 * Event Category. <br />
	 * <strong>Required.</strong> <br />
	 * Ex: video
	 */
	@AnalyticsRequest(parameter = "ec")
	public String eventCategory;

	/**
	 * Event Action. <br />
	 * <strong>Required.</strong> <br />
	 * Ex: play
	 */
	@AnalyticsRequest(parameter = "ea")
	public String eventAction;

	/**
	 * Event label. <br />
	 * Ex: holiday
	 */
	@AnalyticsRequest(parameter = "el")
	public String eventLabel;

	/**
	 * Event Value. <br />
	 * Ex: 300
	 */
	@AnalyticsRequest(parameter = "ev")
	public String eventValue;

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
	public AnalyticsEventTracking(final HttpServletRequest request, final Locale locale) {
		super(request, locale);
	}

	@Override
	public String getTrackingType() {
		return trackingType;
	}

}
