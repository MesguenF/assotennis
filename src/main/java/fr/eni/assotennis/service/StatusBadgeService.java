package fr.eni.assotennis.service;

import java.util.List;

import fr.eni.assotennis.bo.StatusBadge;

public interface StatusBadgeService {
	
	public StatusBadge getStatusBadge(long id);
	
	public List<StatusBadge> getStatusBadges();
}