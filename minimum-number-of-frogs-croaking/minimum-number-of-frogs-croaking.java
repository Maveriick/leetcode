class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
       if (croakOfFrogs.length() % 5 != 0) return -1;
        int c=0, r=0, o=0, a=0, k=0;
        int frogs=1;
        Stack<Character> croaks = new Stack<>();
        for (char letter : croakOfFrogs.toCharArray()) {
            if (letter == 'c') {
                c++;
                croaks.push(letter);
                frogs = Math.max(frogs,croaks.size());
            }
            if (letter == 'r') {
                r++;
                if (r > c) return -1;
            }
            if (letter == 'o') {
                o++;
                if (o > r) return -1;
            }
            if (letter == 'a') {
                a++;
                if (a > r) return -1;
            }
            if (letter == 'k') {
                k++;
                if (k > a) return -1;
                if (croaks.isEmpty()) return -1;
                croaks.pop();
            }
        }
        if (!(c==r&&r==o&&o==a&&a==k)) return -1;
        return frogs;
    }
}