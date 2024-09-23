package com.util;

public record ResultDto<T>(
		int code,
		String message,
		T data
		) {
}
