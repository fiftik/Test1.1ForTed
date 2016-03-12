package test1.controllers;

public class RobotCleaner implements Toggle {

	static int x = 0;
	
	@Override
	public String onOff() {
		if( x == 0){
			x = 1;
			return "RobotCleaner: I am turned on!";
		} else {
			x = 0;
		    return "RobotCleaner: I am turned off!";
		}
	
	}

}
