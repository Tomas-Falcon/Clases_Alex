import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

public class ModeloDeDatos extends DefaultTreeModel {

    private DefaultMutableTreeNode nodoRaiz;

    public ModeloDeDatos() {
        super(new DefaultMutableTreeNode("root"));
        nodoRaiz = (DefaultMutableTreeNode) getRoot();
    }

    public void recargar(String unNodo) {
        nodoRaiz.removeAllChildren();
        int nodoAleatorio = (int) (Math.random() * 10);

        for (int i = 0; i < nodoAleatorio; i++) {
            DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode("un nodo hijo");
            nodoHijo.add(obtenerEstructura("algo")); // Modificado
            nodoRaiz.add(nodoHijo);
        }
        super.nodeStructureChanged(nodoRaiz);
    }

    private MutableTreeNode obtenerEstructura(String contenido) {
        DefaultMutableTreeNode retorno = new DefaultMutableTreeNode(contenido); // Modificado
        int nodoAleatorio = (int) (Math.random() * 10);
        for (int i = 0; i < nodoAleatorio; i++) {
            DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode("nodo hijo");
            retorno.add(nodoHijo);
        }
        return retorno;
    }
}
