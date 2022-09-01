package view;
import javax.swing.JOptionPane;

import Controller.KillController;

public class Main {
	static String qualSO;
	private static String Sistema(String qualSO) {
		qualSO = System.getProperty("os.name");
		return qualSO ;
	}
	
	public static void main(String[] args) {
		KillController controller = new KillController();	
		int opc = 0;
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1-) Qual OS\n2-)Lista de Processo\n3-)Mata PID\n4-)Mata Nome\n9-)fechar"));
			switch (opc) {
			case 1:
				qualSO = Sistema(qualSO);
				System.out.println(qualSO);
				break;
			case 2:
				if(qualSO.contains("Windows")) {
				controller.Process("TASKLIST /FO TABLE");
				} 
				if(qualSO.contains("Linux")) {
					controller.Process("ps -ef");
				}				
				break;
			case 3:
				int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID: "));
				controller.Killpid(pid,qualSO);
				System.out.println("Programa fechado!");
				break;
			case 4:
				String name = JOptionPane.showInputDialog("Coloque o nome do programa para fechar: ");
				controller.Killname(name, qualSO);
				System.out.println("Programa fechado!");				
				break;
			case 9:
				System.exit(0); 
				break;
			default: 
				System.out.println("ERRO");
				break;
			}
		}
	}
}


