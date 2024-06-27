package lt.techin.books_demo.controllers;

import lombok.extern.slf4j.Slf4j;
import lt.techin.books_demo.controllers.dto.CommentRequest;
import lt.techin.books_demo.model.Comment;
import lt.techin.books_demo.services.CommentsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping
public class CommentController {

    private CommentsServices commentsServices;

    public CommentController(CommentsServices commentsServices) {
        this.commentsServices = commentsServices;
    }

    @GetMapping("/api/comments")
    public List<Comment> getAllComments() {
        return this.commentsServices.findAllComments();
    }

    @PostMapping("/api/books/{book_id}/comments")
    public ResponseEntity<?> createComment(@PathVariable Long book_id, @RequestBody CommentRequest commentRequest) {
        log.info("Book id: {}", book_id);
        log.info("Comment: {}", commentRequest.getText());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.commentsServices.createNewComment(book_id, commentRequest));
    }

    @PutMapping("/api/books/{book_id}/comments/{comment_id}")
    public ResponseEntity<?> updateComment(@PathVariable Long book_id, @PathVariable Long comment_id, @RequestBody CommentRequest commentRequest) {
        return ResponseEntity.ok(this.commentsServices.updateComment(book_id, comment_id, commentRequest));
    }

    @DeleteMapping("/api/comments/{id}")
    public void deleteComment(@PathVariable Long id) {
        this.commentsServices.deleteComment(id);
    }
    @GetMapping("/api/books/{book_id}/comments")
   // @GetMapping("/api/comments/bybookid/{book_id}")
    public List<Comment> getCommentsByBookId(@PathVariable Long book_id) {
        return commentsServices.findByBookId(book_id);
    }
}
