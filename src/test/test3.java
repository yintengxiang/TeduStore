public class test3 {

    public static void main(String[] args) {
        int sum=0;
        for (int x=0;x<10;x++){
            sum+=x;
            if(x%3==0){
                break;
            }
        }
        System.out.println(sum);
    }
}
