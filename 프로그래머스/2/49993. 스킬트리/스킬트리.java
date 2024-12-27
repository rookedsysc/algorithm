class Solution {
    public int solution(String skill, String[] skill_trees) {
        int idx = 0;
		int ans = 0;
        int skillLen = skill.length();
        
        for(String stree: skill_trees) {
            idx = 0;
            ans ++;
            for(int i = 0; i < stree.length(); i++) {
                char cur = stree.charAt(i);
                if(idx < skillLen && cur == skill.charAt(idx)) {
                    idx ++;
                } else if(skill.indexOf(cur) == -1) {
                    continue;
                } else {
                    ans --;
                    break;
                }
            }
        }
        return ans;
    }
}