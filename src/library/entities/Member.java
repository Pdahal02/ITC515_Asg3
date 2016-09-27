package library.entities;

import java.util.ArrayList;
import java.util.List;

import library.interfaces.entities.EMemberState;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

public class Member implements IMember {
	private final String firstName;
    private final String lastName;
    private final String contactPhone;
    private final String emailAddress;
    private final int id;
    private EMemberState state;
    private List<ILoan> loanList;
    private float totalFines;

    public Member(String firstName, String lastName, String contactPhone, String email, int memberID) {
        if (!this.sane(firstName, lastName, contactPhone, email, memberID)) {
            throw new IllegalArgumentException("Member: constructor : bad parameters");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactPhone = contactPhone;
        this.emailAddress = email;
        this.id = memberID;
        this.loanList = new ArrayList<ILoan>();
        this.totalFines = 0.0f;
        this.state = EMemberState.BORROWING_ALLOWED;
    }

    private boolean sane(String firstName, String lastName, String contactPhone, String emailAddress, int memberID) {
        if (!(firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() || contactPhone == null || contactPhone.isEmpty() || emailAddress == null || emailAddress.isEmpty() || memberID <= 0)) {
            return true;
        }
        return false;
    }


	@Override
	public boolean hasOverDueLoans() {
		for (ILoan loan : this.loanList) {
            if (!loan.isOverDue()) continue;
            return true;
        }
		return false;
	}

	@Override
	public boolean hasReachedLoanLimit() {
		boolean b = this.loanList.size() >= 5;
        return b;
	}

	@Override
	public boolean hasFinesPayable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasReachedFineLimit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getFineAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addFine(float fine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void payFine(float payment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addLoan(ILoan loan) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ILoan> getLoans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeLoan(ILoan loan) {
		// TODO Auto-generated method stub

	}

	@Override
	public EMemberState getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContactPhone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmailAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
