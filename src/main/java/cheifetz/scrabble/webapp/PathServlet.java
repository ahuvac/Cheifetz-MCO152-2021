package cheifetz.scrabble.webapp;
import cheifetz.scrabble.Dictionary;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class PathServlet extends HttpServlet {
    private final Dictionary dictionary;

    public PathServlet() throws FileNotFoundException {
        dictionary = new Dictionary();
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        PrintWriter out = response.getWriter();

        String word = request.getParameter("input");
        String definition = dictionary.getDef(word);

        if (dictionary.hasWord(word)) {
            request.setAttribute(definition,"output");
        } else {
            out.println("Invalid word");
        }

    }
}
