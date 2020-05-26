package dao;

import dto.Member;

public interface MemberDao {
	public int selectNextUserno();

	public void joiner(Member member);

}
