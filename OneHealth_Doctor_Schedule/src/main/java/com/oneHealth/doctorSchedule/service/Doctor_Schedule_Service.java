package com.oneHealth.doctorSchedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oneHealth.doctorSchedule.entity.Doctor_Schedule;

// Service interface for managing Doctor_Schedule objects
@Service
public interface Doctor_Schedule_Service {

	/**
     * @author  Madhavi
     * @version 3.9.10
     * @since   28-07-2023
    * Retrieves an schedule by ID.
    *
    * @param id The ID of the schedule to retrieve.
    * @return The retrieved schedule.
    */
    Doctor_Schedule getScheduleById(Long id);

    
    /**
     * Retrieves all schedules.
     *
     * @return A list of all schedules.
     */
    List<Doctor_Schedule> getAllSchedules();


    /**
     * Creates a new schedule.
     *
     * @param schedule The schedule to create.
     * @return The created schedule.
     */
    Doctor_Schedule createSchedule(Doctor_Schedule schedule);
    

    /**
     * Updates an existing schedule.
     *
     * @param id    The ID of the schedule to update.
     * @param schedule The updated schedule information.
     * @return The updated schedule.
     */
    Doctor_Schedule updateSchedule(Long id, Doctor_Schedule schedule);

    /**
     * Deletes schedule by ID.
     *
     * @param id The ID of the schedule to delete.
     * @return A success message indicating the schedule deletion.
     */
    boolean deleteSchedule(Long id);
    
    

    /**
     * Deletes all schedules.
     *
     * @param id The ID of the schedule to delete.
     * @return A success message indicating the all schedules deleted.
    
     */
    void deleteAllSchedules();
}
