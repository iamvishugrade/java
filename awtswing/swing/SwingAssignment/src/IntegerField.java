package com.javax.swing;

//import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class IntegerField extends JTextField implements KeyListener {
	final private String validCharsString = "-+0123456789";
	final private String formatStr = "[0-9]";
	
	public IntegerField() {
		this(11); // 11 is default width = Max int digit + sign character
	}
	
	public IntegerField(int length) {
		super(length);
		addKeyListener(this);
	}
	
	public void keyPressed(KeyEvent event) {
	}
	public void keyReleased(KeyEvent event) {
	}
	public void keyTyped(KeyEvent event) {
		char ch = event.getKeyChar();
		if(validCharsString.indexOf(ch) < 0)
			event.setKeyChar('\u0000');
	}
}