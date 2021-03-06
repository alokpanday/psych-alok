package com.game.app.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "stats")
public class Stats extends Auditable {
    @Getter
    @Setter
    private long correctAnswers = 0;
    @Getter
    @Setter
    private long gotPsychedCount = 0;
    @Getter
    @Setter
    private long psychedOthersCount = 0;
}