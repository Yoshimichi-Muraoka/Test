package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Member;

public class MemberDaoImpl implements MemberDao{

	Connection con;

	public MemberDaoImpl(Connection con) {
		if(con != null) {
		this.con=con;
		} else {
			System.out.println("DBへの接続ができませんでした。");
		}
	}

	private void closeConnection() {
		try {
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("接続を切断できません。");
		}
	}

	@Override
	public List<Member> findAll() throws Exception {
		List<Member> memberList = new ArrayList<>();
		String sql = "SELECT *,member_types.name AS type_name FROM members JOIN member_types ON members.type_id = member_types.id";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
	    while (rs.next()) {
	      memberList.add(mapToMember(rs));
	    }
	    closeConnection();
		return memberList;
	}

	@Override
	public Member findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Member member) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Member member) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Member member) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private Member mapToMember(ResultSet rs) throws Exception {
	    Member member = new Member();
	    member.setId((Integer)rs.getObject("id"));
	    member.setName(rs.getString("name"));
	    member.setAge((Integer)rs.getObject("age"));
	    member.setAddress(rs.getString("address"));
	    member.setTypeId((Integer)rs.getObject("type_id"));
	    member.setCreated(rs.getTimestamp("created"));
	    member.setTypeName(rs.getString("type_name"));
	    return member;
	  }

}
