package ch.hsr.mge.recyclerviewdemo;

public class Module {

	private String code;
	private String name;
	private boolean selected;

	public Module(String code, String name, boolean selected) {
		this.code = code;
		this.name = name;
		this.selected = selected;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
