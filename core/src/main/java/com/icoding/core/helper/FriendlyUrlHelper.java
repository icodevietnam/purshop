package com.icoding.core.helper;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class FriendlyUrlHelper {

	public static String toFriendlyUrl(String string) {
		return Normalizer.normalize(string.toLowerCase(), Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
				.replaceAll("Đ", "D").replaceAll("đ", "d").replaceAll("[^\\p{ASCII}]", "").replaceAll("\\p{M}", "")
				.replaceAll("[^\\p{Alnum}]+", "-");
	}

}
