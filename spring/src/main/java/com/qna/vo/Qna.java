package com.qna.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Qna {
	private Integer num;
	private String writer;
	private String wdate;
	private String title;
	private String content;
	private Integer count;	
	private String status;
}
