package outros;

import javax.swing.JOptionPane;

public class Espiral_SQRT_N {

	public String calculaEspiral(int ponto, int numRepeticoes) {
		int x = 0;
		int y = 0;
		int numCorrente = 1;
		int sinalx = -1;
		int sinaly = 1;
		double aux = (double) numRepeticoes;
		numRepeticoes = (int) Math.sqrt(aux);
		if (ponto == 0) {
			return new String("(0,0)");
		}
		while (numCorrente <= ponto) {
			for (int i = 0; i < numRepeticoes; i++) {
				if (numCorrente <= ponto) {
					y += sinaly;
					numCorrente++;
				} else {
					break;
				}
			}
			for (int i = 0; i < numRepeticoes; i++) {
				if (numCorrente <= ponto) {
					x += sinalx;
					numCorrente++;

				} else {
					break;
				}
			}
			numRepeticoes++;
			sinalx *= -1;
			sinaly *= -1;
		}
		return new String("(" + x + "," + y + ").");
	}

	public static void main(String[] args) {
		Espiral_O_1 ep = new Espiral_O_1();
		String entrada = "1";
		String repeticoes = "1";
		repeticoes = JOptionPane
				.showInputDialog("Digite o valor de N para o calculo de O(sqrt(n))");
		while (entrada.trim().length() != 0) {

			entrada = JOptionPane
					.showInputDialog("Digite o numero do ponto ou deixe branco para SAIR.");

			if (entrada.trim().length() != 0) {
				JOptionPane.showMessageDialog(
						null,
						"O ponto "
								+ entrada.trim()
								+ " corresponde ao "
								+ ep.calculaEspiral(
										new Integer(entrada.trim()),
										new Integer(repeticoes.trim())));
			}
		}
		System.out.println("Terminou a execu�ao");

	}
}
