package com.oneHealth.doctorSchedule.exception;


/**
 * Custom exception for when an schdule is not found.
 */
public class ScheduleNotFoundException extends Exception {

	 /**
     * Constructs an ScheduleNotFoundException with the specified error message.
     *
     * @param message The error message.
     */
    public ScheduleNotFoundException(String message) {
        // Call the constructor of the parent class (Exception) with the error message
        super(message);
    }
}
