package com.apt.vo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Apart {
    private Long aptCode;
    private String roadName;
    private String roadNameSeq;
    private String dongName;
	private String apartMentName;
	private double lng;
	private double lat;
}
