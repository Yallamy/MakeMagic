package br.com.magicApi;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomUtils;

/**
 * Classe de teste auxilar.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
public class EntityGenericUtil {

	public static Integer getInteger() {
		return RandomUtils.nextInt(0, 999999);
	}

	public static Long getLong() {
		return RandomUtils.nextLong(0, 999999);
	}

	public static Long getLong(int length) {

		long value = RandomUtils.nextLong(1111111111111111111L, 9219999999999999999L);
		return Long.parseLong(String.valueOf(value).substring(0, length));
	}

	public static String getString() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static BigInteger getBigInteger() {
		return new BigInteger(getInteger().toString());
	}

	public static Date getDate() {
		return new Date();
	}

	public static LocalDateTime getDateTime() {
		return LocalDateTime.now();
	}

	public static BigDecimal getBigDecimal() {
		return new BigDecimal(String.valueOf(RandomUtils.nextDouble(0, 999999)));
	}

	public static Double getDouble() {
		return new Double(String.valueOf(RandomUtils.nextDouble(0, 999999)));
	}

	public static LocalDate getLocalDate() {

		return LocalDate.now();
	}

	public static LocalDateTime getLocalDateTime() {
		return LocalDateTime.now();
	}

	public static Boolean getBoolean() {
		return new Random().nextBoolean();
	}

	public static Object getByType(Class<?> type) {

		if (type == Integer.class || type == int.class) {

			return getInteger();

		} else if (type == BigDecimal.class) {

			return getBigDecimal();

		} else if (type == BigInteger.class) {

			return getBigInteger();

		} else if (type == Date.class) {

			return getDate();

		} else if (type == LocalDateTime.class) {

			return getDateTime();

		} else if (type == LocalDate.class) {

			return getDateTime().toLocalDate();

		} else if (type == LocalTime.class) {

			return getDateTime().toLocalTime();

		} else if (type == Long.class) {

			return getLong();

		} else if (type == String.class) {

			return getString();

		}

		return null;
	}

}
