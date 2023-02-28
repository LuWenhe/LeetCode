package String;

public class Q28_FindTheIndexOfTheFirstOccurrenceInAString {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        int index = new Q28_FindTheIndexOfTheFirstOccurrenceInAString()
                .strStr(haystack, needle);
        System.out.println(index);
    }

}
