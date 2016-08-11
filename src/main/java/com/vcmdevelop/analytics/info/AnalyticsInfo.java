package com.vcmdevelop.analytics.info;

import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.vcmdevelop.analytics.annotation.AnalyticsRequest;
import com.vcmdevelop.analytics.objs.AnalyticsUser;
import com.vcmdevelop.analytics.setup.AnalyticsSetupData;

/**
 * Informações gerais do analytics, que deve ser enviado sempre
 *
 * @author Victor
 *
 */
public abstract class AnalyticsInfo {

	/**
	 * Version
	 */
	@AnalyticsRequest(parameter = "v")
	public final int analyticsVersion = AnalyticsSetupData.googleTrackingVersion;

	/**
	 * Tracking ID / Property ID.
	 */
	@AnalyticsRequest(parameter = "tid")
	public final String trackingId = AnalyticsSetupData.trackingId;

	/**
	 * Document hostname Specifies the hostname from which content was hosted. Example value: foo.com Example usage:
	 * dh=foo.com
	 */
	@AnalyticsRequest(parameter = "dh")
	public final String documentHostname = AnalyticsSetupData.documentHostname;

	/**
	 * Anonymous Client ID
	 */
	@AnalyticsRequest(parameter = "cid")
	public String anonymousClientID;

	/**
	 * Example value: 1.2.3.4 Example usage: uip=1.2.3.4
	 */
	@AnalyticsRequest(parameter = "uip")
	public String ipOverride;

	/**
	 * userLanguage Example value: en-us Example usage: ul=en-us
	 */
	@AnalyticsRequest(parameter = "ul")
	public String userLanguage;

	// public AnalyticsInfo() {
	//
	// }

	public AnalyticsInfo(final HttpServletRequest request, final AnalyticsUser analyticsUser, final Locale locale) {
		ipOverride = request.getRemoteAddr();
		setAnonymousClientID(analyticsUser);
		userLanguage = locale.getDisplayLanguage();
	}

	public void setAnonymousClientID(final AnalyticsUser analyticsUser) {
		if (analyticsUser == null || StringUtils.isBlank(analyticsUser.getUuid())) {
			if (AnalyticsSetupData.useAutoGenUserUUID) {
				anonymousClientID = UUID.randomUUID().toString();
				// } else {
				// throw new NullPointerException("User UUID Null");
			}
		} else {
			anonymousClientID = analyticsUser.getUuid();
		}
	}

	public abstract String getTrackingType();

	// Geographical Override
	// Example value: US
	// Example usage: geoid=US
	//
	// Example value: 21137
	// Example usage: geoid=21137

}