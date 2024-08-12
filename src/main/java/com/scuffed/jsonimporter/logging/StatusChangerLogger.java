package com.scuffed.jsonimporter.logging;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
//TODO 09.08.2024: Hübscher machen und anwenden
public class StatusChangerLogger implements System.Logger {
	
	

	@Override
	public String getName() {
		return "StatusChangerLogger";
	}
	
	@Override
	public boolean isLoggable(Level level) {
		return true;
	}
	
	@Override
	public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
		System.out.printf("Abrechnungsstatus [%s]: %s - %s%n", level, msg, thrown);
	}
	
	@Override
	public void log(Level level, ResourceBundle bundle, String format, Object... params) {
		System.out.printf("[%s] | Abrechnungsstatus [%s]: %s%n", LocalDateTime.now(), level.getName(),
						  MessageFormat.format(format, params));
	}
}