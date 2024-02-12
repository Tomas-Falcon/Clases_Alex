
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

public class ModeloDeDatos extends DefaultTreeModel{

		private DefaultMutableTreeNode nodoRaiz;
		
		public ModeloDeDatos() {
			super(new DefaultMutableTreeNode("root"));
			nodoRaiz = (DefaultMutableTreeNode)getRoot();
		}
		
		public void recargar(String unNodo) {
			nodoRaiz.removeAllChildren();
			int nodoAleatorio = (int) (Math.random()*10);
			
			for(int i = 0; i < nodoAleatorio; i++) {
				DefaultMutableTreeNode nodohijo = new DefaultMutableTreeNode("un nodo hijo");
				nodohijo.add(obtenerEstructura(unNodo.toString()));
				nodoRaiz.add(nodohijo);
				super.nodeStructureChanged(nodoRaiz);
			}
		}
		
		private MutableTreeNode obtenerEstructura(String string) {
			DefaultMutableTreeNode retorno = new DefaultMutableTreeNode();
			int nodoAleatorio = (int) (Math.random()*10);
			for (int i = 0; i < nodoAleatorio; i++) {
				DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode();
				retorno.add(nodoHijo);
			}
			return retorno;
		}
		
	

}
