
package com.JPA.onlineExam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Score")
public class Score {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ScoreIId")
	private int ScoreId;

	private int avg_Topic_score;
	private int percentile;
	private int avg_global_score;

	public int getScoreId() {
		return ScoreId;
	}

	public void setScoreId(int scoreId) {
		ScoreId = scoreId;
	}

	public int getAvg_Topic_score() {
		return avg_Topic_score;
	}

	public void setAvg_Topic_score(int avg_Topic_score) {
		this.avg_Topic_score = avg_Topic_score;
	}

	public int getPercentile() {
		return percentile;
	}

	public void setPercentile(int percentile) {
		this.percentile = percentile;
	}

	public int getAvg_global_score() {
		return avg_global_score;
	}

	public void setAvg_global_score(int avg_global_score) {
		this.avg_global_score = avg_global_score;
	}

	@Override
	public String toString() {
		return "Score [avg_Topic_score=" + avg_Topic_score + ", percentile=" + percentile + ", avg_global_score="
				+ avg_global_score + "]";
	}

}
