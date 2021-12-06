package cheifetz.scrabble;
import cheifetz.scrabble.Dictionary;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ScrabbleServlet extends HttpServlet {
    private final Dictionary dictionary;

    public ScrabbleServlet() throws IOException {
        dictionary = new Dictionary();
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        PrintWriter out = response.getWriter();

        String word = request.getParameter("word");
        String definition = dictionary.hasWord(word) ? dictionary.getDef(word) : "Word not found";
        out.println(definition);
        }
}
