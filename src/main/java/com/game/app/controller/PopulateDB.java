package com.game.app.controller;


import com.game.app.Constants;
import com.game.app.Pair;
import com.game.app.Utils;
import com.game.app.model.GameMode;
 
import com.game.app.model.Question;
 
import com.game.app.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/dev")
public class PopulateDB {
    @Autowired
    private QuestionRepository questionRepository;
     

    @GetMapping("/add-questions-from-files")
    public void addQuestionsFromFiles() throws IOException {
        questionRepository.deleteAll();
        for (Map.Entry<String, GameMode> entry : Constants.QA_FILES.entrySet()) {
            int questionNumber = 0;
            String filename = entry.getKey();
            GameMode gameMode = entry.getValue();
            for (Pair<String, String> question_answer : Utils.readQAFile(filename)) {
                Question q = new Question();
                q.setQuestionText(question_answer.getFirst());
                q.setCorrectAnswer(question_answer.getSecond());
                q.setGameMode(gameMode);
                questionRepository.save(q);
                questionNumber++;
                if (questionNumber > Constants.MAX_QUESTIONS_TO_READ) {
                    break;
                }
            }
        }
    }

   
}