package examen;
import java.text.*;
import java.util.*;

public class CalcularFechas {
	


	
	
	private List<Calendar> diasFestivos = new List<Calendar>() {
		
		@Override
		public <T> T[] toArray(T[] a) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Calendar> subList(int fromIndex, int toIndex) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Calendar set(int index, Calendar element) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public Calendar remove(int index) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public ListIterator<Calendar> listIterator(int index) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public ListIterator<Calendar> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int lastIndexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Iterator<Calendar> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public int indexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Calendar get(int index) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean addAll(int index, Collection<? extends Calendar> c) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean addAll(Collection<? extends Calendar> c) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void add(int index, Calendar element) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean add(Calendar e) {
			// TODO Auto-generated method stub
			return false;
		}
	};
	
	
	
	protected void calcuFechas(boolean notificacion, String fechaIni, String diasStr) {
		try {
			
			String fechaInicialStr = fechaIni;
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Date fechaInicialDate = formato.parse(fechaInicialStr);
			Calendar fechaInicial = Calendar.getInstance();
			fechaInicial.setTime(fechaInicialDate);

			int dias = Integer.parseInt(diasStr);
			if(notificacion) {
			Calendar nuevaFecha = calcularNuevaFechaHabil(fechaInicial, dias, notificacion);
			}
			
		} catch (ParseException | NumberFormatException e) {
			ClaseMain claseMain = new ClaseMain();
			claseMain.Main2("Error en el formato de la fecha introducida.");
		}
	}
	
	
	protected Calendar calcularNuevaFechaHabil(Calendar fechaInicial, int dias, boolean diasHabiles) {
		Calendar fecha = (Calendar) fechaInicial.clone();
		int diasCalculados = 0;
		while (diasCalculados < dias) {
			fecha.add(Calendar.DAY_OF_MONTH, 1);
			if (diasHabiles) {


				int diaDeLaSemana = fecha.get(Calendar.DAY_OF_WEEK);
				if (diaDeLaSemana != Calendar.SATURDAY && diaDeLaSemana != Calendar.SUNDAY
						&& !esFechaFestivo(fecha)) {
					diasCalculados++;
				}
			}
		}
		return fecha;
	}
	
	
	protected boolean esFechaFestivo(Calendar fecha) {
		for (Calendar fechaFestiva : diasFestivos) {
			if (sonIguales(fecha, fechaFestiva)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean sonIguales(Calendar fecha1, Calendar fecha2) {
		return fecha1.get(Calendar.YEAR) == fecha2.get(Calendar.YEAR)
				&& fecha1.get(Calendar.MONTH) == fecha2.get(Calendar.MONTH)
				&& fecha1.get(Calendar.DAY_OF_MONTH) == fecha2.get(Calendar.DAY_OF_MONTH);
	}
	
	protected void festivos(String fecha[]) {
		try {
			for(String fecha1 : fecha){
			String nuevaFechaFestivaStr = fecha1;
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");			
			Date nuevaFechaFestivaDate = formato.parse(nuevaFechaFestivaStr);
			Calendar nuevaFechaFestiva = Calendar.getInstance();
			nuevaFechaFestiva.setTime(nuevaFechaFestivaDate);
			
			diasFestivos.add(nuevaFechaFestiva);
			}
		} catch (Exception e) {
			ClaseMain claseMain = new ClaseMain();
			claseMain.Main2("Error en el formato de la fecha introducida.");
		}
	}
	
	
}
