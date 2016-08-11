package com.vcmdevelop.analytics.setup;

import com.vcmdevelop.analytics.constants.AnalyticsKeys;

public class AnalyticsSetupData {

	/**
	 * Não deve ser substituido, a menos que haja alguma outra URL a conectar
	 */
	public static String googleAnalyticsUrl = AnalyticsKeys.GOOGLE_ANALYTICS_URL;

	/**
	 * Versão da API do Google para recebimento dos dados
	 */
	public static int googleTrackingVersion = AnalyticsKeys.GOOGLE_TRACKING_VERSION;

	/**
	 * Endereço do site a ser monitorado
	 */
	public static String documentHostname = null;

	/**
	 * Tracking ID salvo criado dentro do Google Analytics para a aplicação que será monitorada
	 */
	public static String trackingId = null;

	/** Define if this tool will generate the UUID to user */
	public static boolean useAutoGenUserUUID = false;

}
