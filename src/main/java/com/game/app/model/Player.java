package com.game.app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

@SuppressWarnings("serial")
@Entity
@Table(name = "players")
public class Player extends Auditable {
	 

	@NotBlank
    private String name;
	
	


	    @Getter
	    @Setter
	    @URL
	    private String psychFaceURL;
	    @Getter
	    @Setter
	    @URL
	    private String picURL;

	    @OneToOne
	    @Getter
	    @Setter
	    private Stats stats;

	    @ManyToMany(mappedBy = "players")
	    @Getter
	    @Setter
	    private List<Game> games;
	    
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
       
}

 
