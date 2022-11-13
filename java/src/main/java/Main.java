import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

public class Main {

    static String exp = "((a === 1)  && (b === \"www\")) || (g != 12)";

    public static void main(String[] args) throws IOException {

        Context context = Context.newBuilder("js")
                                 .allowIO(true)
                                 .allowExperimentalOptions(true)
                                 .option("js.esm-eval-returns-exports", "true")
                                 .build();

        URL varCollector = Main.class.getClassLoader().getResource("vars-collector.mjs");
        Source source = Source.newBuilder("js", varCollector)
                              .mimeType("application/javascript+module")
                              .build();

        Value exports = context.eval(source);
        Value result = exports.invokeMember("getGlobalVarNames", exp, "{}");

        System.out.println("Global var name list: ");
        System.out.println(result.as(List.class));
    }

}
