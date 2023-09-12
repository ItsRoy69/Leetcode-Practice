class Solution {
    public List<String> letterCombinations(String digits) {
        
      ArrayList <String> ans = new ArrayList<>();	
					if(digits==null || digits.length()==0){
						return new ArrayList<>();
					}

		        
					else { ans = PhonePad("",digits);
		          return ans;}

    }

    static String mapping(int Digit) {
		String Alpha[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs","tuv","wxyz" };

		String code = Alpha[Digit];
		  

		return code;

	}

    static ArrayList<String> PhonePad(String p , String up) {
		   
		  if(up.isEmpty()) {
			  ArrayList <String> List = new ArrayList<>();	
			List.add(p);
			return List;
		  }
		  
		  
		  ArrayList <String> list = new ArrayList<>();
		  int digit = up.charAt(0) - '0';
		  String code = mapping(digit);
		  for(char letter : code.toCharArray() ) {
			  char ch =  letter;
			 list.addAll(PhonePad(p+ch, up.substring(1)));
	
		  }
		  return list;
	  }
}