package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OTPGenerator {

	private List<String> otpList;

	private Random random;

	public OTPGenerator() {

		otpList = new ArrayList<>();

		otpList.add("1134");

		otpList.add("4523");

		otpList.add("8765");

		random = new Random();

	}

	public String generateOtp() {

		int index = random.nextInt(otpList.size());

		return otpList.get(index);

	}

	public static void main(String[] args) {

		OTPGenerator otpGenerator = new OTPGenerator();

		// Example usage:

		String otp = otpGenerator.generateOtp(); // Get a random OTP

		System.out.println("Generated OTP: " + otp);

	}

}
