package com.JCEX.utils;

/*
 *数据处理类
 */
public class ByteUtil {

	public static int bs2Int(byte bs) {
		return Integer.valueOf(bs);
	}

	public static String toString(byte[] bytes, int index, int size) {
		StringBuilder builder = new StringBuilder(size);
		for (byte byteChar : bytes) {
			builder.append(String.format("%02x ", byteChar));
		}
		return builder.toString();
	}

	public static String toString(byte[] bytes) {
		return toString(bytes, 0, bytes.length);
	}

	public static byte[] hexStringToBytes(String hex) {
		byte[] bytes = new byte[hex.length() / 2];
		String part = "";
		for (int i = 0; i < bytes.length; ++i) {
			part = "0x" + hex.substring(i * 2, i * 2 + 2);
			bytes[i] = Long.decode(part).byteValue();
		}
		return bytes;
	}

	/**
	 * 
	 * @param h
	 *            高8位
	 * @param l
	 *            低8位
	 * @return int
	 */
	public static int bytes2int(byte h, byte l) {
		char c = (char) (((h & 0xFF) << 8) | (l & 0xFF));
		return (int) c & 0xffff;
	}

	/**
	 * 将十进制转换为16进制，高位在前，低位在后
	 * 
	 * @param dec
	 * @return
	 */
	public static String decToHex(int dec) {
		String hex = "";
		while (dec != 0) {
			String h = Integer.toString(dec & 0xff, 16);
			if ((h.length() & 0x01) == 1)
				h = '0' + h;
			hex = hex + h;
			dec = dec >> 8;
		}
		return hex;
	}

}
