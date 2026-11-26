import java.util.Arrays;
import java.util.Scanner;

public class q109 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int sum = 0;//3n人の得点合計値
        
        int n = Integer.parseInt(sc.nextLine());//1行目　5N人の審査員

        String line = sc.nextLine();
        String[] tmp = line.split(" ");
        int[] referee = new int[5*n];//全審査員配列を作成している
            for (int i = 0; i < referee.length; i++){
                referee[i] = Integer.parseInt(tmp[i]);
            } 
        
        Arrays.sort(referee);//昇順に並び替え
        int[] newreferee = new int[4*n];//新審査員配列は5nからn人少ない

        for (int j = 0; j < 4*n; j++){//4n人分繰り返す
            newreferee[j] = referee[j];
        }

        //最小値をカットしていく
        int[] renewreferee = new int[3*n];//新審査員配列は4nからn人少ない
        for (int j = 0; j < 3*n; j++){//3n人分繰り返す
             renewreferee[j] = referee[4*n - 1 - j];//上から数字が入っていく
        }
        for (int i = 0; i < renewreferee.length; i++){
            sum += renewreferee[i];
        }

        double ave = (double) sum / renewreferee.length;

        System.out.printf("%.5f%n", ave);

    }
}

