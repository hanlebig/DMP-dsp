package com.taiyear.dsp.utils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

/**
 * 封装各种格式的编码解码工具类. 1.Commons-Codec的 hex/base64 编码 2.自制的base62 编码
 * 3.Commons-Lang的xml/html escape************ 4.JDK提供的URLEncoder 5.SHA-1加密，替代MD5
 */
public final class Encodes {

	private static final String DEFAULT_URL_ENCODING = "UTF-8";
	private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
			.toCharArray();

	public static String getSha1(String str) {
		if (null == str || 0 == str.length()) {
			return null;
		}
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes("UTF-8"));

			byte[] md = mdTemp.digest();
			int j = md.length;
			char[] buf = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Hex编码.
	 */
	public static String encodeHex(byte[] input) {
		return new String(Hex.encodeHex(input));
	}

	/**
	 * Hex解码.
	 */
	public static byte[] decodeHex(String input) {
		try {
			return Hex.decodeHex(input.toCharArray());
		} catch (DecoderException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Base64编码.
	 */
	public static String encodeBase64(byte[] input) {
		return new String(Base64.encodeBase64(input));
	}

	/**
	 * Base64编码.
	 */
	public static String encodeBase64(String input) {
		try {
			return new String(Base64.encodeBase64(input
					.getBytes(DEFAULT_URL_ENCODING)));
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	/**
	 * Base64解码.
	 */
	public static byte[] decodeBase64(String input) {
		return Base64.decodeBase64(input.getBytes());
	}

	/**
	 * Base64解码.
	 */
	public static String decodeBase64String(String input) {
		try {
			return new String(Base64.decodeBase64(input.getBytes()),
					DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	/**
	 * Base62编码。
	 */
	public static String encodeBase62(byte[] input) {
		char[] chars = new char[input.length];
		for (int i = 0; i < input.length; i++) {
			chars[i] = BASE62[((input[i] & 0xFF) % BASE62.length)];
		}
		return new String(chars);
	}

	/**
	 * Html 转码.
	 */
	public static String escapeHtml(String html) {
		return StringEscapeUtils.escapeHtml4(html);
	}

	/**
	 * Html 解码.
	 */
	public static String unescapeHtml(String htmlEscaped) {
		return StringEscapeUtils.unescapeHtml4(htmlEscaped);
	}

	/**
	 * Xml 转码.
	 */
	public static String escapeXml(String xml) {
		return StringEscapeUtils.escapeXml10(xml);
	}

	/**
	 * Xml 解码.
	 */
	public static String unescapeXml(String xmlEscaped) {
		return StringEscapeUtils.unescapeXml(xmlEscaped);
	}

	/**
	 * URL 编码, Encode默认为UTF-8.
	 */
	public static String urlEncode(String part) {
		try {
			return URLEncoder.encode(part, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * URL 解码, Encode默认为UTF-8.
	 */
	public static String urlDecode(String part) {

		try {
			return URLDecoder.decode(part, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
}