package com.board.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//vo(value object): 테이블 안의 레코드 한 건의 정보를 담는 역할

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Board {
	private Integer num;
	private String writer;
	private String wdate;
	private String title;
	private String content;
	private Integer count;	


}
