package sk.cyklosoft.hrmservice.web.impl;

public class Greeting {
	private String text;
	private String from;
	private String time;
	
    public Greeting(String from, String text, String time) {
           this.text = text;
           this.from = from;
           this.time = time;
    }

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
