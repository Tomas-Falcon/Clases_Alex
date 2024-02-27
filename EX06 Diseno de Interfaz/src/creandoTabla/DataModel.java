package creandoTabla;
import javax.swing.table.AbstractTableModel;

public class DataModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private Object [][]data;
	public DataModel() {
		data=new Object[][]{
			{1,"MAB","Araujo"},
			{2,"Belen","Caceres"}
			};
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return data[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return super.getColumnName(column);
	}

}
