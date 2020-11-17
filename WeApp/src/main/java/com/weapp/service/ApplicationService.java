package com.weapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weapp.domain.Application;
import com.weapp.domain.User;
import com.weapp.repositories.ApplicationRepository;

@Service
public class ApplicationService {
	
	@Autowired
	private ApplicationRepository appRepo; 
	
	public Optional<Application> findById(int id) {
		return appRepo.findById(id);
	}
	
	public List<Application> findByNameIgnoreCase(String name) {
		return appRepo.findByNameIgnoreCase(name); 
	}
	
	public List<Application> findByOrganization(String organization) {
		return appRepo.findByOrganization(organization); 
	}
	
	public List<Application> findByApproved(boolean approved) {
		return appRepo.findByApproved(approved); 
	}
	
	public List<Application> findByUser(User user) {
		return appRepo.findByUser(user); 
	}
	
	public List<Application> findByCategory(String category) {
		return appRepo.findByCategory(category); 
	}
	
	public List<Application> findByVersion(String version) {
		return appRepo.findByVersion(version); 
	}
	
	public List<Application> findByPlatform(String platform) {
		return appRepo.findByPlatform(platform); 
	}
	
	public List<Application> findAll() {
		return appRepo.findAll(); 
	} 
	
	public List<Application> findByOrderByNameAsc() {
		return appRepo.findByOrderByNameAsc(); 
	}
	
	public List<Application> findByOrderByPriceDesc() {
		return appRepo.findByOrderByPriceDesc();
	}
	
	public List<Application> findByKeyword(String keyword) {
		return appRepo.findByKeyword(keyword); 
	}
	
	public List<Application> findByKeywordForAdmin(String keyword) {
		return appRepo.findByKeywordForAdmin(keyword);
	}
	
	public List<String> findDistinctCategory() {
		return appRepo.findDistinctCategory();
	}
	
	public List<String> findDistinctPlatform() {
		return appRepo.findDistinctPlatform();
	}
	
	public Application save(Application application) {
		return appRepo.save(application); 
	}
	
	public void deleteApplication(int id) {
		appRepo.deleteById(id);
	}
	
}
