import java.util.ArrayList;

public class Anagrama {
	public static ArrayList<String> anagramas = new ArrayList<String>();
	public static ArrayList<String> palavras = new ArrayList<String>();

	public static void main(String[] args) {
		/*
		 * String palavra = "Para"; imprimeAnagramas("", palavra);
		 * 
		 * for (String string : anagramas) { System.out.println("Palavra " +
		 * string);
		 * 
		 * }
		 */
		testeAnagramas();
	}

	public static void imprimeAnagramas(String prefix, String word) {
		if (word.length() <= 1) {
			// System.out.println(prefix + word);
			anagramas.add(prefix + word);

		} else {
			for (int i = 0; i < word.length(); i++) {
				String cur = word.substring(i, i + 1);
				String before = word.substring(0, i);
				String after = word.substring(i + 1);

				imprimeAnagramas(prefix + cur, before + after);
			}
		}
	}

	public static void carregaPalavras() {
		palavras.add("carro");
		palavras.add("farol");
		palavras.add("casa");
		palavras.add("paris");
		palavras.add("saca");
		palavras.add("missa");
		palavras.add("taro");
		palavras.add("fator");
		palavras.add("america");
		palavras.add("porta");
		palavras.add("males");
		palavras.add("tropa");
		palavras.add("lesma");
		palavras.add("assim");

	}

	public static void testeAnagramas() {
		ArrayList<String> palavrasSaoAnagramas = new ArrayList<String>();
		ArrayList<String> auxPalavras = palavras;
		carregaPalavras();

		for (String palavra : palavras) {
			for (String auxPalavra : auxPalavras) {
				if ((palavra.length() == auxPalavra.length())
						&& (!palavra.equals(auxPalavra))) {

					for (int j = 0; j < palavra.length(); j++) {
						for (int i = 0; i < auxPalavra.length(); i++) {
							if (!(palavra.charAt(i) == auxPalavra.charAt(j))) {
								System.out.println(palavra
										+ " não é anagrama de " + auxPalavra);

							}
						}
					}
					System.out.println("A palavra: " + palavra
							+ " tem o mesmo tamanho da palavra " + auxPalavra);
				}
			}
		}

		/*for (String listaPalavras : palavras) {
			if (!anagramas.isEmpty()) {
				anagramas.removeAll(anagramas);
				anagramas.clear();
				anagramas = new ArrayList<String>();
			} else {
				imprimeAnagramas("", listaPalavras);
				for (int i = 1; i < anagramas.size(); i++) {
					for (String palavra : palavras) {
						if (anagramas.get(i).equalsIgnoreCase(palavra)) {
							palavrasSaoAnagramas.add(anagramas.get(i)); //
							System.out.println(palavra + " : "
									+ anagramas.get(i));
						}
					}
				}
			}
		}*/
		for (int i = 0; i < palavrasSaoAnagramas.size(); i++) {
			for (int j = 0; j < palavrasSaoAnagramas.size(); j++) {
				if (palavrasSaoAnagramas.get(i).equals(
						palavrasSaoAnagramas.get(j))) {
					palavrasSaoAnagramas.remove(j);
				}

			}
		}

		for (String string : palavrasSaoAnagramas) {
			System.out.println(string);
		}

	}
}
