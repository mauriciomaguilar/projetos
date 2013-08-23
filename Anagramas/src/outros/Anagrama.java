package outros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Anagrama {

	private final String PATHARQUIVO = "A:\\Anagramas\\src\\entrada1.txt";
	private ArrayList<String> palavras = new ArrayList<String>();

	public void verificarAnagrama() throws IOException {
		FileReader arq;

		try {
			arq = new FileReader(PATHARQUIVO);
			BufferedReader read = new BufferedReader(arq);

			String linha = read.readLine();
			while (linha != null) {
				palavras.add(linha.trim().toUpperCase());
				linha = read.readLine();

			}
			String palavraAnalisada, palavraDoGrupo = "";

			for (int i = 0; i < palavras.size(); i++) {
				palavraAnalisada = palavras.get(i);
				String anagramas = "";
				for (int j = 0; j < palavras.size(); j++) {
					palavraDoGrupo = palavras.get(j);

					anagramas += palavraDoGrupo + "  ";
					if (verificaAnagrama(palavraAnalisada, palavraDoGrupo)) {
						System.out.println(palavraAnalisada + " - -> "
								+ palavraDoGrupo);
					}

				}
			}
			System.out
					.println(" - - - - - - - - - - FINAL DA ANALISE - - - - - - - - ");
			read.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"Não conseguiu encontrar o arquivo de entrada!");
		}

	}

	private boolean verificaAnagrama(String palavraAnalisadaS,
			String palavraDoGrupoS) {

		char[] palavraAnalisada = palavraAnalisadaS.toCharArray();
		char[] palavraDoGrupo = palavraDoGrupoS.toCharArray();
		if (palavraAnalisada.length == palavraDoGrupo.length) {
			if (!(new String(palavraAnalisada).contains(new String(
					palavraDoGrupo)))) // retirando a mesma palavra
				for (int i = 0; i < palavraAnalisada.length; i++) {
					for (int j = 0; j < palavraDoGrupo.length; j++)
						if (palavraAnalisada[i] == palavraDoGrupo[j]) {
							palavraDoGrupo[j] = ' ';
							break;
						}
				}
			String resultado = new String(palavraDoGrupo);
			if (resultado.trim().length() == 0) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static void main(String args[]) throws IOException {
		Anagrama ag = new Anagrama();
		ag.verificarAnagrama();
	}
}
