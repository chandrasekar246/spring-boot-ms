package com.github.chandrasekar246.java8.demo.uc2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UniqueUserActivity {

	public static void main(String[] args) throws IOException {
		
		URL userActivityFileUrl = UniqueUserActivity.class.getClassLoader().getResource("user-activity.log");
		
		File userActivityFile = new File(userActivityFileUrl.getFile());
		
		System.out.println("====== File Content ======");
		Files.lines(userActivityFile.toPath()).forEach(System.out::println);
		
		System.out.println("\n====== Maximum Users Logged-In During An Hour ======");
		//System.out.println(Files.lines(userActivityFile.toPath()).map(line -> parse(line)).filter(user -> user[1].equals("USER1")).map(user -> user[0]).toList());
		System.out.println(Files.lines(userActivityFile.toPath()).map(line -> parse(line)).filter(user -> myTimeFilter(user)).map(user -> user[0]).toList());
	}

	private static boolean myTimeFilter(String[] user) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy hh:mm:ss a");
		LocalDateTime dateTime = LocalDateTime.parse(user[0], formatter);
		
		return dateTime.isAfter(LocalDateTime.of(2022, 3, 7, 12,0)) && dateTime.isBefore(LocalDateTime.of(2022, 3, 7, 12,10));
	}

	private static String[] parse(String line) {
		String[] timeUserActivity = new String[3];

		timeUserActivity[0] = line.substring(0, 23);

		String remaining = line.substring(24);
		String[] userActivity = remaining.split("\\s+");

		timeUserActivity[1] = userActivity[0];
		timeUserActivity[2] = userActivity[1];
		
		//System.out.println(timeUserActivity[0] + "~" + timeUserActivity[1] + "~" + timeUserActivity[2]);

		return timeUserActivity;
	}

}
