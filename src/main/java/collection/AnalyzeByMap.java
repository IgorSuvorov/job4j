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
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temp.put(subject.name(), temp.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String key : temp.keySet()) {
            rsl.add(new Label(key, temp.get(key) / temp.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double stAvg = 0;
            for (Subject subject : pupil.subjects()) {
                stAvg += subject.score();
            }
            rsl.add(new Label(pupil.name(), stAvg));
        }
        Collections.sort(rsl, Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temp.put(subject.name(), temp.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String key : temp.keySet()) {
            list.add(new Label(key, temp.get(key)));
        }
        Collections.sort(list, Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}