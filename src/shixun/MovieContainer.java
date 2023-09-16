package shixun;

import java.util.*;
import java.util.Collection;
import java.util.Iterator;

class Movie{
	private String name;
	public Movie(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void play() {
		System.out.println(getName()+"is playing.....");
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int value=0;
		for(int i=0;i<name.length();i++) {
			value=value+name.charAt(i);
		}
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.getName().equals(((Movie)obj).getName());
	}
	
}

class MovieGenerator{
	private String[] movieList= {"movie1","movie2","movie3","movie4"};
	private int count=0;
	public Movie next() {
		Movie m=new Movie(movieList[count++%4]);
		return m;
	}
	
	public void setMovieList(String[] movielist) {
		this.movieList=movielist;
	}
}

class MovieComparator<T> implements Comparator<Movie>{

	@Override
	public int compare(Movie o1, Movie o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
	
}

public class MovieContainer {
//	public static Movie[] fillArray(Movie[] m) {
//		MovieGenerator g=new MovieGenerator();
//		for(int i=0;i<m.length;i++) {
//			m[i]=g.next();
//		}
//		return m;
//	}
//	
//	public static void printArray(Movie[] m) {
//		for(int i=0;i<m.length;i++) {
//			System.out.print(m[i].getName()+",");
//		}
//		System.out.println();
//	}
	
	public static Collection<Movie> fillCollection(Collection<Movie> collection,int count){
		MovieGenerator g=new MovieGenerator();
		for(int i=0;i<count;i++) {
			collection.add(g.next());
		}
		return collection;
	}
	
	public static void printCollection(Collection<Movie> collection) {
		Iterator<Movie> iter=collection.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next().getName()+',');
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//Movie[] m=fillArray(new Movie[8]);
		//printArray(m);
		
		printCollection(fillCollection(new LinkedHashSet<Movie>(), 8));
		printCollection(fillCollection(new LinkedList<Movie>(), 8));
		printCollection(fillCollection(new ArrayList<Movie>(), 8));
		printCollection(fillCollection(new HashSet<Movie>(), 8));
		printCollection(fillCollection(new TreeSet<Movie>(new MovieComparator()), 8));
	}
}