package io.github.lianjishu.set.exerciseF;

public class AcademicScores {
    private int chinese;
    private int math;
    private int english;
    private int totalScore;

    public AcademicScores() {
    }

    public AcademicScores(int chinese, int math, int english) {
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.totalScore = chinese + math + english;
    }

    public int getTotalScores() {
        return this.totalScore;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        // this.totalScore = chinese + math + english;
        this.totalScore = this.totalScore - this.chinese + chinese;
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        // this.totalScore = chinese + math + english;
        this.totalScore = this.totalScore - this.math + math;
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        // this.totalScore = chinese + math + english;
        this.totalScore = this.totalScore - this.english + english;
        this.english = english;
    }

    @Override
    public String toString() {
        return "AcademicScores [chinese=" + chinese + ", math=" + math + ", english=" + english + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + chinese;
        result = prime * result + math;
        result = prime * result + english;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AcademicScores other = (AcademicScores) obj;
        if (chinese != other.chinese)
            return false;
        if (math != other.math)
            return false;
        if (english != other.english)
            return false;
        return true;
    }

    // @Override
    // /*
    // * <li>如果总分一样，按照语文成绩排</li>
    // * <li>如果语文一样，按照数学成绩排</li>
    // * <li>如果数学成绩一样，按照英语成绩排</li>
    // * <li>如果英语成绩一样，按照年龄排</li>
    // * <li>如果年龄一样，按照姓名的字母顺序排</li>
    // * <li>如果都一样，认为是同一个学生。</li>
    // */
    // public int compareTo(AcademicScores o) {

    // return 0;
    // }

}
