package cheifetz.scrabble.webapp;
import cheifetz.scrabble.Dictionary;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ScrabbleServlet extends HttpServlet {
    private final Dictionary dictionary;

    public ScrabbleServlet() throws FileNotFoundException {
        dictionary = new Dictionary();
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        PrintWriter out = response.getWriter();

        String word = request.getParameter("input");
        String definition = dictionary.hasWord(word) ? dictionary.getDef(word)
                                                     : "Invalid word";
        out.println(definition);
        }
}
