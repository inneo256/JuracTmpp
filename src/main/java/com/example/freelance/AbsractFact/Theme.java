package com.example.freelance.AbsractFact;

public class Theme {
    private String background;
    private String textColor;
    private String buttonColor;
    private String buttonHover;
    private String cardBackground;

    public Theme(String background, String textColor,
                 String buttonColor, String buttonHover, String cardBackground) {
        this.background = background;
        this.textColor = textColor;
        this.buttonColor = buttonColor;
        this.buttonHover = buttonHover;
        this.cardBackground = cardBackground;
    }

    public String getBackground() { return background; }
    public String getTextColor() { return textColor; }
    public String getButtonColor() { return buttonColor; }
    public String getButtonHover() { return buttonHover; }
    public String getCardBackground() { return cardBackground; }
}