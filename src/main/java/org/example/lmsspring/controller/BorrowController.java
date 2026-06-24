package org.example.lmsspring.controller;
import org.example.lmsspring.service.BorrowService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/loan")
public class BorrowController {
    private final BorrowService borrowService;
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }
    @PostMapping("/{memberId}/{bookId}")
    public String borrowBook(@PathVariable Integer memberId, @PathVariable Integer bookId) {
        return borrowService.borrowBook(memberId, bookId);
    }
    @DeleteMapping("/{loanId}")
    public String returnBook(@PathVariable Integer loanId) {
        return borrowService.returnBook(loanId);
    }
}