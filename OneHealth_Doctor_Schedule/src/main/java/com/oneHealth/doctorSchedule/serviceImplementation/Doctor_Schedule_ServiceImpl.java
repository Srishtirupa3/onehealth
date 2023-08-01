package com.oneHealth.doctorSchedule.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneHealth.doctorSchedule.entity.Doctor_Schedule;
import com.oneHealth.doctorSchedule.repository.ScheduleRepository;
import com.oneHealth.doctorSchedule.service.Doctor_Schedule_Service;


/**
 * Implementation of the AdminService interface.
 * @author  Madhavi
 * @version 3.9.10
 * @since   28-07-2023
 */
@Service
public class Doctor_Schedule_ServiceImpl implements Doctor_Schedule_Service {

    // Autowire the ScheduleRepository for data access
    @Autowired
    private ScheduleRepository scheduleRepository;

    /**
     * Get an schedule by ID.
     *
     * @param id The ID of the schedule to retrieve.
     * @return The schedule with the specified ID.
     * @throws ScheduleNotFoundException if the schedule is not found.
     */
    @Override
    public Doctor_Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id).orElse(null);
    }
    
    

    /**
     * Get all schedule.
     *
     * @return A list of all schedule.
     */
    @Override
    public List<Doctor_Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    /**
     * Create a new schedule.
     *
     * @param schedule The schedule to create.
     * @return The created schedule.
     */
    @Override
    public Doctor_Schedule createSchedule(Doctor_Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    
    
    /**
     * Update an existing schedule.
     *
     * @param id    The ID of the schedule to update.
     * @param schedule The updated schedule.
     * @return The updated schedule.
     * @throws ScheduleNotFoundException if the schedule is not found.
     */
    @Override
    public Doctor_Schedule updateSchedule(Long id, Doctor_Schedule schedule) {
        // Check if the schedule with the given ID exists
        Doctor_Schedule existingSchedule = getScheduleById(id);
        if (existingSchedule != null) {
            // Update the properties of the existing schedule
            existingSchedule.setDoctor_id(schedule.getDoctor_id());
            existingSchedule.setDate(schedule.getDate());
            existingSchedule.setStart_time(schedule.getStart_time());
            existingSchedule.setEnd_time(schedule.getEnd_time());
            existingSchedule.setType_availability(schedule.getType_availability());
            existingSchedule.setAddress_availability(schedule.getAddress_availability());

            // Save and return the updated schedule
            return scheduleRepository.save(existingSchedule);
        }

        return null;
    }

    /**
     * Delete an schedule by ID.
     *
     * @param id The ID of the schedule to delete.
     * @return A message indicating the success of the deletion.
     * @throws ScheduleNotFoundException if the schedule is not found.
     */
    @Override
    public boolean deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
        return false; // This should be modified to indicate the result of the deletion operation
    }

    /**
     * Delete all schedule.
     *
     * @return A list of all schedule to delete.
     */
    @Override
    public void deleteAllSchedules() {
        scheduleRepository.deleteAll();
    }
}
