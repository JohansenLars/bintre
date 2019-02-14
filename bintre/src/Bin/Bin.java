package Bin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class Bin {
	
	

	public static class Node {
	Node venstre;
	Node hoyre;
	
	String verdi;
	int teller;
	public Node(){
		
	}
	public Node(String a) {
	this.verdi = a;
	this.teller = 1;
		}
	void write()
	{
	    System.out.print("\n" + verdi + ":" + teller);	    
	}
		
	}
	
	
	
	static Node rot = null;
	
	public static void skrivUtSortert(Node rot){
		if (rot == null)
			return;
		
		skrivUtSortert(rot.venstre);
		 System.out.print("\n" + rot.verdi + ":" + rot.teller);
		 
		skrivUtSortert(rot.hoyre);
	
		
	}
	
	
 
	
	public static void settInn(String ord){
		Node nyNode = new Node(ord);
		if (rot == null){
			rot = nyNode;
			return;
		}
		else{
			boolean ferdig = false;
			Node denne = rot;
			while(!ferdig){
				if (ord.compareTo(denne.verdi) < 0){
					if(denne.venstre == null){
						denne.venstre = nyNode;
						ferdig = true;
					}
					else {
						denne = denne.venstre;
					}
				}
				else if(ord.compareTo(denne.verdi) > 0){
					if(denne.hoyre == null){
						denne.hoyre = nyNode;
						ferdig = true;
					}
					else {
						denne = denne.hoyre;
					}
				}
				else if(ord.compareTo(denne.verdi) == 0){
					denne.teller++;
					ferdig = true;
				}
			}
		}
		

	}
	
	
	public static void main(String args[]){
	int n = 10;
	
	int[] num = new int[n];
	Random r = new Random();
	for (int i = 0; i < n; i++){
		num[i] = r.nextInt(10);
		
	}
	Scanner in = new Scanner(System.in);
	System.out.println("Definér filsti...");
	File fil1 = new File(in.nextLine());
	try {
		Scanner filLeser = new Scanner(fil1);
		//filLeser.nextLine().replaceAll("^[a-zA-Z]", "");
		filLeser.useDelimiter("\\W[0-9]*[^a-zA-Z]*");
		while(filLeser.hasNext()){
		
			settInn(filLeser.next().toLowerCase());
		}
		filLeser.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	in.close();
	//inorder();
	skrivUtSortert(rot);
	}
}
