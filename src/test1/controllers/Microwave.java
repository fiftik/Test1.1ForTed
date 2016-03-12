package test1.controllers;

public class Microwave implements Toggle {

	static int x = 0;
	
	@Override
	public String onOff() {
		if( x == 0){
			x = 1;
			return "Microwave: I am turned on!";
		} else {
			x = 0;
		    return "Microwave: I am turned off!";
		}
	
	}

}
