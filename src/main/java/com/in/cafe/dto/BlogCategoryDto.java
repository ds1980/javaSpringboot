package com.in.cafe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BlogCategoryDto {
	private Integer categoryId;
	private String categoryTitle;
	private String categoryDescription;
}
