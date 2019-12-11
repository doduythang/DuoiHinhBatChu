package com.example.duoihinhbatchu.Model;

public class Answer {
    private String answer;
    private int idImage;

    public Answer(String answer, int idImage) {
        this.answer = answer;
        this.idImage = idImage;
        //l
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
}
