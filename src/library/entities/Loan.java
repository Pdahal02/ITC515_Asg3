package library.entities;

import java.util.Date;

import library.interfaces.entities.ELoanState;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

public class Loan implements ILoan {
	private int id;
    private final IMember borrower;
    private final IBook book;
    private Date borrowDate;
    private Date dueDate;
    private ELoanState state;

    public Loan(IBook book, IMember borrower, Date borrowDate, Date returnDate) {
        if (!this.sane(book, borrower, borrowDate, returnDate)) {
            throw new IllegalArgumentException("Loan: constructor : bad parameters");
        }
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.dueDate = returnDate;
        this.state = ELoanState.PENDING;
    }
    private boolean sane(IBook book, IMember borrower, Date borrowDate, Date returnDate) {
        if (book != null && borrower != null && borrowDate != null && returnDate != null && borrowDate.compareTo(returnDate) <= 0) {
            return true;
        }
        return false;
    }


	@Override
	public void commit(int loanId) {
        if (this.state != ELoanState.PENDING) {
            throw new RuntimeException(String.format("Loan : commit : incorrect state transition  : %s -> %s\n", new Object[]{this.state, ELoanState.CURRENT}));
        }
        if (loanId <= 0) {
            throw new RuntimeException(String.format("Loan : commit : id must be a positive integer  : %d\n", loanId));
        }
        this.id = loanId;
        this.state = ELoanState.CURRENT;
        this.book.borrow(this);
        this.borrower.addLoan(this);
	}

	@Override
	public void complete() {
		if (this.state != ELoanState.CURRENT && this.state != ELoanState.OVERDUE) {
            throw new RuntimeException(String.format("Loan : complete : incorrect state transition  : %s -> %s\n", new Object[]{this.state, ELoanState.COMPLETE}));
        }
        this.state = ELoanState.COMPLETE;
	}

	@Override
	public boolean isOverDue() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkOverDue(Date currentDate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IMember getBorrower() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBook getBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
