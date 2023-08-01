package com.oneHealth.doctorSchedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.oneHealth.doctorSchedule.entity.Doctor_Schedule;
import com.oneHealth.doctorSchedule.exception.ScheduleNotFoundException;
import com.oneHealth.doctorSchedule.service.Doctor_Schedule_Service;

import java.util.List;

/**
 * The ScheduleController class handles the API endpoints related to Schedule
 * operations.
 * 
 * @author Madhavi
 * @version 3.9.10
 * @since 28-07-2023
 */
@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private Doctor_Schedule_Service doctor_scheduleService;

    /**
     * Get all schedules.
     *
     * @return ResponseEntity with all schedules or a not found
     *         response if no schedules are found.
     */
    @GetMapping("/allSchedules")
    public ResponseEntity<List<Doctor_Schedule>> getAllSchedules() throws ScheduleNotFoundException {
        List<Doctor_Schedule> schedules = doctor_scheduleService.getAllSchedules();
        if (schedules.isEmpty()) {
            throw new ScheduleNotFoundException("No schedules found.");
        }
        return ResponseEntity.ok(schedules);
    }

    /**
	 * Get an slot_id by ID.
	 *
	 * @param id The ID of the slot_id to retrieve.
	 * @return ResponseEntity with the slot_id object if it exists, or a not found
	 *         response if the slot_id is not found.
	 */
    @GetMapping("/{slot_id}")
    public ResponseEntity<Object> getScheduleById(@PathVariable("slot_id") Long id) {
        try {
            Doctor_Schedule schedule = doctor_scheduleService.getScheduleById(id);
            if (schedule != null) {
                return ResponseEntity.ok(schedule);
            } else {
                throw new ScheduleNotFoundException("Schedule not found with slot_id: " + id);
            }
        } catch (ScheduleNotFoundException e) {
            String message = e.getMessage();
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            String errorMessage = "Internal Server Error: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
	 * Create a new slot_id.
	 *
	 * @param doctor_schedule The doctor_schedule object containing the details of the new doctor_schedule.
	 * @return ResponseEntity with the created doctor_schedule object if successful, or an
	 *         internal server error response if the creation fails.
	 */
    @PostMapping("/create")
    public ResponseEntity<Object> createSchedule(@RequestBody Doctor_Schedule doctor_schedule) {
        try {
            Doctor_Schedule createdDoctorSchedule = doctor_scheduleService.createSchedule(doctor_schedule);
            Long createdScheduleId = createdDoctorSchedule.getSlot_id();
            String successMessage = "Schedule created successfully with ID: " + createdScheduleId;
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);
        } catch (Exception e) {
            String errorMessage = "Internal Server Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }


	/**
	 * Update an existing slot_id.
	 *
	 * @param id    The ID of the slot_id to update.
	 * @param schedule The updated schedule object.
	 * @return ResponseEntity with the updated schedule object if successful, or a not
	 *         found response if the schedule is not found.
	 */
    @PutMapping("/{slot_id}")
    public ResponseEntity<Object> updateSchedule(@PathVariable("slot_id") Long id,
                                                  @RequestBody Doctor_Schedule schedule) throws ScheduleNotFoundException {
        try {
            Doctor_Schedule updatedSchedule = doctor_scheduleService.updateSchedule(id, schedule);
            if (updatedSchedule != null) {
                String successMessage = "Schedule updated successfully with ID: " + id;
                return ResponseEntity.ok().body(successMessage);
            } else {
                String errorMessage = "Schedule not found with slot_id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (Exception e) {
            // Log the exception or return a custom error response for other exceptions
            String errorMessage = "Internal Server Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    /**
     * Removes a schedule by their ID.
     *
     * @param slot_id The ID of the Schedule to remove.
     * @return ResponseEntity with a success message if the schedule is deleted successfully,
     *         or an error message if the schedule deletion fails.
     */
    @DeleteMapping("/{slot_id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable("slot_id") Long slotId) throws ScheduleNotFoundException {
        try {
            boolean isDeleted = doctor_scheduleService.deleteSchedule(slotId);
            if (isDeleted) {
                String successMessage = "Schedule with ID " + slotId + " has been successfully deleted.";
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(successMessage);
            } else {
                String errorMessage = "Schedule not found with ID: " + slotId;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (Exception e) {
            // Log the exception or return a custom error response
            String errorMessage = "Internal Server Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }


    /**
     * Deletes an allSchedules by its ID.
     *
     * @param slot_id The ID of the order to delete.
     * @throws OrdersNotFoundException if the schedule is not found.
     */
    @DeleteMapping("/allSchedules")
    public ResponseEntity<Void> deleteAllSchedules() {
        try {
            doctor_scheduleService.deleteAllSchedules();
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            // Log the exception or return a custom error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
