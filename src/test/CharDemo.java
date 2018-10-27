public class CharDemo {
    public static void main(String[] args) {
        String str="avgdsfgvadfbsdbnsbnnasd";
        int[] arr=new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)-'a']++;
        }
        for (int i : arr) {
            System.out.println(i);
        }


    }
}
