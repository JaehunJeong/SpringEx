package chap06.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Profiler {
//advice 구현 클래스
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		//이 메서드를 사용해 around advice에 맞는 공통 기능을 구현한다.
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString+"시작");
		
		long start = System.currentTimeMillis();
		
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + "종료");
			System.out.println(signatureString + "실행 시간 : "+(finish - start) + "ms");
		}
	}
}
