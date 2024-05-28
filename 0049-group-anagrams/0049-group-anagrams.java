class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String, List<String>> map = new HashMap<>();
      for(String str: strs) {
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        String newStr = new String(temp);
        if(!map.containsKey(newStr)) {
          map.put(newStr, new ArrayList<>());
        }
        map.get(newStr).add(str);
      }
      return new ArrayList<>(map.values());
    }
}