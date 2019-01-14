package leaguetracker.backend.handler;

public class LeagueTrackerAPIResponse {
    /**
     * A status code of the request that matches REST status codes
     */
    private int statusCode;

    /**
     * A return body that contains information for the request
     */
    private String body;

    public LeagueTrackerAPIResponse(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }
}
