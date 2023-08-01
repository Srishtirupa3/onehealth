package com.oneHealth.doctorSchedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oneHealth.doctorSchedule.entity.Doctor_Schedule;

/**
 * This repository interface provides access to the database for managing doctor schedules.
 * It extends JpaRepository to inherit common CRUD operations and additional functionality.
 *
 * @author Madhavi
 * @version 3.9.10
 * @since 28-07-2023
 */
@Repository
public interface ScheduleRepository extends JpaRepository<Doctor_Schedule, Long> {

}
