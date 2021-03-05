class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, ArrayList<String>> map = new HashMap<>();
          for (String s : strings) {
              if (s == null || s == "") {  // in case [null, null, ...] or ["", "", ...]
                if (!map.containsKey(s))
                    map.put(s, new ArrayList<String>());
                map.get(s).add(s);
              } else {
                String str = "";
                for (char c : s.toCharArray())
                str += (c - s.charAt(0) + 26) % 26 + ",";
                if (!map.containsKey(str))
                    map.put(str, new ArrayList<String>());
                map.get(str).add(s);
              }
          }
          List<List<String>> ret = new ArrayList<>();
          for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
              String key = entry.getKey();
              ArrayList<String> value = entry.getValue();
              if (key != null)  // in case [null, null, ...]
                  Collections.sort(value);
              ret.add(value);
            }
          return ret;
    }
}