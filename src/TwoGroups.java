import java.util.ArrayList;
import java.util.Scanner;

public class TwoGroups {
    private static ArrayList<ArrayList<Integer>> friends;
    public static void main(String[] args){

        //assigning number of people and friends starts ---------------
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        friends = new ArrayList<>();
        scanner = new Scanner(System.in);
        for(int i = 0; i < n; i++){
            friends.add(new ArrayList<>());
            String temp[] = scanner.nextLine().split(" ");
            //assigning friends list
            for(String s:temp){
                if(s.equals("0")) continue;
                friends.get(i).add(Integer.parseInt(s));
            }
        }
        //assigning number of people and friends ends ---------------

        //return if making team is not possible
        if(!isTeamPossible(n)){
            System.out.println("0");
            return;
        }
        //assign team1
        ArrayList<Integer> team1 = makeTeam(n);
        //print result
        System.out.println(team1.size() + "");
        for(int i = 0; i < team1.size(); i++){
            System.out.print(team1.get(i) + "");
            if(i == team1.size() - 1) continue;
            System.out.print(",");
        }
    }

    //function to make two teams and return first
    private static ArrayList<Integer> makeTeam(int n){
        ArrayList<Integer> team1 = new ArrayList<>();
        ArrayList<Integer> team2 = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(hasFriend(i, team2)){
                if(!team1.contains(i)) team1.add(i);
            }else{
                if(hasFriend(i, team1)){
                    if(!team2.contains(i)) team2.add(i);
                    continue;
                }
                team1.add(i);
                team2.add(friends.get(i - 1).get(0));
            }
        }
        return team1;
    }

    //function to check is there friend of given number in a given list
    private static boolean hasFriend(int n, ArrayList<Integer> list){
        for(int i = 0; i < friends.get(n - 1).size(); i++){
            if(list.contains(friends.get(n - 1).get(i))){
                return true;
            }
        }
        return false;
    }

    //function to check making team is possible
    private static boolean isTeamPossible(int n){
        for(ArrayList<Integer> temp:friends){
            //team is not possible only if at least one of person has no any friend
            if(temp.isEmpty()) return false;
        }
        return true;
    }

//    function to check making team is possible
//    private static boolean isTeamPossible(int n){
//        ArrayList<Integer> numbers = new ArrayList<>();
//        for(int i = 1; i <= n; i++){
//            numbers.add(i);
//        }
//        for(ArrayList<Integer> list : friends){
//            for(int i = 0; i < numbers.size(); i++){
//                if(list.contains(numbers.get(i))){
//                    numbers.remove(i);
//                    i--;
//                }
//            }
//        }
//
//        return (numbers.size() == 0);
//    }
}

//    test input:
//    8
//            2 3 0
//            1 3 0
//            1 2 8 0
//            5 6 0
//            4 8 0
//            4 7 0
//            6 8 0
//            3 5 7 0