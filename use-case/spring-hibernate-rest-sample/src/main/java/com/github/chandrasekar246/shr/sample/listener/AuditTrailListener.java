package com.github.chandrasekar246.shr.sample.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

import com.github.chandrasekar246.shr.sample.entity.Employee2;

@Component
public class AuditTrailListener {

	@PrePersist
	@PreUpdate
	@PreRemove
	private void beforeAnyUpdate(Employee2 employee) {
		if (employee.getId() == null) {
			System.out.println("[Employee AUDIT] About to add a user");
		} else {
			System.out.println("[Employee AUDIT] About to update/delete user: " + employee.getId());
		}
	}

	@PostPersist
	@PostUpdate
	@PostRemove
	private void afterAnyUpdate(Employee2 employee) {
		System.out.println("[Employee AUDIT] add/update/delete complete for user: " + employee.getId());
	}

	@PostLoad
	private void afterLoad(Employee2 employee) {
		System.out.println("[Employee AUDIT] user loaded from database: " + employee.getId());
	}
}