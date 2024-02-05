package usando_tree_selector;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;


public class UsandoTreeSelector extends JFrame{
	
	public static void main(String[] args) {
		new UsandoTreeSelector();
	}
	
	public UsandoTreeSelector() {
	super("Tree selector");
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Object [] unArray = {Boolean.TRUE, Boolean.FALSE, "Hola"};
	JTree tree = new JTree(unArray);
	tree.setEditable(true);
	
	DefaultTreeCellRenderer renderer;
	renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();	
	
	String [] elementos = {"Madrid", "Toledo", "Barcelona", "Palma de mallorca"};
	
	JComboBox<String> comboBox = new JComboBox<String>(elementos);
	comboBox.setEditable(true);

	JScrollPane scroll = new JScrollPane(tree);
	
	TreeCellEditor comboEditor = new DefaultCellEditor(comboBox);
	
	
	
	TreeCellEditor editor = new DefaultTreeCellEditor(tree, renderer, comboEditor); 
	tree.setCellEditor(editor);

	add(scroll, BorderLayout.CENTER);
	setSize(300,200);
	setLocationRelativeTo(null);
	setVisible(true);

	
	
	
	
	}

}
