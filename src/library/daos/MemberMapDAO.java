package library.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import library.interfaces.daos.IMemberDAO;
import library.interfaces.daos.IMemberHelper;
import library.interfaces.entities.IMember;

public class MemberMapDAO implements IMemberDAO {
	private IMemberHelper helper;
    private Map<Integer, IMember> memberMap;
    private int nextID;

    public MemberMapDAO(IMemberHelper helper) {
        if (helper == null) {
            throw new IllegalArgumentException(String.format("MemberMapDAO : constructor : helper cannot be null.", new Object[0]));
        }
        this.helper = helper;
        this.memberMap = new HashMap<Integer, IMember>();
        this.nextID = 1;
    }

    public MemberMapDAO(IMemberHelper helper, Map<Integer, IMember> memberMap) {
        this(helper);
        if (memberMap == null) {
            throw new IllegalArgumentException(String.format("MemberMapDAO : constructor : memberMap cannot be null.", new Object[0]));
        }
        this.memberMap = memberMap;
    }

	@Override
	public IMember addMember(String firstName, String lastName, String ContactPhone, String emailAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMember getMemberByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IMember> listMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IMember> findMembersByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IMember> findMembersByEmailAddress(String emailAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IMember> findMembersByNames(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
