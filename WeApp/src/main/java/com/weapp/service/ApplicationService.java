/*
 * 
 */
package com.weapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weapp.domain.Application;
import com.weapp.domain.User;
import com.weapp.repositories.ApplicationRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationService.
 */
@Service
public class ApplicationService {
	
	/** The app repo. */
	@Autowired
	private ApplicationRepository appRepo; 
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Application> findById(int id) {
		return appRepo.findById(id);
	}
	
	/**
	 * Find by name ignore case.
	 *
	 * @param name the name
	 * @return the list
	 */
	public List<Application> findByNameIgnoreCase(String name) {
		return appRepo.findByNameIgnoreCase(name); 
	}
	
	/**
	 * Find by organization.
	 *
	 * @param organization the organization
	 * @return the list
	 */
	public List<Application> findByOrganization(String organization) {
		return appRepo.findByOrganization(organization); 
	}
	
	/**
	 * Find by approved.
	 *
	 * @param approved the approved
	 * @return the list
	 */
	public List<Application> findByApproved(boolean approved) {
		return appRepo.findByApproved(approved); 
	}
	
	/**
	 * Find by user.
	 *
	 * @param user the user
	 * @return the list
	 */
	public List<Application> findByUser(User user) {
		return appRepo.findByUser(user); 
	}
	
	/**
	 * Find by category.
	 *
	 * @param category the category
	 * @return the list
	 */
	public List<Application> findByCategory(String category) {
		return appRepo.findByCategory(category); 
	}
	
	/**
	 * Find by version.
	 *
	 * @param version the version
	 * @return the list
	 */
	public List<Application> findByVersion(String version) {
		return appRepo.findByVersion(version); 
	}
	
	/**
	 * Find by platform.
	 *
	 * @param platform the platform
	 * @return the list
	 */
	public List<Application> findByPlatform(String platform) {
		return appRepo.findByPlatform(platform); 
	}
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Application> findAll() {
		return appRepo.findAll(); 
	} 
	
	/**
	 * Find by order by name asc.
	 *
	 * @return the list
	 */
	public List<Application> findByOrderByNameAsc() {
		return appRepo.findByOrderByNameAsc(); 
	}
	
	/**
	 * Find by order by price desc.
	 *
	 * @return the list
	 */
	public List<Application> findByOrderByPriceDesc() {
		return appRepo.findByOrderByPriceDesc();
	}
	
	/**
	 * Find by keyword.
	 *
	 * @param keyword the keyword
	 * @return the list
	 */
	public List<Application> findByKeyword(String keyword) {
		return appRepo.findByKeyword(keyword); 
	}
	
	/**
	 * Find by keyword for admin.
	 *
	 * @param keyword the keyword
	 * @return the list
	 */
	public List<Application> findByKeywordForAdmin(String keyword) {
		return appRepo.findByKeywordForAdmin(keyword);
	}
	
	/**
	 * Find distinct category.
	 *
	 * @return the list
	 */
	public List<String> findDistinctCategory() {
		return appRepo.findDistinctCategory();
	}
	
	/**
	 * Find distinct platform.
	 *
	 * @return the list
	 */
	public List<String> findDistinctPlatform() {
		return appRepo.findDistinctPlatform();
	}
	
	/**
	 * Save.
	 *
	 * @param application the application
	 * @return the application
	 */
	public Application save(Application application) {
		return appRepo.save(application); 
	}
	
	/**
	 * Delete application.
	 *
	 * @param id the id
	 */
	public void deleteApplication(int id) {
		appRepo.deleteById(id);
	}
	
}
