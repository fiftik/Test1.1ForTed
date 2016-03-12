package test1.controllers;

public class Burner implements Toggle {

	static int x = 0;
	
	@Override
	public String onOff() {
		if( x == 0){
			x = 1;
			return "Burner: I am turned on!";
		} else {
			x = 0;
		    return "Burner: I am turned off!";
		}
	
	}

}
