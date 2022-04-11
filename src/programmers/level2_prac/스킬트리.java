package programmers.level2_prac;

public class 스킬트리 {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            String tempSkill = skill_tree;
            for (int i = 0; i < skill_tree.length(); i++) {
                String s = skill_tree.substring(i, i+1);
                if (!skill.contains(s)) {
                    tempSkill = tempSkill.replace(s, "");
                }
            }

            if (skill.indexOf(tempSkill) == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"CBADF", "AECB", "BDA"})); //2
    }
}
