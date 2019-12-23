package com.game.app.model;


 
import lombok.Getter;
import lombok.Setter;
import com.game.app.Constants;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "questions")
public class Question extends Auditable {
    @NotBlank
     @Column(length = Constants.MAX_QUESTION_LENGTH)
    private String questionText;
    
    public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public GameMode getGameMode() {
		return gameMode;
	}

	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}

	public List<EllenAnswer> getEllenAnswers() {
		return ellenAnswers;
	}

	public void setEllenAnswers(List<EllenAnswer> ellenAnswers) {
		this.ellenAnswers = ellenAnswers;
	}

	@NotBlank
     @Column(length = Constants.MAX_ANSWER_LENGTH)
    private String correctAnswer;
    
    @NotNull
    private GameMode gameMode;

    @OneToMany(mappedBy = "question")
    private List<EllenAnswer> ellenAnswers;

}