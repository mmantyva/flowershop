package hh.swd20.flowershop.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Message {
	@NotNull
	private Long id;
	
    @Size(min=5, max=30)
	private String msgText;
    
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
	public String getMsgText() {
		return this.msgText;
	}
	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}
	
	@Override
	public String toString() {
		return "Message [msg=" + this.msgText + "]";
	}
}