package com.spring.codeplace.question.service;

import com.spring.codeplace.comment.repository.CommentRepository;
import com.spring.codeplace.question.entity.Question;
import com.spring.codeplace.question.repository.QuestionRepository;
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
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    CommentRepository commentRepository;

    // 전체 list (페이징 처리)
    public Page<Question> findAll(@PageableDefault(sort = { "oid" }, direction = Sort.Direction.DESC, size = 5) Pageable pageable){
        Page<Question> list = questionRepository.findAll(pageable);
        return list;
    }

    // Tag별 list(페이징 처리)
    public Page<Question> findTagAll(@PageableDefault(sort = {"oid"}, direction = Sort.Direction.DESC, size = 5) Pageable pageable, @PathVariable("tag") String tag){
        Page<Question> list = questionRepository.findAllByTag(pageable, tag);
        return list;
    }

    // Tag list
    public List<String> findTag(){
        List<String> list = questionRepository.findAllTag();

        return list;
    }

    // 새 질문 생성
    public void createQuestion(Question question){
        questionRepository.save(question);
    }

    // 질문글 상세보기
    public Question readQuestion(Long oid){
        updateViewcnt(oid, questionRepository.getOne(oid));

        return questionRepository.getOne(oid);
    }

    // 질문글 가져오기
    public Question getOneQuestion(Long oid){
        return questionRepository.getOne(oid);
    }

    // 질문글 수정
    public void updateQuestion(Long oid, Question newQuestion){
        questionRepository.findById((Long) oid).map(
                Question -> {
                    Question.setTitle(newQuestion.getTitle());
                    Question.setContents(newQuestion.getContents());
                    Question.setLastmodifiedat(newQuestion.getLastmodifiedat());
                    Question.setTag(newQuestion.getTag());
                    return questionRepository.save(Question);
                }).orElseGet(() -> {
            newQuestion.setOid(oid);
            return questionRepository.save(newQuestion);
        });
    }

    // 질문글 삭제
    public void deleteQuestion(Long oid){
        questionRepository.deleteById(oid);
    }

    // add viewcnt
    private void updateViewcnt(Long oid, Question newQuestion){
        questionRepository.findById((Long) oid).map(
                Question -> {
                    Question.setViewcnt(newQuestion.getViewcnt() + 1);
                    return questionRepository.save(Question);
                }).orElseGet(() -> {
            newQuestion.setOid(oid);
            return questionRepository.save(newQuestion);
        });
    }

    // add cmtcnt
    public void updateAddCmtcnt(Long oid, Question newQuestion){
        questionRepository.findById((Long) oid).map(
                Question -> {
                    Question.setCmtcnt(newQuestion.getCmtcnt() + 1);
                    return questionRepository.save(Question);
                }).orElseGet(() -> {
            newQuestion.setOid(oid);
            return questionRepository.save(newQuestion);
        });
    }

    // sub cmtcnt
    public void updateSubCmtcnt(Long oid, Question newQuestion){
        questionRepository.findById((Long) oid).map(
                Question -> {
                    Question.setCmtcnt(newQuestion.getCmtcnt() - 1);
                    return questionRepository.save(Question);
                }).orElseGet(() -> {
            newQuestion.setOid(oid);
            return questionRepository.save(newQuestion);
        });
    }

    // add likecnt
    public void updateAddlikecnt(Long oid, Question newQuestion){
        questionRepository.findById((Long) oid).map(
                Question -> {
                    Question.setLikecnt(newQuestion.getLikecnt() + 1);
                    return questionRepository.save(Question);
                }).orElseGet(() -> {
            newQuestion.setOid(oid);
            return questionRepository.save(newQuestion);
        });
    }

    // sub likecnt
    public void updateSublikecnt(Long oid, Question newQuestion){
        questionRepository.findById((Long) oid).map(
                Question -> {
                    Question.setLikecnt(newQuestion.getLikecnt() - 1);
                    return questionRepository.save(Question);
                }).orElseGet(() -> {
            newQuestion.setOid(oid);
            return questionRepository.save(newQuestion);
        });
    }

    // add reportcnt
    public void updateAddreportcnt(Long oid, Question newQuestion){
        questionRepository.findById((Long) oid).map(
                Question -> {
                    Question.setReportcnt(newQuestion.getReportcnt() + 1);
                    return questionRepository.save(Question);
                }).orElseGet(() -> {
            newQuestion.setOid(oid);
            return questionRepository.save(newQuestion);
        });
    }
}
