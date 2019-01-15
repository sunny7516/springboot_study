package com.example.demo2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;


public class calculatorTest {

	@Test
	public void 더하기_테스트() {
		// given // 데이터 주입
		calculator cal = new calculator();
		
		final int a = 3;
		final int b = 5;
		
		// when // 처리
		Integer result = cal.add(a, b);
		
		// then // 검증
		assertThat(result).isEqualTo(8);
	}
	
	@Test
	public void 더하기_모킹_테스트() {
		// given
		calculator calcul = mock(calculator.class);
		
		final int a = 3;
		final int b = 5;
		
		// return 값 조작 가능 (확인용 코드-실제로는 사용 이런식으로 x)
		given(calcul.add(a, b)).willReturn(6);
		
		// when // 처리
		Integer result = calcul.add(a, b);
		
		// then // 검증
		assertThat(result).isEqualTo(8);
	}
}
