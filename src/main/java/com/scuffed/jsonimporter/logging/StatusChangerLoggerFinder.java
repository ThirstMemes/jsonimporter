package com.scuffed.jsonimporter.logging;

import java.lang.System.Logger;

public class StatusChangerLoggerFinder extends System.LoggerFinder{
	
	@Override
	public Logger getLogger(final String name, final Module module) {
		return new StatusChangerLogger();
	}
}