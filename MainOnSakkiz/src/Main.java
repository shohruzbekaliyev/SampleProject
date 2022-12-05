public class Main {
    public static void main(String[] args) {

        Team<Footballplyer> footballPlayerTeam = new Team<>("FootBallTeam");
        footballPlayerTeam.addPlayer(new Footballplyer("Hayotbek"));
        footballPlayerTeam.addPlayer(new Footballplyer("Asrorbek"));
        footballPlayerTeam.addPlayer(new Footballplyer("Akrom"));
        footballPlayerTeam.addPlayer(new Footballplyer("benzima"));
        League<Team<Footballplyer>> teamLeague1 = new League<>("FootBallPlayerLeague");
        teamLeague1.addTeam(footballPlayerTeam);

        Team<Bassketball> baseBallPlayerTeam = new Team<>("Baseballteam");
        baseBallPlayerTeam.addPlayer(new Bassketball("Xusniddin"));
        baseBallPlayerTeam.addPlayer(new Bassketball("Abror"));
        baseBallPlayerTeam.addPlayer(new Bassketball("Alisher"));
        baseBallPlayerTeam.addPlayer(new Bassketball("Aziz"));
        League<Team<Bassketball>> baseBallPlayerLeague = new League<>("baseBallPlayerLeague");
        baseBallPlayerLeague.addTeam(baseBallPlayerTeam);

        Team<SoccerPlayer> soccerPlayerTeam = new Team<>("SoccerTeam");
        soccerPlayerTeam.addPlayer(new SoccerPlayer("Hayitali"));
        soccerPlayerTeam.addPlayer(new SoccerPlayer("Abbos"));
        soccerPlayerTeam.addPlayer(new SoccerPlayer("Karim"));
        soccerPlayerTeam.addPlayer(new SoccerPlayer("Axror"));
        League<Team<SoccerPlayer>> teamLeague = new League<>("SoccerPlayerLeague");
        teamLeague.addTeam(soccerPlayerTeam);





    }
}
