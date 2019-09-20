package com.uks.jvs.jyoti.test.assignment3;

import java.util.Base64;
import java.util.Scanner;

/**
 * Class Name :EncodeDecodeDemo Description : Encode and Decode the entered
 * string using Base64 encoder and decoder
 *
 * @author Jyoti [04-07-2019]
 *
 */
public class EncodeDecodeDemo {

	public static void main(String[] args) {

		Scanner objScanner = new Scanner(System.in);
		String stringValue = null;
		System.out.println("Input String is :");
		stringValue = objScanner.next();
		// Encode this value into Base6
		String stringValueBase64Encoded = Base64.getEncoder().encodeToString(stringValue.getBytes());
		System.out.println(stringValue + " when Base64 encoded is: " + stringValueBase64Encoded);

		// Decode Base64 encoded value
		byte[] byteValueBase64Decoded = Base64.getDecoder().decode(stringValueBase64Encoded);
		String stringValueBase64Decoded = new String(byteValueBase64Decoded);

		System.out.println(stringValueBase64Encoded + " when decoded is: " + stringValueBase64Decoded);
		objScanner.close();
	}

}
