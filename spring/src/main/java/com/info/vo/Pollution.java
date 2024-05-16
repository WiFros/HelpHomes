package com.info.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pollution {
	
	private String year, month, day, dongCode, guName;
	private Integer microDust, ultraMicroDust;
	private Float ozone;
}
