package library.entities;

import library.interfaces.entities.EBookState;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;

public class Book implements IBook {
	
	private String author;
    private String title;
    private String callNumber;
    private int id;
    private ILoan loan;
    private EBookState state;
    
	public Book(String author, String title, String callNumber, int bookID) {
        if (!this.sane(author, title, callNumber, bookID)) {
            throw new IllegalArgumentException("Member: constructor : bad parameters");
        }
	}
        
        private boolean sane(String author, String title, String callNumber, int bookID) {
            if (!(author == null || author.isEmpty() || title == null || title.isEmpty() || callNumber == null || callNumber.isEmpty() || bookID <= 0)) {
                return true;
            }
            return false;
        }

	@Override
	public void borrow(ILoan loan) {
		// TODO Auto-generated method stub

	}

	@Override
	public ILoan getLoan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void returnBook(boolean damaged) {
		// TODO Auto-generated method stub

	}

	@Override
	public void lose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void repair() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public EBookState getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCallNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
