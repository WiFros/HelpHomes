package com.info.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Store {
	
	private String name, categoryId, categoryName, detailCategoryName, dongCode, address, lat, lng;
}
