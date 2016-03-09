package com.empsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empsi.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
