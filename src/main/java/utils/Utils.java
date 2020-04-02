package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	public static boolean validarCpfCnpj(String cpfCnpj) {
		cpfCnpj.replaceAll("[^0-9]", "");
		String result = executeRegexp(cpfCnpj, "(\\d{3}\\.\\d{3}\\.\\{3}-\\d{2}|\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}-\\d{2})", 1, Pattern.DOTALL);
		return isValidString(result);
	}
	
	public static final String executeRegexp(final String text, final String er, final int group, int pattern) {
		final Matcher matcher = Pattern.compile(er, pattern).matcher(text);
		final boolean match = matcher.find();
		if (!match) {
			return "";
		}
		return matcher.group(group);
	}
	
	public static final boolean isValidString(final String string) {
		return string != null && !"".equals(string);
	}


		

}
