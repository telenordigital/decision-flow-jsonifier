import com.telenordigital.decisionflow.DecisionFlowDescriber;
import com.telenordigital.decisionflow.describers.JsonDescriber;
import com.telenordigital.decisionflow.describers.Papyrus;
import com.telenordigital.decisionflow.describers.VisualParadigm;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final String PAPYRUS = "-papyrus";
    private static final String VISUAL_PARADIGM = "-visualparadigm";

    private static final List<String> umlToolIndicators = Arrays.asList(PAPYRUS, VISUAL_PARADIGM);

    public static void main(String[] args) {
        final List<String> lArgs = Arrays.asList(args);
        final List<String> umlTools =
                lArgs.stream().filter(s -> umlToolIndicators.contains(s)).collect(Collectors.toList());
        if (umlTools.size() != 1) {
            printUsage();
            return;
        }

        final List<String> fileNames =
                lArgs.stream().filter(s -> !umlToolIndicators.contains(s)).collect(Collectors.toList());
        if (fileNames.size() != 1) {
            printUsage();
            return;
        }

        DecisionFlowDescriber describer;
        switch(umlTools.get(0)) {
            case PAPYRUS:
                describer = Papyrus.getInstance(fileNames.get(0));
                break;
            case VISUAL_PARADIGM:
                describer = VisualParadigm.getInstance(fileNames.get(0));
                break;
            default:
                printUsage();
                return;
        }
        JsonDescriber jsonDescriber = (JsonDescriber) JsonDescriber.getInstance(describer);
        System.out.println(jsonDescriber.getJson());

    }

    private static void printUsage() {
        System.out.println(
                String.format("Usage: java -jar [%s] < /path/to/uml/or/xmi//file > /path/to/jsonFile",
                umlToolIndicators.stream().collect(Collectors.joining("|"))));
    }
}
