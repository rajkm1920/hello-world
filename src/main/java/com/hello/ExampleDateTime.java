package com.hello;

import java.security.SecureRandom;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;

import org.springframework.util.ObjectUtils;

import com.google.cloud.trace.core.Timestamp;

public class ExampleDateTime {
	private static DateTimeFormatter standardFormatter =
	        new DateTimeFormatterBuilder()
	                .appendPattern("yyyy-MM-dd'T'HH:mm:ss[.SSS]'Z'")
	                .toFormatter();
	 static Clock clock = Clock.systemUTC();

	public static void main(String[] args) {
		try {
			
			
			SecureRandom random = new SecureRandom();
			random.nextInt();
			
			String now = Instant.now().toString();
			String now1 = "";
			if(now1 != null && !ObjectUtils.isEmpty(now1)) {
				System.err.println("Not Null ");
				System.err.println("--"+Instant.parse(now1).toEpochMilli()); 
			}
			
			System.err.println(Instant.now().truncatedTo( ChronoUnit.NANOS ).toString()+"::::Instant.now()");
			System.err.println(Instant.now(clock).toString()+"::::Instant.now(clock)");
			System.err.println(OffsetDateTime.now(ZoneOffset.UTC)+"::::OffsetDateTime.now(ZoneOffset.UTC)");
			System.err.println(ZonedDateTime.now(ZoneId.of("UTC"))+"::::ZonedDateTime.now(ZoneId.of(UTC))");
			System.err.println(LocalDateTime.now(ZoneId.of("UTC"))+"::::LocalDateTime.now(ZoneId.of(\"UTC\"))");
			long publishMilli = LocalDateTime.parse(now, standardFormatter).toInstant(ZoneOffset.UTC).toEpochMilli();
			//System.err.print(Timestamp);
			
		
			System.err.print(publishMilli);
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
