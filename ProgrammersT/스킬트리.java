import java.util.ArrayList;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        ArrayList<Character> check_al = new ArrayList<Character>();
	    int answer = 0;
	    int count = 0;
	    boolean sw = false;
	    for(int i = 0; i < skill_trees.length; i++) {
	    	for(int j = 0; j < skill_trees[i].length(); j++) {
	    		for(int z = 0; z < skill.length(); z++) {
	    			if(skill.charAt(z) == skill_trees[i].charAt(j)){
		    			check_al.add(skill_trees[i].charAt(j));
		    		}
	    		}
	    	}
	    	
	    	if(check_al.size() == 0) sw = true;
	    	else {
	    		for(int j = 0; j < check_al.size(); j++) {
		    	    if(check_al.get(j) == skill.charAt(count % skill.length())) {
		    	    	sw = true;
		    	    	count++;
		    	    }
		    	    else {
		    	    	sw = false;
		    	    	break;
		    	    }
		    	}
	    	}	
	    	if(sw == true) answer++;
	
	    	check_al.clear();
	    	count = 0;
	    }
        return answer;
    }
}