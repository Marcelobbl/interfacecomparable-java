package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Funcionario;

public class Program {
	
	public static void main(String[] args) {
		
		List<Funcionario> list = new ArrayList<>();
		String path = "C:\\Users\\User\\Desktop\\Marcelo\\TrabalhoEclipse\\in.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String funcionarioCsv = br.readLine();
			while (funcionarioCsv != null) {
				String[] filtro = funcionarioCsv.split(",");
				list.add(new Funcionario(filtro[0], Double.parseDouble(filtro[1])));
				funcionarioCsv = br.readLine();
			}
			Collections.sort(list);
			for (Funcionario funcionario : list) {
				System.out.println(funcionario.getNome() + ", " + funcionario.getSalario());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}