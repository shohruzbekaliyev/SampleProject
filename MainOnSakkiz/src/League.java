import java.util.ArrayList;

public class League<T extends Team> {
    private ArrayList<T> teams;
    private String name;

    public League(String name) {
        this.name = name;
        this.teams = new ArrayList<>();
    }

    public boolean addTeam(T team) {
        if (teams.contains(team)) {
            System.out.println(team.getName() + " is already exist ");
            return false;
        } else {
            teams.add(team);
            System.out.println(team.getName() + " picked for team " + this.getName());
            return true;
        }
    }

    public ArrayList<T> getTeams() {
        return teams;
    }

    public String getName() {
        return name;
    }
    public static void sort(int[] a){

    }
}
