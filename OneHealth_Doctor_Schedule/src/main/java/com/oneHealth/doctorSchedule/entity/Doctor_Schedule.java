package com.oneHealth.doctorSchedule.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 * Represents an Doctor_Schedule in the system.
 * @author  Madhavi
 * @version 3.9.10
 * @since   24-05-2023
 */
@Entity
public class Doctor_Schedule {

    // Primary key for the schedule entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slot_id;

    // ID of the doctor associated with this schedule
    private Long doctor_id;

    // Date for the schedule
    private Date date;

    // Start time for the schedule
    private String start_time;

    // End time for the schedule
    private String end_time;

    // Type of availability (e.g., available, unavailable, busy, etc.)
    private String type_availability;

    // Address for the availability (optional, can be used to specify the location)
    private String address_availability;

    // Default constructor
    public Doctor_Schedule() {
        super();
    }

    // Parameterized constructor
    public Doctor_Schedule(Long slot_id, Long doctor_id, Date date, String start_time, String end_time,
            String type_availability, String address_availability) {
        super();
        this.slot_id = slot_id;
        this.doctor_id = doctor_id;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.type_availability = type_availability;
        this.address_availability = address_availability;
    }


	/**
     * Gets the schedule slot ID.
     *
     * @return The schedule slot ID.
     */
    public Long getSlot_id() {
        return slot_id;
    }

    /**
     * Sets the schedule slot ID.
     *
     * @param adminId The administrator ID to set.
     */
    public void setSlot_id(Long slot_id) {
        this.slot_id = slot_id;
    }

    // Getter for doctor_id
    public Long getDoctor_id() {
        return doctor_id;
    }

    // Setter for doctor_id
    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    // Getter for date
    public Date getDate() {
        return date;
    }

    // Setter for date
    public void setDate(Date date) {
        this.date = date;
    }

    // Getter for start_time
    public String getStart_time() {
        return start_time;
    }

    // Setter for start_time
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    // Getter for end_time
    public String getEnd_time() {
        return end_time;
    }

    // Setter for end_time
    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    // Getter for type_availability
    public String getType_availability() {
        return type_availability;
    }

    // Setter for type_availability
    public void setType_availability(String type_availability) {
        this.type_availability = type_availability;
    }

    // Getter for address_availability
    public String getAddress_availability() {
        return address_availability;
    }

    // Setter for address_availability
    public void setAddress_availability(String address_availability) {
        this.address_availability = address_availability;
    }
}
