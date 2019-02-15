package com.puck.utilities;


// Print quelque chose en sortie


public interface Logger {
	

	public static void logMethod(String methodeName,String message)
	{
		System.out.println("["+ methodeName + "]: " + message);
	}

	public static void logError(String methodeName,String message)
	{
		System.err.println("["+ methodeName + "]: " + message);
	}
}
