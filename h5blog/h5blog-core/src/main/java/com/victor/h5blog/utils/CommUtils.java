package com.victor.h5blog.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Decoder;

@SuppressWarnings("restriction")
@Service("commUtils")
public class CommUtils {

	private Logger logger = Logger.getLogger(CommUtils.class);

	public String formDate(String f) {

		if (f.equals("")) {
			return "";
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date = dateFormat.parse(f);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = formatter.format(date);
			return strDate;
		} catch (ParseException e) {
			logger.error("", e);
			return null;
		}
	}

	public byte[] getFromBASE64(String input) {
		if (input == null) {
			return null;
		}

		input = input + "=";

		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] output = decoder.decodeBuffer(input);

			return output;
		} catch (Exception e) {
			logger.error("", e);
			return null;
		}
	}

	/**
	 * ��Date���͵�ʱ��ת����yyyyMMdd��ʽ���ַ�������
	 * 
	 * @param myDate
	 *            Date����
	 * @return
	 */
	public String fotmatDate(Date myDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String strDate = formatter.format(myDate);
		return strDate;
	}

	public String encodeHex(byte bytes[]) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if ((bytes[i] & 0xff) < 16)
				buf.append("0");
			buf.append(Long.toString(bytes[i] & 0xff, 16));
		}

		return buf.toString();
	}

	public byte[] decodeHex(String pwd) {
		try {
			byte[] rs = Hex.decodeHex(pwd.toCharArray());
			return rs;
		} catch (DecoderException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getCurrAlphaByCurrNum(String num) {
		num.replaceAll("/(\\s*$)/g", "");
		if (num.equals("008"))
			return "ALL";
		else if (num.equals("012"))
			return "DZD";
		else if (num.equals("032"))
			return "ARS";
		else if (num.equals("036"))
			return "AUD";
		else if (num.equals("044"))
			return "BSD";
		else if (num.equals("048"))
			return "BHD";
		else if (num.equals("050"))
			return "BDT";
		else if (num.equals("051"))
			return "AMD";
		else if (num.equals("052"))
			return "BBD";
		else if (num.equals("060"))
			return "BMD";
		else if (num.equals("064"))
			return "BTN";
		else if (num.equals("068"))
			return "BOB";
		else if (num.equals("072"))
			return "BWP";
		else if (num.equals("084"))
			return "BZD";
		else if (num.equals("090"))
			return "SBD";
		else if (num.equals("096"))
			return "BND";
		else if (num.equals("104"))
			return "MMK";
		else if (num.equals("108"))
			return "BIF";
		else if (num.equals("116"))
			return "KHR";
		else if (num.equals("124"))
			return "CAD";
		else if (num.equals("132"))
			return "CVE";
		else if (num.equals("136"))
			return "KYD";
		else if (num.equals("144"))
			return "LKR";
		else if (num.equals("152"))
			return "CLP";
		else if (num.equals("156"))
			return "CNY";
		else if (num.equals("170"))
			return "COP";
		else if (num.equals("174"))
			return "KMF";
		else if (num.equals("188"))
			return "CRC";
		else if (num.equals("191"))
			return "HRK";
		else if (num.equals("192"))
			return "CUP";
		else if (num.equals("196"))
			return "CYP";
		else if (num.equals("203"))
			return "CZK";
		else if (num.equals("208"))
			return "DKK";
		else if (num.equals("214"))
			return "DOP";
		else if (num.equals("222"))
			return "SVC";
		else if (num.equals("230"))
			return "ETB";
		else if (num.equals("232"))
			return "ERN";
		else if (num.equals("233"))
			return "EEK";
		else if (num.equals("238"))
			return "FKP";
		else if (num.equals("242"))
			return "FJD";
		else if (num.equals("262"))
			return "DJF";
		else if (num.equals("270"))
			return "GMD";
		else if (num.equals("292"))
			return "GIP";
		else if (num.equals("320"))
			return "GTQ";
		else if (num.equals("324"))
			return "GNF";
		else if (num.equals("328"))
			return "GYD";
		else if (num.equals("332"))
			return "HTG";
		else if (num.equals("340"))
			return "HNL";
		else if (num.equals("344"))
			return "HKD";
		else if (num.equals("348"))
			return "HUF";
		else if (num.equals("352"))
			return "ISK";
		else if (num.equals("356"))
			return "INR";
		else if (num.equals("360"))
			return "IDR";
		else if (num.equals("364"))
			return "IRR";
		else if (num.equals("368"))
			return "IQD";
		else if (num.equals("376"))
			return "ILS";
		else if (num.equals("388"))
			return "JMD";
		else if (num.equals("392"))
			return "JPY";
		else if (num.equals("398"))
			return "KZT";
		else if (num.equals("400"))
			return "JOD";
		else if (num.equals("404"))
			return "KES";
		else if (num.equals("408"))
			return "KPW";
		else if (num.equals("410"))
			return "KRW";
		else if (num.equals("414"))
			return "KWD";
		else if (num.equals("417"))
			return "KGS";
		else if (num.equals("418"))
			return "LAK";
		else if (num.equals("422"))
			return "LBP";
		else if (num.equals("426"))
			return "LSL";
		else if (num.equals("428"))
			return "LVL";
		else if (num.equals("430"))
			return "LRD";
		else if (num.equals("434"))
			return "LYD";
		else if (num.equals("440"))
			return "LTL";
		else if (num.equals("446"))
			return "MOP";
		else if (num.equals("454"))
			return "MWK";
		else if (num.equals("458"))
			return "MYR";
		else if (num.equals("462"))
			return "MVR";
		else if (num.equals("470"))
			return "MTL";
		else if (num.equals("478"))
			return "MRO";
		else if (num.equals("480"))
			return "MUR";
		else if (num.equals("484"))
			return "MXN";
		else if (num.equals("496"))
			return "MNT";
		else if (num.equals("498"))
			return "MDL";
		else if (num.equals("504"))
			return "MAD";
		else if (num.equals("512"))
			return "OMR";
		else if (num.equals("516"))
			return "NAD";
		else if (num.equals("524"))
			return "NPR";
		else if (num.equals("532"))
			return "ANG";
		else if (num.equals("533"))
			return "AWG";
		else if (num.equals("548"))
			return "VUV";
		else if (num.equals("554"))
			return "NZD";
		else if (num.equals("558"))
			return "NIO";
		else if (num.equals("566"))
			return "NGN";
		else if (num.equals("578"))
			return "NOK";
		else if (num.equals("586"))
			return "PKR";
		else if (num.equals("590"))
			return "PAB";
		else if (num.equals("598"))
			return "PGK";
		else if (num.equals("600"))
			return "PYG";
		else if (num.equals("604"))
			return "PEN";
		else if (num.equals("608"))
			return "PHP";
		else if (num.equals("624"))
			return "GWP";
		else if (num.equals("634"))
			return "QAR";
		else if (num.equals("643"))
			return "RUB";
		else if (num.equals("646"))
			return "RWF";
		else if (num.equals("654"))
			return "SHP";
		else if (num.equals("678"))
			return "STD";
		else if (num.equals("682"))
			return "SAR";
		else if (num.equals("690"))
			return "SCR";
		else if (num.equals("694"))
			return "SLL";
		else if (num.equals("702"))
			return "SGD";
		else if (num.equals("703"))
			return "SKK";
		else if (num.equals("704"))
			return "VND";
		else if (num.equals("706"))
			return "SOS";
		else if (num.equals("710"))
			return "ZAR";
		else if (num.equals("716"))
			return "ZWD";
		else if (num.equals("748"))
			return "SZL";
		else if (num.equals("752"))
			return "SEK";
		else if (num.equals("756"))
			return "CHF";
		else if (num.equals("760"))
			return "SYP";
		else if (num.equals("764"))
			return "THB";
		else if (num.equals("776"))
			return "TOP";
		else if (num.equals("780"))
			return "TTD";
		else if (num.equals("784"))
			return "AED";
		else if (num.equals("788"))
			return "TND";
		else if (num.equals("795"))
			return "TMM";
		else if (num.equals("800"))
			return "UGX";
		else if (num.equals("807"))
			return "MKD";
		else if (num.equals("818"))
			return "EGP";
		else if (num.equals("826"))
			return "GBP";
		else if (num.equals("834"))
			return "TZS";
		else if (num.equals("840"))
			return "USD";
		else if (num.equals("858"))
			return "UYU";
		else if (num.equals("860"))
			return "UZS";
		else if (num.equals("882"))
			return "WST";
		else if (num.equals("886"))
			return "YER";
		else if (num.equals("894"))
			return "ZMK";
		else if (num.equals("901"))
			return "TWD";
		else if (num.equals("936"))
			return "GHS";
		else if (num.equals("937"))
			return "VEF";
		else if (num.equals("938"))
			return "SDG";
		else if (num.equals("940"))
			return "UYI";
		else if (num.equals("941"))
			return "RSD";
		else if (num.equals("943"))
			return "MZN";
		else if (num.equals("944"))
			return "AZN";
		else if (num.equals("946"))
			return "RON";
		else if (num.equals("947"))
			return "CHE";
		else if (num.equals("948"))
			return "CHW";
		else if (num.equals("949"))
			return "TRY";
		else if (num.equals("950"))
			return "XAF";
		else if (num.equals("951"))
			return "XCD";
		else if (num.equals("952"))
			return "XOF";
		else if (num.equals("953"))
			return "XPF";
		else if (num.equals("955"))
			return "XBA";
		else if (num.equals("956"))
			return "XBB";
		else if (num.equals("957"))
			return "XBC";
		else if (num.equals("958"))
			return "XBD";
		else if (num.equals("959"))
			return "XAU";
		else if (num.equals("960"))
			return "XDR";
		else if (num.equals("961"))
			return "XAG";
		else if (num.equals("962"))
			return "XPT";
		else if (num.equals("963"))
			return "XTS";
		else if (num.equals("964"))
			return "XPD";
		else if (num.equals("968"))
			return "SRD";
		else if (num.equals("969"))
			return "MGA";
		else if (num.equals("970"))
			return "COU";
		else if (num.equals("971"))
			return "AFN";
		else if (num.equals("972"))
			return "TJS";
		else if (num.equals("973"))
			return "AOA";
		else if (num.equals("974"))
			return "BYR";
		else if (num.equals("975"))
			return "BGN";
		else if (num.equals("976"))
			return "CDF";
		else if (num.equals("977"))
			return "BAM";
		else if (num.equals("978"))
			return "EUR";
		else if (num.equals("979"))
			return "MXV";
		else if (num.equals("980"))
			return "UAH";
		else if (num.equals("981"))
			return "GEL";
		else if (num.equals("984"))
			return "BOV";
		else if (num.equals("985"))
			return "PLN";
		else if (num.equals("986"))
			return "BRL";
		else if (num.equals("990"))
			return "CLF";
		else if (num.equals("997"))
			return "USN";
		else if (num.equals("998"))
			return "USS";
		else if (num.equals("999"))
			return "XXX";
		else
			return "   ";
	}

	public String getCurrNumByCurrAlpha(String alpha) {
		alpha.replaceAll("/(\\s*$)/g", "");
		if (alpha.equals("ALL"))
			return "008";
		else if (alpha.equals("DZD"))
			return "012";
		else if (alpha.equals("ARS"))
			return "032";
		else if (alpha.equals("AUD"))
			return "036";
		else if (alpha.equals("BSD"))
			return "044";
		else if (alpha.equals("BHD"))
			return "048";
		else if (alpha.equals("BDT"))
			return "050";
		else if (alpha.equals("AMD"))
			return "051";
		else if (alpha.equals("BBD"))
			return "052";
		else if (alpha.equals("BMD"))
			return "060";
		else if (alpha.equals("BTN"))
			return "064";
		else if (alpha.equals("BOB"))
			return "068";
		else if (alpha.equals("BWP"))
			return "072";
		else if (alpha.equals("BZD"))
			return "084";
		else if (alpha.equals("SBD"))
			return "090";
		else if (alpha.equals("BND"))
			return "096";
		else if (alpha.equals("MMK"))
			return "104";
		else if (alpha.equals("BIF"))
			return "108";
		else if (alpha.equals("KHR"))
			return "116";
		else if (alpha.equals("CAD"))
			return "124";
		else if (alpha.equals("CVE"))
			return "132";
		else if (alpha.equals("KYD"))
			return "136";
		else if (alpha.equals("LKR"))
			return "144";
		else if (alpha.equals("CLP"))
			return "152";
		else if (alpha.equals("CNY"))
			return "156";
		else if (alpha.equals("COP"))
			return "170";
		else if (alpha.equals("KMF"))
			return "174";
		else if (alpha.equals("CRC"))
			return "188";
		else if (alpha.equals("HRK"))
			return "191";
		else if (alpha.equals("CUP"))
			return "192";
		else if (alpha.equals("CYP"))
			return "196";
		else if (alpha.equals("CZK"))
			return "203";
		else if (alpha.equals("DKK"))
			return "208";
		else if (alpha.equals("DOP"))
			return "214";
		else if (alpha.equals("SVC"))
			return "222";
		else if (alpha.equals("ETB"))
			return "230";
		else if (alpha.equals("ERN"))
			return "232";
		else if (alpha.equals("EEK"))
			return "233";
		else if (alpha.equals("FKP"))
			return "238";
		else if (alpha.equals("FJD"))
			return "242";
		else if (alpha.equals("DJF"))
			return "262";
		else if (alpha.equals("GMD"))
			return "270";
		else if (alpha.equals("GIP"))
			return "292";
		else if (alpha.equals("GTQ"))
			return "320";
		else if (alpha.equals("GNF"))
			return "324";
		else if (alpha.equals("GYD"))
			return "328";
		else if (alpha.equals("HTG"))
			return "332";
		else if (alpha.equals("HNL"))
			return "340";
		else if (alpha.equals("HKD"))
			return "344";
		else if (alpha.equals("HUF"))
			return "348";
		else if (alpha.equals("ISK"))
			return "352";
		else if (alpha.equals("INR"))
			return "356";
		else if (alpha.equals("IDR"))
			return "360";
		else if (alpha.equals("IRR"))
			return "364";
		else if (alpha.equals("IQD"))
			return "368";
		else if (alpha.equals("ILS"))
			return "376";
		else if (alpha.equals("JMD"))
			return "388";
		else if (alpha.equals("JPY"))
			return "392";
		else if (alpha.equals("KZT"))
			return "398";
		else if (alpha.equals("JOD"))
			return "400";
		else if (alpha.equals("KES"))
			return "404";
		else if (alpha.equals("KPW"))
			return "408";
		else if (alpha.equals("KRW"))
			return "410";
		else if (alpha.equals("KWD"))
			return "414";
		else if (alpha.equals("KGS"))
			return "417";
		else if (alpha.equals("LAK"))
			return "418";
		else if (alpha.equals("LBP"))
			return "422";
		else if (alpha.equals("LSL"))
			return "426";
		else if (alpha.equals("LVL"))
			return "428";
		else if (alpha.equals("LRD"))
			return "430";
		else if (alpha.equals("LYD"))
			return "434";
		else if (alpha.equals("LTL"))
			return "440";
		else if (alpha.equals("MOP"))
			return "446";
		else if (alpha.equals("MWK"))
			return "454";
		else if (alpha.equals("MYR"))
			return "458";
		else if (alpha.equals("MVR"))
			return "462";
		else if (alpha.equals("MTL"))
			return "470";
		else if (alpha.equals("MRO"))
			return "478";
		else if (alpha.equals("MUR"))
			return "480";
		else if (alpha.equals("MXN"))
			return "484";
		else if (alpha.equals("MNT"))
			return "496";
		else if (alpha.equals("MDL"))
			return "498";
		else if (alpha.equals("MAD"))
			return "504";
		else if (alpha.equals("OMR"))
			return "512";
		else if (alpha.equals("NAD"))
			return "516";
		else if (alpha.equals("NPR"))
			return "524";
		else if (alpha.equals("ANG"))
			return "532";
		else if (alpha.equals("AWG"))
			return "533";
		else if (alpha.equals("VUV"))
			return "548";
		else if (alpha.equals("NZD"))
			return "554";
		else if (alpha.equals("NIO"))
			return "558";
		else if (alpha.equals("NGN"))
			return "566";
		else if (alpha.equals("NOK"))
			return "578";
		else if (alpha.equals("PKR"))
			return "586";
		else if (alpha.equals("PAB"))
			return "590";
		else if (alpha.equals("PGK"))
			return "598";
		else if (alpha.equals("PYG"))
			return "600";
		else if (alpha.equals("PEN"))
			return "604";
		else if (alpha.equals("PHP"))
			return "608";
		else if (alpha.equals("GWP"))
			return "624";
		else if (alpha.equals("QAR"))
			return "634";
		else if (alpha.equals("RUB"))
			return "643";
		else if (alpha.equals("RWF"))
			return "646";
		else if (alpha.equals("SHP"))
			return "654";
		else if (alpha.equals("STD"))
			return "678";
		else if (alpha.equals("SAR"))
			return "682";
		else if (alpha.equals("SCR"))
			return "690";
		else if (alpha.equals("SLL"))
			return "694";
		else if (alpha.equals("SGD"))
			return "702";
		else if (alpha.equals("SKK"))
			return "703";
		else if (alpha.equals("VND"))
			return "704";
		else if (alpha.equals("SOS"))
			return "706";
		else if (alpha.equals("ZAR"))
			return "710";
		else if (alpha.equals("ZWD"))
			return "716";
		else if (alpha.equals("SZL"))
			return "748";
		else if (alpha.equals("SEK"))
			return "752";
		else if (alpha.equals("CHF"))
			return "756";
		else if (alpha.equals("SYP"))
			return "760";
		else if (alpha.equals("THB"))
			return "764";
		else if (alpha.equals("TOP"))
			return "776";
		else if (alpha.equals("TTD"))
			return "780";
		else if (alpha.equals("AED"))
			return "784";
		else if (alpha.equals("TND"))
			return "788";
		else if (alpha.equals("TMM"))
			return "795";
		else if (alpha.equals("UGX"))
			return "800";
		else if (alpha.equals("MKD"))
			return "807";
		else if (alpha.equals("EGP"))
			return "818";
		else if (alpha.equals("GBP"))
			return "826";
		else if (alpha.equals("TZS"))
			return "834";
		else if (alpha.equals("USD"))
			return "840";
		else if (alpha.equals("UYU"))
			return "858";
		else if (alpha.equals("UZS"))
			return "860";
		else if (alpha.equals("WST"))
			return "882";
		else if (alpha.equals("YER"))
			return "886";
		else if (alpha.equals("ZMK"))
			return "894";
		else if (alpha.equals("TWD"))
			return "901";
		else if (alpha.equals("GHS"))
			return "936";
		else if (alpha.equals("VEF"))
			return "937";
		else if (alpha.equals("SDG"))
			return "938";
		else if (alpha.equals("UYI"))
			return "940";
		else if (alpha.equals("RSD"))
			return "941";
		else if (alpha.equals("MZN"))
			return "943";
		else if (alpha.equals("AZN"))
			return "944";
		else if (alpha.equals("RON"))
			return "946";
		else if (alpha.equals("CHE"))
			return "947";
		else if (alpha.equals("CHW"))
			return "948";
		else if (alpha.equals("TRY"))
			return "949";
		else if (alpha.equals("XAF"))
			return "950";
		else if (alpha.equals("XCD"))
			return "951";
		else if (alpha.equals("XOF"))
			return "952";
		else if (alpha.equals("XPF"))
			return "953";
		else if (alpha.equals("XBA"))
			return "955";
		else if (alpha.equals("XBB"))
			return "956";
		else if (alpha.equals("XBC"))
			return "957";
		else if (alpha.equals("XBD"))
			return "958";
		else if (alpha.equals("XAU"))
			return "959";
		else if (alpha.equals("XDR"))
			return "960";
		else if (alpha.equals("XAG"))
			return "961";
		else if (alpha.equals("XPT"))
			return "962";
		else if (alpha.equals("XTS"))
			return "963";
		else if (alpha.equals("XPD"))
			return "964";
		else if (alpha.equals("SRD"))
			return "968";
		else if (alpha.equals("MGA"))
			return "969";
		else if (alpha.equals("COU"))
			return "970";
		else if (alpha.equals("AFN"))
			return "971";
		else if (alpha.equals("TJS"))
			return "972";
		else if (alpha.equals("AOA"))
			return "973";
		else if (alpha.equals("BYR"))
			return "974";
		else if (alpha.equals("BGN"))
			return "975";
		else if (alpha.equals("CDF"))
			return "976";
		else if (alpha.equals("BAM"))
			return "977";
		else if (alpha.equals("EUR"))
			return "978";
		else if (alpha.equals("MXV"))
			return "979";
		else if (alpha.equals("UAH"))
			return "980";
		else if (alpha.equals("GEL"))
			return "981";
		else if (alpha.equals("BOV"))
			return "984";
		else if (alpha.equals("PLN"))
			return "985";
		else if (alpha.equals("BRL"))
			return "986";
		else if (alpha.equals("CLF"))
			return "990";
		else if (alpha.equals("USN"))
			return "997";
		else if (alpha.equals("USS"))
			return "998";
		else if (alpha.equals("XXX"))
			return "999";
		else
			return "   ";
	}
}
