package chap06;

import chap06.board.*;
import chap06.member.*;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainQuickStart {
	//aop를 사용하여 콘솔창에 log를 찍어줄것이다.
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:acQuickStart.xml");
		
		WriteArticleService writeArticleService = ctx.getBean("writeArticleService", WriteArticleService.class);
		//writearticle 서비스 빈을 가져와서 저장
		writeArticleService.write(new NewArticleRequest("writer", "title", "content"));
		//값을 넣고 호출값이 어떻게 나오나 확인
		
		MemberService memberService = ctx.getBean(MemberService.class);
		//마찬가지
		MemberRegRequest memberRegReq = new MemberRegRequest("id", "name", "pw");
		memberService.regist(memberRegReq);
		
		ctx.close();
	}
}
