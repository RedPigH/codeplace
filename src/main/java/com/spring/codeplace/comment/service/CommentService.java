package com.spring.codeplace.comment.service;

import com.spring.codeplace.comment.entity.Comment;
import com.spring.codeplace.comment.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@AllArgsConstructor
@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Comment getOneComment(Long oid){
        return commentRepository.getOne(oid);
    }

    public List<Comment> findAll(@PathVariable("targetoid") Long targetoid){
        //Page<Comment> list = commentRepository.findALLbyTargetoid(pageable,targetoid);
        List<Comment> list = commentRepository.findALLbyTargetoid(targetoid);
        return list;
    }

    public void writeComment(Comment comment){
        commentRepository.save(comment);
    }

    public void modifyQuestion(Long oid, Comment newComment){
        commentRepository.findById((Long) oid).map(
                Comment -> {
                    Comment.setContents(newComment.getContents());
                    return commentRepository.save(Comment);
                }).orElseGet(() -> {
            newComment.setOid(oid);
            return commentRepository.save(newComment);
        });
    }

    public void deleteComment(Long oid){
        commentRepository.deleteById(oid);
    }


}
