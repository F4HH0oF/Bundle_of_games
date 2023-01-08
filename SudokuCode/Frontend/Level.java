package SudokuCode.Frontend;

enum Level {
    EASY(30, "Easy"),
    MEDIUM(45, "Medium"),
    HARD(60, "Hard");
    private int difficulty;
    private String level;

    public int getDifficulty() {
        return difficulty;
    }

    public String getLevel() {
        return level;
    }

    Level(int difficulty, String level) {
        this.difficulty = difficulty;
        this.level = level;
    }
}
