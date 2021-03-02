package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;

/**
 * 실제 DB과 연결해서 SQL문을 수행하여 결과를 작성해서 Service에 전달하는 DAO의 interface
 */
public interface IMemberDao {
	
	/**
	 * MemberVO에 담겨진 자료를 DB에서 insert하는 메서드
	 * 
	 * @param memVO DB에 insert할 자료가 저장된 MemberVO객체
	 * @return insert작업 성공 :1 , 실패 : 0
	 */
	public int insertMember(MemberVO memVo);
	
	/**
	 * 회원ID를 매개값으로 받아서 해당 회원 정보를 삭제하는 메서드
	 * 
	 * @param memId 삭제할 회원Id
	 * @return 삭제 성공: 1, 삭제 실패 : 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * MemberVO에 담겨진 정보를 이용하여 회원 정보를 수정하는 메서드
	 * 
	 * @param memVo 수정할 정보가 저장된 MemberVO객체
	 * @return 수정 성공 : 1 , 수정 실패 : 0
	 */
	public int updateMember(MemberVO memVo);
	
	/**
	 * DB의 회원 테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드
	 * 
	 * @return MemberVO객체를 담고 있는 list객체
	 */
	public List<MemberVO> getAllMemberList(); //하나가 한개의 레코드를 갖고 있음
	
	/**
	 * 회원 ID를 매개값으로 받아서 해당 회원의 개수를 반환하는 메서드
	 * 
	 * @param memId 검색할 회원 ID
	 * @return 검색된 회원 ID 개수
	 */
	public int getMemberCount(String memId);
	/**
	 * Map정보를 이용하여 회원정보를 원하는컬럼을 수정하는 메서드
	 * Map의 key값 : 회원 ID(memId), 변경할컬럼명(field).변경한 데이터(data)
	 * @param paraMap 회원 ID, 변경할 컬럼, 변경할 데이터가 저장된 Map객체
	 * @return 수정 성공 0 ,수정 삭제 1
	 */
	public int updateMember2(Map<String, String> paraMap);  //메서드를 간소화 하기 위해
	/**
	 * 회원 ID를 멤버변수로 받아서 해당 회원 정보를 반한하느 메서드
	 * @param memId 검색할 회원 ID
	 * @return 검색된 회원의 정보가 저장될 MemberVO객체
	 */
	public MemberVO getMember(String memId);
	/*
	public int memname(MemberVO memVo);
	
	public int memtel(MemberVO memVo);
	
	public int memaddr(MemberVO memVo);
	*/
}
