package org.example.lmsspring.service;
import jakarta.transaction.Transactional;
import org.example.lmsspring.model.Book;
import org.example.lmsspring.model.Loan;
import org.example.lmsspring.model.Member;
import org.example.lmsspring.repository.BookRepository;
import org.example.lmsspring.repository.LoanRepository;
import org.example.lmsspring.repository.MemberRepository;
import org.springframework.stereotype.Service;
@Service
public class BorrowService {
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final LoanRepository loanRepository;
    public BorrowService(BookRepository bookRepository, MemberRepository memberRepository, LoanRepository loanRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.loanRepository = loanRepository;
    }
    @Transactional
    public String borrowBook(Integer memberId, Integer bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if(book == null)
            return "Book not found";
        if(!book.getStatus().equals("AVAILABLE"))
            return "Book unavailable";
        Member member = memberRepository.findById(memberId).orElse(null);
        if(member == null)
            return "Member not found";
        Loan loan = new Loan();
        loan.setBook(book);
        loan.setMember(member);
        loanRepository.save(loan);
        book.setStatus("BORROWED");
        bookRepository.save(book);
        return "Book borrowed successfully";
    }
    @Transactional
    public String returnBook(Integer loanId) {
        Loan loan = loanRepository.findById(loanId).orElse(null);
        if(loan == null)
            return "Loan not found";
        Book book = loan.getBook();
        book.setStatus("AVAILABLE");
        bookRepository.save(book);
        loanRepository.delete(loan);
        return "Book returned successfully";
    }
}