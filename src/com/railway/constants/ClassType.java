package com.railway.constants;

public enum ClassType {
	FIRST_CLASS("firstClass"), THIRD_AC("thirdAc"), SECOND_AC("secondAc"), FIRST_AC("firstAc"),
	SLEEPER_CLASS("sleeperClass"), GENERAL("general");

	private String name;

	private ClassType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
