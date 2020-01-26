package com.spring.codeplace;

import com.spring.codeplace.question.entity.Question;
import com.spring.codeplace.question.repository.QuestionRepository;
import com.spring.codeplace.user.Entity.User;
import com.spring.codeplace.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.BindException;
import java.util.stream.IntStream;

@SpringBootApplication
public class CodeplaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeplaceApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository, QuestionRepository questionRepository) throws Exception{
        return(args) -> {
            User user = userRepository.save(User.builder()
                    .account("test")
                    .password("test")
                    .name("test")
                    .password("test")
                    .email("Test@naver.com")
                    .build());

            IntStream.rangeClosed(1,50).forEach(index ->
                    questionRepository.save(Question.builder()
                    .title("게시글" + index)
                            .contents("test" + index)
                            .user(user).build())
                    );
        };
    }

}
