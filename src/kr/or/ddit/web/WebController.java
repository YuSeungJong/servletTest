package kr.or.ddit.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthScrollBarUI;

import kr.or.ddit.member.action.MemberListAction;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.web.IAction;
import oracle.net.aso.a;

public class WebController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 	URL ==> http://localhost/servletTest2/member/memberList.do
		 	URI ==> /servletTest2/member/memberList.do
		 	ContextPath ==>/servletTest2 ==>13글자
		 	
		 	원하는 요청 URI ==>/member/memberList.do
		 */
		
		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length());
		
		String viewPage = null;
		IAction action = null;
		
		// 요청 URI를 이용해서 실행할 Action객체를 구한다.
		action = URIActionMapper.getAction(uri);
		
		if(action ==null) {
			// 실행할 Action이 없으면 404에러 
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}else {
			// 실행 작업 완료 후 View페이지를 받는다.
			viewPage = action.process(request, response);
			
			if(viewPage!=null) {
				if(action.isRedirect()) { // 리다이렉트 true일 경우
					response.sendRedirect(request.getContextPath() + viewPage);
				}else { // 포워딩
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view" + viewPage);
					rd.forward(request, response);
				}
			}
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
