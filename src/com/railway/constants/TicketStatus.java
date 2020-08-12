package com.railway.constants;

public enum TicketStatus {
	CONFIRMED("confirmed"), WAITINGLIST("waitingList"), CANCELLED("cancelled");

	private String name;

	private TicketStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
