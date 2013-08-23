import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestePalavra {
	public static List<String> anagramas = new ArrayList<String>();
	public static List<String> palavras = new ArrayList<String>();
	boolean sair;
	String palavra1;

	public TestePalavra(String palavra1) {
		this.palavra1 = palavra1;
	}

	boolean resolvaProblemaA(String palavra2) {
		int i = 0;
		if (!palavra1.equals(palavra2)) {
			while (i < palavra1.length() & sair == false) {
				char aux = palavra1.charAt(i);
				int c1 = 0;
				if (palavra1.length() != palavra2.length()) {
					sair = true;
				}
				for (int j = 0; j < palavra1.length(); j++) {
					if (palavra1.charAt(j) == aux)
						c1++;
				}
				int c2 = 0;
				for (int j = 0; j < palavra2.length(); j++) {
					if (palavra2.charAt(j) == aux)
						c2++;
				}
				if (c1 != c2)
					sair = true;
				i++;
			}
		} else {
			sair = true;
		}
		return sair;
	}

	public static void carregaPalavras() {

		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"A:/Anagramas/src/entrada1.txt"));

			while (br.ready()) {
				String linha = br.readLine();
				palavras.add(linha);
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		carregaPalavras();

		if (palavras != null) {
			for (String palavra : palavras) {
				TestePalavra obj = new TestePalavra(palavra);
				for (String outraPalavra : palavras) {
					obj.sair = false;
					boolean auxSair = obj.resolvaProblemaA(outraPalavra);
					if (auxSair == false) {
						anagramas.add("Anagrama: " + palavra + " - "
								+ outraPalavra);
					}
				}
			}
			for (String anagrama : anagramas) {
				System.out.println(anagrama);
			}
		}
	}
}