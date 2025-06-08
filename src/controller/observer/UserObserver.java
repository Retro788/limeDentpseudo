package controller.observer;


import model.User;


public interface UserObserver {
	
	/**
	 *
	 * Updates the observer with the latest profile photo of the logged-in user.
	 *
	 * @param loggedInUser the user whose profile photo has changed
	 */
	void updateProfilePhoto( User loggedInUser );
	
	/**
	 *
	 * Updates the observer with the latest information of the logged-in user.
	 *
	 * @param loggedInUser the user whose information has changed
	 */
	void updateUserInfo( User loggedInUser );
	
}
