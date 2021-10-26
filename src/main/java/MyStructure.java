import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStructure  implements IMyStructure{
    private List<INode> nodes;



    public INode findByCode(String code) {
        return filterNode(code);
    }

    private INode filterNode(String code) {
        Optional<INode> iNodeStream=nodes.stream()
                .filter(s->s.equals(code))
                .findFirst();

    return iNodeStream.orElse(null);
    }

    public INode findByRenderer(String renderer) {
        return filterNode(renderer);
    }

    public int count() {
        return nodes.size();
    }
}
interface INode {
    String getCode();
    String getRenderer();
}
interface ICompositeNode extends INode {
    List<INode> getNodes();
}
interface IMyStructure {
    // zwraca węzeł o podanym kodzie lub null
    INode findByCode(String code);
    // zwraca węzeł o podanym rendererze lub null
    INode findByRenderer(String renderer);
    //zwraca liczbę węzłów
    int count();
}
