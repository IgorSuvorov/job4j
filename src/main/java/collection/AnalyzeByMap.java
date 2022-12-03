package collection;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0;
        for (Pupil pupil : pupils) {
            double stAvg = 0;
            for (Subject subject : pupil.subjects()) {
                stAvg += subject.score();
            }
            stAvg /= pupil.subjects().size();
            rsl += stAvg;
        }
        return rsl / pupils.size();
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double stAvg = 0;
            for (Subject subject : pupil.subjects()) {
                stAvg += subject.score();
            }
            stAvg /= pupil.subjects().size();
            rsl.add(new Label(pupil.name(), stAvg));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        int subjectIndex = 0;
        while (subjectIndex < pupils.get(0).subjects().size()) {
            double score = 0;
            for (Pupil pupil : pupils) {
                score += pupil.subjects().get(subjectIndex).score();
            }
            score /= pupils.size();
            rsl.add(new Label(pupils.get(0).subjects().get(subjectIndex).name(), score));
            subjectIndex++;
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        String bestName = "";
        double bestScore = 0;
        for (Pupil pupil : pupils) {
            double stAvg = 0;
            for (Subject subject : pupil.subjects()) {
                stAvg += subject.score();
            }
            if (stAvg > bestScore) {
                bestScore = stAvg;
                bestName = pupil.name();
            }
        }
        return new Label(bestName, bestScore);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        String bestName = "";
        double bestScore = 0;
        int subjectIndex = 0;
        while (subjectIndex < pupils.get(0).subjects().size()) {
            double score = 0;
            for (Pupil pupil : pupils) {
                score += pupil.subjects().get(subjectIndex).score();
            }
            if (score > bestScore) {
                bestScore = score;
                bestName = pupils.get(0).subjects().get(subjectIndex).name();
            }
            subjectIndex++;
        }
        return new Label(bestName, bestScore);
    }
}