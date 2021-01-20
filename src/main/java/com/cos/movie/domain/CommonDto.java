package com.cos.movie.domain;

import lombok.Data;

@Data
public class CommonDto<T> {
	private int satusCode;
	private T data;
	
	public CommonDto(int satusCode, T data) {
		super();
		this.satusCode = satusCode;
		this.data = data;
	}
	public CommonDto(int satusCode) {
		super();
		this.satusCode = satusCode;
	}
}
