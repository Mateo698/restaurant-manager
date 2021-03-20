package model;

import java.io.Serializable;

public class Date implements Serializable{
	private static final long serialVersionUID = 1;
	private int day;
	private int month;
	private int year;
	private int hour;
	private int minutes;

	public Date(int hour, int minutes,int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minutes = minutes;
	
	}
	
	public String intoString() {
		String x = hour+"/"+minutes+" "+day+"/"+month+"/"+year;
		return x;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	public int compareTo(Date otherDate) {
		if(otherDate.getYear()>year) {
			return -1;
		}
		else if(otherDate.getYear()<year){
			return 1;
		}
		else {
			if(otherDate.getMonth()>month) {
				return -1;
			}
			else if(otherDate.getMonth()<month) {
				return 1;
			}
			else {
				if(otherDate.getDay()>day) {
					return -1;
				}
				else if(otherDate.getDay()<day) {
					return 1;
				}
				else {
					if(otherDate.getHour()>hour) {
						return -1;
					}
					else if(otherDate.getHour()<hour) {
						return 1;
					}
					else {
						if(otherDate.getMinutes()>minutes) {
							return -1;
						}
						else if(otherDate.getMinutes()>minutes) {
							return 1;
						}
						else {
							return 0;
						}
					}
				}
			}
		}
		
	}
}
