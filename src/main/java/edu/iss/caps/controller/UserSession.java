package edu.iss.caps.controller;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import edu.iss.caps.model.User;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession {
	
	private String sessionId = null;
	private boolean logedIn = false;
	private boolean adminFlag = false;
	private int generalID;
	private User user = null;
	
	public UserSession() {
		super();
	}

	public UserSession(String sessionId, User user) {
		super();
		this.sessionId = sessionId;
		this.user = user;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean isLogedIn() {
		return logedIn;
	}

	public void setLogedIn(boolean logedIn) {
		this.logedIn = logedIn;
	}
	
	public boolean isAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(boolean homeFlag) {
		this.adminFlag = homeFlag;
	}
	
	public int getGeneralID() {
		return generalID;
	}

	public void setGeneralID(int generalID) {
		this.generalID = generalID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSession other = (UserSession) obj;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		return true;
	}
	
	


}
