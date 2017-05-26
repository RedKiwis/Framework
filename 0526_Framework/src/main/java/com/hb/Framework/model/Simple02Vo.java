package com.hb.Framework.model;

public class Simple02Vo {
	private int sabun,pay;
	private String name,nalja;
	
	public Simple02Vo() {
		// TODO Auto-generated constructor stub
	}

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNalja() {
		return nalja;
	}

	public void setNalja(String nalja) {
		this.nalja = nalja;
	}

	@Override
	public String toString() {
		return "Simple02Vo [sabun=" + sabun + ", pay=" + pay + ", name=" + name + ", nalja=" + nalja + "]";
	}
	
	
}
