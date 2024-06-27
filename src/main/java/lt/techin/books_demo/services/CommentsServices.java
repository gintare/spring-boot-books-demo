package lt.techin.books_demo.services;

import lt.techin.books_demo.controllers.dto.CommentRequest;
import lt.techin.books_demo.exceptions.BookNotFoundException;
import lt.techin.books_demo.exceptions.CommentNotFoundException;
import lt.techin.books_demo.model.Book;
import lt.techin.books_demo.model.Comment;
import lt.techin.books_demo.repositories.BookRepository;
import lt.techin.books_demo.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentsServices {

    private CommentRepository commentRepository;
    private BookRepository bookRepository;

    public CommentsServices(CommentRepository commentRepository, BookRepository bookRepository) {
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
    }

    public List<Comment> findAllComments() {
        return this.commentRepository.findAll();
    }

    public Comment createNewComment(Long bookId, CommentRequest commentRequest) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("No book found with id = "+bookId));
        Comment comment  = new Comment();
        comment.setText(commentRequest.getText());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd h:mm:ss");
        comment.setCreatedAt(sdf.format(date));
        comment.setBook(book);
        return this.commentRepository.save(comment);
    }

    public Comment updateComment(Long bookId, Long commentId, CommentRequest commentRequest) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("No book found with id = "+bookId));
        Comment comment  = new Comment();
        comment.setId(commentId);
        comment.setText(commentRequest.getText());
        comment.setBook(book);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd h:mm:ss");
        comment.setCreatedAt(sdf.format(date));
        return this.commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        Comment comment = this.commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("Comment with id = "+id+" not found"));
        commentRepository.delete(comment);
    }


    public List<Comment> findByBookId(Long bookId) {
        return commentRepository.findByBookId(bookId);
    }
}
