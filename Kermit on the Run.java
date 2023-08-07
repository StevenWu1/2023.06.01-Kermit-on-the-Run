import java.util.*;

public class Solution {
    static ArrayList<String> teamsQualified = new ArrayList<>();
    static ArrayList<String> teamsDUP = new ArrayList<>();
    static ArrayList<Integer> rank = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int runners = Integer.parseInt(sc.nextLine());
        String[] teams = new String[runners];
        for (int i = 0; i < runners; i++) {
            String teamName = sc.nextLine();
            teams[i] = teamName;
        }
        qualified(teams);
        teamsDUP = removeDuplicates(teamsQualified);
        for (int i = 0; i < teamsDUP.size(); i++) {
            rank.add(0);
            String current = teamsDUP.get(i);
            int count = 0;
            for (int j = 0; count < 5 && j < teamsQualified.size(); j++) {
                String current2 = teamsQualified.get(j);
                if (current.equals(current2)) {
                    rank.set(i, rank.get(i) + (j + 1));
                    count++;
                }
            }
        }
        sort(teamsDUP, rank);
        for (int i = 0; i < teamsDUP.size(); i++) {
            System.out.println(teamsDUP.get(i) + ": " + rank.get(i));
        }
    }

    public static void sort(ArrayList<String> list, ArrayList<Integer> rank) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                String currentString = list.get(i);
                String currentString2 = list.get(j);
                int currentInt = rank.get(i);
                int currentInt2 = rank.get(j);

                if (currentInt2 < currentInt || (currentInt2 == currentInt && compare6thPlace(currentString, currentString2))) {
                    // Swap teams and ranks
                    list.set(i, currentString2);
                    list.set(j, currentString);
                    rank.set(i, currentInt2);
                    rank.set(j, currentInt);
                }
            }
        }
    }

    public static boolean compare6thPlace(String team1, String team2) {
        int count1 = 0, count2 = 0;
        for (String qualifiedTeam : teamsQualified) {
            if (qualifiedTeam.equals(team1)) {
                count1++;
            } else if (qualifiedTeam.equals(team2)) {
                count2++;
            }
            //System.out.println(team1 + ": " + count1 + " " + team2 + ": " + count2);
            if (count1 == 6 && count2 < 6) {
                return false;
            } else if (count1 < 6 && count2 == 6) {
                return true;
            }
        }
        if (count1 < 6 && count2 < 6){
            return (compare5thPlace(team1, team2));
        }
        return false;
    }
    
    public static boolean compare5thPlace(String team1, String team2){
        int count1 = 0, count2 = 0;
        for (String qualifiedTeam : teamsQualified) {
            if (qualifiedTeam.equals(team1)) {
                count1++;
            } else if (qualifiedTeam.equals(team2)) {
                count2++;
            }

            if (count1 == 5 && count2 < 5) {
                return false;
            } else if (count1 < 5 && count2 == 5) {
                return true;
            }
        }
        return false;
    }

    public static void qualified(String[] teams) {
        for (int i = 0; i < teams.length; i++) {
            String current = teams[i];
            int count = 0;
            for (int j = 0; j < teams.length; j++) {
                String current2 = teams[j];
                if (current2.equals(current)) {
                    count++;
                }
            }
            if (count >= 5) {
                int count1 = 0;
                for (int k = teamsQualified.size() - 1; k >= 0; k--) {
                    if (teamsQualified.get(k).equals(current)) {
                        count1++;
                    }
                }
                if (count1 < 7) {
                    teamsQualified.add(current);
                }
            }
        }
    }

    public static ArrayList<String> removeDuplicates(ArrayList<String> list) {
        ArrayList<String> newList = new ArrayList<>();
        for (String element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }
}
