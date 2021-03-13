package eu.msdhn.aad;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.aad.adal4j.AuthenticationResult;
import com.microsoft.graph.models.extensions.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AadServlet extends HttpServlet {

    private static final String MS_GRAPH_ME = "https://graph.microsoft.com/v1.0/me";
    private static String OBJ_ID_GRP_1 = null;
    private static String OBJ_ID_GRP_2 = null;
    ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public void init() throws ServletException {
        OBJ_ID_GRP_1 = System.getenv("OBJ_ID_GRP_1");
        OBJ_ID_GRP_2 = System.getenv("OBJ_ID_GRP_2");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AuthenticationResult result = (AuthenticationResult) session.getAttribute(AuthHelper.PRINCIPAL_SESSION_NAME);
        String tenant = session.getServletContext().getInitParameter("tenant");
        try {
            String data = getUserDetailsFromGraph(result.getAccessToken());
            User user = objectMapper.readValue(data, User.class);
            // String myData = getUserGroupDetailsFromGraph(result.getAccessToken(), user);
            // Set response content type
            String groupMemberShip = getUserGroupDetailsFromGraph(result.getAccessToken(), user);
            response.setContentType("text/html");
            // Actual logic goes here.
            PrintWriter out = response.getWriter();
            out.println(data + "\n" + groupMemberShip);
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html");
            response.sendError(500);
            // Actual logic goes here.
            PrintWriter out = response.getWriter();
            out.println("<h1>" + "error" + "</h1>");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AuthenticationResult result = (AuthenticationResult) session.getAttribute(AuthHelper.PRINCIPAL_SESSION_NAME);
        String tenant = session.getServletContext().getInitParameter("tenant");
        try {
            String data = getUserDetailsFromGraph(result.getAccessToken());
            User user = objectMapper.readValue(data, User.class);
            // IGraphServiceClient graphClient = GraphServiceClient.builder().authenticationProvider(new SimpleAuthProvider(result.getAccessToken())).buildClient();
            // LinkedList<String> groupIdsList = new LinkedList<String>();
            // groupIdsList.add("groupIds-value");
            String groupMemberShip = getUserGroupDetailsFromGraph(result.getAccessToken(), user);
            // Set response content type
            response.setContentType("text/html");
            // Actual logic goes here.
            PrintWriter out = response.getWriter();
            out.println(data + "\n" + groupMemberShip);
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html");
            response.sendError(500);
            // Actual logic goes here.
            PrintWriter out = response.getWriter();
            out.println("<h1>" + "error" + "</h1>");
        }
    }

    public void destroy() {
        // do nothing.
    }

    private String getUserDetailsFromGraph(String accessToken) throws Exception {
        URL url = new URL(MS_GRAPH_ME);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
        conn.setRequestProperty("Accept", "application/json");
        int httpResponseCode = conn.getResponseCode();
        return HttpClientHelper.getResponseStringFromConn(conn, true);
    }

    private String getUserGroupDetailsFromGraph(String accessToken, User user) throws Exception {
        URL url = new URL("https://graph.microsoft.com/v1.0/users/" + user.id + "/checkMemberGroups");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Content-Type", "application/json");
        Map<String, List<String>> dataInput = new HashMap();
        dataInput.put("groupIds", Arrays.asList(OBJ_ID_GRP_1, OBJ_ID_GRP_2));
        String jsonInputString = objectMapper.writeValueAsString(dataInput);
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        int httpResponseCode = conn.getResponseCode();
        return HttpClientHelper.getResponseStringFromConn(conn, true);
    }
}
